package net.mani.shopingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.mani.shopingbackend.dao.CategoryDAO;
import net.mani.shopingbackend.dto.Category;

public class CategoryTestCase {
private static AnnotationConfigApplicationContext context;
private static CategoryDAO categoryDAO;

private Category category;

@BeforeClass
public static void init(){
	context=new AnnotationConfigApplicationContext();
	context.scan("net.mani.shopingbackend");
	context.refresh();
	
	categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
}

/*@Test
public void testAddCategory(){
	category=new Category();
	category.setName("Television");
	category.setDescription("This is description of Television");
	category.setImageURL("CAT_1.png");
	assertEquals("Successfully Added the category",true,categoryDAO.add(category));
}

@Test
public void testGetCategory(){
	category=categoryDAO.get(1);
	assertEquals("Successfully Fetched single category from the table","Television",category.getName());
	
}

@Test
public void testUpdateCategory(){
	category=categoryDAO.get(2);
	category.setName("Mobile");
	
	assertEquals("Successfully Updated single category from the table",true,categoryDAO.update(category));
	
}*/

/*@Test
public void testDeleteCategory(){
	category=categoryDAO.get(2);
	
	
	assertEquals("Successfully Deleted single category from the table",true,categoryDAO.delete(category));
	
}*/


@Test
public void testListCategory(){
	
	
	assertEquals("Successfully Fetched list of category from the table",1,categoryDAO.list().size());
	
}


@Test 
public void testCRUDCategory(){
	category=new Category();
	category.setName("Laptop");
	category.setDescription("This is description of Laptop");
	category.setImageURL("CAT_2.png");
	assertEquals("Successfully Added the category",true,categoryDAO.add(category));
	
	
	category=categoryDAO.get(2);
	category.setDescription("This is description of Mobile");
	
	assertEquals("Successfully Updated single category from the table",true,categoryDAO.update(category));
	
	
	category=categoryDAO.get(3);
	
	
	assertEquals("Successfully Deleted single category from the table",true,categoryDAO.delete(category));
	
	
	assertEquals("Successfully Fetched list of category from the table",1,categoryDAO.list().size());
}

}
