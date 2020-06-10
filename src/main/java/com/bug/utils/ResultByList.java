package com.bug.utils;

import java.util.List;

/*
 *   Author = Liewona
 *   Date = 2020/6/8 16:54
 */
public class ResultByList {

    private Integer code;
    private String msg;
    private Long count;
    private List data;

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

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

}
