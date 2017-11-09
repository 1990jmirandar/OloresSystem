package com.sinergiass.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sinergiass.model.TipoOlor;

public class CreateTipoOlor{

   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
      
      EntityManager entitymanager = emfactory.createEntityManager( );
      entitymanager.getTransaction().begin();

      TipoOlor olor = new TipoOlor();
      olor.setName("gasolina");
      olor.setHexColor("ffffce");
      olor.setId(1);
      
      entitymanager.persist(olor);
      entitymanager.getTransaction().commit();

      entitymanager.close();
      emfactory.close();
   }
}