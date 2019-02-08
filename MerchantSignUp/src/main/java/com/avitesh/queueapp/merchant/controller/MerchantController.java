package com.avitesh.queueapp.merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.avitesh.queueapp.merchant.dao.model.Merchant;
import com.avitesh.queueapp.merchant.dao.repo.MerchantRepository;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

	@Autowired
	MerchantRepository repo;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addMerchant(@RequestBody Merchant merchantObj) {
		Merchant savedMerchant = repo.save(merchantObj);
		return new ResponseEntity<>(savedMerchant, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/listMerchants", method = RequestMethod.GET)
	public Iterable<Merchant> listMerchant() {
		return repo.findAll();

	}
}
