package com.zbkj.admin.controller;

import com.zbkj.common.model.product.StoreProductBrand;
import com.zbkj.common.page.CommonPage;
import com.zbkj.common.request.PageParamRequest;
import com.zbkj.common.request.StoreProductBrandRequest;
import com.zbkj.common.request.StoreProductBrandSearchRequest;
import com.zbkj.common.result.CommonResult;
import com.zbkj.service.service.StoreProductBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品品牌管理 前端控制器
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
@RestController
@RequestMapping("api/admin/store/product/brand")
@Api(tags = "商品品牌管理")
public class StoreProductBrandController {

    @Autowired
    private StoreProductBrandService storeProductBrandService;

    @PreAuthorize("hasAuthority('admin:product:brand:list')")
    @ApiOperation(value = "品牌分页列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<StoreProductBrand>> getList(@Validated StoreProductBrandSearchRequest request,
                                                                @Validated PageParamRequest pageParamRequest) {
        List<StoreProductBrand> list = storeProductBrandService.getList(request, pageParamRequest);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @PreAuthorize("hasAuthority('admin:product:brand:list')")
    @ApiOperation(value = "品牌全部列表")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public CommonResult<List<StoreProductBrand>> getAll() {
        return CommonResult.success(storeProductBrandService.list());
    }

    @PreAuthorize("hasAuthority('admin:product:brand:save')")
    @ApiOperation(value = "新增品牌")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public CommonResult<String> save(@Validated StoreProductBrandRequest request) {
        if (storeProductBrandService.add(request)) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @PreAuthorize("hasAuthority('admin:product:brand:update')")
    @ApiOperation(value = "修改品牌")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult<String> update(@RequestParam Integer id, @Validated StoreProductBrandRequest request) {
        if (storeProductBrandService.update(id, request)) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @PreAuthorize("hasAuthority('admin:product:brand:delete')")
    @ApiOperation(value = "删除品牌")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public CommonResult<String> delete(@RequestParam(value = "id") Integer id) {
        if (storeProductBrandService.delete(id)) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @PreAuthorize("hasAuthority('admin:product:brand:info')")
    @ApiOperation(value = "品牌详情")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public CommonResult<StoreProductBrand> info(@RequestParam(value = "id") Integer id) {
        return CommonResult.success(storeProductBrandService.getById(id));
    }

    @PreAuthorize("hasAuthority('admin:product:brand:update')")
    @ApiOperation(value = "切换品牌状态")
    @RequestMapping(value = "/update/status", method = RequestMethod.GET)
    public CommonResult<String> updateStatus(@RequestParam(value = "id") Integer id) {
        if (storeProductBrandService.updateStatus(id)) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

}
