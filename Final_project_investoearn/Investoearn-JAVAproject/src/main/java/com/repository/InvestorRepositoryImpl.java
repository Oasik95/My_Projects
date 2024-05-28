package com.repository;

import com.domain.Entrepreneur;
import com.domain.Investor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class InvestorRepositoryImpl implements InvestorRepository {

    private SessionFactory sessionFactory;

    public InvestorRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Investor create(Investor investor) {
        Session session = sessionFactory.getCurrentSession();
        session.save(investor);
        return investor;
    }

    @Override
    public Investor findByUserName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Investor> userQuery = session.createQuery("from Investor where username = :username", Investor.class);
        userQuery.setParameter("username", name);
        return userQuery.getSingleResult();
    }

    public Investor get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Investor.class, id);
    }

}
