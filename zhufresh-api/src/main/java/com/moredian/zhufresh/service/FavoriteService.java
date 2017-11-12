package com.moredian.zhufresh.service;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.zhufresh.model.FavoriteInfo;
import com.moredian.zhufresh.model.MenuInfo;
import com.moredian.zhufresh.request.FavoriteCreateRequest;
import com.moredian.zhufresh.request.FavoriteUpdateRequest;

import java.util.List;

/**
 * 收藏服务
 * @author zhutx
 *
 */
public interface FavoriteService {

    ServiceResponse<Long> createFavorite(FavoriteCreateRequest request);

    ServiceResponse<Boolean> updateFavorite(FavoriteUpdateRequest request);

    ServiceResponse<Boolean> deleteFavorite(Long userId, Long favoriteId);

    List<FavoriteInfo> searchFavorite(Long userId);

    Pagination<MenuInfo> findMenu(Long userId, Long favoriteId, Pagination<MenuInfo> pagination);

    ServiceResponse<Boolean> doFavorite(Long userId, Long favoriteId, Long menuId);

    ServiceResponse<Boolean> cancelFavorite(Long userId, Long menuId);

}
