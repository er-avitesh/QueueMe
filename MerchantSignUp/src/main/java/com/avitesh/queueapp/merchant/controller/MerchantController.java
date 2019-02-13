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

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateMerchant(@RequestBody Merchant merchantObj) {
		return service.updateMerchant(merchantObj);
	}

	@RequestMapping(value = "/listMerchants", method = RequestMethod.POST)
	public ResponseEntity<Object> listMerchant() {
		return new ResponseEntity<>(service.listMerchant(), HttpStatus.FOUND);
	}

	@RequestMapping(value = "/getMerchantbyid", method = RequestMethod.POST)
	public ResponseEntity<Object> findMerchantById(@RequestBody Merchant merchantObj) {
		return new ResponseEntity<>(service.getMerchantById(merchantObj.getId()), HttpStatus.FOUND);
	}

	@RequestMapping(value = "/getMerchantbycategory", method = RequestMethod.POST)
	public ResponseEntity<Object> findMerchantByCategory(@RequestBody Merchant merchantObj) {
		return new ResponseEntity<>(service.getMerchantByCategory(merchantObj.getMerchantCategory()), HttpStatus.FOUND);
	}

	@RequestMapping(value = "/getMerchantbycity", method = RequestMethod.POST)
	public ResponseEntity<Object> findMerchantByCity(@RequestBody Merchant merchantObj) {
		return new ResponseEntity<>(service.getMerchantByCity(merchantObj.getMerchantCity()), HttpStatus.FOUND);
	}

	@RequestMapping(value = "/getMerchantbyname", method = RequestMethod.POST)
	public ResponseEntity<Object> findMerchantByName(@RequestBody Merchant merchantObj) {
		return new ResponseEntity<>(service.getMerchantByName(merchantObj.getMerchantName()), HttpStatus.FOUND);
	}

	@RequestMapping(value = "/deleteMerchant", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteMerchant(@RequestBody Merchant merchantObj) {
		return service.deleteMerchant(merchantObj.getId());
	}
}
