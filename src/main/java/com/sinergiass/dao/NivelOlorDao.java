package com.sinergiass.dao;

import java.util.List;

import javax.persistence.Query;

import com.sinergiass.model.NivelOlor;

public class NivelOlorDao extends BaseDao<NivelOlor> {
	
	public NivelOlorDao() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NivelOlor> consultar() throws Exception {
		
		entitymanager.getTransaction().begin();
		
		Query q = entitymanager.createQuery("SELECT e FROM NivelOlor e");
		
		return (List<NivelOlor>) q.getResultList();
		
	}
	
	@Override
	public void actualizar(NivelOlor nivel) throws Exception {

		entitymanager.getTransaction().begin();
		
		Query q = entitymanager.createQuery("UPDATE NivelOlor e SET e.name= :name, e.hexColor= :hexColor WHERE e.id= :id");
		q.setParameter("id", nivel.getId());
		q.setParameter("name", nivel.getName());
		q.setParameter("hexColor", nivel.getHexColor());
		
		q.executeUpdate();
		
		entitymanager.getTransaction( ).commit( );

	    entitymanager.close( );
	    emfactory.close( );
	}
	
	// No probado
	@Override
	public NivelOlor consultarById(long id) throws Exception {
		NivelOlor nivel = entitymanager.find( NivelOlor.class, id);
		return nivel;
	}
}