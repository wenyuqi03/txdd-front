package com.zbkj.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zbkj.common.model.product.StoreProductBrand;
import com.zbkj.common.request.PageParamRequest;
import com.zbkj.common.request.StoreProductBrandRequest;
import com.zbkj.common.request.StoreProductBrandSearchRequest;

import java.util.List;

/**
 * 商品品牌服务接口
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
public interface StoreProductBrandService extends IService<StoreProductBrand> {

    /**
     * 品牌分页列表
     */
    List<StoreProductBrand> getList(StoreProductBrandSearchRequest request, PageParamRequest pageParamRequest);

    /**
     * 新增品牌
     */
    Boolean add(StoreProductBrandRequest request);

    /**
     * 修改品牌
     */
    Boolean update(Integer id, StoreProductBrandRequest request);

    /**
     * 删除品牌
     */
    Boolean delete(Integer id);

    /**
     * 切换品牌状态
     */
    Boolean updateStatus(Integer id);

    /**
     * 品牌列表（不分页，支持过滤）
     */
    List<StoreProductBrand> getList(StoreProductBrandSearchRequest request);

    /**
     * 移动端品牌列表（仅启用状态）
     */
    List<StoreProductBrand> getFrontList();

}
