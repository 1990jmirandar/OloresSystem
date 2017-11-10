package com.sinergiass.dao;

import java.util.List;

public interface IBaseDao<T> {
	
	public void insertar(T t) throws Exception;
	
	public void actualizar(T t) throws Exception;
	
	public List<T> consultar() throws Exception;
	
	public T consultarById(long id) throws Exception;
	
	public void eliminar(T t) throws Exception;
	
}
