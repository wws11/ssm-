package com.soecode.lyf.test;

/**
 * Create by wws on 2019/9/9
 */
public enum AAA implements AbstractSyslog {


    BBB {
        @Override
        public String getOperFun() throws Exception {
            return "bbb";
        }

        @Override
        public int getNum() {
            return 0;
        }

    }, CCC {
        @Override
        public String getOperFun() throws Exception {
            return null;
        }

        @Override
        public int getNum() {
            return 0;
        }
    },DDD{
        @Override
        public String getOperFun() throws Exception {
            return null;
        }

        @Override
        public int getNum() {
            return 0;
        }
    },EEE {
        @Override
        public String getOperFun() throws Exception {
            return "嘿嘿";
        }

        @Override
        public int getNum() {
            return 1;
        }
    };

    public static void main(String[] args) throws Exception {
        String operFun = AAA.EEE.getOperFun();
        System.out.println(operFun);
        System.out.println(AAA.EEE.getNum());
    }

}
