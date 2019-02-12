package com.avitesh.queueapp.merchant.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.avitesh.queueapp.merchant.dao.model.Merchant;
import com.avitesh.queueapp.merchant.dao.repo.MerchantRepository;
import com.avitesh.queueapp.merchant.dto.MerchantResponse;
import com.avitesh.queueapp.merchant.helper.Messages;

@Service
public class MerchantService {

	@Autowired
	MerchantRepository repo;

	@Autowired
	MerchantResponse response;

	@Autowired
	Messages msg;

	// private static final Logger log =
	// LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public ResponseEntity<Object> addMerchant(Merchant merchantObj) {
		if (!repo.existsById(merchantObj.getMerchantId())) {
			Merchant savedMerchant = repo.save(merchantObj);
			response.setMerchantId(savedMerchant.getMerchantId());
			response.setName(savedMerchant.getMerchantName());
			response.setCategory(savedMerchant.getMerchantCategory());
			response.setMsg(msg.MERCHANT_ADD_SUCCESS);

			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} else {
			response.setMerchantId(merchantObj.getMerchantId());
			response.setName(merchantObj.getMerchantName());
			response.setCategory(merchantObj.getMerchantCategory());
			response.setMsg(msg.MERCHANT_ADD_EXIST);
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
	}

	public Iterable<Merchant> listMerchant() {
		return repo.findAll();
	}

	public MerchantResponse getMerchantById(Long id) {
		if (id != null && id > 0) {
			Optional<Merchant> merchant = repo.findById(id);
			response.setMerchantId(merchant.get().getMerchantId());
			response.setName(merchant.get().getMerchantName());
			response.setCategory(merchant.get().getMerchantCategory());
			response.setMsg(msg.MERCHANT_FOUND_BY_ID);
			return response;
		} else {
			response.setMerchantId(id);
			response.setMsg(msg.MERCHANT_NOT_FOUND_BY_ID);
			return response;
		}
	}

}
