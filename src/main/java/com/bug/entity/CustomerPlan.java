package com.bug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

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
    private Integer userid;

    @ApiModelProperty(value = "开发机会id",name = "chanceid",example = "1")
    private Integer chanceid;

    @ApiModelProperty(value = "开发日期",name = "date",example = "2020-06-06 09:15:29")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    @ApiModelProperty(value = "机会来源",name = "chanceFrom",example = "新的方式去提供产品")
    private String chanceFrom;

    @ApiModelProperty(value = "概要",name = "summary",example = "这个客户有点东西")
    private String summary;

    @ApiModelProperty(value = "机会描述",name = "description",example = "这是机会描述，这个机会难得")
    private String description;

    @ApiModelProperty(value = "客户姓名",name = "customerName",example = "赵子龙")
    private String customerName;

    @ApiModelProperty(value = "联系电话",name = "telephone",example = "15310997468")
    private String telephone;

    @ApiModelProperty(value = "前期计划",name = "content1",example = "执行xx")
    private String content1;

    @ApiModelProperty(value = "中期计划",name = "content2",example = "执行xx")
    private String content2;

    @ApiModelProperty(value = "后期计划",name = "content3",example = "执行xx")
    private String content3;

    @ApiModelProperty(value = "进度",name = "progress",example = "1")
    private Integer progress;

    @ApiModelProperty(value = "计划状态",name = "state",example = "0-未制定，1-已制定")
    private Integer makeState;

    @ApiModelProperty(value = "开发状态",name = "state",example = "1-未指派 2-已指派 3：开发成功；4：开发失败")
    private Integer state;

}
