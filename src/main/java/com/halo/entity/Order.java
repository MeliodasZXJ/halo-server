package com.halo.entity;

import java.util.Date;

/**
 * @author MelloChan
 */
public class Order {
  private String id;
  private Integer userId;
  private Short payType;
  private Short shipmentTime;
  private Short shipmentType;
  private Integer shipmentAmount;
  private Short orderStatus;
  private Integer orderAmount;
  private Integer payAmount;
  private Date gmtCreate;
  private Date gmtUpdated;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Short getPayType() {
    return payType;
  }

  public void setPayType(Short payType) {
    this.payType = payType;
  }

  public Short getShipmentTime() {
    return shipmentTime;
  }

  public void setShipmentTime(Short shipmentTime) {
    this.shipmentTime = shipmentTime;
  }

  public Short getShipmentType() {
    return shipmentType;
  }

  public void setShipmentType(Short shipmentType) {
    this.shipmentType = shipmentType;
  }

  public Integer getShipmentAmount() {
    return shipmentAmount;
  }

  public void setShipmentAmount(Integer shipmentAmount) {
    this.shipmentAmount = shipmentAmount;
  }

  public Short getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(Short orderStatus) {
    this.orderStatus = orderStatus;
  }

  public Integer getOrderAmount() {
    return orderAmount;
  }

  public void setOrderAmount(Integer orderAmount) {
    this.orderAmount = orderAmount;
  }

  public Integer getPayAmount() {
    return payAmount;
  }

  public void setPayAmount(Integer payAmount) {
    this.payAmount = payAmount;
  }

  public Date getGmtCreate() {
    return gmtCreate;
  }

  public void setGmtCreate(Date gmtCreate) {
    this.gmtCreate = gmtCreate;
  }

  public Date getGmtUpdated() {
    return gmtUpdated;
  }

  public void setGmtUpdated(Date gmtUpdated) {
    this.gmtUpdated = gmtUpdated;
  }
}
