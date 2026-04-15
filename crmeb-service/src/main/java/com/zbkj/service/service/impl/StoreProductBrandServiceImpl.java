package com.zbkj.service.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.zbkj.common.exception.CrmebException;
import com.zbkj.common.model.product.StoreProductBrand;
import com.zbkj.common.request.PageParamRequest;
import com.zbkj.common.request.StoreProductBrandRequest;
import com.zbkj.common.request.StoreProductBrandSearchRequest;
import com.zbkj.service.dao.StoreProductBrandDao;
import com.zbkj.service.service.StoreProductBrandService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 商品品牌服务实现
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
@Service
public class StoreProductBrandServiceImpl extends ServiceImpl<StoreProductBrandDao, StoreProductBrand> implements StoreProductBrandService {

    @Resource
    private StoreProductBrandDao dao;

    @Override
    public List<StoreProductBrand> getList(StoreProductBrandSearchRequest request, PageParamRequest pageParamRequest) {
        PageHelper.startPage(pageParamRequest.getPage(), pageParamRequest.getLimit());
        LambdaQueryWrapper<StoreProductBrand> wrapper = new LambdaQueryWrapper<>();
        if (StrUtil.isNotBlank(request.getBrandName())) {
            wrapper.like(StoreProductBrand::getBrandName, request.getBrandName());
        }
        if (request.getStatus() != null) {
            wrapper.eq(StoreProductBrand::getStatus, request.getStatus());
        }
        wrapper.orderByDesc(StoreProductBrand::getId);
        return dao.selectList(wrapper);
    }

    @Override
    public Boolean add(StoreProductBrandRequest request) {
        // 校验品牌编号唯一
        LambdaQueryWrapper<StoreProductBrand> wrapper = new LambdaQueryWrapper<>();
        StoreProductBrand brand = new StoreProductBrand();
        BeanUtils.copyProperties(request, brand);
        brand.setCreateTime(new Date());
        brand.setUpdateTime(new Date());
        return save(brand);
    }

    @Override
    public Boolean update(Integer id, StoreProductBrandRequest request) {
        StoreProductBrand existBrand = getById(id);
        if (existBrand == null) {
            throw new CrmebException("品牌不存在");
        }
        StoreProductBrand brand = new StoreProductBrand();
        BeanUtils.copyProperties(request, brand);
        brand.setId(id);
        brand.setUpdateTime(new Date());
        return updateById(brand);
    }

    @Override
    public Boolean delete(Integer id) {
        StoreProductBrand brand = getById(id);
        if (brand == null) {
            throw new CrmebException("品牌不存在");
        }
        return removeById(id);
    }

    @Override
    public Boolean updateStatus(Integer id) {
        StoreProductBrand brand = getById(id);
        if (brand == null) {
            throw new CrmebException("品牌不存在");
        }
        StoreProductBrand updateBrand = new StoreProductBrand();
        updateBrand.setId(id);
        updateBrand.setStatus(brand.getStatus().equals(1) ? 2 : 1);
        updateBrand.setUpdateTime(new Date());
        return updateById(updateBrand);
    }

    @Override
    public List<StoreProductBrand> getFrontList() {
        LambdaQueryWrapper<StoreProductBrand> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StoreProductBrand::getStatus, 1);
        wrapper.orderByDesc(StoreProductBrand::getId);
        return dao.selectList(wrapper);
    }

}
