/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.hos.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.modules.sys.entity.User;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 房屋信息Entity
 * @author Mickey
 * @version 2019-04-09
 */
public class SysHousemsg extends DataEntity<SysHousemsg> {
	
	private static final long serialVersionUID = 1L;
	private String application;		// 房源用途
	private String transaction;		// 房源交易
	private String address;		// 房源地址
	private String area;		// 面积
	private String type;		// 种类
	private String houseType;		// 房型：房/厅/卫/阳台
	private String decoration;		// 装修
	private String orientation;		// 朝向
	private String status;		// 状态
	private String sellPrice;		// 售总价
	private String attribute;		// 属性
	private String sellLowprice;		// 售低价
	private Date purchasingDate;		// 购买时间
	private String rentPrice;		// 租总价
	private String rentLowprice;		// 租低价
	private Date precatoryDate;		// 委托日期
	private String loan;		// 贷款
	private String precatoryMethod;		// 委托方式
	private String resource;		// 来源
	private String precatoryNumber;		// 委托编号
	private Date lunchTime;		// 交房日期
	private String recordNumber;		// 备案号
	private String remark;		// 备注
	private String statusQuo;		// 现状
	private String furniture;		// 家具
	private String originalyPurchasingPrice;		// 原始购价
	private String managementCost;		// 管理费
	private String householdApplicances;		// 家电
	private String parkingPlot;		// 车位
	private String paymentMethod;		// 付款方式
	private String productionLicenseNumber;		// 产证号
	private Date yearOfPropertyRight;		// 产权年限
	private String certificateOfHouseProperty;		// 房产证
	private String idCard;		// 身份证
	private String precatoryBook;		// 委托书
	private String clientId;		// 业主id
	private User user;		// 相关员工
	private String organizationId;		// 部门id
	
	public SysHousemsg() {
		super();
	}

	public SysHousemsg(String id){
		super(id);
	}

