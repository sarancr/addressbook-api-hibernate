package com.adb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.adb.model.Contact;

public class ContactDAOPersistenceImpl implements ContactDAO {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("addrbookUnit");
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getAllContacts(int userId) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select c from Contact c where c.userId = " + userId);
		List<Contact> contacts = query.getResultList();
		return contacts;
	}

	@Override
	public Contact getContact(int contactId) {
		EntityManager em = emf.createEntityManager();
		//Query query = em.createQuery("select c from Contact c where c.id="+contactId);
		//Contact contact = (Contact) query.getSingleResult();
		Contact contact = em.find(Contact.class, contactId);
		return contact;
	}

	@Override
	public int update(Contact contact) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(contact);
		em.getTransaction().commit();
		return 1;
	}

	@Override
	public Contact insert(Contact contact) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(contact);
		em.getTransaction().commit();
		return contact;
	}

	@Override
	public void deleteContact(int contactId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Contact contact = em.find(Contact.class, contactId);
		em.remove(contact);
		em.getTransaction().commit();
	}

}
