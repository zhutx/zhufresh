package com.moredian.zhufresh.web.controller.coupon;

import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.common.web.BaseResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.model.CouponInfo;
import com.moredian.zhufresh.model.GoodsInfo;
import com.moredian.zhufresh.request.CouponQueryRequest;
import com.moredian.zhufresh.request.GoodsQueryRequest;
import com.moredian.zhufresh.service.CouponService;
import com.moredian.zhufresh.utils.AuthorizeUtil;
import com.moredian.zhufresh.web.controller.coupon.request.BindUserModel;
import com.moredian.zhufresh.web.controller.coupon.request.CouponBatchCreateModel;
import com.moredian.zhufresh.web.controller.coupon.request.CouponQueryModel;
import com.moredian.zhufresh.web.controller.coupon.response.CouponData;
import com.moredian.zhufresh.web.controller.coupon.response.PaginationCouponData;
import com.moredian.zhufresh.web.controller.goods.request.GoodsQueryModel;
import com.moredian.zhufresh.web.controller.goods.response.GoodsData;
import com.moredian.zhufresh.web.controller.goods.response.PaginationGoodsData;
import com.moredian.zhufresh.web.controller.ticket.request.TicketLongTimeBatchCreateModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@RestController
@RequestMapping(value="/coupon")
public class CouponController {

    @SI
    private CouponService couponService;

    @RequestMapping(value="/batchCreate", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse batchCreate(@RequestBody CouponBatchCreateModel model) {
        couponService.batchCreateCoupon(model.getCouponPrice(), model.getAmount()).pickDataThrowException();
        return new BaseResponse();
    }

    @RequestMapping(value="/bind", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse bindUser(@RequestBody BindUserModel model) {
        couponService.bindUser(model.getUserId(), model.getCouponCode()).pickDataThrowException();
        return new BaseResponse();
    }

    private CouponData couponInfoToCouponData(CouponInfo couponInfo) {
        if (couponInfo == null) return null;
        return BeanUtils.copyProperties(CouponData.class, couponInfo);
    }

    @RequestMapping(value="/fetchOne", method= RequestMethod.GET)
    @ResponseBody
    public BaseResponse fetchOne() {
        CouponInfo couponInfo = couponService.getOneCoupon(AuthorizeUtil.getUserId());
        CouponData data = couponInfoToCouponData(couponInfo);
        BaseResponse<CouponData> br = new BaseResponse<>();
        br.setData(data);
        return br;
    }

    private CouponQueryRequest buildRequest(CouponQueryModel model) {
        return BeanUtils.copyProperties(CouponQueryRequest.class, model);
    }

    private Pagination<CouponInfo> buildPagination(int pageNo, int pageSize) {
        Pagination<CouponInfo> pagination = new Pagination<>();
        pagination.setPageNo(pageNo);
        pagination.setPageSize(pageSize);
        return pagination;
    }

    private PaginationCouponData paginationToPaginationData(Pagination<CouponInfo> pagination) {
        PaginationCouponData data = new PaginationCouponData();
        data.setPageNo(pagination.getPageNo());
        data.setTotalCount(pagination.getTotalCount());
        data.setCoupons(BeanUtils.copyListProperties(CouponData.class, pagination.getData()));
        return data;
    }

    @RequestMapping(value="/list", method= RequestMethod.GET)
    @ResponseBody
    public BaseResponse list(@RequestParam(value = "beginDate", required = false) String beginDate, @RequestParam(value = "endDate", required = false) String endDate, @RequestParam(value = "status", required = false) Integer status) {

        CouponQueryModel model = new CouponQueryModel();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (StringUtils.isNotBlank(beginDate)) {
            try {
                model.setBeginTime(sdf.parse(beginDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (StringUtils.isNotBlank(endDate)) {
            try {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(sdf.parse(endDate));
                calendar.add(Calendar.DATE, 1);
                model.setEndTime(calendar.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        model.setStatus(status);

        Pagination<CouponInfo> pagination = couponService.searchCoupon(this.buildRequest(model), this.buildPagination(model.getPageNo(), model.getPageSize()));
        BaseResponse<PaginationCouponData> br = new BaseResponse<>();
        br.setData(paginationToPaginationData(pagination));
        return br;

    }

}
