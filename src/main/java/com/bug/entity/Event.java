package com.bug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Liewona
 * @since 2020-06-08
 */
public class Event extends Model<Event> {

    private static final long serialVersionUID=1L;

    /**
     * 事件ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 事件世间
     */
    private String time;

    /**
     * 事件地点
     */
    private String place;

    /**
     * 概要
     */
    private String schema;

    /**
     * 详细信息
     */
    private String detail;

    /**
     * 备注
     */
    private String comment;

    /**
     * 所属记录
     */
    private Integer recordId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Event{" +
        "id=" + id +
        ", time=" + time +
        ", place=" + place +
        ", schema=" + schema +
        ", detail=" + detail +
        ", comment=" + comment +
        ", recordId=" + recordId +
        "}";
    }
}
