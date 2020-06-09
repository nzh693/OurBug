package com.bug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
public class CustomerPlan extends Model<CustomerPlan> {

    private static final long serialVersionUID=1L;

    /**
     * 开发计划id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 开发机会id
     */
    private String chanceid;

    /**
     * 开发日期(xxxx-xx-xx)
     */
    private LocalDateTime date;

    /**
     * 内容
     */
    private String content;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChanceid() {
        return chanceid;
    }

    public void setChanceid(String chanceid) {
        this.chanceid = chanceid;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "CustomerPlan{" +
        "id=" + id +
        ", chanceid=" + chanceid +
        ", date=" + date +
        ", content=" + content +
        "}";
    }
}
