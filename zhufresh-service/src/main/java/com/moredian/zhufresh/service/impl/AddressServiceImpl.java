package com.moredian.zhufresh.service.impl;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.domain.Address;
import com.moredian.zhufresh.manager.AddressManager;
import com.moredian.zhufresh.model.AddressInfo;
import com.moredian.zhufresh.request.AddressCreateRequest;
import com.moredian.zhufresh.request.AddressUpdateRequest;
import com.moredian.zhufresh.service.AddressService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SI
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressManager addressManager;

    @Override
    public ServiceResponse<Long> createAddress(AddressCreateRequest request) {
        Long result = addressManager.addAddress(request);
        return new ServiceResponse<>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> updateAddress(AddressUpdateRequest request) {
        boolean result = addressManager.updateAddress(request);
        return new ServiceResponse<>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> deleteAddress(Long userId, Long addressId) {
        boolean result = addressManager.deleteAddress(userId, addressId);
        return new ServiceResponse<>(true, null, result);
    }

    private List<AddressInfo> addressListToAddressInfoList(List<Address> addressList) {
        if (CollectionUtils.isEmpty(addressList)) return new ArrayList<>();
        return BeanUtils.copyListProperties(AddressInfo.class, addressList);
    }

    @Override
    public List<AddressInfo> searchAddress(Long userId) {
        List<Address> addressList = addressManager.queryAddress(userId);
        return addressListToAddressInfoList(addressList);
    }

    private AddressInfo addressToAddressInfo(Address address) {
        if (address == null) return null;
        return BeanUtils.copyProperties(AddressInfo.class, address);
    }

    @Override
    public AddressInfo getAddress(Long userId, Long addressId) {
        Address address = addressManager.getAddress(userId, addressId);
        return addressToAddressInfo(address);
    }

    @Override
    public AddressInfo getCurrent(Long userId) {
        Address address = addressManager.getCurrent(userId);
        return addressToAddressInfo(address);
    }

    @Override
    public ServiceResponse<Boolean> toggleCurrent(Long userId, Long addressId) {
        boolean result = addressManager.toggleCurrent(userId, addressId);
        return new ServiceResponse<Boolean>(true, null, result);
    }
}
