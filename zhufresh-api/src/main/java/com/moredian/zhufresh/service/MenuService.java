package com.moredian.zhufresh.service;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.zhufresh.model.*;
import com.moredian.zhufresh.request.GoodsQueryRequest;
import com.moredian.zhufresh.request.MenuCreateRequest;
import com.moredian.zhufresh.request.MenuQueryRequest;
import com.moredian.zhufresh.request.MenuUpdateRequest;

import java.awt.*;
import java.util.List;

/**
 * 菜谱服务
 * @author zhutx
 *
 */
public interface MenuService {

    ServiceResponse<Long> createMenu(MenuCreateRequest request);

    ServiceResponse<Boolean> updateMenu(MenuUpdateRequest request);

    ServiceResponse<Boolean> deleteMenu(Long menuId);

    ServiceResponse<Boolean> enableMenu(Long menuId);

    ServiceResponse<Boolean> disableMenu(Long menuId);

    MenuInfo getMenu(Long menuId);

    ServiceResponse<Boolean> configGoods(Long menuId, List<MenuGoodsInfo> goodsInfos);

    ServiceResponse<Boolean> configBulk(Long menuId, List<MenuBulkInfo> bulkInfos);

    ServiceResponse<Boolean> configStep(Long menuId, List<MenuStepInfo> stepInfos);

    List<MenuGoodsInfo> findGoods(Long menuId);

    List<MenuBulkInfo> findBulk(Long menuId);

    List<MenuStepInfo> findStep(Long menuId);

    Pagination<MenuInfo> searchMenu(MenuQueryRequest request, Pagination<MenuInfo> pagination);

}
