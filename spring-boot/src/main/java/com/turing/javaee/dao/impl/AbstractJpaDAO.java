package com.turing.javaee.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractJpaDAO < T extends Serializable > {

	   private Class< T > clazz;

	   @PersistenceContext
	   EntityManager entityManager;

	   @SuppressWarnings("unchecked")
	    public AbstractJpaDAO(){
	        this.clazz =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	    }
	   
	   public T findOne( long id ){
	      return entityManager.find( clazz, id );
	   }
	   public List< T > findAll(){
	      return entityManager.createQuery( "from " + clazz.getName() )
	       .getResultList();
	   }

	   public void create( T entity ){
	      entityManager.persist( entity );
	   }

	   public T update( T entity ){
	      return entityManager.merge( entity );
	   }

	   public void delete( T entity ){
	      entityManager.remove( entity );
	   }
	   public void deleteById( long entityId ){
	      T entity = findOne( entityId );
	      delete( entity );
	   }
	}
