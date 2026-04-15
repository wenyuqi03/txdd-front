package com.zbkj.front.controller;

import com.zbkj.common.model.product.StoreProductBrand;
import com.zbkj.common.result.CommonResult;
import com.zbkj.service.service.StoreProductBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 移动端 - 商品品牌 前端控制器
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
@Slf4j
@RestController("FrontStoreProductBrandController")
@RequestMapping("api/front")
@Api(tags = "商品品牌")
public class StoreProductBrandController {

    @Autowired
    private StoreProductBrandService storeProductBrandService;

    @ApiOperation(value = "品牌列表")
    @RequestMapping(value = "/brand/list", method = RequestMethod.GET)
    public CommonResult<List<StoreProductBrand>> getList() {
        return CommonResult.success(storeProductBrandService.getFrontList());
    }

}
