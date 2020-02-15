package com.llg.hnbc.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import com.llg.hnbc.entity.SystemFile;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

public class ZipUtils {
    private static int bufferSize = 2048;

    /**
     * 压缩
     * @param srcFileOrDir 原文件或文件夹
     * @param destZipFilePath 输出到的目标路径，默认zip文件为原文件或文件夹名称
     */
    public static boolean zip(String srcFileOrDir, String destZipFilePath){
        File file = new File(srcFileOrDir);
        if(!file.exists()){
            return false;
        }

        String destZipFileName = file.getName();

        return zip(srcFileOrDir, destZipFilePath, destZipFileName);
    }

    /**
     * 压缩
     * @param srcFileOrDir 原文件或文件夹
     * @param destZipFilePath 输出到的目标路径
     * @param destZipFileName 生成的zip文件名称
     */
    public static boolean zip(String srcFileOrDir, String destZipFilePath, String destZipFileName){
        File file = new File(srcFileOrDir);
        if(!file.exists()){
            return false;
        }

        if(!destZipFilePath.endsWith(File.separator)){
            destZipFilePath += File.separator;
        }

        File destZipFileParentDir = new File(destZipFilePath);
        if(!destZipFileParentDir.exists()){
            destZipFileParentDir.mkdirs();
        }

        if(!destZipFileName.endsWith(".zip")&&!destZipFileName.endsWith(".ZIP")){
            destZipFileName += ".zip";
        }

        boolean zipResult = false;
        if(file.isFile()){
            zipResult = zipFile(srcFileOrDir, destZipFilePath, destZipFileName);
        }else if(file.isDirectory()){
            zipResult = zipDir(srcFileOrDir, destZipFilePath, destZipFileName);
        }

        return zipResult;
    }

    private static boolean zipFile(String srcFileName, String destZipFilePath, String destZipFileName){
        boolean zipResult = false;
        File srcFile = new File(srcFileName);

        ZipOutputStream zipOutputStream = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(destZipFilePath + destZipFileName));
            zipOutputStream.setEncoding(System.getProperty("sun.jnu.encoding"));

            String fileName = srcFile.getName();
            ZipEntry entry = new ZipEntry(fileName);

