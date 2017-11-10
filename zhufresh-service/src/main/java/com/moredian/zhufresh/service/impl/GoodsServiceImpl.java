package com.moredian.zhufresh.service.impl;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.convertor.PaginationConvertor;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.domain.Building;
import com.moredian.zhufresh.domain.Goods;
import com.moredian.zhufresh.enums.GoodsStatus;
import com.moredian.zhufresh.manager.GoodsManager;
import com.moredian.zhufresh.model.BuildingInfo;
import com.moredian.zhufresh.model.GoodsInfo;
import com.moredian.zhufresh.request.GoodsCreateRequest;
import com.moredian.zhufresh.request.GoodsQueryRequest;
import com.moredian.zhufresh.request.GoodsUpdateRequest;
import com.moredian.zhufresh.service.GoodsService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@SI
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsManager goodsManager;

    @Override
    public ServiceResponse<Long> createGoods(GoodsCreateRequest request) {
        Long result = goodsManager.addGoods(request);
        return new ServiceResponse<Long>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> updateGoods(GoodsUpdateRequest request) {
        boolean result = goodsManager.updateGoods(request);
        return new ServiceResponse<Boolean>(true, null, result);
    }

    private GoodsInfo goodsToGoodsInfo(Goods goods) {
        if (goods == null) return null;
        return BeanUtils.copyProperties(GoodsInfo.class, goods);
    }

    @Override
    public GoodsInfo getGoods(Long goodsId) {
        Goods goods = goodsManager.getGoods(goodsId);
        return goodsToGoodsInfo(goods);
    }

    @Override
    public ServiceResponse<Boolean> enableGoods(Long goodsId) {
        boolean result = goodsManager.updateStatus(goodsId, GoodsStatus.ENABLE);
        return new ServiceResponse<Boolean>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> disableGoods(Long goodsId) {
        boolean result = goodsManager.updateStatus(goodsId, GoodsStatus.DISABLE);
        return new ServiceResponse<Boolean>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> deleteGoods(Long goodsId) {
        boolean result = goodsManager.updateStatus(goodsId, GoodsStatus.DELETE);
        return new ServiceResponse<Boolean>(true, null, result);
    }

    private List<GoodsInfo> goodsListToGoodsInfoList(List<Goods> goods) {
        if(CollectionUtils.isEmpty(goods)) return new ArrayList<>();
        return BeanUtils.copyListProperties(GoodsInfo.class, goods);
    }

    private Pagination<GoodsInfo> paginationDomainToPagination(PaginationDomain<Goods> fromPagination) {
        Pagination<GoodsInfo> toPagination = PaginationConvertor.paginationDomainToPagination(fromPagination, new Pagination<GoodsInfo>());
        if (toPagination == null)
            return null;
        toPagination.setData(goodsListToGoodsInfoList(fromPagination.getData()));
        return toPagination;
    }

    @Override
    public Pagination<GoodsInfo> searchGoods(GoodsQueryRequest request, Pagination<GoodsInfo> pagination) {
        PaginationDomain<Goods> paginationDomain = goodsManager.searchGoods(request, pagination);
        return paginationDomainToPagination(paginationDomain);
    }
}
