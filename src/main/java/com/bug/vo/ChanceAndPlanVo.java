package com.bug.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName ChanceAndPlanVo
 * @Description
 * @Author 柳成荫
 * @Date 2020/6/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Api(tags = "机会与计划类")
public class ChanceAndPlanVo {

    @ApiModelProperty(value = "机会Id",name = "id",example = "1")
    private Integer id;

    @ApiModelProperty(value = "客户名称",name = "customerName",example = "熊世隐")
    private String customerName;

    @ApiModelProperty(value = "机会来源",name = "chanceFrom",example = "熊世隐线下单挑熊葛亮")
    private String chanceFrom;

    @ApiModelProperty(value = "客户电话",name = "telephone",example = "15310968864")
    private String telephone;

    @ApiModelProperty(value = "概要",name = "summary",example = "熊葛亮闪现疾步送人头")
    private String summary;

    @ApiModelProperty(value = "描述",name = "description",example = "熊世隐简直无敌好吧")
    private String description;

    @ApiModelProperty(value = "计划是否制定",name = "state",example = "0-未制定，1-已制定")
    private Integer state;
}
