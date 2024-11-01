package com.lwq.slave2.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class R {
    public final static String STATUS_SUCCESS = "success";
    public final static String STATUS_ERROR = "error";

    private String status;

    private Object data;

    private Integer errorCode;

    private String message;

    public static final R success(Object data) {
        return R.builder().status(STATUS_SUCCESS).data(data).build();
    }

    public static final R error(String message) {
        return R.builder().status(STATUS_ERROR).errorCode(401).message(message).build();
    }

    public static final R error(Integer errorCode, String message) {
        return R.builder().status(STATUS_ERROR).errorCode(errorCode).message(message).build();
    }
}
