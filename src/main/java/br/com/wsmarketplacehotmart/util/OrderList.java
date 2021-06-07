package br.com.wsmarketplacehotmart.util;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.wsmarketplacehotmart.model.Product;

public class OrderList {
	public static void orderListProduct(List<Product> productList){
	    Comparator<Product> comparetor = Comparator.comparing(Product::getScore)
	        .thenComparing(Product::getName).thenComparing(Product::getNameCategoryProduct);
	    Collections.sort(productList, comparetor);
	}
}
