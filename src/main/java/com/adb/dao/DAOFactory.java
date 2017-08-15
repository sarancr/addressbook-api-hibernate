package com.adb.dao;

public class DAOFactory {

	public static ContactDAO createContactDAO(){
		//	return new ContactDAODBImpl();
		return new ContactDAOPersistenceImpl();
	}
}
