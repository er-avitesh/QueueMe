package com.avitesh.queueapp.merchant.dao.repo;

import org.springframework.data.repository.CrudRepository;

import com.avitesh.queueapp.merchant.dao.model.Merchant;

public interface MerchantRepository extends CrudRepository<Merchant, String> {

	
}
