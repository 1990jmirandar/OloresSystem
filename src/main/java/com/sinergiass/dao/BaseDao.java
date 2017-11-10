package com.sinergiass.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseDao<T> implements IBaseDao<T>{
	
	EntityManagerFactory emfactory;
    
    EntityManager entitymanager;
	
	public BaseDao() {
		emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
		entitymanager = emfactory.createEntityManager( );
	}

	@Override
	public void actualizar(T t) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<T> consultar() throws Exception {
		return null;
	}

	@Override
	public void insertar(T t) throws Exception {
		
		entitymanager.getTransaction( ).begin( );

		entitymanager.persist(t);
		entitymanager.getTransaction( ).commit( );

	    entitymanager.close( );
	    emfactory.close( );
		
	}

	@Override
	public T consultarById(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(T t) throws Exception {
		entitymanager.getTransaction( ).begin( );
		
		t = entitymanager.merge(t);
		entitymanager.remove(t);
		entitymanager.getTransaction( ).commit( );

	    entitymanager.close( );
	    emfactory.close( );
	}
	
}
