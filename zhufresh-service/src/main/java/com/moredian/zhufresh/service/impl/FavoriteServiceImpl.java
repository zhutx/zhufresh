package com.moredian.zhufresh.service.impl;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.convertor.PaginationConvertor;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.domain.Favorite;
import com.moredian.zhufresh.domain.Menu;
import com.moredian.zhufresh.manager.FavoriteManager;
import com.moredian.zhufresh.model.FavoriteInfo;
import com.moredian.zhufresh.model.MenuInfo;
import com.moredian.zhufresh.request.FavoriteCreateRequest;
import com.moredian.zhufresh.request.FavoriteUpdateRequest;
import com.moredian.zhufresh.service.FavoriteService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@SI
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteManager favoriteManager;

    @Override
    public ServiceResponse<Long> createFavorite(FavoriteCreateRequest request) {
        Long result = favoriteManager.addFavorite(request);
        return new ServiceResponse<>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> updateFavorite(FavoriteUpdateRequest request) {
        boolean result = favoriteManager.updateFavorite(request);
        return new ServiceResponse<>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> deleteFavorite(Long userId, Long favoriteId) {
        boolean result = favoriteManager.deleteFavorite(userId, favoriteId);
        return new ServiceResponse<>(true, null, result);
    }

    private List<FavoriteInfo> favoritesToFavoriteInfos(List<Favorite> favorites) {
        if (CollectionUtils.isEmpty(favorites)) return new ArrayList<>();
        return BeanUtils.copyListProperties(FavoriteInfo.class, favorites);
    }

    @Override
    public List<FavoriteInfo> searchFavorite(Long userId) {
        List<Favorite> favorites = favoriteManager.searchFavorite(userId);
        return favoritesToFavoriteInfos(favorites);
    }

    private List<MenuInfo> menuListToMenuInfoList(List<Menu> menuList) {
        if(CollectionUtils.isEmpty(menuList)) return new ArrayList<>();
        return BeanUtils.copyListProperties(MenuInfo.class, menuList);
    }

    private Pagination<MenuInfo> paginationDomainToPagination(PaginationDomain<Menu> fromPagination) {
        Pagination<MenuInfo> toPagination = PaginationConvertor.paginationDomainToPagination(fromPagination, new Pagination<MenuInfo>());
        if (toPagination == null)
            return null;
        toPagination.setData(menuListToMenuInfoList(fromPagination.getData()));
        return toPagination;
    }

    @Override
    public Pagination<MenuInfo> findMenu(Long userId, Long favoriteId, Pagination<MenuInfo> pagination) {
        PaginationDomain<Menu> paginationDomain = favoriteManager.findMenu(userId, favoriteId, pagination);
        return paginationDomainToPagination(paginationDomain);
    }

    @Override
    public ServiceResponse<Boolean> doFavorite(Long userId, Long favoriteId, Long menuId) {
        boolean result = favoriteManager.doFavorite(userId, favoriteId, menuId);
        return new ServiceResponse<>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> cancelFavorite(Long userId, Long menuId) {
        boolean result = favoriteManager.cancelFavorite(userId, menuId);
        return new ServiceResponse<>(true, null, result);
    }
}
