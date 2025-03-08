package com.milky.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milky.entity.DairyProduct;
import com.milky.repository.DairyProductRepository;
import com.milky.service.DairyProductService;

@Service
public class DairyProductServiceImpl implements DairyProductService{
	
	@Autowired
	DairyProductRepository dairyProductRepository;

	@Override
	public DairyProduct addDairyProduct(DairyProduct dairyProduct) {
		return this.dairyProductRepository.save(dairyProduct);
	}

	@Override
	public List<DairyProduct> getAllDairyProducts() {
		return this.dairyProductRepository.findAll();
	}

	@Override
	public DairyProduct getDairyProductById(Integer id) {
		Optional<DairyProduct> dp = dairyProductRepository.findById(id);
		if(dp.isEmpty()) {
			return null;
		}
		else {
			return dp.get();
		}
	}

	@Override
	public DairyProduct getDairyProductByName(String name) {
		Optional<DairyProduct> dp = Optional.ofNullable(dairyProductRepository.findByName(name));
		if(dp.isEmpty()) {
			return null;
		}
		else {
			return dp.get();
		}
	}

}
