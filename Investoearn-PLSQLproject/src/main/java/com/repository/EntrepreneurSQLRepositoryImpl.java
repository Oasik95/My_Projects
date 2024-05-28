package com.repository;

import com.domain.Entrepreneur;
import com.domain.EntrepreneurIdea;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Repository
public class EntrepreneurSQLRepositoryImpl implements EntrepreneurRepository {

    private SessionFactory sessionFactory;

    public EntrepreneurSQLRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    public Entrepreneur create(Entrepreneur entrepreneur) {
        Session session = sessionFactory.getCurrentSession();

        String sql = "INSERT INTO en_entrepreneur (ID, DOB,EMAIL,FIRST_NAME,GENDER,LAST_NAME,NID,PHONE_NUMBER,USER_NAME) VALUES (EN_ENTREPRENEUR_SEQ.NEXTVAL, :value2,:value3,:value4,:value5,:value6,:value7,:value8,:value9)";

        SQLQuery query = session.createSQLQuery(sql);

        query.setParameter("value2", entrepreneur.getDob());
        query.setParameter("value3", entrepreneur.getEmail());
        query.setParameter("value4", entrepreneur.getFirstname());
        query.setParameter("value5", entrepreneur.getGender());
        query.setParameter("value6", entrepreneur.getLastname());
        query.setParameter("value7", entrepreneur.getNid());
        query.setParameter("value8", entrepreneur.getPhonenumber());
        query.setParameter("value9", entrepreneur.getUsername());


        int result = query.executeUpdate();

        return entrepreneur;
    }

    public Entrepreneur get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Entrepreneur.class, id);
    }
    public List<Entrepreneur> getAllEN() {
        Session session = sessionFactory.getCurrentSession();
        Query<Entrepreneur> entrepreneurQuery = session.createQuery("from Entrepreneur", Entrepreneur.class);
        return entrepreneurQuery.getResultList();
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
