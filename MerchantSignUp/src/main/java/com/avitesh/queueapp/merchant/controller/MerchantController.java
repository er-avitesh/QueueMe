package com.avitesh.queueapp.merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.avitesh.queueapp.merchant.dao.model.Merchant;
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

	/*
	 * @RequestMapping(value = "/listMerchants", method = RequestMethod.POST) public
	 * Iterable<Merchant> listMerchant() { return service.listMerchant(); }
	 */
	@RequestMapping(value = "/listMerchants", method = RequestMethod.POST)
	public ResponseEntity<Object> listMerchant() {
		return new ResponseEntity<>(service.listMerchant(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getMerchantbyid", method = RequestMethod.POST)
	public ResponseEntity<Object> findMerchantById(@RequestBody Merchant merchantObj) {
		return new ResponseEntity<>(service.getMerchantById(merchantObj.getId()), HttpStatus.FOUND);
	}

	@RequestMapping(value = "/getMerchantbycategory", method = RequestMethod.POST)
	public ResponseEntity<Object> findMerchantByCategory(@RequestBody Merchant merchantObj) {
		return new ResponseEntity<>(service.getMerchantByCategory(merchantObj.getMerchantCategory()), HttpStatus.FOUND);
		// return service.getMerchantByCategory(merchantObj.getMerchantCategory());
	}
}
