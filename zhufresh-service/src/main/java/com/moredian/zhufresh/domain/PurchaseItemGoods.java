package com.moredian.zhufresh.domain;

import java.util.Date;

public class PurchaseItemGoods {
	
	private Long purchaseItemGoodsId;
	private Long purchaseId;
	private String purchaseCode;
	private Long purchaseItemId;
	private String purchaseItemCode;
	private Long goodsId;
	private String goodsName;
	private String goodsImgUrl;
	private Integer needWeight;
	private Integer purchaseUnit;
	private Integer purchaseUnitPrice;
	private Integer purchaseWeight;
	private Integer purchasePrice;
	private Date gmtCreate;
	private Date gmtModify;
	
	public Long getPurchaseItemGoodsId() {
		return purchaseItemGoodsId;
	}
	public void setPurchaseItemGoodsId(Long purchaseItemGoodsId) {
		this.purchaseItemGoodsId = purchaseItemGoodsId;
	}
	public Long getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getPurchaseCode() {
		return purchaseCode;
	}
	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}
	public Long getPurchaseItemId() {
		return purchaseItemId;
	}
	public void setPurchaseItemId(Long purchaseItemId) {
		this.purchaseItemId = purchaseItemId;
	}
	public String getPurchaseItemCode() {
		return purchaseItemCode;
	}
	public void setPurchaseItemCode(String purchaseItemCode) {
		this.purchaseItemCode = purchaseItemCode;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsImgUrl() {
		return goodsImgUrl;
	}
	public void setGoodsImgUrl(String goodsImgUrl) {
		this.goodsImgUrl = goodsImgUrl;
	}
	public Integer getNeedWeight() {
		return needWeight;
	}
	public void setNeedWeight(Integer needWeight) {
		this.needWeight = needWeight;
	}
	public Integer getPurchaseUnit() {
		return purchaseUnit;
	}
	public void setPurchaseUnit(Integer purchaseUnit) {
		this.purchaseUnit = purchaseUnit;
	}
	public Integer getPurchaseUnitPrice() {
		return purchaseUnitPrice;
	}
	public void setPurchaseUnitPrice(Integer purchaseUnitPrice) {
		this.purchaseUnitPrice = purchaseUnitPrice;
	}
	public Integer getPurchaseWeight() {
		return purchaseWeight;
	}
	public void setPurchaseWeight(Integer purchaseWeight) {
		this.purchaseWeight = purchaseWeight;
	}
	public Integer getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Integer purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModify() {
		return gmtModify;
	}
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

}
