package com.moredian.zhufresh.manager;

import com.moredian.zhufresh.domain.Address;
import com.moredian.zhufresh.request.AddressCreateRequest;
import com.moredian.zhufresh.request.AddressUpdateRequest;

import java.util.List;

public interface AddressManager {

    Long addAddress(AddressCreateRequest request);

    boolean updateAddress(AddressUpdateRequest request);

    boolean deleteAddress(Long userId, Long addressId);

    List<Address> queryAddress(Long userId);

}
