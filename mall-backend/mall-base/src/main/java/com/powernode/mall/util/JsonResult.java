package com.powernode.mall.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonResult<E> implements Serializable {
    private Integer stateCode;
    private String stateMsg;
    private E data;
    public JsonResult(){super();}
    public JsonResult(Integer stateCode) {
        super();
        this.stateCode = stateCode;
    }

    public JsonResult(Throwable e) {
        super();
        this.stateMsg=e.getMessage();
    }

    public JsonResult(Integer stateCode, E data) {
        super();
        this.stateCode = stateCode;
        this.data = data;
    }
}
