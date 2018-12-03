package com.msa.jbk.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.msa.jbk.dao.AccountDAO;
import com.msa.jbk.entity.Account;

//Transactional for hibernate
@Transactional
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Account findAccount(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Account.class);
		criteria.add(Restrictions.eq("userName", userName));
		return (Account) criteria.uniqueResult();
	}

}
