package com.repository;

import com.domain.Investor;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvestorSQLRepositoryImpl implements InvestorRepository {

    private SessionFactory sessionFactory;

    public InvestorSQLRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Investor create(Investor investor) {
        Session session = sessionFactory.getCurrentSession();

        String sql = "INSERT INTO investor (ID, DOB,EMAIL,FIRST_NAME,GENDER,LAST_NAME,NID,PHONE_NUMBER,USER_NAME) VALUES (INVESTOR_SEQ.NEXTVAL, :value2,:value3,:value4,:value5,:value6,:value7,:value8,:value9)";

        SQLQuery query = session.createSQLQuery(sql);

        query.setParameter("value2", investor.getDob());
        query.setParameter("value3", investor.getEmail());
        query.setParameter("value4",investor.getFirstname());
        query.setParameter("value5", investor.getGender());
        query.setParameter("value6", investor.getLastname());
        query.setParameter("value7", investor.getNid());
        query.setParameter("value8", investor.getPhonenumber());
        query.setParameter("value9", investor.getUsername());


        int result = query.executeUpdate();

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

    public List<Investor> getAllinvestor() {
        Session session = sessionFactory.getCurrentSession();
        Query<Investor> investorQuery = session.createQuery("from Investor", Investor.class);
        return investorQuery.getResultList();
    }

}
