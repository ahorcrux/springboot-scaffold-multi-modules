package org.ahorcrux.common.exception;

public interface IErrorCode {

    String code();

    String message();

    IErrorCode SUCCESS = new IErrorCode() {
        public String code() {
            return "0000";
        }
        public String message() {
            return "Success";
        }
    };

    IErrorCode FAIL = new IErrorCode() {
        public String code() {
            return "9999";
        }
        public String message() {
            return "系统正忙, 请稍后重试";
        }
    };

    IErrorCode UNAUTHORIZED = new IErrorCode() {
        public String code() {
            return "9001";
        }
        public String message() {
            return "非法访问";
        }
    };

    IErrorCode PARAM_ILLEGAL = new IErrorCode() {
        public String code() {
            return "9002";
        }
        public String message() {
            return "请求的参数包含非法字符";
        }
    };

    IErrorCode PARAM_INVALID = new IErrorCode() {
        public String code() {
            return "9003";
        }
        public String message() {
            return "参数校验失败";
        }
    };

    IErrorCode TOKEN_INVALID = new IErrorCode() {
        public String code() {
            return "9004";
        }
        public String message() {
            return "请先登录";
        }
    };

    IErrorCode TOKEN_EXPIRED = new IErrorCode() {
        public String code() {
            return "9005";
        }
        public String message() {
            return "会话已过期,请重新登录";
        }
    };
    IErrorCode NOT_PERMISSION = new IErrorCode() {
        public String code() {
            return "9006";
        }
        public String message() {
            return "没有权限";
        }
    };
    IErrorCode TOKEN_INVALID_PERMISSION_CHANGED = new IErrorCode() {
        public String code() {
            return "9007";
        }
        public String message() {
            return "您的角色权限发生改变，请重新登录";
        }
    };
    IErrorCode SYSTEM_ERROR = new IErrorCode() {
        public String code() {
            return "9010";
        }
        public String message() {
            return "系统服务错误";
        }
    };

}
