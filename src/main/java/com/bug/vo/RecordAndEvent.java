package com.bug.vo;

import java.time.LocalTime;

public class RecordAndEvent {

    private int id;
    private int  customerid;
    private LocalTime time;
    private String place;
    private String schema;
    private String  detail;
    private String  comment;

    public RecordAndEvent(int id, int customerid, LocalTime time, String place, String schema, String detail, String comment) {
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

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
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
