package br.com.wsmarketplacehotmart.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.wsmarketplacehotmart.model.CategoryProduct;
import br.com.wsmarketplacehotmart.model.Product;
import br.com.wsmarketplacehotmart.repository.ProductRepository;

class ProductServiceImplTest {
	@Mock
	private ProductRepository productRepository;

	private ProductServiceImpl productServiceImpl;

	@BeforeEach
	public void beforeEach() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testInsert() {
		productServiceImpl = new ProductServiceImpl(productRepository);
		LocalDateTime dateTimeCurrent = LocalDateTime.now();
		Product product = new Product();
		product.setName("Name Teste");
		product.setDescription("Description Teste");
		product.setDateCreation(dateTimeCurrent);
		CategoryProduct categoryProduct = new CategoryProduct();
		categoryProduct.setIdentifier(1);
		categoryProduct.setName("Categoria Teste");
		product.setCategoryProduct(categoryProduct);
		productServiceImpl.insert(product);
		product.setIdentifier(1);
		Mockito.when(productServiceImpl.insert(product)).thenReturn(product);
		
		
		Mockito.verify(productRepository).save(product);
		
		Assert.assertEquals("Name Teste", product.getName());
		Assert.assertEquals("Description Teste", product.getDescription());
		Assert.assertEquals(dateTimeCurrent, product.getDateCreation());
		Assert.assertEquals(categoryProduct.getIdentifier(), product.getCategoryProduct().getIdentifier());
		Assert.assertEquals("Categoria Teste", product.getCategoryProduct().getName());
	}

	@Test
	void testUpdate() {
		productServiceImpl = new ProductServiceImpl(productRepository);
		LocalDateTime dateTimeCurrent = LocalDateTime.now();
		Product product = new Product();
		product.setName("Name Teste");
		product.setDescription("Description Teste");
		product.setDateCreation(dateTimeCurrent);
		CategoryProduct categoryProduct = new CategoryProduct();
		categoryProduct.setIdentifier(1);
		categoryProduct.setName("Categoria Teste");
		product.setCategoryProduct(categoryProduct);
		productServiceImpl.insert(product);
		product.setIdentifier(1);
		Mockito.when(productServiceImpl.insert(product)).thenReturn(product);
		
		
		Mockito.verify(productRepository).save(product);

		Product p = new Product();

		p.setName("Name Alter");
		p.setDescription("Description Teste");
		product.setDateCreation(dateTimeCurrent);

		CategoryProduct categoryProductAlter = new CategoryProduct();
		categoryProductAlter.setIdentifier(1);
		categoryProductAlter.setName("Categoria Teste");
		p.setCategoryProduct(categoryProductAlter);
		p.setIdentifier(1);
		productServiceImpl.update(p);
		Mockito.when(productServiceImpl.update(p)).thenReturn(p);

		Mockito.verify(productRepository).saveAndFlush(p);

		Assert.assertEquals("Name Alter", p.getName());
		Assert.assertEquals("Description Teste", p.getDescription());
		Assert.assertEquals(categoryProduct.getIdentifier(), p.getCategoryProduct().getIdentifier());
		Assert.assertEquals("Categoria Teste", p.getCategoryProduct().getName());
	}

	
//	@Test
//	void testDelete() {
//		Mockito.verify(productRepository).deleteById(1);
//	}
	@Test
	void testlistAllProduct() { 
		productServiceImpl = new ProductServiceImpl(productRepository);
		Product product = new Product();
		List<Product> products = new ArrayList<Product>();
		LocalDateTime dateTimeCurrent = LocalDateTime.now();
		product.setName("Name Teste");
		product.setDescription("Description Teste");
		product.setDateCreation(dateTimeCurrent);
		CategoryProduct categoryProduct = new CategoryProduct();
		categoryProduct.setIdentifier(1);
		categoryProduct.setName("Categoria Teste");
		product.setCategoryProduct(categoryProduct);
		product.setIdentifier(1);
		products.add(product);
		
		Product p2 = new Product();
		LocalDateTime dateTimeCurrent2 = LocalDateTime.now();
		p2.setName("Name Teste");
		p2.setDescription("Description Teste");
		p2.setDateCreation(dateTimeCurrent2);
		CategoryProduct categoryProduct2 = new CategoryProduct();
		categoryProduct2.setIdentifier(1);
		categoryProduct2.setName("Categoria Teste");
		p2.setCategoryProduct(categoryProduct2);
		p2.setIdentifier(1);
		products.add(p2);
		productServiceImpl.listAllProduct();
		Mockito.when(productServiceImpl.listAllProduct()).thenReturn(products);
		Mockito.verify(productRepository).findAll();
		Assert.assertNotNull(products);
	}

}