            BufferedInputStream bis = null;
            try {
                zipOutputStream.putNextEntry(entry);
                bis = new BufferedInputStream(new FileInputStream(srcFile));

                byte[] buf = new byte[bufferSize];
                int len;
                while ((len = bis.read(buf)) >= 0) {
                    zipOutputStream.flush();
                    zipOutputStream.write(buf, 0, len);
                }
                zipResult = true;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(zipOutputStream!=null){
                        zipOutputStream.closeEntry();
                    }

                    if(bis!=null){
                        bis.close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(zipOutputStream!=null){
                    zipOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return zipResult;
    }

    private static boolean zipDir(String srcDir, String destZipFilePath, String destZipFileName){
        boolean zipResult = false;
        if(!srcDir.endsWith(File.separator)){
            srcDir += File.separator;
        }
        File srcFile = new File(srcDir);
        File[] files = srcFile.listFiles();

        ZipOutputStream zipOutputStream = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(destZipFilePath + destZipFileName));
            zipOutputStream.setEncoding(System.getProperty("sun.jnu.encoding"));
            if(files!=null&&files.length>0){
                for(File f :files){
                    compressFiles(f, f.getParent() ,zipOutputStream);
                }
            }
            zipResult = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(zipOutputStream!=null){
                    zipOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return zipResult;
    }

    private static void compressFiles(File file, String basePath, ZipOutputStream stream){
        if(file==null||stream==null){
            return;
        }
        if(file.isDirectory()){
            ZipEntry entry = new ZipEntry(getEntryPath(file,basePath) + File.separator);
            try {
                stream.putNextEntry(entry);
            } catch (IOException e) {
                e.printStackTrace();
            }

            File[] files = file.listFiles();
            if(files!=null&&files.length>0){
                for(File f :files){
                    compressFiles(f, basePath, stream);
                }
            }
        }else{
            String fileName = getEntryPath(file, basePath);
            ZipEntry entry = new ZipEntry(fileName);

            BufferedInputStream bis = null;
            try {
                stream.putNextEntry(entry);
                bis = new BufferedInputStream(new FileInputStream(file));

                byte[] buf = new byte[bufferSize];
                int len;
                while ((len = bis.read(buf)) >= 0) {
                    stream.flush();
                    stream.write(buf, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(stream!=null){
                        stream.closeEntry();
                    }

                    if(bis!=null){
                        bis.close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static String getEntryPath(File file, String basePath){
        String path = file.getPath().substring(basePath.length() + 1);
        return path;
    }

    /**
     * 解压
     * @param srcZipFile 压缩文件
     * @param destDir 目标路径
     * @return
     */
    public static boolean unzip(String srcZipFile, String destDir) {
        boolean unzipResult = false;
        ZipFile zipFile = null;
        Enumeration<ZipEntry> entries = null;
        try {
            zipFile = new ZipFile(srcZipFile, System.getProperty("sun.jnu.encoding"));
            if(zipFile!=null){
                entries = zipFile.getEntries();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(zipFile==null||entries == null){
            return false;
        }

        if(!destDir.endsWith(File.separator)){
            destDir += File.separator;
        }

        ZipEntry zipEntry = null;
        while (entries.hasMoreElements()) {
            zipEntry = entries.nextElement();

            if (isDirectory(zipEntry)) {
                try {
                    mkDirs(destDir + zipEntry.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                String name = zipEntry.getName();
                File file = new File(destDir + name);
                try {
                    mkDirs(file.getParent());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                InputStream in = null;
                FileOutputStream out = null;
                try {
                    in = zipFile.getInputStream(zipEntry);
                    out = new FileOutputStream(file);
                    int c;
                    byte[] by = new byte[1024];
                    while ((c = in.read(by)) != -1) {
                        out.flush();
                        out.write(by, 0, c);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if(out!=null){
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(in!=null){
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        unzipResult = true;
        try {
            zipFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return unzipResult;
    }


    public static String unZip(String srcZipFile, String destDir, String[] fileValid, SystemFile sf, List<SystemFile> systemFileList){
        String errorMsg = null;
        try (ZipFile zipFile = new ZipFile(srcZipFile, System.getProperty("sun.jnu.encoding"))){
            Enumeration<ZipEntry> entries = zipFile.getEntries();
            if(!destDir.endsWith(File.separator)){
                destDir += File.separator;
            }
            ZipEntry zipEntry = null;
            while (entries.hasMoreElements()) {
                zipEntry = entries.nextElement();
                if (isDirectory(zipEntry) || zipEntry.getName().startsWith("__MACOSX")) {
                    continue;
                }
                String fileOriginName = zipEntry.getName();
                String format = fileOriginName.substring(fileOriginName.lastIndexOf("."));
                if(!new HashSet<>(Arrays.asList(fileValid)).contains(format)){
                    errorMsg = "压缩包中存在格式不正确的文件: " + format + "，目前只支持以下格式：" + Arrays.toString(fileValid);
                    break;
                }
                String saveFileName = UUID.randomUUID().toString().replaceAll("-", "") + format;
                File file = new File(destDir + saveFileName);
                file.createNewFile();
                try (InputStream in = zipFile.getInputStream(zipEntry);
                     FileOutputStream out = new FileOutputStream(file)){
                    int c;
                    byte[] by = new byte[1024];
                    while ((c = in.read(by)) != -1) {
                        out.flush();
                        out.write(by, 0, c);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                SystemFile systemFile = new SystemFile(
                        sf.getModule(), sf.getModuleName(), sf.getBusinessId(),
                        saveFileName, fileOriginName, file.getAbsolutePath(), format
                );
                systemFileList.add(systemFile);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return errorMsg;
    }

    /**
     * 重写判断zipEntry是否是文件夹，他的类方法【zipEntry.isDirectory()】是写死的"/"，windows情况下会判断错误。
     * @param zipEntry
     * @return
     */
    private static boolean isDirectory(ZipEntry zipEntry){
        boolean isDirectory = false;
        String name = zipEntry.getName();
        if(name.endsWith(File.separator)){
            isDirectory = true;
        }
        return isDirectory;
    }

    private static void mkDirs(String dir){
        if (dir == null || dir.equals("")){
            return;
        }

        File file = new File(dir);
        if (!file.exists()){
            file.mkdirs();
        }

    }

    public static void main(String[] args) {
        zip("D:\\test", "D:\\test1");
        unzip("D:\\test1\\test.zip", "D:\\test1\\");
    }

}
