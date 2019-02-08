package com.avitesh.queueapp.merchant.dao.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Merchant {

	@Id
	private String merchantId;
	private String name;
	private String category;
	private String StreetAdd;
	private String City;
	private String State;
	private String zip;
	private String contactPerson;
	private String contactPersonNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStreetAdd() {
		return StreetAdd;
	}

	public void setStreetAdd(String streetAdd) {
		StreetAdd = streetAdd;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactPersonNumber() {
		return contactPersonNumber;
	}

	public void setContactPersonNumber(String contactPersonNumber) {
		this.contactPersonNumber = contactPersonNumber;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	@Override
	public String toString() {
		return "Merchant [merchantId=" + merchantId + ", name=" + name + ", category=" + category + ", StreetAdd="
				+ StreetAdd + ", City=" + City + ", State=" + State + ", zip=" + zip + ", contactPerson="
				+ contactPerson + ", contactPersonNumber=" + contactPersonNumber + "]";
	}
}
