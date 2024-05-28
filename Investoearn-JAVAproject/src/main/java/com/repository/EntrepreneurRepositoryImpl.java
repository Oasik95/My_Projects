package com.repository;

import com.domain.Authority;
import com.domain.Entrepreneur;

import com.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EntrepreneurRepositoryImpl implements EntrepreneurRepository {

    private SessionFactory sessionFactory;

    public EntrepreneurRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Entrepreneur create(Entrepreneur entrepreneur) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entrepreneur);
        return entrepreneur;
    }

    public Entrepreneur get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Entrepreneur.class, id);
    }

    @Override
    public Entrepreneur findByUserName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Entrepreneur> userQuery = session.createQuery("from Entrepreneur where username = :username", Entrepreneur.class);
        userQuery.setParameter("username", name);
        return userQuery.getSingleResult();
    }

    @Override
    public void update(Entrepreneur entrepreneur) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entrepreneur);

    }
}
