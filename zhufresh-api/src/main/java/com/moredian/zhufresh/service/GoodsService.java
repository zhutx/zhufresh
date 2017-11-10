package com.moredian.zhufresh.service;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.zhufresh.model.BuildingInfo;
import com.moredian.zhufresh.model.GoodsInfo;
import com.moredian.zhufresh.request.BuildingQueryRequest;
import com.moredian.zhufresh.request.GoodsCreateRequest;
import com.moredian.zhufresh.request.GoodsQueryRequest;
import com.moredian.zhufresh.request.GoodsUpdateRequest;

/**
 * 食材服务
 * @author zhutx
 *
 */
public interface GoodsService {

    ServiceResponse<Long> createGoods(GoodsCreateRequest request);

    ServiceResponse<Boolean> updateGoods(GoodsUpdateRequest request);

    GoodsInfo getGoods(Long goodsId);

    ServiceResponse<Boolean> enableGoods(Long goodsId);

    ServiceResponse<Boolean> disableGoods(Long goodsId);

    ServiceResponse<Boolean> deleteGoods(Long goodsId);

    Pagination<GoodsInfo> searchGoods(GoodsQueryRequest request, Pagination<GoodsInfo> pagination);

}
