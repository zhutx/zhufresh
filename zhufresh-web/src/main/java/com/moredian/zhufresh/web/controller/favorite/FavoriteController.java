package com.moredian.zhufresh.web.controller.favorite;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.common.web.BaseResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.model.FavoriteInfo;
import com.moredian.zhufresh.model.MenuInfo;
import com.moredian.zhufresh.request.FavoriteCreateRequest;
import com.moredian.zhufresh.request.FavoriteUpdateRequest;
import com.moredian.zhufresh.service.FavoriteService;
import com.moredian.zhufresh.utils.AuthorizeUtil;
import com.moredian.zhufresh.web.BaseController;
import com.moredian.zhufresh.web.controller.favorite.request.*;
import com.moredian.zhufresh.web.controller.favorite.response.FavoriteData;
import com.moredian.zhufresh.web.controller.menu.response.MenuData;
import com.moredian.zhufresh.web.controller.menu.response.PaginationMenuData;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/favorite")
public class FavoriteController extends BaseController {

    @SI
    private FavoriteService favoriteService;

    private FavoriteCreateRequest buildRequest(FavoriteCreateModel model) {
        return BeanUtils.copyProperties(FavoriteCreateRequest.class, model);
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse create(@RequestBody FavoriteCreateModel model) {
        model.setUserId(AuthorizeUtil.getUserId());
        ServiceResponse<Long> sr = favoriteService.createFavorite(this.buildRequest(model));
        if (!sr.isSuccess()) sr.pickDataThrowException();
        BaseResponse<Long> br = new BaseResponse<>();
        br.setData(sr.getData());
        return br;
    }

    private FavoriteUpdateRequest buildRequest(FavoriteUpdateModel model) {
        return BeanUtils.copyProperties(FavoriteUpdateRequest.class, model);
    }

    @RequestMapping(value="/update", method= RequestMethod.PUT)
    @ResponseBody
    public BaseResponse update(@RequestBody FavoriteUpdateModel model) {
        model.setUserId(AuthorizeUtil.getUserId());
        favoriteService.updateFavorite(this.buildRequest(model)).pickDataThrowException();
        return new BaseResponse();
    }

    @RequestMapping(value="/delete", method= RequestMethod.DELETE)
    @ResponseBody
    public BaseResponse delete(@RequestBody FavoriteDeleteModel model) {
        model.setUserId(AuthorizeUtil.getUserId());
        favoriteService.deleteFavorite(model.getUserId(), model.getFavoriteId()).pickDataThrowException();
        return new BaseResponse();
    }

    @RequestMapping(value="/do", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse doFavorite(@RequestBody FavoriteDoModel model) {
        model.setUserId(AuthorizeUtil.getUserId());
        favoriteService.doFavorite(model.getUserId(), model.getFavoriteId(), model.getMenuId());
        return new BaseResponse();
    }

    @RequestMapping(value="/cancel", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse cancelFavorite(@RequestBody FavoriteCancelModel model) {
        model.setUserId(AuthorizeUtil.getUserId());
        favoriteService.cancelFavorite(model.getUserId(), model.getMenuId());
        return new BaseResponse();
    }

    private List<FavoriteData> favoriteInfoListToFavoriteDataList(List<FavoriteInfo> favoriteInfos) {
        return BeanUtils.copyListProperties(FavoriteData.class, favoriteInfos);
    }

    @RequestMapping(value="/list", method= RequestMethod.GET)
    @ResponseBody
    public BaseResponse list() {
        List<FavoriteInfo> favoriteInfos = favoriteService.searchFavorite(AuthorizeUtil.getUserId());
        BaseResponse<List<FavoriteData>> br = new BaseResponse<>();
        br.setData(favoriteInfoListToFavoriteDataList(favoriteInfos));
        return br;

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
        List<MenuData> menus = BeanUtils.copyListProperties(MenuData.class, pagination.getData());
        data.setMenus(menus);
        return data;
    }

    @RequestMapping(value="/menus", method= RequestMethod.GET)
    @ResponseBody
    public BaseResponse menus(@RequestParam(value = "favoriteId") Long favoriteId) {

        FavoriteMenuQueryModel model = new FavoriteMenuQueryModel();
        model.setUserId(AuthorizeUtil.getUserId());
        model.setFavoriteId(favoriteId);

        Pagination<MenuInfo> pagination = favoriteService.findMenu(model.getUserId(), model.getFavoriteId(), this.buildPagination(model.getPageNo(), model.getPageSize()));
        BaseResponse<PaginationMenuData> br = new BaseResponse<>();
        br.setData(paginationToPaginationData(pagination));
        return br;

    }

}
