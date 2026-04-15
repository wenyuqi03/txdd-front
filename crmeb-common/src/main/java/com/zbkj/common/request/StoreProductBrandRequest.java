package com.zbkj.common.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 商品品牌表 Request
 * +----------------------------------------------------------------------
 * | CRMEB [ CRMEB赋能开发者，助力企业发展 ]
 * +----------------------------------------------------------------------
 * | Copyright (c) 2016~2025 https://www.crmeb.com All rights reserved.
 * +----------------------------------------------------------------------
 * | Licensed CRMEB并不是自由软件，未经许可不能去掉CRMEB相关版权
 * +----------------------------------------------------------------------
 * | Author: CRMEB Team <admin@crmeb.com>
 * +----------------------------------------------------------------------
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "StoreProductBrandRequest对象", description = "商品品牌表请求")
public class StoreProductBrandRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "品牌名称")
    @NotBlank(message = "品牌名称必须填写")
    @Length(max = 100, message = "品牌名称不能超过100个字符")
    private String brandName;

    @ApiModelProperty(value = "状态，1启用，2禁用")
    @NotNull(message = "状态必须选择")
    private Integer status;

}
