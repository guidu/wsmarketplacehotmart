package com.br.wsmarketplacehotmart.util;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.br.wsmarketplacehotmart.model.Product;

public class OrderList {
	public void orderListProduct(List<Product> productList){
	    Comparator<Product> comparetor = Comparator.comparing(Product::getScore)
	        .thenComparing(Product::getName).thenComparing(Product::getNameCategoryProduct);
	    Collections.sort(productList, comparetor);
	}
}
