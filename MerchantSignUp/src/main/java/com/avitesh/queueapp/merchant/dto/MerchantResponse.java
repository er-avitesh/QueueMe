package com.avitesh.queueapp.merchant.dto;

import org.springframework.stereotype.Component;

@Component
public class MerchantResponse {

	private Long merchantId;
	private String name;
	private String category;
	private String msg;

	public MerchantResponse(Long merchantId, String name, String category, String msg) {
		super();
		this.merchantId = merchantId;
		this.name = name;
		this.category = category;
		this.msg = msg;
	}

	public MerchantResponse(Long merchantId, String msg) {
		super();
		this.merchantId = merchantId;
		this.msg = msg;
	}

	public MerchantResponse() {
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
