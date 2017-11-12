package com.moredian.zhufresh.manager;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.zhufresh.domain.Favorite;
import com.moredian.zhufresh.domain.Menu;
import com.moredian.zhufresh.model.FavoriteInfo;
import com.moredian.zhufresh.model.MenuInfo;
import com.moredian.zhufresh.request.FavoriteCreateRequest;
import com.moredian.zhufresh.request.FavoriteUpdateRequest;

import java.util.List;

public interface FavoriteManager {

    Long addFavorite(FavoriteCreateRequest request);

    boolean updateFavorite(FavoriteUpdateRequest request);

    boolean deleteFavorite(Long userId, Long favoriteId);

    List<Favorite> searchFavorite(Long userId);

    PaginationDomain<Menu> findMenu(Long userId, Long favoriteId, Pagination<MenuInfo> pagination);

    boolean doFavorite(Long userId, Long favoriteId, Long menuId);

    boolean cancelFavorite(Long userId, Long menuId);
}
