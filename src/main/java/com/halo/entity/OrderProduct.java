package com.halo.entity;

import java.util.Date;

/**
 * @author MelloChan
 */
public class OrderProduct {
  private Integer id;
  private Integer proId;
  private String orderId;
  private String image;
  private String title;
  private Integer price;
  private Integer totalFee;
  private Short number;
  private Date gmtCreate;
  private Date gmtUpdated;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getProId() {
    return proId;
  }

  public void setProId(Integer proId) {
    this.proId = proId;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Integer getTotalFee() {
    return totalFee;
  }

  public void setTotalFee(Integer totalFee) {
    this.totalFee = totalFee;
  }

  public Short getNumber() {
    return number;
  }

  public void setNumber(Short number) {
    this.number = number;
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
