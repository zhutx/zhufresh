package com.moredian.zhufresh.manager.impl;

import com.moredian.bee.common.exception.BizAssert;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.convertor.PaginationConvertor;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.idgenerator.service.IdgeneratorService;
import com.moredian.zhufresh.domain.Building;
import com.moredian.zhufresh.domain.BuildingQueryCondition;
import com.moredian.zhufresh.domain.Goods;
import com.moredian.zhufresh.domain.GoodsQueryCondition;
import com.moredian.zhufresh.enums.GoodsStatus;
import com.moredian.zhufresh.manager.GoodsManager;
import com.moredian.zhufresh.mapper.GoodsMapper;
import com.moredian.zhufresh.model.BuildingInfo;
import com.moredian.zhufresh.model.GoodsInfo;
import com.moredian.zhufresh.request.BuildingQueryRequest;
import com.moredian.zhufresh.request.GoodsCreateRequest;
import com.moredian.zhufresh.request.GoodsQueryRequest;
import com.moredian.zhufresh.request.GoodsUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsManagerImpl implements GoodsManager {

    @Autowired
    private GoodsMapper goodsMapper;
    @SI
    private IdgeneratorService idgeneratorService;

    private Long genPrimaryKey(String name) {
        return idgeneratorService.getNextIdByTypeName(name).getData();
    }

    private Goods requestToDomain(GoodsCreateRequest request) {
        Goods goods = BeanUtils.copyProperties(Goods.class, request);
        goods.setGoodsId(genPrimaryKey(Goods.class.getName()));
        goods.setStatus(GoodsStatus.DISABLE.getValue());
        return goods;
    }
    @Override
    public Long addGoods(GoodsCreateRequest request) {
        BizAssert.notBlank(request.getGoodsName(), "goodsName is required");
        BizAssert.notNull(request.getGoodsType1Id(), "goodsType1Id is required");
        BizAssert.notNull(request.getGoodsType2Id(), "goodsType2Id is required");
        BizAssert.notBlank(request.getGoodsImgUrl(), "goodsImgUrl is required");
        BizAssert.notNull(request.getGoodsUnit(), "goodsUnit is required");
        BizAssert.notNull(request.getGoodsUnitPrice(), "goodsUnitPrice is required");
        BizAssert.notBlank(request.getKeywords(), "keywords is required");
        BizAssert.notBlank(request.getGoodsDesc(), "goodsDesc is required");

        Goods goods = requestToDomain(request);
        goodsMapper.insert(goods);
        return goods.getGoodsId();
    }

    private Goods requestToDomain(GoodsUpdateRequest request) {
        return BeanUtils.copyProperties(Goods.class, request);
    }

    @Override
    public boolean updateGoods(GoodsUpdateRequest request) {
        BizAssert.notNull(request.getGoodsId(), "goodsId is required");
        Goods goods = requestToDomain(request);
        goodsMapper.update(goods);
        return true;
    }

    @Override
    public Goods getGoods(Long goodsId) {
        return goodsMapper.load(goodsId);
    }

    @Override
    public boolean updateStatus(Long goodsId, GoodsStatus goodsStatus) {
        goodsMapper.updateStatus(goodsId, goodsStatus.getValue());
        return true;
    }

    private GoodsQueryCondition requestToCondition(GoodsQueryRequest request) {
        return BeanUtils.copyProperties(GoodsQueryCondition.class, request);
    }

    private PaginationDomain<Goods> paginationToPaginationDomain(Pagination<GoodsInfo> pagination) {
        return PaginationConvertor.paginationToPaginationDomain(pagination, new PaginationDomain<Goods>());
    }

    protected PaginationDomain getPagination(PaginationDomain paginationDomain, GoodsQueryCondition queryCondition) {
        int totalCount = goodsMapper.getTotalCountByCondition(queryCondition);
        paginationDomain.setTotalCount(totalCount);
        if (totalCount > 0) {
            queryCondition.setStartRow(paginationDomain.getStartRow());
            queryCondition.setPageSize(paginationDomain.getPageSize());
            paginationDomain.setData(goodsMapper.findPaginationByCondition(queryCondition));
        }
        return paginationDomain;
    }

    @Override
    public PaginationDomain<Goods> searchGoods(GoodsQueryRequest request, Pagination<GoodsInfo> pagination) {

        GoodsQueryCondition queryCondition = requestToCondition(request);

        PaginationDomain<Goods> paginationDomain = paginationToPaginationDomain(pagination);

        return this.getPagination(paginationDomain, queryCondition);
    }

}
