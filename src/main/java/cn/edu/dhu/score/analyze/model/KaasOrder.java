package cn.edu.dhu.score.analyze.model;

import java.util.Date;

public class KaasOrder {
	
	private Date createDate;
	private String orderId; // primary key
	private String orderSn;// serial number
	private int orderStatue;// 0 means not paid, 1 means has been paid
	private String userId;

	public Date getCreateDate() {
		return createDate;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getOrderSn() {
		return orderSn;
	}

	public int getOrderStatue() {
		return orderStatue;
	}

	public String getUserId() {
		return userId;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	public void setOrderStatue(int orderStatue) {
		this.orderStatue = orderStatue;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
