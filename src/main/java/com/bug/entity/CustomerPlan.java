package com.bug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerPlan extends Model<CustomerPlan> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "开发计划id",name = "id",example = "1")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "指派经理id",name = "userId",example = "1")
    private Integer userId;

    @ApiModelProperty(value = "开发机会id",name = "chanceid",example = "1")
    private Integer chanceid;

    @ApiModelProperty(value = "开发日期",name = "date",example = "2020-06-06 09:15:29")
    private Date date;

    @ApiModelProperty(value = "前期计划",name = "content1",example = "执行xx")
    private String content1;

    @ApiModelProperty(value = "中期计划",name = "content2",example = "执行xx")
    private String content2;

    @ApiModelProperty(value = "后期计划",name = "content3",example = "执行xx")
    private String content3;

    @ApiModelProperty(value = "进度",name = "progress",example = "1")
    private Integer progress;

    @ApiModelProperty(value = "状态",name = "state",example = "0-未制定，1-已制定")
    private Integer state;
}
