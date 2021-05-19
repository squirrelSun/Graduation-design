package com.sust.swy.print.entity;

import java.util.Date;

public class OrderDetail {

	private Integer orderId;

	private Integer memberId;

	private Integer merchantId;

	private Integer machineId;

	private Integer documentId;

	private Integer orderStatus;

	private String orderNum;

	private String payOrderNum;

	private Double orderAmount;

	private String orderRemark;

	private Date updateTime;

	private Integer orderIsDelete;

	private String memberName;

	private Integer memberIsDelete;

	private String machineName;

	private Integer machineIsDelete;

	private String documentName;

	private Integer documentStatus;

	private String documentUrl;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	public Integer getMachineId() {
		return machineId;
	}

	public void setMachineId(Integer machineId) {
		this.machineId = machineId;
	}

	public Integer getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getPayOrderNum() {
		return payOrderNum;
	}

	public void setPayOrderNum(String payOrderNum) {
		this.payOrderNum = payOrderNum;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderRemark() {
		return orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getOrderIsDelete() {
		return orderIsDelete;
	}

	public void setOrderIsDelete(Integer orderIsDelete) {
		this.orderIsDelete = orderIsDelete;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Integer getMemberIsDelete() {
		return memberIsDelete;
	}

	public void setMemberIsDelete(Integer memberIsDelete) {
		this.memberIsDelete = memberIsDelete;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public Integer getMachineIsDelete() {
		return machineIsDelete;
	}

	public void setMachineIsDelete(Integer machineIsDelete) {
		this.machineIsDelete = machineIsDelete;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public Integer getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(Integer documentStatus) {
		this.documentStatus = documentStatus;
	}

	public String getDocumentUrl() {
		return documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}

	public OrderDetail(Integer orderId, Integer memberId, Integer merchantId, Integer machineId, Integer documentId,
			Integer orderStatus, String orderNum, String payOrderNum, Double orderAmount, String orderRemark,
			Date updateTime, Integer orderIsDelete, String memberName, Integer memberIsDelete, String machineName,
			Integer machineIsDelete, String documentName, Integer documentStatus, String documentUrl) {
		super();
		this.orderId = orderId;
		this.memberId = memberId;
		this.merchantId = merchantId;
		this.machineId = machineId;
		this.documentId = documentId;
		this.orderStatus = orderStatus;
		this.orderNum = orderNum;
		this.payOrderNum = payOrderNum;
		this.orderAmount = orderAmount;
		this.orderRemark = orderRemark;
		this.updateTime = updateTime;
		this.orderIsDelete = orderIsDelete;
		this.memberName = memberName;
		this.memberIsDelete = memberIsDelete;
		this.machineName = machineName;
		this.machineIsDelete = machineIsDelete;
		this.documentName = documentName;
		this.documentStatus = documentStatus;
		this.documentUrl = documentUrl;
	}

	public OrderDetail() {
		super();
	}

	@Override
	public String toString() {
		return "OrderDetail [orderId=" + orderId + ", memberId=" + memberId + ", merchantId=" + merchantId
				+ ", machineId=" + machineId + ", documentId=" + documentId + ", orderStatus=" + orderStatus
				+ ", orderNum=" + orderNum + ", payOrderNum=" + payOrderNum + ", orderAmount=" + orderAmount
				+ ", orderRemark=" + orderRemark + ", updateTime=" + updateTime + ", orderIsDelete=" + orderIsDelete
				+ ", memberName=" + memberName + ", memberIsDelete=" + memberIsDelete + ", machineName=" + machineName
				+ ", machineIsDelete=" + machineIsDelete + ", documentName=" + documentName + ", documentStatus="
				+ documentStatus + ", documentUrl=" + documentUrl + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documentId == null) ? 0 : documentId.hashCode());
		result = prime * result + ((documentName == null) ? 0 : documentName.hashCode());
		result = prime * result + ((documentStatus == null) ? 0 : documentStatus.hashCode());
		result = prime * result + ((documentUrl == null) ? 0 : documentUrl.hashCode());
		result = prime * result + ((machineId == null) ? 0 : machineId.hashCode());
		result = prime * result + ((machineIsDelete == null) ? 0 : machineIsDelete.hashCode());
		result = prime * result + ((machineName == null) ? 0 : machineName.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((memberIsDelete == null) ? 0 : memberIsDelete.hashCode());
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((merchantId == null) ? 0 : merchantId.hashCode());
		result = prime * result + ((orderAmount == null) ? 0 : orderAmount.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderIsDelete == null) ? 0 : orderIsDelete.hashCode());
		result = prime * result + ((orderNum == null) ? 0 : orderNum.hashCode());
		result = prime * result + ((orderRemark == null) ? 0 : orderRemark.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + ((payOrderNum == null) ? 0 : payOrderNum.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetail other = (OrderDetail) obj;
		if (documentId == null) {
			if (other.documentId != null)
				return false;
		} else if (!documentId.equals(other.documentId))
			return false;
		if (documentName == null) {
			if (other.documentName != null)
				return false;
		} else if (!documentName.equals(other.documentName))
			return false;
		if (documentStatus == null) {
			if (other.documentStatus != null)
				return false;
		} else if (!documentStatus.equals(other.documentStatus))
			return false;
		if (documentUrl == null) {
			if (other.documentUrl != null)
				return false;
		} else if (!documentUrl.equals(other.documentUrl))
			return false;
		if (machineId == null) {
			if (other.machineId != null)
				return false;
		} else if (!machineId.equals(other.machineId))
			return false;
		if (machineIsDelete == null) {
			if (other.machineIsDelete != null)
				return false;
		} else if (!machineIsDelete.equals(other.machineIsDelete))
			return false;
		if (machineName == null) {
			if (other.machineName != null)
				return false;
		} else if (!machineName.equals(other.machineName))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (memberIsDelete == null) {
			if (other.memberIsDelete != null)
				return false;
		} else if (!memberIsDelete.equals(other.memberIsDelete))
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (merchantId == null) {
			if (other.merchantId != null)
				return false;
		} else if (!merchantId.equals(other.merchantId))
			return false;
		if (orderAmount == null) {
			if (other.orderAmount != null)
				return false;
		} else if (!orderAmount.equals(other.orderAmount))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderIsDelete == null) {
			if (other.orderIsDelete != null)
				return false;
		} else if (!orderIsDelete.equals(other.orderIsDelete))
			return false;
		if (orderNum == null) {
			if (other.orderNum != null)
				return false;
		} else if (!orderNum.equals(other.orderNum))
			return false;
		if (orderRemark == null) {
			if (other.orderRemark != null)
				return false;
		} else if (!orderRemark.equals(other.orderRemark))
			return false;
		if (orderStatus == null) {
			if (other.orderStatus != null)
				return false;
		} else if (!orderStatus.equals(other.orderStatus))
			return false;
		if (payOrderNum == null) {
			if (other.payOrderNum != null)
				return false;
		} else if (!payOrderNum.equals(other.payOrderNum))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		return true;
	}

}
