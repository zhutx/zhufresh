package com.moredian.zhufresh.manager.impl;

import com.moredian.bee.common.exception.BizAssert;
import com.moredian.bee.common.utils.ExceptionUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.idgenerator.dto.BatchIdDto;
import com.moredian.idgenerator.service.IdgeneratorService;
import com.moredian.zhufresh.domain.Coupon;
import com.moredian.zhufresh.domain.Ticket;
import com.moredian.zhufresh.enums.CouponStatus;
import com.moredian.zhufresh.enums.ZhufreshErrorCode;
import com.moredian.zhufresh.manager.CouponManager;
import com.moredian.zhufresh.mapper.CouponMapper;
import com.moredian.zhufresh.model.CouponInfo;
import com.moredian.zhufresh.request.CouponQueryRequest;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;

@Service
public class CouponManagerImpl implements CouponManager {

    @Autowired
    private CouponMapper couponMapper;
    @SI
    private IdgeneratorService idgeneratorService;

    private BatchIdDto batchGenPrimaryKey(String name, int amount) {
        return idgeneratorService.getNextIdBatchBytypeName(name, amount).getData();
    }

    @Override
    @Transactional
    public boolean batchCreateCoupon(Integer couponPrice, Integer amount) {

        BizAssert.notNull(couponPrice, "price is required");
        BizAssert.notNull(amount, "amount is required");

        BatchIdDto batchIdDto = batchGenPrimaryKey(Ticket.class.getName(), amount);

        for (int i = 0; i < amount; i++) {
            Coupon coupon = new Coupon();
            coupon.setCouponId(batchIdDto.nextId());
            coupon.setCouponCode(RandomStringUtils.randomAlphanumeric(8));
            coupon.setCouponPrice(couponPrice);
            coupon.setStatus(CouponStatus.NEW.getValue());

            couponMapper.insert(coupon);
        }

        return true;
    }

    @Override
    public boolean bindUser(Long userId, String couponCode) {

        BizAssert.notNull(userId, "userId is required");
        BizAssert.notBlank(couponCode, "couponCode is required");

        Coupon coupon = couponMapper.loadByCode(couponCode);
        if (coupon == null || coupon.getStatus() != CouponStatus.NEW.getValue()) {
            ExceptionUtils.throwException(ZhufreshErrorCode.COUPON_CODE_FAIL, ZhufreshErrorCode.COUPON_CODE_FAIL.getMessage());
        }

        coupon.setStatus(CouponStatus.ENABLE.getValue());
        coupon.setBindUserId(userId);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        coupon.setBindDate(cal.getTime());

        cal.add(Calendar.DATE, 8);

        coupon.setExpireDate(cal.getTime());
        couponMapper.bindUser(coupon);

        return true;
    }

    @Override
    public PaginationDomain<Coupon> searchCoupon(CouponQueryRequest request, Pagination<CouponInfo> pagination) {
        return null;
    }

    @Override
    public Coupon getOneCoupon(Long userId) {
        return couponMapper.loadForUse(userId, CouponStatus.ENABLE.getValue());
    }

    @Override
    public boolean useOneCoupon(Long couponId, Long userId, Long orderId) {
        Date useTime = new Date();
        couponMapper.updateByUse(couponId, userId, orderId, useTime, CouponStatus.USED.getValue());
        return true;
    }

    @Override
    public boolean autoExpire() {
        couponMapper.updateByExpire(CouponStatus.EXPIRE.getValue());
        return true;
    }
}