	@Length(min=0, max=45, message="房源用途长度必须介于 0 和 45 之间")
	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}
	
	@Length(min=0, max=45, message="房源交易长度必须介于 0 和 45 之间")
	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	
	@Length(min=0, max=100, message="房源地址长度必须介于 0 和 100 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=45, message="面积长度必须介于 0 和 45 之间")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	@Length(min=0, max=45, message="种类长度必须介于 0 和 45 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=45, message="房型：房/厅/卫/阳台长度必须介于 0 和 45 之间")
	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	
	@Length(min=0, max=45, message="装修长度必须介于 0 和 45 之间")
	public String getDecoration() {
		return decoration;
	}

	public void setDecoration(String decoration) {
		this.decoration = decoration;
	}
	
	@Length(min=0, max=45, message="朝向长度必须介于 0 和 45 之间")
	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	
	@Length(min=0, max=45, message="状态长度必须介于 0 和 45 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Length(min=0, max=45, message="售总价长度必须介于 0 和 45 之间")
	public String getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(String sellPrice) {
		this.sellPrice = sellPrice;
	}
	
	@Length(min=0, max=45, message="属性长度必须介于 0 和 45 之间")
	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
	@Length(min=0, max=45, message="售低价长度必须介于 0 和 45 之间")
	public String getSellLowprice() {
		return sellLowprice;
	}

	public void setSellLowprice(String sellLowprice) {
		this.sellLowprice = sellLowprice;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPurchasingDate() {
		return purchasingDate;
	}

	public void setPurchasingDate(Date purchasingDate) {
		this.purchasingDate = purchasingDate;
	}
	
	@Length(min=0, max=45, message="租总价长度必须介于 0 和 45 之间")
	public String getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(String rentPrice) {
		this.rentPrice = rentPrice;
	}
	
	@Length(min=0, max=45, message="租低价长度必须介于 0 和 45 之间")
	public String getRentLowprice() {
		return rentLowprice;
	}

	public void setRentLowprice(String rentLowprice) {
		this.rentLowprice = rentLowprice;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPrecatoryDate() {
		return precatoryDate;
	}

	public void setPrecatoryDate(Date precatoryDate) {
		this.precatoryDate = precatoryDate;
	}
	
	@Length(min=0, max=45, message="贷款长度必须介于 0 和 45 之间")
	public String getLoan() {
		return loan;
	}

	public void setLoan(String loan) {
		this.loan = loan;
	}
	
	@Length(min=0, max=45, message="委托方式长度必须介于 0 和 45 之间")
	public String getPrecatoryMethod() {
		return precatoryMethod;
	}

	public void setPrecatoryMethod(String precatoryMethod) {
		this.precatoryMethod = precatoryMethod;
	}
	
	@Length(min=0, max=45, message="来源长度必须介于 0 和 45 之间")
	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}
	
	@Length(min=0, max=45, message="委托编号长度必须介于 0 和 45 之间")
	public String getPrecatoryNumber() {
		return precatoryNumber;
	}

	public void setPrecatoryNumber(String precatoryNumber) {
		this.precatoryNumber = precatoryNumber;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLunchTime() {
		return lunchTime;
	}

	public void setLunchTime(Date lunchTime) {
		this.lunchTime = lunchTime;
	}
	
	@Length(min=0, max=45, message="备案号长度必须介于 0 和 45 之间")
	public String getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}
	
	@Length(min=0, max=100, message="备注长度必须介于 0 和 100 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Length(min=0, max=45, message="现状长度必须介于 0 和 45 之间")
	public String getStatusQuo() {
		return statusQuo;
	}

	public void setStatusQuo(String statusQuo) {
		this.statusQuo = statusQuo;
	}
	
	@Length(min=0, max=45, message="家具长度必须介于 0 和 45 之间")
	public String getFurniture() {
		return furniture;
	}

	public void setFurniture(String furniture) {
		this.furniture = furniture;
	}
	
	@Length(min=0, max=45, message="原始购价长度必须介于 0 和 45 之间")
	public String getOriginalyPurchasingPrice() {
		return originalyPurchasingPrice;
	}

	public void setOriginalyPurchasingPrice(String originalyPurchasingPrice) {
		this.originalyPurchasingPrice = originalyPurchasingPrice;
	}
	
	@Length(min=0, max=45, message="管理费长度必须介于 0 和 45 之间")
	public String getManagementCost() {
		return managementCost;
	}

	public void setManagementCost(String managementCost) {
		this.managementCost = managementCost;
	}
	
	@Length(min=0, max=45, message="家电长度必须介于 0 和 45 之间")
	public String getHouseholdApplicances() {
		return householdApplicances;
	}

	public void setHouseholdApplicances(String householdApplicances) {
		this.householdApplicances = householdApplicances;
	}
	
	@Length(min=0, max=45, message="车位长度必须介于 0 和 45 之间")
	public String getParkingPlot() {
		return parkingPlot;
	}

	public void setParkingPlot(String parkingPlot) {
		this.parkingPlot = parkingPlot;
	}
	
	@Length(min=0, max=45, message="付款方式长度必须介于 0 和 45 之间")
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	@Length(min=0, max=45, message="产证号长度必须介于 0 和 45 之间")
	public String getProductionLicenseNumber() {
		return productionLicenseNumber;
	}

	public void setProductionLicenseNumber(String productionLicenseNumber) {
		this.productionLicenseNumber = productionLicenseNumber;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getYearOfPropertyRight() {
		return yearOfPropertyRight;
	}

	public void setYearOfPropertyRight(Date yearOfPropertyRight) {
		this.yearOfPropertyRight = yearOfPropertyRight;
	}
	
	@Length(min=1, max=100, message="房产证长度必须介于 1 和 100 之间")
	public String getCertificateOfHouseProperty() {
		return certificateOfHouseProperty;
	}

	public void setCertificateOfHouseProperty(String certificateOfHouseProperty) {
		this.certificateOfHouseProperty = certificateOfHouseProperty;
	}
	
	@Length(min=0, max=100, message="身份证长度必须介于 0 和 100 之间")
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	@Length(min=0, max=100, message="委托书长度必须介于 0 和 100 之间")
	public String getPrecatoryBook() {
		return precatoryBook;
	}

	public void setPrecatoryBook(String precatoryBook) {
		this.precatoryBook = precatoryBook;
	}
	
	@Length(min=0, max=45, message="业主id长度必须介于 0 和 45 之间")
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Length(min=0, max=20, message="部门id长度必须介于 0 和 20 之间")
	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	
}