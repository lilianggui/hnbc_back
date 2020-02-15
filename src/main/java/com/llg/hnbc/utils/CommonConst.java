package com.llg.hnbc.utils;

public class CommonConst {

    public enum SYSTEM_FILE_MODULE {
        CALLIGRAPHY_IMG("书法图片", "1"),
        CALLIGRAPHY_BATCH_ZIP("书法模块批量上传图片zip文件", "12");
        // 成员变量
        private String name;
        private String index;
        // 构造方法
        SYSTEM_FILE_MODULE(String name, String index) {
            this.name = name;
            this.index = index;
        }

        // get set 方法
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }
    }
}
