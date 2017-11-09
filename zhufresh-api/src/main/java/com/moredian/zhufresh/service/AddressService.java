package com.moredian.zhufresh.service;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.zhufresh.model.AddressInfo;
import com.moredian.zhufresh.request.AddressCreateRequest;
import com.moredian.zhufresh.request.AddressUpdateRequest;

import java.util.List;

/**
 * 地址服务
 *
 * @author zhutx
 */
public interface AddressService {

    ServiceResponse<Long> createAddress(AddressCreateRequest request);

    ServiceResponse<Boolean> updateAddress(AddressUpdateRequest request);

    ServiceResponse<Boolean> deleteAddress(Long userId, Long addressId);

    List<AddressInfo> searchAddress(Long userId);

    AddressInfo getAddress(Long userId, Long addressId);

    ServiceResponse<Boolean> toggleCurrent(Long userId, Long addressId);

    AddressInfo getCurrent(Long userId);

}
