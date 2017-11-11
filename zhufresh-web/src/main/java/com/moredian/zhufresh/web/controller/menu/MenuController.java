package com.moredian.zhufresh.web.controller.menu;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.common.web.BaseResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.model.MenuBulkInfo;
import com.moredian.zhufresh.model.MenuGoodsInfo;
import com.moredian.zhufresh.model.MenuInfo;
import com.moredian.zhufresh.model.MenuStepInfo;
import com.moredian.zhufresh.request.MenuCreateRequest;
import com.moredian.zhufresh.request.MenuQueryRequest;
import com.moredian.zhufresh.request.MenuUpdateRequest;
import com.moredian.zhufresh.service.MenuService;
import com.moredian.zhufresh.web.BaseController;
import com.moredian.zhufresh.web.controller.menu.request.*;
import com.moredian.zhufresh.web.controller.menu.response.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/menu")
public class MenuController extends BaseController {

    @SI
    private MenuService menuService;

    private MenuCreateRequest buildRequest(MenuCreateModel model) {
        return BeanUtils.copyProperties(MenuCreateRequest.class, model);
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse create(@RequestBody MenuCreateModel model) {
        ServiceResponse<Long> sr = menuService.createMenu(this.buildRequest(model));
        if (!sr.isSuccess()) sr.pickDataThrowException();
        BaseResponse<Long> br = new BaseResponse<>();
        br.setData(sr.getData());
        return br;
    }

    private MenuUpdateRequest buildRequest(MenuUpdateModel model) {
        return BeanUtils.copyProperties(MenuUpdateRequest.class, model);
    }

    @RequestMapping(value="/update", method= RequestMethod.PUT)
    @ResponseBody
    public BaseResponse update(@RequestBody MenuUpdateModel model) {
        menuService.updateMenu(this.buildRequest(model)).pickDataThrowException();
        return new BaseResponse();
    }

    @RequestMapping(value="/delete", method= RequestMethod.DELETE)
    @ResponseBody
    public BaseResponse delete(@RequestBody MenuDeleteModel model) {
        menuService.deleteMenu(model.getMenuId()).pickDataThrowException();
        return new BaseResponse();
    }

    @RequestMapping(value="/enable", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse enable(@RequestBody MenuEnableModel model) {
        menuService.enableMenu(model.getMenuId()).pickDataThrowException();
        return new BaseResponse();
    }

    @RequestMapping(value="/disable", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse disable(@RequestBody MenuDisableModel model) {
        menuService.disableMenu(model.getMenuId()).pickDataThrowException();
        return new BaseResponse();
    }

    private MenuData menuInfoToMenuData(MenuInfo menuInfo) {
        if (menuInfo == null) return null;
        return BeanUtils.copyProperties(MenuData.class, menuInfo);
    }

    @RequestMapping(value="/info", method= RequestMethod.GET)
    @ResponseBody
    public BaseResponse info(@RequestParam(value = "menuId") Long menuId) {
        MenuInfo menuInfo = menuService.getMenu(menuId);
        MenuData data = menuInfoToMenuData(menuInfo);
        BaseResponse<MenuData> br = new BaseResponse<>();
        br.setData(data);
        return br;
    }

    private MenuQueryRequest buildRequest(MenuQueryModel model) {
        return BeanUtils.copyProperties(MenuQueryRequest.class, model);
    }

    private Pagination<MenuInfo> buildPagination(int pageNo, int pageSize) {
        Pagination<MenuInfo> pagination = new Pagination<>();
        pagination.setPageNo(pageNo);
        pagination.setPageSize(pageSize);
        return pagination;
    }

    private PaginationMenuData paginationToPaginationData(Pagination<MenuInfo> pagination) {
        PaginationMenuData data = new PaginationMenuData();
        data.setPageNo(pagination.getPageNo());
        data.setTotalCount(pagination.getTotalCount());
        data.setMenus(BeanUtils.copyListProperties(MenuData.class, pagination.getData()));
        return data;
    }

    @RequestMapping(value="/list", method= RequestMethod.GET)
    @ResponseBody
    public BaseResponse list(@RequestParam(value = "hotType", required = false) Integer hotType, @RequestParam(value = "styleType", required = false) Integer styleType, @RequestParam(value = "placeType", required = false) Integer placeType, @RequestParam(value = "tasteType", required = false) Integer tasteType, @RequestParam(value = "keywords", required = false) String keywords, @RequestParam(value = "status", required = false) Integer status) {

        MenuQueryModel model = new MenuQueryModel();
        model.setHotType(hotType);
        model.setStyleType(styleType);
        model.setPlaceType(placeType);
        model.setTasteType(tasteType);
        model.setKeywords(keywords);
        model.setStatus(status);

        Pagination<MenuInfo> pagination = menuService.searchMenu(this.buildRequest(model), this.buildPagination(model.getPageNo(), model.getPageSize()));
        BaseResponse<PaginationMenuData> br = new BaseResponse<>();
        br.setData(paginationToPaginationData(pagination));
        return br;

    }

    @RequestMapping(value="/goods/config", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse configGoods(@RequestBody MenuGoodsConfigModel model) {
        menuService.configGoods(model.getMenuId(), model.getGoodsInfos()).pickDataThrowException();
        return new BaseResponse();
    }

    @RequestMapping(value="/bulk/config", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse configBulk(@RequestBody MenuBulkConfigModel model) {
        menuService.configBulk(model.getMenuId(), model.getBulkInfos()).pickDataThrowException();
        return new BaseResponse();
    }

    @RequestMapping(value="/step/config", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse configStep(@RequestBody MenuStepConfigModel model) {
        menuService.configStep(model.getMenuId(), model.getStepInfos()).pickDataThrowException();
        return new BaseResponse();
    }

    private List<MenuGoodsData> menuGoodsInfosToMenuGoodsDatas(List<MenuGoodsInfo> menuGoodsInfos) {
        return BeanUtils.copyListProperties(MenuGoodsData.class, menuGoodsInfos);
    }

    @RequestMapping(value="/goods/list", method= RequestMethod.GET)
    @ResponseBody
    public BaseResponse listGoods(@RequestParam(value = "menuId") Long menuId) {
        List<MenuGoodsInfo> menuGoodsInfos = menuService.findGoods(menuId);
        BaseResponse<List<MenuGoodsData>> br = new BaseResponse<>();
        br.setData(menuGoodsInfosToMenuGoodsDatas(menuGoodsInfos));
        return br;

    }

    private List<MenuBulkData> menuBulkInfosToMenuBulkDatas(List<MenuBulkInfo> menuBulkInfos) {
        return BeanUtils.copyListProperties(MenuBulkData.class, menuBulkInfos);
    }

    @RequestMapping(value="/bulk/list", method= RequestMethod.GET)
    @ResponseBody
    public BaseResponse listBulk(@RequestParam(value = "menuId") Long menuId) {
        List<MenuBulkInfo> menuBulkInfos = menuService.findBulk(menuId);
        BaseResponse<List<MenuBulkData>> br = new BaseResponse<>();
        br.setData(menuBulkInfosToMenuBulkDatas(menuBulkInfos));
        return br;

    }

    private List<MenuStepData> menuStepInfosToMenuStepDatas(List<MenuStepInfo> menuStepInfos) {
        return BeanUtils.copyListProperties(MenuStepData.class, menuStepInfos);
    }

    @RequestMapping(value="/step/list", method= RequestMethod.GET)
    @ResponseBody
    public BaseResponse listStep(@RequestParam(value = "menuId") Long menuId) {
        List<MenuStepInfo> menuStepInfos = menuService.findStep(menuId);
        BaseResponse<List<MenuStepData>> br = new BaseResponse<>();
        br.setData(menuStepInfosToMenuStepDatas(menuStepInfos));
        return br;

    }

}
