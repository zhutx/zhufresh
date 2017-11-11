package com.moredian.zhufresh.manager;

import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.zhufresh.domain.Menu;
import com.moredian.zhufresh.domain.MenuBulk;
import com.moredian.zhufresh.domain.MenuGoods;
import com.moredian.zhufresh.domain.MenuStep;
import com.moredian.zhufresh.enums.MenuStatus;
import com.moredian.zhufresh.model.MenuBulkInfo;
import com.moredian.zhufresh.model.MenuGoodsInfo;
import com.moredian.zhufresh.model.MenuInfo;
import com.moredian.zhufresh.model.MenuStepInfo;
import com.moredian.zhufresh.request.MenuCreateRequest;
import com.moredian.zhufresh.request.MenuQueryRequest;
import com.moredian.zhufresh.request.MenuUpdateRequest;

import java.util.List;

public interface MenuManager {

    Long addMenu(MenuCreateRequest request);

    boolean updateMenu(MenuUpdateRequest request);

    boolean updateStatus(Long menuId, MenuStatus menuStatus);

    Menu getMenu(Long menuId);

    boolean configGoods(Long menuId, List<MenuGoodsInfo> goodsInfos);

    boolean configBulk(Long menuId, List<MenuBulkInfo> bulkInfos);

    boolean configStep(Long menuId, List<MenuStepInfo> stepInfos);

    List<MenuGoods> findGoods(Long menuId);

    List<MenuBulk> findBulk(Long menuId);

    List<MenuStep> findStep(Long menuId);

    PaginationDomain searchMenu(MenuQueryRequest request, Pagination<MenuInfo> pagination);

}
