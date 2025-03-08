package com.milky.service;

import java.util.List;

import com.milky.entity.DairyProduct;

public interface DairyProductService {
	
	DairyProduct addDairyProduct(DairyProduct dairyProduct);
	
	List<DairyProduct> getAllDairyProducts();
	
	DairyProduct getDairyProductById(Integer id);
	
	DairyProduct getDairyProductByName(String name);

}
