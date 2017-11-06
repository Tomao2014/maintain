package online.zhaopei.myproject.domain.gjent;

import java.util.Date;

import online.zhaopei.myproject.domain.BaseDomain;

public class PersonalInfo extends BaseDomain {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8341912837423289472L;

	private String uuid;
	
	private String perName;
	
	private String certId;
	
	private String status;
	
	private String perPhone;
	
	private Date sysDate;
	
	private String beginSysDate;
	
	private String endSysDate;

	private String sysDateStr;
	
	private String authWay;
	
	private String authCop;
	
	private String checkFlag;
	
	private String checkMark;
	
	private String jyOrderNo;
	
	private String isCheck;
	
	private String billMode;
	
	private String errorCode;
	
	private String errorResult;
	
	private Integer errorCount;
	
	private String ciqStatus;
	
	private String chkMark;
	
	private Date noticeDate;
	
	private String ebpCode;
	
	private String searchText;

	private String groupOne;

	private String groupTwo;

	private Long sumRequestNum;

	private Long sumResponseNum;

	private Long personalNum;

	private Long orderNum;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPerPhone() {
		return perPhone;
	}

	public void setPerPhone(String perPhone) {
		this.perPhone = perPhone;
	}

	public Date getSysDate() {
		return sysDate;
	}

	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}

	public String getAuthWay() {
		return authWay;
	}

	public void setAuthWay(String authWay) {
		this.authWay = authWay;
	}

	public String getAuthCop() {
		return authCop;
	}

	public void setAuthCop(String authCop) {
		this.authCop = authCop;
	}

	public String getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}

	public String getCheckMark() {
		return checkMark;
	}

	public void setCheckMark(String checkMark) {
		this.checkMark = checkMark;
	}

	public String getJyOrderNo() {
		return jyOrderNo;
	}

	public void setJyOrderNo(String jyOrderNo) {
		this.jyOrderNo = jyOrderNo;
	}

	public String getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}

	public String getBillMode() {
		return billMode;
	}

	public void setBillMode(String billMode) {
		this.billMode = billMode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorResult() {
		return errorResult;
	}

	public void setErrorResult(String errorResult) {
		this.errorResult = errorResult;
	}

	public Integer getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(Integer errorCount) {
		this.errorCount = errorCount;
	}

	public String getCiqStatus() {
		return ciqStatus;
	}

	public void setCiqStatus(String ciqStatus) {
		this.ciqStatus = ciqStatus;
	}

	public String getChkMark() {
		return chkMark;
	}

	public void setChkMark(String chkMark) {
		this.chkMark = chkMark;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getEbpCode() {
		return ebpCode;
	}

	public void setEbpCode(String ebpCode) {
		this.ebpCode = ebpCode;
	}

	public String getBeginSysDate() {
		return beginSysDate;
	}

	public void setBeginSysDate(String beginSysDate) {
		this.beginSysDate = beginSysDate;
	}

	public String getEndSysDate() {
		return endSysDate;
	}

	public void setEndSysDate(String endSysDate) {
		this.endSysDate = endSysDate;
	}

	public String getSysDateStr() {
		return sysDateStr;
	}

	public void setSysDateStr(String sysDateStr) {
		this.sysDateStr = sysDateStr;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getGroupOne() {
		return groupOne;
	}

	public void setGroupOne(String groupOne) {
		this.groupOne = groupOne;
	}

	public String getGroupTwo() {
		return groupTwo;
	}

	public void setGroupTwo(String groupTwo) {
		this.groupTwo = groupTwo;
	}

	public Long getSumRequestNum() {
		return sumRequestNum;
	}

	public void setSumRequestNum(Long sumRequestNum) {
		this.sumRequestNum = sumRequestNum;
	}

	public Long getSumResponseNum() {
		return sumResponseNum;
	}

	public void setSumResponseNum(Long sumResponseNum) {
		this.sumResponseNum = sumResponseNum;
	}

	public Long getPersonalNum() {
		return personalNum;
	}

	public void setPersonalNum(Long personalNum) {
		this.personalNum = personalNum;
	}

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}
}
