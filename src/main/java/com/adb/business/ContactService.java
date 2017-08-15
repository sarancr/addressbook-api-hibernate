package com.adb.business;

import java.util.List;

import com.adb.dao.ContactDAO;
import com.adb.dao.DAOFactory;
import com.adb.model.Contact;

public class ContactService {
	
	private ContactDAO dao;
	
	public ContactService(){
		this.dao =  DAOFactory.createContactDAO();
	}
	
	public List<Contact> getAllContacts(int userId){
		return dao.getAllContacts(userId);
	}
	
	public Contact getContact(int contactId){
		return dao.getContact(contactId);
	}
	
	/*
	 * updating a existing contact
	 */
	public int update(Contact contact){
		return dao.update(contact);
	}
	
	/*
	 * Adding a new contact
	 */
	public Contact insert(Contact contact){
		return dao.insert(contact);
	}
	
	public void deleteContact(int contactId){
		dao.deleteContact(contactId);
	}
}
