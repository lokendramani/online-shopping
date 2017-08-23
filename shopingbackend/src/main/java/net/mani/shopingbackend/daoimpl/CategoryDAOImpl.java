package net.mani.shopingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.mani.shopingbackend.dao.CategoryDAO;
import net.mani.shopingbackend.dto.Category;
@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	private static List<Category> categories=new ArrayList<>();;
	
	/*static{
		Category category=new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is description of Television");
		category.setImageURL("CAT_1.png");
		categories.add(category);
		
		category=new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is description of Mobile");
		category.setImageURL("CAT_2.png");
		categories.add(category);
		
		category=new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is description of Laptop");
		category.setImageURL("CAT_3.png");
		categories.add(category);
	}
	*/
	
	/*Getting single category
	 * (non-Javadoc)
	 * @see net.mani.shopingbackend.dao.CategoryDAO#get(int)
	 */
	@Override
	public Category get(int id) {
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
		
	}

	public List<Category> list() {
		
		String selectActiveCategory="From Category Where active=:active";
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	
	public boolean add(Category category) {
		try{
			//add the category to database
			sessionFactory.getCurrentSession().persist(category);;
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	
	}
	/*Updating a single category
	 * (non-Javadoc)
	 * @see net.mani.shopingbackend.dao.CategoryDAO#update(net.mani.shopingbackend.dto.Category)
	 */
	@Override
	public boolean update(Category category) {
		try{
			//add the category to database
			sessionFactory.getCurrentSession().update(category);;
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try{
			//add the category to database
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	

}
