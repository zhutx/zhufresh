package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.Goods;
import com.moredian.zhufresh.domain.GoodsQueryCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {

    int insert(Goods goods);

    int update(Goods goods);

    Goods load(Long goodsId);

    int updateStatus(@Param("goodsId") Long goodsId, @Param("status") Integer status);

    int getTotalCountByCondition(GoodsQueryCondition condition);

    List<Goods> findPaginationByCondition(GoodsQueryCondition condition);

}
