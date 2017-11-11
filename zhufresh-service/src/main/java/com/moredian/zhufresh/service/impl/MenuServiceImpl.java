package com.moredian.zhufresh.service.impl;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.convertor.PaginationConvertor;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.domain.*;
import com.moredian.zhufresh.enums.MenuStatus;
import com.moredian.zhufresh.manager.MenuManager;
import com.moredian.zhufresh.model.*;
import com.moredian.zhufresh.request.MenuCreateRequest;
import com.moredian.zhufresh.request.MenuQueryRequest;
import com.moredian.zhufresh.request.MenuUpdateRequest;
import com.moredian.zhufresh.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@SI
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuManager menuManager;

    @Override
    public ServiceResponse<Long> createMenu(MenuCreateRequest request) {
        Long result = menuManager.addMenu(request);
        return new ServiceResponse<>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> updateMenu(MenuUpdateRequest request) {
        boolean result = menuManager.updateMenu(request);
        return new ServiceResponse<>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> deleteMenu(Long menuId) {
        boolean result = menuManager.updateStatus(menuId, MenuStatus.DELETE);
        return new ServiceResponse<>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> enabelMenu(Long menuId) {
        boolean result = menuManager.updateStatus(menuId, MenuStatus.ENABLE);
        return new ServiceResponse<>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> disableMenu(Long menuId) {
        boolean result = menuManager.updateStatus(menuId, MenuStatus.DISABLE);
        return new ServiceResponse<>(true, null, result);
    }

    private MenuInfo menuToMenuInfo(Menu menu) {
        if (menu == null) return null;
        return BeanUtils.copyProperties(MenuInfo.class, menu);
    }

    @Override
    public MenuInfo getMenu(Long menuId) {
        Menu menu = menuManager.getMenu(menuId);
        return menuToMenuInfo(menu);
    }

    @Override
    public ServiceResponse<Boolean> configGoods(Long menuId, List<MenuGoodsInfo> goodsInfos) {
        boolean result = menuManager.configGoods(menuId, goodsInfos);
        return new ServiceResponse<>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> configBulk(Long menuId, List<MenuBulkInfo> bulkInfos) {
        boolean result = menuManager.configBulk(menuId, bulkInfos);
        return new ServiceResponse<>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> configStep(Long menuId, List<MenuStepInfo> stepInfos) {
        boolean result = menuManager.configStep(menuId, stepInfos);
        return new ServiceResponse<>(true, null, result);

    }

    private List<MenuGoodsInfo> menuGoodsListToMenuGoodsInfoList(List<MenuGoods> menuGoodsList) {
        if (CollectionUtils.isEmpty(menuGoodsList)) return new ArrayList<>();
        return BeanUtils.copyListProperties(MenuGoodsInfo.class, menuGoodsList);
    }

    @Override
    public List<MenuGoodsInfo> findGoods(Long menuId) {
        List<MenuGoods> menuGoodsList = menuManager.findGoods(menuId);
        return menuGoodsListToMenuGoodsInfoList(menuGoodsList);
    }

    private List<MenuBulkInfo> menuBulksToMenuBulkInfos(List<MenuBulk> menuBulks) {
        if (CollectionUtils.isEmpty(menuBulks)) return new ArrayList<>();
        return BeanUtils.copyListProperties(MenuBulkInfo.class, menuBulks);
    }

    @Override
    public List<MenuBulkInfo> findBulk(Long menuId) {
        List<MenuBulk> menuBulks = menuManager.findBulk(menuId);
        return menuBulksToMenuBulkInfos(menuBulks);
    }

    private List<MenuStepInfo> menuStepsToMenuStepInfos(List<MenuStep> menuSteps) {
        if (CollectionUtils.isEmpty(menuSteps)) return new ArrayList<>();
        return BeanUtils.copyListProperties(MenuStepInfo.class, menuSteps);
    }

    @Override
    public List<MenuStepInfo> findStep(Long menuId) {
        List<MenuStep> menuSteps = menuManager.findStep(menuId);
        return menuStepsToMenuStepInfos(menuSteps);
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
    public Pagination<MenuInfo> searchMenu(MenuQueryRequest request, Pagination<MenuInfo> pagination) {
        PaginationDomain<Menu> paginationDomain = menuManager.searchMenu(request, pagination);
        return paginationDomainToPagination(paginationDomain);
    }
}
