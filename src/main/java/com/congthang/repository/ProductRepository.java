package com.congthang.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.congthang.entity.Product;
import com.congthang.util.HibernateUtil;


@Repository
@Transactional
public class ProductRepository {
	
	public void saveProduct(Product product) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        //Save the employee in database
        session.save(product);
 
        //Commit the transaction
        session.getTransaction().commit();
    }
}
