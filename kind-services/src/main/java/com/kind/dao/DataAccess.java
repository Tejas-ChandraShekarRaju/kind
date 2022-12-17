package com.kind.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kind.model.User;

@Repository
public class DataAccess {
	
    @PersistenceContext
    private EntityManager entityManager;

    public int findUserMarks(String user) {
        Query q = entityManager.createNativeQuery("Select marks from user where name='"+user+"' for update");
        //Query q = entityManager.createQuery("select u.marks from User u where u.name=?1");
        q.setParameter(1, user);
        //q.setLockMode(LockModeType.PESSIMISTIC_WRITE);
        System.out.println("Printing");
        int marks = (int) q.getSingleResult();
        System.out.println("Printing"+marks);
        return marks;
    }
    
    @Transactional
    public int addUser(String user,int newMarks) {
    	TypedQuery<User> query = entityManager.createQuery("Select u from user u where u.name='adam'",User.class);
    	User u = new User();
    	u.setMarks(newMarks);
    	u.setName(user);
    	entityManager.persist(u);
    	//entityManager.flush();
    	TypedQuery<User> query1 = entityManager.createQuery("Select u from user u where u.name=?1",User.class);
    	query1.setParameter(1, user);
    	int marks = query1.getSingleResult().getMarks();
    	query.getSingleResult().setMarks(marks);
    	entityManager.merge(query.getSingleResult());
    	return 1;
    	
    	
    	
    }

}
