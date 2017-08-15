package net.mani.shopingbackend.dao;

import java.util.List;

import net.mani.shopingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
}
