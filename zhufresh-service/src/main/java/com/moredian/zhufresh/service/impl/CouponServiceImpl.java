package com.moredian.zhufresh.service.impl;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.convertor.PaginationConvertor;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.domain.Coupon;
import com.moredian.zhufresh.domain.Ticket;
import com.moredian.zhufresh.manager.CouponManager;
import com.moredian.zhufresh.model.CouponInfo;
import com.moredian.zhufresh.model.TicketInfo;
import com.moredian.zhufresh.request.CouponQueryRequest;
import com.moredian.zhufresh.service.CouponService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@SI
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponManager couponManager;

    @Override
    public ServiceResponse<Boolean> batchCreateCoupon(Integer price, Integer amount) {
        boolean result = couponManager.batchCreateCoupon(price, amount);
        return new ServiceResponse<>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> bindUser(Long userId, String couponCode) {
        boolean result = couponManager.bindUser(userId, couponCode);
        return new ServiceResponse<>(true, null, result);
    }

    private List<CouponInfo> couponListToCouponInfoList(List<Coupon> couponList) {
        if(CollectionUtils.isEmpty(couponList)) return new ArrayList<>();
        return BeanUtils.copyListProperties(CouponInfo.class, couponList);
    }

    private Pagination<CouponInfo> paginationDomainToPagination(PaginationDomain<Coupon> fromPagination) {
        Pagination<CouponInfo> toPagination = PaginationConvertor.paginationDomainToPagination(fromPagination, new Pagination<CouponInfo>());
        if (toPagination == null)
            return null;
        toPagination.setData(couponListToCouponInfoList(fromPagination.getData()));
        return toPagination;
    }

    @Override
    public Pagination<CouponInfo> searchCoupon(CouponQueryRequest request, Pagination<CouponInfo> pagination) {
        PaginationDomain<Coupon> paginationDomain = couponManager.searchCoupon(request, pagination);
        return paginationDomainToPagination(paginationDomain);
    }

    private CouponInfo couponToCouponInfo(Coupon coupon) {
        if (coupon == null) return null;
        return BeanUtils.copyProperties(CouponInfo.class, coupon);
    }

    @Override
    public CouponInfo getOneCoupon(Long userId) {
        Coupon coupon = couponManager.getOneCoupon(userId);
        return couponToCouponInfo(coupon);
    }
}
