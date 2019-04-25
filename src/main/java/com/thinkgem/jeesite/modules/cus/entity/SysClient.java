/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cus.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 客服类Entity
 * @author Mickey
 * @version 2019-04-09
 */
public class SysClient extends DataEntity<SysClient> {
	
	private static final long serialVersionUID = 1L;
	private String transaction;		// 交易
	private String application;		// 用途
	private String willingAddress;		// 意向地址
	private String status;		// 状态
	private String area;		// 面积
	private String attribute;		// 属性
	private String purchasingPrice;		// 价格
	private Date precatoryDate;		// 委托日期
	private String rentPrice;		// 租金单价
	private String precatoryMethod;		// 委托方式
	private String rank;		// 客户等级
	private String source;		// 来源
	private String type;		// 客户类别
	private String deadline;		// 客户期限
	private String intention;		// 客户意向
	private Date maturity;		// 到期日
	private String remark;		// 备注
	private String housetype;		// 房型：房/厅/卫/阳
	private String decoration;		// 装修
	private String gener;		// 装备
	private String development;		// 配套
	private String orientation;		// 朝向
	private String floor;		// 楼层
	private String payment;		// 付款
	private String nowAddress;		// 客户现住
	private String paymentCommission;		// 付拥
	private String clientAge;		// 入住人年龄
	private String address;		// 现住址
	
	public SysClient() {
		super();
	}

	public SysClient(String id){
		super(id);
	}

	@Length(min=0, max=45, message="交易长度必须介于 0 和 45 之间")
	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	
	@Length(min=0, max=45, message="用途长度必须介于 0 和 45 之间")
	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}
	
	@Length(min=0, max=45, message="意向地址长度必须介于 0 和 45 之间")
	public String getWillingAddress() {
		return willingAddress;
	}

	public void setWillingAddress(String willingAddress) {
		this.willingAddress = willingAddress;
	}
	
	@Length(min=0, max=45, message="状态长度必须介于 0 和 45 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Length(min=0, max=45, message="面积长度必须介于 0 和 45 之间")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	@Length(min=0, max=45, message="属性长度必须介于 0 和 45 之间")
	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
	@Length(min=0, max=45, message="价格长度必须介于 0 和 45 之间")
	public String getPurchasingPrice() {
		return purchasingPrice;
	}

	public void setPurchasingPrice(String purchasingPrice) {
		this.purchasingPrice = purchasingPrice;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPrecatoryDate() {
		return precatoryDate;
	}

	public void setPrecatoryDate(Date precatoryDate) {
		this.precatoryDate = precatoryDate;
	}
	
	@Length(min=0, max=45, message="租金单价长度必须介于 0 和 45 之间")
	public String getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(String rentPrice) {
		this.rentPrice = rentPrice;
	}
	
	@Length(min=0, max=45, message="委托方式长度必须介于 0 和 45 之间")
	public String getPrecatoryMethod() {
		return precatoryMethod;
	}

	public void setPrecatoryMethod(String precatoryMethod) {
		this.precatoryMethod = precatoryMethod;
	}
	
	@Length(min=0, max=45, message="客户等级长度必须介于 0 和 45 之间")
	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	@Length(min=0, max=45, message="来源长度必须介于 0 和 45 之间")
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	@Length(min=0, max=45, message="客户类别长度必须介于 0 和 45 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=45, message="客户期限长度必须介于 0 和 45 之间")
	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	@Length(min=0, max=45, message="客户意向长度必须介于 0 和 45 之间")
	public String getIntention() {
		return intention;
	}

	public void setIntention(String intention) {
		this.intention = intention;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getMaturity() {
		return maturity;
	}

	public void setMaturity(Date maturity) {
		this.maturity = maturity;
	}
	
	@Length(min=0, max=100, message="备注长度必须介于 0 和 100 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Length(min=0, max=45, message="房型：房/厅/卫/阳长度必须介于 0 和 45 之间")
	public String getHousetype() {
		return housetype;
	}

	public void setHousetype(String housetype) {
		this.housetype = housetype;
	}
	
	@Length(min=0, max=45, message="装修长度必须介于 0 和 45 之间")
	public String getDecoration() {
		return decoration;
	}

	public void setDecoration(String decoration) {
		this.decoration = decoration;
	}
	
	@Length(min=0, max=45, message="装备长度必须介于 0 和 45 之间")
	public String getGener() {
		return gener;
	}

	public void setGener(String gener) {
		this.gener = gener;
	}
	
	@Length(min=0, max=45, message="配套长度必须介于 0 和 45 之间")
	public String getDevelopment() {
		return development;
	}

	public void setDevelopment(String development) {
		this.development = development;
	}
	
	@Length(min=0, max=45, message="朝向长度必须介于 0 和 45 之间")
	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	
	@Length(min=0, max=45, message="楼层长度必须介于 0 和 45 之间")
	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}
	
	@Length(min=0, max=45, message="付款长度必须介于 0 和 45 之间")
	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	@Length(min=0, max=45, message="客户现住长度必须介于 0 和 45 之间")
	public String getNowAddress() {
		return nowAddress;
	}

	public void setNowAddress(String nowAddress) {
		this.nowAddress = nowAddress;
	}
	
	@Length(min=0, max=45, message="付拥长度必须介于 0 和 45 之间")
	public String getPaymentCommission() {
		return paymentCommission;
	}

	public void setPaymentCommission(String paymentCommission) {
		this.paymentCommission = paymentCommission;
	}
	
	@Length(min=0, max=45, message="入住人年龄长度必须介于 0 和 45 之间")
	public String getClientAge() {
		return clientAge;
	}

	public void setClientAge(String clientAge) {
		this.clientAge = clientAge;
	}
	
	@Length(min=0, max=45, message="现住址长度必须介于 0 和 45 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}