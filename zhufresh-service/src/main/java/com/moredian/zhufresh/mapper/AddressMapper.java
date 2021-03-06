package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AddressMapper {

    int insert(Address address);

    int update(Address address);

    int delete(@Param("userId") Long userId, @Param("addressId") Long addressId);

    Address load(@Param("userId") Long userId, @Param("addressId") Long addressId);

    Address loadCurrent(@Param("userId") Long userId);

    List<Address> findByUserId(@Param("userId") Long userId);

    int clearCurrentFlag(@Param("userId") Long userId);

    int updateCurrentFlag(@Param("userId") Long userId, @Param("addressId") Long addressId);

}
