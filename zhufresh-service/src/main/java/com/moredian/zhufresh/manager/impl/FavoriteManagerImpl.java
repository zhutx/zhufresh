package com.moredian.zhufresh.manager.impl;

import com.moredian.bee.common.exception.BizAssert;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.ExceptionUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.convertor.PaginationConvertor;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.idgenerator.service.IdgeneratorService;
import com.moredian.zhufresh.domain.Favorite;
import com.moredian.zhufresh.domain.FavoriteMenu;
import com.moredian.zhufresh.domain.Menu;
import com.moredian.zhufresh.domain.MenuQueryCondition;
import com.moredian.zhufresh.enums.ZhufreshErrorCode;
import com.moredian.zhufresh.manager.FavoriteManager;
import com.moredian.zhufresh.mapper.FavoriteMapper;
import com.moredian.zhufresh.mapper.FavoriteMenuMapper;
import com.moredian.zhufresh.mapper.MenuMapper;
import com.moredian.zhufresh.model.MenuInfo;
import com.moredian.zhufresh.request.FavoriteCreateRequest;
import com.moredian.zhufresh.request.FavoriteUpdateRequest;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriteManagerImpl implements FavoriteManager {

    @Autowired
    private FavoriteMapper favoriteMapper;
    @Autowired
    private FavoriteMenuMapper favoriteMenuMapper;
    @Autowired
    private MenuMapper menuMapper;
    @SI
    private IdgeneratorService idgeneratorService;

    private Long genPrimaryKey(String name) {
        return idgeneratorService.getNextIdByTypeName(name).getData();
    }

    private Favorite requestToDomain(FavoriteCreateRequest request) {
        Favorite favorite = BeanUtils.copyProperties(Favorite.class, request);
        favorite.setFavoriteId(genPrimaryKey(Favorite.class.getName()));
        return favorite;
    }

    @Override
    public Long addFavorite(FavoriteCreateRequest request) {
        BizAssert.notNull(request.getUserId(), "userId is required");
        BizAssert.notBlank(request.getFavoriteName(), "favoriteName is required");
        Favorite favorite = requestToDomain(request);
        favoriteMapper.insert(favorite);
        return favorite.getFavoriteId();
    }

    private Favorite requestToDomain(FavoriteUpdateRequest request) {
        return BeanUtils.copyProperties(Favorite.class, request);
    }

    @Override
    public boolean updateFavorite(FavoriteUpdateRequest request) {
        BizAssert.notNull(request.getFavoriteId(), "favoriteId is required");
        BizAssert.notNull(request.getUserId(), "userId is required");
        BizAssert.notBlank(request.getFavoriteName(), "favoriteName is required");
        favoriteMapper.update(requestToDomain(request));
        return true;
    }

    @Override
    public boolean deleteFavorite(Long userId, Long favoriteId) {
        BizAssert.notNull(userId, "userId is required");
        BizAssert.notNull(favoriteId, "favoriteId is required");

        List<Long> menuIds = favoriteMenuMapper.findMenuId(userId, favoriteId);
        if (CollectionUtils.isNotEmpty(menuIds)) {
            ExceptionUtils.throwException(ZhufreshErrorCode.FAVORITE_CONTAINS_MENU, ZhufreshErrorCode.FAVORITE_CONTAINS_MENU.getMessage());
        }
        favoriteMapper.delete(userId, favoriteId);
        return true;
    }

    @Override
    public List<Favorite> searchFavorite(Long userId) {
        BizAssert.notNull(userId, "userId is required");
        return favoriteMapper.findByUserId(userId);
    }

    private PaginationDomain<Menu> paginationToPaginationDomain(Pagination<MenuInfo> pagination) {
        return PaginationConvertor.paginationToPaginationDomain(pagination, new PaginationDomain<Menu>());
    }

    private PaginationDomain getPagination(PaginationDomain paginationDomain, List<Long> menuIds) {
        int totalCount = menuIds.size();
        paginationDomain.setTotalCount(totalCount);
        if (totalCount > 0) {
            paginationDomain.setData(menuMapper.findPaginationByIds(menuIds, paginationDomain.getStartRow(), paginationDomain.getPageSize()));
        }
        return paginationDomain;
    }

    @Override
    public PaginationDomain<Menu> findMenu(Long userId, Long favoriteId, Pagination<MenuInfo> pagination) {

        BizAssert.notNull(userId, "userId is required");
        BizAssert.notNull(favoriteId, "favoriteId is required");

        List<Long> menuIds = favoriteMenuMapper.findMenuId(userId, favoriteId);

        if (CollectionUtils.isEmpty(menuIds)) return new PaginationDomain<>();

        PaginationDomain<Menu> paginationDomain = paginationToPaginationDomain(pagination);

        return this.getPagination(paginationDomain, menuIds);
    }

    @Override
    @Transactional
    public boolean doFavorite(Long userId, Long favoriteId, Long menuId) {
        BizAssert.notNull(userId, "userId is required");
        BizAssert.notNull(favoriteId, "favoriteId is required");
        BizAssert.notNull(menuId, "menuId is required");

        favoriteMenuMapper.deleteOne(userId, favoriteId, menuId);

        FavoriteMenu favoriteMenu = new FavoriteMenu();
        favoriteMenu.setFavoriteMenuId(genPrimaryKey(FavoriteMenu.class.getName()));
        favoriteMenu.setUserId(userId);
        favoriteMenu.setFavoriteId(favoriteId);
        favoriteMenu.setMenuId(menuId);

        favoriteMenuMapper.insert(favoriteMenu);

        return true;
    }

    @Override
    public boolean cancelFavorite(Long userId, Long menuId) {
        BizAssert.notNull(userId, "userId is required");
        BizAssert.notNull(menuId, "menuId is required");

        favoriteMenuMapper.deleteByMenuId(userId, menuId);

        return true;
    }
}
