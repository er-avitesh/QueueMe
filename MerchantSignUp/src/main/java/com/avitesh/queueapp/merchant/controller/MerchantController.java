package com.avitesh.queueapp.merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.avitesh.queueapp.merchant.dao.model.Merchant;
import com.avitesh.queueapp.merchant.dto.MerchantResponse;
import com.avitesh.queueapp.merchant.service.MerchantService;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

	@Autowired
	MerchantService service;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addMerchant(@RequestBody Merchant merchantObj) {
		return service.addMerchant(merchantObj);
	}

	@RequestMapping(value = "/listMerchants", method = RequestMethod.POST)
	public Iterable<Merchant> listMerchant() {
		return service.listMerchant();
	}

	@RequestMapping(value = "/getMerchant", method = RequestMethod.POST)
	public MerchantResponse findMerchantById(@RequestBody Merchant merchantObj) {
		return service.getMerchantById(merchantObj.getMerchantId());
	}
}
