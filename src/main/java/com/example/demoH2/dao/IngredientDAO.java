package com.example.demoH2.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demoH2.model.Ingredient;

@Transactional
@Repository
public class IngredientDAO {
	
	@Autowired
	private EntityManager sessionFactory;
	private Session session;
	
	public IngredientDAO(EntityManager sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	public List<Ingredient> getAllIngredients() {
		session=sessionFactory.unwrap(Session.class);
		List<Ingredient> listIngredient=session.createQuery("from Ingredient",Ingredient.class).getResultList();
		return listIngredient;
	}

	public Ingredient getIngredientById(Long id) {
		session=sessionFactory.unwrap(Session.class);
	    return  session.get(Ingredient.class,id);
	}
	
	public void updateIngredient(Ingredient ingredient) {
		session=sessionFactory.unwrap(Session.class);
		session.update(ingredient);
	}
	
	public int deleteIngredientById(Long id) {
		session=sessionFactory.unwrap(Session.class);
		Query query=session.createQuery("delete from Ingredient where ingredient_id= :id");
		query.setParameter("id", id);
		return query.executeUpdate();
	}
	
	public int deleteIngredients() {
		session=sessionFactory.unwrap(Session.class);
		Query<Ingredient> query=session.createQuery("delete from Ingredient",Ingredient.class);
		return query.executeUpdate();
	}

	public void createIngredient(Ingredient ingredient) {
		session=sessionFactory.unwrap(Session.class);
        session.save(ingredient);		
	}
}
