package com.avitesh.queueapp.merchant.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "merchant")
public class Merchant {

	@Id
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String merchantName;

	@Column(nullable = false)
	private String merchantCategory;

	@Column(nullable = false)
	private String merchantStAddress;

	@Column(nullable = false)
	private String merchantCity;

	@Column(nullable = false)
	private String merchantState;

	@Column(nullable = false)
	private String merchantZipCd;

	@Column(nullable = false)
	private String merchantContactPerson;

	@Column(nullable = false)
	private String merchantContactPersonNbr;

	public Long getMerchantId() {
		return id;
	}

	public void setMerchantId(Long merchantId) {
		this.id = merchantId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantCategory() {
		return merchantCategory;
	}

	public void setMerchantCategory(String merchantCategory) {
		this.merchantCategory = merchantCategory;
	}

	public String getMerchantStAddress() {
		return merchantStAddress;
	}

	public void setMerchantStAddress(String merchantStAddress) {
		this.merchantStAddress = merchantStAddress;
	}

	public String getMerchantCity() {
		return merchantCity;
	}

	public void setMerchantCity(String merchantCity) {
		this.merchantCity = merchantCity;
	}

	public String getMerchantState() {
		return merchantState;
	}

	public void setMerchantState(String merchantState) {
		this.merchantState = merchantState;
	}

	public String getMerchantZipCd() {
		return merchantZipCd;
	}

	public void setMerchantZipCd(String merchantZipCd) {
		this.merchantZipCd = merchantZipCd;
	}

	public String getMerchantContactPerson() {
		return merchantContactPerson;
	}

	public void setMerchantContactPerson(String merchantContactPerson) {
		this.merchantContactPerson = merchantContactPerson;
	}

	public String getMerchantContactPersonNbr() {
		return merchantContactPersonNbr;
	}

	public void setMerchantContactPersonNbr(String merchantContactPersonNbr) {
		this.merchantContactPersonNbr = merchantContactPersonNbr;
	}
	
	@Override
	public String toString() {
		return "Merchant [merchantId=" + id + ", name=" + merchantName + ", category=" + merchantCategory
				+ ", StreetAdd=" + merchantStAddress + ", City=" + merchantCity + ", State=" + merchantState + ", zip="
				+ merchantZipCd + ", contactPerson=" + merchantContactPerson + ", contactPersonNumber="
				+ merchantContactPersonNbr + "]";
	}
}
