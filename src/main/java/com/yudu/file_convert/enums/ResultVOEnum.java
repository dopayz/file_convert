package com.yudu.file_convert.enums;

public enum  ResultVOEnum {
    FILE_NOT_EMPTY(0,"文件不能为空"),
    CONVERT_SUCCESS(0,"转换成功"),
    CONVERT_ERROR(1,"转换失败");
    private Integer code;
    private String msg;

    ResultVOEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
