package com.moredian.zhufresh.manager.impl;

import com.moredian.bee.common.exception.BizAssert;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.idgenerator.service.IdgeneratorService;
import com.moredian.zhufresh.domain.Address;
import com.moredian.zhufresh.enums.YesNoFlag;
import com.moredian.zhufresh.manager.AddressManager;
import com.moredian.zhufresh.mapper.AddressMapper;
import com.moredian.zhufresh.request.AddressCreateRequest;
import com.moredian.zhufresh.request.AddressUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressManagerImpl implements AddressManager {

    @Autowired
    private AddressMapper addressMapper;
    @SI
    private IdgeneratorService idgeneratorService;

    private Long genPrimaryKey(String name) {
        return idgeneratorService.getNextIdByTypeName(name).getData();
    }

    private Address requestToDomain(AddressCreateRequest request) {
        Address address = BeanUtils.copyProperties(Address.class, request);
        address.setAddressId(genPrimaryKey(Address.class.getName()));
        address.setCurrentFlag(YesNoFlag.NO.getValue());
        return address;
    }

    @Override
    public Long addAddress(AddressCreateRequest request) {
        BizAssert.notNull(request.getUserId(), "userId is required");
        BizAssert.notNull(request.getBuildingId(), "buildingId is required");
        BizAssert.notBlank(request.getMobile(), "mobile is required");
        BizAssert.notBlank(request.getReceiveName(), "receiveName is required");
        BizAssert.notBlank(request.getAddressInfo(), "addressInfo is required");

        Address address = this.requestToDomain(request);
        addressMapper.insert(address);

        return address.getAddressId();
    }

    private Address requestToDomain(AddressUpdateRequest request) {
        return BeanUtils.copyProperties(Address.class, request);
    }

    @Override
    public boolean updateAddress(AddressUpdateRequest request) {

        BizAssert.notNull(request.getAddressId(), "addressId is required");
        BizAssert.notNull(request.getUserId(), "userId is required");

        Address address = this.requestToDomain(request);
        addressMapper.update(address);

        return true;
    }

    @Override
    public boolean deleteAddress(Long userId, Long addressId) {

        BizAssert.notNull(userId, "userId is required");
        BizAssert.notNull(addressId, "addressId is required");

        addressMapper.delete(userId, addressId);

        return true;
    }

    @Override
    public List<Address> queryAddress(Long userId) {
        BizAssert.notNull(userId, "userId is required");
        return addressMapper.findByUserId(userId);
    }

    @Override
    public Address getCurrent(Long userId) {
        BizAssert.notNull(userId, "userId is required");
        return addressMapper.loadCurrent(userId);
    }

    @Override
    public Address getAddress(Long userId, Long addressId) {
        return addressMapper.load(userId, addressId);
    }

    @Override
    @Transactional
    public boolean toggleCurrent(Long userId, Long addressId) {
        addressMapper.clearCurrentFlag(userId);
        addressMapper.updateCurrentFlag(userId, addressId);
        return true;
    }
}
