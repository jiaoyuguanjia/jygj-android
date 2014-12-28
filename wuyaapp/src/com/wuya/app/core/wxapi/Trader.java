package com.wuya.app.core.wxapi;

import java.io.Serializable;

public class Trader implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5127219153930267744L;

	/**
	 * 商户号
	 */
	private String traderName;
	/**
	 * 商户密码
	 */
	private String traderPassword;

	/**
	 * 系统(WAP,PalmOS、Symbian、Windows mobile、WinCE、Linux和Android、iPhoneOS、黑莓)
	 */
	private String clientSystem;
	/**
	 * 客户端版本
	 */
	private String clientVersion;
	/**
	 * 协议(Webservice,HTTPXML)
	 */
	private String protocol;

	/**
	 * app interface name
	 */
	private String interfaceVersion;

	/**
	 * 应用版本
	 */
	private String clientAppVersion;

	/**
	 * 客户端电话号码
	 */
	private String clientTelnetPhone;

	/**
	 * 省份Id
	 */
	private String provinceId;

	/**
	 * 临时token
	 */
	private String userToken;

	/**
	 * 当前纬度
	 */
	private String latitude;

	/**
	 * 当前经度
	 */
	private String longitude;

	/**
	 * 客户端唯一标识，wap、website模拟一个
	 */
	private String deviceCode;

	/**
	 * 客户端唯一标识，wap、website模拟一个（未加密）
	 */
	private String deviceCodeNotEncrypt;

	/**
	 * user deviceToken
	 */
	private String deviceToken;

	public String getTraderName() {
		return traderName;
	}

	public void setTraderName(String traderName) {
		this.traderName = traderName;
	}

	public String getTraderPassword() {
		return traderPassword;
	}

	public void setTraderPassword(String traderPassword) {
		this.traderPassword = traderPassword;
	}

	public String getClientSystem() {
		return clientSystem;
	}

	public void setClientSystem(String clientSystem) {
		this.clientSystem = clientSystem;
	}

	public String getClientVersion() {
		return clientVersion;
	}

	public void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getInterfaceVersion() {
		return interfaceVersion;
	}

	public void setInterfaceVersion(String interfaceVersion) {
		this.interfaceVersion = interfaceVersion;
	}

	public String getClientAppVersion() {
		return clientAppVersion;
	}

	public void setClientAppVersion(String clientAppVersion) {
		this.clientAppVersion = clientAppVersion;
	}

	public String getClientTelnetPhone() {
		return clientTelnetPhone;
	}

	public void setClientTelnetPhone(String clientTelnetPhone) {
		this.clientTelnetPhone = clientTelnetPhone;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getDeviceCodeNotEncrypt() {
		return deviceCodeNotEncrypt;
	}

	public void setDeviceCodeNotEncrypt(String deviceCodeNotEncrypt) {
		this.deviceCodeNotEncrypt = deviceCodeNotEncrypt;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
}
