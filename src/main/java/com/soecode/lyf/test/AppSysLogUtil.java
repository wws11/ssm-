package com.soecode.lyf.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @Description: gy-app操作日志
 * @Date: 2019/03/27 14:27
 * @Author: WangLingJi
 */
public enum AppSysLogUtil implements AbstractSysLogUtil {
    LOGOUTLOG {
        @Override
        public String getOperFunc() throws Exception {
            return "退出->退出";
        }
    },
    EDITPOSSWORDLOG {
        @Override
        public String getCustomDesc(String operateName, String... objects) throws Exception {
            return operateName + COLON + Arrays.toString(objects);
        }

        @Override
        public String getOperFunc() throws Exception {
            return "我的->修改密码";
        }
    },
    MEETIONGLOG {
        @Override
        public String getOperFunc() throws Exception {
            return "常用->会议";
        }
    },
    BOOKLOG {
        @Override
        public String getCustomDesc(String operateName, String... objects) throws Exception {
            return operateName + COLON + Arrays.toString(objects);
        }

        @Override
        public String getOperFunc() throws Exception {
            return "常用->通讯";
        }
    },
    QUALITYLOG {
        @Override
        public String getCustomDesc(String operateName, String... objects) throws Exception {
            return operateName + COLON + Arrays.toString(objects);
        }

        @Override
        public String getOperFunc() throws Exception {
            return "管理->质量";
        }
    },
    SAFELOG {
        @Override
        public String getCustomDesc(String operateName, String... objects) throws Exception {
            return operateName + COLON + Arrays.toString(objects);
        }

        @Override
        public String getOperFunc() throws Exception {
            return "管理->安全";
        }
    },
    LOGLOG {
        @Override
        public String getCustomDesc(String operateName, String... objects) throws Exception {
            return operateName + COLON + Arrays.toString(objects);
        }

        @Override
        public String getOperFunc() throws Exception {
            return "资料->日志";
        }
    },
    GRAPHMODELLOG {
        @Override
        public String getCustomDesc(String operateName, String... objects) throws Exception {
            return operateName + COLON + Arrays.toString(objects);
        }

        @Override
        public String getOperFunc() throws Exception {
            return "资料->图模";
        }
    },
    GDLOG {
        @Override
        public String getCustomDesc(String operateName, String... objects) throws Exception {
            return operateName + COLON + Arrays.toString(objects);
        }

        @Override
        public String getOperFunc() throws Exception {
            return "资料->归档";
        }
    },
    NOGDLOG {
        @Override
        public String getCustomDesc(String operateName, String... objects) throws Exception {
            return operateName + COLON + Arrays.toString(objects);
        }

        @Override
        public String getOperFunc() throws Exception {
            return "资料->非归档";
        }
    },
    INSPECTIONLOG {
        @Override
        public String getOperFunc() throws Exception {
            return "管控->巡检";
        }
    },
    CHECKLOG {
        @Override
        public String getOperFunc() throws Exception {
            return "管控->验收";
        }
    },
    DETECTIONLOG {
        @Override
        public String getOperFunc() throws Exception {
            return "管控->检测";
        }
    },
    ACCOUNTLOG {
        @Override
        public String getOperFunc() throws Exception {
            return "我的->个人信息";
        }
    },
    PROGRESSLOG {
        @Override
        public String getOperFunc() throws Exception {
            return "项目概况->形象进度";
        }
    },
    DEVICELOG {
        @Override
        public String getOperFunc() throws Exception {
            return "资源->机械";
        }
    },
    METERIALLOG {
        @Override
        public String getCustomDesc(String operateName, String... objects) throws Exception {
            return operateName + COLON + Arrays.toString(objects);
        }
        @Override
        public String getCustomDesc(String operateName, Collection<String> objects) throws Exception {
            if (objects == null || objects.size() < 1) {
                return null;
            }
            return operateName + COLON + objects.stream().collect(Collectors.joining(","));
        }
        @Override
        public String getOperFunc() throws Exception {
            return "资源->材料";
        }
    },
    MANAGERLOG {
        @Override
        public String getOperFunc() throws Exception {
            return "资源->管理人员";
        }
    },
    OPERATORSLOG {
        @Override
        public String getOperFunc() throws Exception {
            return "资源->作业人员";
        }
    };

