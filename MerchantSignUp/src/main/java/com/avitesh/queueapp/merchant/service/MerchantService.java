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
		if (!repo.existsById(merchantObj.getId())) {
			Merchant savedMerchant = repo.save(merchantObj);
			response.setMerchantId(savedMerchant.getId());
			response.setName(savedMerchant.getMerchantName());
			response.setCategory(savedMerchant.getMerchantCategory());
			response.setMsg(msg.MERCHANT_ADD_SUCCESS);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} else {
			response.setMerchantId(merchantObj.getId());
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
			response.setMerchantId(merchant.get().getId());
			response.setName(merchant.get().getMerchantName());
			response.setCategory(merchant.get().getMerchantCategory());
			response.setMsg(msg.MERCHANT_FOUND_BY_ID);
			return response;
		} else {
			response.setMerchantId(id);
			response.setMsg(msg.MERCHANT_NOT_FOUND);
			return response;
		}
	}

	public Iterable<Merchant> getMerchantByCategory(String category) {
		Iterable<Merchant> merchants = repo.findByMerchantCategory(category);
		return merchants;
	}

	public Iterable<Merchant> getMerchantByCity(String city) {
		Iterable<Merchant> merchants = repo.findByMerchantCity(city);
		return merchants;
	}

	public Iterable<Merchant> getMerchantByName(String name) {
		Iterable<Merchant> merchants = repo.findByMerchantName(name);
		return merchants;
	}

	public ResponseEntity<Object> updateMerchant(Merchant input) {
		Optional<Merchant> existingMerchant = repo.findById(input.getId());
		if (existingMerchant.isPresent()) {
			existingMerchant.get().setMerchantCategory(input.getMerchantCategory());
			existingMerchant.get().setMerchantCity(input.getMerchantCity());
			existingMerchant.get().setMerchantContactPerson(input.getMerchantContactPerson());
			existingMerchant.get().setMerchantContactPersonNbr(input.getMerchantContactPersonNbr());
			existingMerchant.get().setMerchantName(input.getMerchantName());
			existingMerchant.get().setMerchantStAddress(input.getMerchantStAddress());
			existingMerchant.get().setMerchantState(input.getMerchantState());
			existingMerchant.get().setMerchantZipCd(input.getMerchantZipCd());
			repo.save(existingMerchant.get());
			response.setMerchantId(existingMerchant.get().getId());
			response.setName(existingMerchant.get().getMerchantName());
			response.setCategory(existingMerchant.get().getMerchantCategory());
			response.setMsg(msg.MERCHANT_UPDATED);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setMerchantId(input.getId());
			response.setName(input.getMerchantName());
			response.setCategory(input.getMerchantCategory());
			response.setMsg(msg.MERCHANT_NOT_FOUND);
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}

	}
}