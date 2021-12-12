package com.greatlearning.CRM.Services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.CRM.Entities.Customers;

@Service
public class CRM_ServicesImpl implements CRM_Services {

	private SessionFactory sessionFactory;

	private Session session;

	@Autowired
	public CRM_ServicesImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException ex) {
			session = sessionFactory.openSession();
		}
	}

	@Override
	public List<Customers> findAll() {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		List<Customers> customers = session.createQuery("from Customers").list();

		tx.commit();
		return customers;
	}

	@Override
	@Transactional
	public Customers findById(int id) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		Customers customers = session.get(Customers.class,id);

		tx.commit();
		return customers;
	}

	@Override
	public void save(Customers customer) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		session.save(customer);

		tx.commit();

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		Customers customer = session.get(Customers.class, id);

		tx.commit();

	}

}
