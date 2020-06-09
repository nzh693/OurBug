package com.bug.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName SaleChance
 * @Description 销售机会Pojo
 * @Author 柳成荫
 * @Date 2020/6/9
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "SaleChance对象",description = "销售机会对象")
public class SaleChance extends Model<SaleChance> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "销售机会ID",name = "id",example = "1")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "客户姓名",name = "customerName",example = "赵子龙")
    private String customerName;

    @ApiModelProperty(value = "机会来源",name = "chanceFrom",example = "新的方式去提供产品")
    private String chanceFrom;

    @ApiModelProperty(value = "联系电话",name = "telephone",example = "15310997468")
    private String telephone;

    @ApiModelProperty(value = "成功几率(%)",name = "successRate",example = "55")
    private Integer successRate;

    @ApiModelProperty(value = "概要",name = "summary",example = "这个客户有点东西")
    private String summary;

    @ApiModelProperty(value = "机会描述",name = "description",example = "这是机会描述，这个机会难得")
    private String description;

    @ApiModelProperty(value = "创建人id",name = "createUserid",example = "2")
    private Integer createUserid;

    @TableField(fill = FieldFill.INSERT)   // 插入时修改
    @ApiModelProperty(value = "创建时间",name = "createTime",example = "2020-06-06 09:15:29")
    private Date createTime;

    @ApiModelProperty(value = "被指派的客户经理id",name = "userid",example = "3")
    private Integer userid;

    @ApiModelProperty(value = "指派时间",name = "assginTime",example = "2020-06-06 09:15:29")
    private Date assginTime;

    @ApiModelProperty(value = "机会状态码",name = "state",example = "0：未分派；1：已分派；2：开发成功；3：开发失败")
    private Integer state;
}
