package net.mani.shopingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.mani.shopingbackend.dao.CategoryDAO;
import net.mani.shopingbackend.dao.ProductDAO;
import net.mani.shopingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("net.mani.shopingbackend");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	/*@Test 
	public void testCRUDProduct(){
		product=new Product();
		
		product.setName("Oppo Selfie");
		product.setBrand("Oppo");
		product.setDescription("Description for Oppo");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(2);
		product.setSupplierId(3);
		
		assertEquals("Error while insertion product",true,productDAO.add(product));
		
		product=productDAO.get(2);
		product.setName("Samsung Galaxy S7");
		assertEquals("Error while updation product",true,productDAO.update(product));

		assertEquals("Error while deletion of product",true,productDAO.delete(product));
		
		assertEquals("Error while listing of product",6,productDAO.list().size());
	}*/
	
	@Test
	public void testListActiveProducts(){
		assertEquals("Error while listing of product",5,productDAO.listActiveProducts().size());
	}
	
	@Test
	public void testListActiveProductsByCategory(){
		assertEquals("Error while listing of product",2,productDAO.listActiveProductsByCategory(3).size());
	}
	
	@Test
	public void testLatestActiveProductsByCategory(){
		assertEquals("Error while listing of product",3,productDAO.getLatestActiveProducts(3).size());
	}

}
