package com.sust.swy.print.entity;

import java.util.Date;

public class MachineWithMerchant {

	private Integer machineId;

	private Integer merchantId;

	private String machineName;

	private Integer machineStatus;

	private Integer machineType;

	private Date updateTime;

	private Integer isDelete;

	private String merchantName;

	private String merchantEmail;

	private Integer merchantStatus;

	@Override
	public String toString() {
		return "MachineWithMerchant [machineId=" + machineId + ", merchantId=" + merchantId + ", machineName="
				+ machineName + ", machineStatus=" + machineStatus + ", machineType=" + machineType + ", updateTime="
				+ updateTime + ", isDelete=" + isDelete + ", merchantName=" + merchantName + ", merchantEmail="
				+ merchantEmail + ", merchantStatus=" + merchantStatus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isDelete == null) ? 0 : isDelete.hashCode());
		result = prime * result + ((machineId == null) ? 0 : machineId.hashCode());
		result = prime * result + ((machineName == null) ? 0 : machineName.hashCode());
		result = prime * result + ((machineStatus == null) ? 0 : machineStatus.hashCode());
		result = prime * result + ((machineType == null) ? 0 : machineType.hashCode());
		result = prime * result + ((merchantEmail == null) ? 0 : merchantEmail.hashCode());
		result = prime * result + ((merchantId == null) ? 0 : merchantId.hashCode());
		result = prime * result + ((merchantName == null) ? 0 : merchantName.hashCode());
		result = prime * result + ((merchantStatus == null) ? 0 : merchantStatus.hashCode());
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
		MachineWithMerchant other = (MachineWithMerchant) obj;
		if (isDelete == null) {
			if (other.isDelete != null)
				return false;
		} else if (!isDelete.equals(other.isDelete))
			return false;
		if (machineId == null) {
			if (other.machineId != null)
				return false;
		} else if (!machineId.equals(other.machineId))
			return false;
		if (machineName == null) {
			if (other.machineName != null)
				return false;
		} else if (!machineName.equals(other.machineName))
			return false;
		if (machineStatus == null) {
			if (other.machineStatus != null)
				return false;
		} else if (!machineStatus.equals(other.machineStatus))
			return false;
		if (machineType == null) {
			if (other.machineType != null)
				return false;
		} else if (!machineType.equals(other.machineType))
			return false;
		if (merchantEmail == null) {
			if (other.merchantEmail != null)
				return false;
		} else if (!merchantEmail.equals(other.merchantEmail))
			return false;
		if (merchantId == null) {
			if (other.merchantId != null)
				return false;
		} else if (!merchantId.equals(other.merchantId))
			return false;
		if (merchantName == null) {
			if (other.merchantName != null)
				return false;
		} else if (!merchantName.equals(other.merchantName))
			return false;
		if (merchantStatus == null) {
			if (other.merchantStatus != null)
				return false;
		} else if (!merchantStatus.equals(other.merchantStatus))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		return true;
	}

	public Integer getMachineId() {
		return machineId;
	}

	public void setMachineId(Integer machineId) {
		this.machineId = machineId;
	}

	public Integer getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public Integer getMachineStatus() {
		return machineStatus;
	}

	public void setMachineStatus(Integer machineStatus) {
		this.machineStatus = machineStatus;
	}

	public Integer getMachineType() {
		return machineType;
	}

	public void setMachineType(Integer machineType) {
		this.machineType = machineType;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantEmail() {
		return merchantEmail;
	}

	public void setMerchantEmail(String merchantEmail) {
		this.merchantEmail = merchantEmail;
	}

	public Integer getMerchantStatus() {
		return merchantStatus;
	}

	public void setMerchantStatus(Integer merchantStatus) {
		this.merchantStatus = merchantStatus;
	}

	public MachineWithMerchant(Integer machineId, Integer merchantId, String machineName, Integer machineStatus,
			Integer machineType, Date updateTime, Integer isDelete, String merchantName, String merchantEmail,
			Integer merchantStatus) {
		super();
		this.machineId = machineId;
		this.merchantId = merchantId;
		this.machineName = machineName;
		this.machineStatus = machineStatus;
		this.machineType = machineType;
		this.updateTime = updateTime;
		this.isDelete = isDelete;
		this.merchantName = merchantName;
		this.merchantEmail = merchantEmail;
		this.merchantStatus = merchantStatus;
	}

	public MachineWithMerchant() {
		super();
	}

}
