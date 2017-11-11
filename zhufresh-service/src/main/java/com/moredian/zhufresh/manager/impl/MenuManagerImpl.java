package com.moredian.zhufresh.manager.impl;

import com.moredian.bee.common.exception.BizAssert;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.convertor.PaginationConvertor;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.idgenerator.service.IdgeneratorService;
import com.moredian.zhufresh.domain.*;
import com.moredian.zhufresh.enums.MenuStatus;
import com.moredian.zhufresh.manager.MenuManager;
import com.moredian.zhufresh.mapper.MenuBulkMapper;
import com.moredian.zhufresh.mapper.MenuGoodsMapper;
import com.moredian.zhufresh.mapper.MenuMapper;
import com.moredian.zhufresh.mapper.MenuStepMapper;
import com.moredian.zhufresh.model.*;
import com.moredian.zhufresh.request.GoodsQueryRequest;
import com.moredian.zhufresh.request.MenuCreateRequest;
import com.moredian.zhufresh.request.MenuQueryRequest;
import com.moredian.zhufresh.request.MenuUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuManagerImpl implements MenuManager {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private MenuGoodsMapper menuGoodsMapper;
    @Autowired
    private MenuBulkMapper menuBulkMapper;
    @Autowired
    private MenuStepMapper menuStepMapper;
    @SI
    private IdgeneratorService idgeneratorService;

    private Long genPrimaryKey(String name) {
        return idgeneratorService.getNextIdByTypeName(name).getData();
    }

    private Menu requestToDomain(MenuCreateRequest request) {
        Menu menu = BeanUtils.copyProperties(Menu.class, request);
        menu.setMenuId(genPrimaryKey(Menu.class.getName()));
        menu.setStatus(MenuStatus.DISABLE.getValue());
        return menu;
    }

    @Override
    public Long addMenu(MenuCreateRequest request) {
        BizAssert.notBlank(request.getMenuName(), "menuName is required");
        BizAssert.notBlank(request.getMenuImgUrl(), "menuImgUrl is required");
        BizAssert.notNull(request.getCookieWay(), "cookieWay is required");
        BizAssert.notNull(request.getCookieTime(), "cookieTime is required");

        Menu menu = requestToDomain(request);
        menuMapper.insert(menu);

        return menu.getMenuId();
    }

    private Menu requestToDomain(MenuUpdateRequest request) {
        return BeanUtils.copyProperties(Menu.class, request);
    }

    @Override
    public boolean updateMenu(MenuUpdateRequest request) {
        BizAssert.notNull(request.getMenuId(), "menuId is required");

        Menu menu = requestToDomain(request);
        menuMapper.update(menu);

        return true;
    }

    @Override
    public boolean updateStatus(Long menuId, MenuStatus menuStatus) {

        BizAssert.notNull(menuId, "menuId is required");
        BizAssert.notNull(menuStatus, "menuStatus is required");

        menuMapper.updateStatus(menuId, menuStatus.getValue());

        return true;
    }

    @Override
    public Menu getMenu(Long menuId) {
        BizAssert.notNull(menuId, "menuId is required");
        return menuMapper.load(menuId);
    }

    private List<Long> fetchFinalGoodsIdsInMenuGoods(List<MenuGoodsInfo> goodsInfos) {
        List<Long> finalGoodsIds = new ArrayList<>();
        for (MenuGoodsInfo menuGoodsInfo : goodsInfos) {
            finalGoodsIds.add(menuGoodsInfo.getGoodsId());
        }
        return finalGoodsIds;
    }

    @Override
    @Transactional
    public boolean configGoods(Long menuId, List<MenuGoodsInfo> menuGoodsInfos) {
        BizAssert.notNull(menuId, "menuId is required");
        BizAssert.notEmpty(menuGoodsInfos);

        List<Long> existGoodsIds = menuGoodsMapper.findGoodIdsByMenuId(menuId);
        List<Long> finalGoodsIds = fetchFinalGoodsIdsInMenuGoods(menuGoodsInfos);
        List<Long> tempFinalGoodsIds = new ArrayList<>();
        tempFinalGoodsIds.addAll(finalGoodsIds);
        List<Long> tempExistGoodsIds = new ArrayList<>();
        tempExistGoodsIds.addAll(existGoodsIds);

        finalGoodsIds.removeAll(existGoodsIds); // 定位增加的菜谱食材
        existGoodsIds.removeAll(tempFinalGoodsIds); // 定位移除的菜谱食材
        tempFinalGoodsIds.retainAll(tempExistGoodsIds); // 定位修改的菜谱食材

        for (MenuGoodsInfo menuGoodsInfo : menuGoodsInfos) {

            if (finalGoodsIds.contains(menuGoodsInfo.getGoodsId())) { // 增加的菜谱食材
                MenuGoods menuGoods = BeanUtils.copyProperties(MenuGoods.class, menuGoodsInfo);
                menuGoods.setMenuGoodsId(genPrimaryKey(MenuGoods.class.getName()));
                menuGoods.setMenuId(menuId);
                menuGoodsMapper.insert(menuGoods);
            }

            if (existGoodsIds.contains(menuGoodsInfo.getGoodsId())) { // 移除的菜谱食材
                menuGoodsMapper.deleteByGoodsId(menuId, menuGoodsInfo.getGoodsId());
            }

            if (tempFinalGoodsIds.contains(menuGoodsInfo.getGoodsId())) { // 修改的菜谱食材
                menuGoodsMapper.updateByGoodsId(menuId, menuGoodsInfo.getGoodsId(), menuGoodsInfo.getWeight());
            }

        }

        return true;
    }

    private List<Long> fetchFinalGoodsIdsInMenuBulks(List<MenuBulkInfo> menuBulkInfos) {
        List<Long> finalGoodsIds = new ArrayList<>();
        for (MenuBulkInfo menuBulkInfo : menuBulkInfos) {
            finalGoodsIds.add(menuBulkInfo.getRelationGoodsId());
        }
        return finalGoodsIds;
    }

    @Override
    @Transactional
    public boolean configBulk(Long menuId, List<MenuBulkInfo> menuBulkInfos) {
        BizAssert.notNull(menuId, "menuId is required");
        BizAssert.notEmpty(menuBulkInfos);

        List<Long> existGoodsIds = menuBulkMapper.findGoodIdsByMenuId(menuId);
        List<Long> finalGoodsIds = fetchFinalGoodsIdsInMenuBulks(menuBulkInfos);
        List<Long> tempFinalGoodsIds = new ArrayList<>();
        tempFinalGoodsIds.addAll(finalGoodsIds);
        List<Long> tempExistGoodsIds = new ArrayList<>();
        tempExistGoodsIds.addAll(existGoodsIds);

        finalGoodsIds.removeAll(existGoodsIds); // 定位增加的菜谱辅料
        existGoodsIds.removeAll(tempFinalGoodsIds); // 定位移除的菜谱辅料
        tempFinalGoodsIds.retainAll(tempExistGoodsIds); // 定位修改的菜谱辅料

        for (MenuBulkInfo menuBulkInfo : menuBulkInfos) {

            if (finalGoodsIds.contains(menuBulkInfo.getRelationGoodsId())) { // 增加的菜谱辅料
                MenuBulk menuBulk = BeanUtils.copyProperties(MenuBulk.class, menuBulkInfo);
                menuBulk.setMenuBulkId(genPrimaryKey(MenuBulk.class.getName()));
                menuBulk.setMenuId(menuId);
                menuBulkMapper.insert(menuBulk);
            }

            if (existGoodsIds.contains(menuBulkInfo.getRelationGoodsId())) { // 移除的菜谱辅料
                menuBulkMapper.deleteByGoodsId(menuId, menuBulkInfo.getRelationGoodsId());
            }

            if (tempFinalGoodsIds.contains(menuBulkInfo.getRelationGoodsId())) { // 修改的菜谱辅料
                menuBulkMapper.updateByGoodsId(menuId, menuBulkInfo.getRelationGoodsId(), menuBulkInfo.getBulkName(), menuBulkInfo.getWeightText());
            }

        }

        return true;
    }

    @Override
    @Transactional
    public boolean configStep(Long menuId, List<MenuStepInfo> menuStepInfos) {
        BizAssert.notNull(menuId, "menuId is required");
        BizAssert.notEmpty(menuStepInfos);

        menuStepMapper.deleteByMenuId(menuId);

        int stepNumber = 0;
        for (MenuStepInfo menuStepInfo : menuStepInfos) {
            MenuStep menuStep = BeanUtils.copyProperties(MenuStep.class, menuStepInfo);
            menuStep.setMenuStepId(genPrimaryKey(MenuStep.class.getName()));
            menuStep.setMenuId(menuId);
            menuStep.setStepNumber(++stepNumber);
            menuStepMapper.insert(menuStep);
        }

        return true;
    }

    @Override
    public List<MenuGoods> findGoods(Long menuId) {
        BizAssert.notNull(menuId, "menuId is required");
        return menuGoodsMapper.findByMenuId(menuId);
    }

    @Override
    public List<MenuBulk> findBulk(Long menuId) {
        BizAssert.notNull(menuId, "menuId is required");
        return menuBulkMapper.findByMenuId(menuId);
    }

    @Override
    public List<MenuStep> findStep(Long menuId) {
        BizAssert.notNull(menuId, "menuId is required");
        return menuStepMapper.findByMenuId(menuId);
    }

    private MenuQueryCondition requestToCondition(MenuQueryRequest request) {
        return BeanUtils.copyProperties(MenuQueryCondition.class, request);
    }

    private PaginationDomain<Menu> paginationToPaginationDomain(Pagination<MenuInfo> pagination) {
        return PaginationConvertor.paginationToPaginationDomain(pagination, new PaginationDomain<Menu>());
    }

    private PaginationDomain getPagination(PaginationDomain paginationDomain, MenuQueryCondition queryCondition) {
        int totalCount = menuMapper.getTotalCountByCondition(queryCondition);
        paginationDomain.setTotalCount(totalCount);
        if (totalCount > 0) {
            queryCondition.setStartRow(paginationDomain.getStartRow());
            queryCondition.setPageSize(paginationDomain.getPageSize());
            paginationDomain.setData(menuMapper.findPaginationByCondition(queryCondition));
        }
        return paginationDomain;
    }

    @Override
    public PaginationDomain<Menu> searchMenu(MenuQueryRequest request, Pagination<MenuInfo> pagination) {
        MenuQueryCondition queryCondition = requestToCondition(request);

        PaginationDomain<Menu> paginationDomain = paginationToPaginationDomain(pagination);

        return this.getPagination(paginationDomain, queryCondition);
    }
}
