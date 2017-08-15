package com.adb.dao;

import java.util.List;

import com.adb.model.Contact;

public interface ContactDAO {
	public  List<Contact> getAllContacts(int userId);
	public Contact getContact(int contactId);
	public int update(Contact contact);
	public Contact insert(Contact contact);
	public void deleteContact(int contactId);
}