    public static final String ADD_PROGRESS = "发布形象进度";
    public static final String EDIT_PROGRESS = "编辑形象进度";
    public static final String DEL_PROGRESS = "删除形象进度";

    public static final String ADD_DEVICE = "添加设备(编号+名称)";
    public static final String EDIT_DEVICE = "编辑设备(编号+名称)";
    public static final String ADD_MAINTENANCE_ROCORDS = "添加设备维修记录(编号+名称)";

    public static final String ADD_MEETIONG = "创建会议";
    public static final String EDIT_MEETIONG = "编辑会议";

    public static final String ADD_COORDINATION = "创建协同";
    public static final String DEL_COORDINATION = "删除协同";
    public static final String REPLY_COORDINATION = "回复协同";

    public static final String UPLOAD_CAD = "上传CAD图纸";
    public static final String UPLOAD_GDZL = "上传归档资料";
    public static final String UPLOAD_NOGDZL = "上传非归档资料";
    public static final String UPLOAD_LOG = "上传日志";
    public static final String UPLOAD_QUALITY = "上传质量规范";
    public static final String UPLOAD_SAFE = "上传安全规范";

    public static final String DEL_CAD = "删除CAD图纸";
    public static final String DEL_GDZL = "删除归档资料";
    public static final String DEL_NOGDZL = "删除非归档资料";
    public static final String DEL_LOG = "删除日志";
    public static final String DEL_QUALITY = "删除质量规范";
    public static final String DEL_SAFE = "删除安全规范";

    public static final String REPORT_BINDING_EVIDENTIAL = "报审表关联见证取样";
    public static final String EVIDENTIAL_BINDING_REPORT = "见证取样关联报审表";
    public static final String DEL_EVIDENTIAL = "删除见证取样";

    public static final String EDIT_MANAGER = "编辑管理人员";
    public static final String ADD_OPERATORS = "添加作业人员";
    public static final String EDIT_OPERATORS = "编辑作业人员";
    public static final String DEL_OPERATORS = "删除作业人员";

    public static final String ADD_INSPECTION = "创建巡查";
    public static final String DEL_INSPECTION = "删除巡查";
    public static final String RECTI_INSPECTION = "提交整改巡查";
    public static final String RECTIAGMIN_INSPECTION = "重新整改巡查";
    public static final String ACCEPT_INSPECTION = "通过巡查";

    public static final String ADD_REVIEW = "创建检查";
    public static final String ACCEPET_REVIEW = "整改完成检查";
    public static final String DEL_REVIEW = "删除检查";

    public static final String ADD_DETECTION = "申请检测";
    public static final String FINISH_DETECTION = "检测完成";

    public static final String ADD_CONCELMENTCHECK = "发起隐蔽验收";
    public static final String ACCEPT_CONCELMENTCHECK = "验收通过隐蔽验收";
    public static final String REFUSE_CONCELMENTCHECK = "验收不通过隐蔽验收";

    public static final String ADD_UNIONCHECK = "发起节点验收";
    public static final String CHECK_UNIONCHECK = "检查节点验收";
    public static final String ACCEPET_UNIONCHECK = "通过节点验收";

    public static final String EDIT_PASSWORD_ACCOUNT = "修改密码";

    public static final String EDIT_PORTRAITUUID_ACCOUNT = "修改头像";

    public static final String REMIND = "提醒";
    public static final String REMIND_CAD = "查看CAD";
    public static final String REMIND_GDZL = "查看归档资料";
    public static final String REMIND_LOG = "查看日志";
    public static final String REMIND_NOGDZL = "查看非归档资料";
    public static final String REMIND_QUALITY = "查看质量规范";
    public static final String REMIND_SAFE = "查看安全规范";

    public static final String UPLOAD = "上传";
    public static final String DELETE = "删除";

    public static final String LOGOUT = "退出";

    public static final String LOGOUT_APP = "退出APP";
}
