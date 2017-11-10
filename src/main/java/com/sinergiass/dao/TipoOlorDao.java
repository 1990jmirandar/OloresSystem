package com.sinergiass.dao;

import java.util.List;

import javax.persistence.Query;

import com.sinergiass.model.TipoOlor;

public class TipoOlorDao extends BaseDao<TipoOlor> {
	
	public TipoOlorDao() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoOlor> consultar() throws Exception {
		
		entitymanager.getTransaction().begin();
		
		Query q = entitymanager.createQuery("SELECT e FROM TipoOlor e");
		
		return (List<TipoOlor>) q.getResultList();
		
	}
	
	@Override
	public void actualizar(TipoOlor olor) throws Exception {

		entitymanager.getTransaction().begin();
		
		Query q = entitymanager.createQuery("UPDATE TipoOlor e SET e.name= :name, e.hexColor= :hexColor WHERE e.id= :id");
		q.setParameter("id", olor.getId());
		q.setParameter("name", olor.getName());
		q.setParameter("hexColor", olor.getHexColor());
		
		q.executeUpdate();
		
		entitymanager.getTransaction( ).commit( );

	    entitymanager.close( );
	    emfactory.close( );
	}
	
	// No probado
	@Override
	public TipoOlor consultarById(long id) throws Exception {
		TipoOlor olor = entitymanager.find( TipoOlor.class, id);
		return olor;
	}
}
