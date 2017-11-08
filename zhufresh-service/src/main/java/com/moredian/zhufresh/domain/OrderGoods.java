package com.moredian.zhufresh.domain;

import java.util.Date;

public class OrderGoods {
	
	private Long orderGoodsId;
	private Long orderId;
	private Long goodsId;
	private Integer goodsType1;
	private Integer goodsType2;
	private String goodsName;
	private Integer unitPrice;
	private Integer weight;
	private Integer price;
	private Integer receiveWeight;
	private Integer receivePrice;
	private Date gmtCreate;
	private Date gmtModify;
	
	public Long getOrderGoodsId() {
		return orderGoodsId;
	}
	public void setOrderGoodsId(Long orderGoodsId) {
		this.orderGoodsId = orderGoodsId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getGoodsType1() {
		return goodsType1;
	}
	public void setGoodsType1(Integer goodsType1) {
		this.goodsType1 = goodsType1;
	}
	public Integer getGoodsType2() {
		return goodsType2;
	}
	public void setGoodsType2(Integer goodsType2) {
		this.goodsType2 = goodsType2;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getReceiveWeight() {
		return receiveWeight;
	}
	public void setReceiveWeight(Integer receiveWeight) {
		this.receiveWeight = receiveWeight;
	}
	public Integer getReceivePrice() {
		return receivePrice;
	}
	public void setReceivePrice(Integer receivePrice) {
		this.receivePrice = receivePrice;
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
