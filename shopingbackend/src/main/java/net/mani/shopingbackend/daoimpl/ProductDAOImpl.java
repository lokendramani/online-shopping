package net.mani.shopingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.mani.shopingbackend.dao.ProductDAO;
import net.mani.shopingbackend.dto.Category;
import net.mani.shopingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static List<Category> categories = new ArrayList<>();

	@Override
	public Product get(int id) {
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
	}

	@Override
	public List<Product> list() {
		String selectActiveProducts = "From Product";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts, Product.class).getResultList();

	}

	@Override
	public boolean add(Product product) {
		try {
			// add the category to database
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try {
			// add the category to database
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		try {
			// add the category to database
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		String activeProducts = "From Product where active = :active";

		return sessionFactory.getCurrentSession().createQuery(activeProducts, Product.class)
				.setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String activeProductsByCategory = "From Product where active = :active AND categoryId = :categoryId";

		return sessionFactory.getCurrentSession().createQuery(activeProductsByCategory, Product.class)
				.setParameter("active", true).setParameter("categoryId", categoryId). getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		String latestActiveProducts = "From Product where active = :active order By id";

		return sessionFactory.getCurrentSession().createQuery(latestActiveProducts, Product.class)
				.setParameter("active", true).setFirstResult(0).setMaxResults(count). getResultList();
	
	}

}
