package com.bug.vo;

import java.time.LocalDateTime;


public class RecordAndEvent {

    private int id;
    private int  customerid;
    private String time;
    private String place;
    private String schema;
    private String  detail;
    private String  comment;
    public RecordAndEvent(){

    }

    public RecordAndEvent(int id, int customerid, String time, String place, String schema, String detail, String comment) {
        this.id = id;
        this.customerid = customerid;
        this.time = time;
        this.place = place;
        this.schema = schema;
        this.detail = detail;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
