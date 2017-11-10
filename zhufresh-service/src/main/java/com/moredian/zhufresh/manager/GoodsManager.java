package com.moredian.zhufresh.manager;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.zhufresh.domain.Building;
import com.moredian.zhufresh.domain.Goods;
import com.moredian.zhufresh.enums.GoodsStatus;
import com.moredian.zhufresh.model.BuildingInfo;
import com.moredian.zhufresh.model.GoodsInfo;
import com.moredian.zhufresh.request.BuildingQueryRequest;
import com.moredian.zhufresh.request.GoodsCreateRequest;
import com.moredian.zhufresh.request.GoodsQueryRequest;
import com.moredian.zhufresh.request.GoodsUpdateRequest;

public interface GoodsManager {

    Long addGoods(GoodsCreateRequest request);

    boolean updateGoods(GoodsUpdateRequest request);

    Goods getGoods(Long goodsId);

    boolean updateStatus(Long goodsId, GoodsStatus goodsStatus);

    PaginationDomain<Goods> searchGoods(GoodsQueryRequest request, Pagination<GoodsInfo> pagination);

}
