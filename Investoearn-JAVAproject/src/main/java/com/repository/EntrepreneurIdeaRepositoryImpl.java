package com.repository;

import com.domain.Entrepreneur;
import com.domain.EntrepreneurIdea;
import com.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EntrepreneurIdeaRepositoryImpl implements EntrepreneurIdeaRepository {

    private SessionFactory sessionFactory;

    public EntrepreneurIdeaRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public EntrepreneurIdea create(EntrepreneurIdea entrepreneurIdea) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entrepreneurIdea);
        return entrepreneurIdea;

    }

    public List<EntrepreneurIdea> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<EntrepreneurIdea> entrepreneurIdeaQuery = session.createQuery("from EntrepreneurIdea", EntrepreneurIdea.class);
        return entrepreneurIdeaQuery.getResultList();
    }
    public EntrepreneurIdea get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(EntrepreneurIdea.class, id);
    }
    public void update(EntrepreneurIdea entrepreneurIdea){
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(entrepreneurIdea);
    }

    @Override
    public List<EntrepreneurIdea> findAllByUserName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<EntrepreneurIdea> entrepreneurIdeaQuery = session.createQuery("from EntrepreneurIdea i " +
                        " where i.entrepreneur.username=:username",
                EntrepreneurIdea.class);
        entrepreneurIdeaQuery.setParameter("username", name);
        return entrepreneurIdeaQuery.getResultList();
    }
    @Override
    public List<EntrepreneurIdea> findAllByInvestorName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<EntrepreneurIdea> entrepreneurIdeaQuery = session.createQuery("from EntrepreneurIdea i " +
                        " where i.investor.username=:username",
                EntrepreneurIdea.class);
        entrepreneurIdeaQuery.setParameter("username", name);
        return entrepreneurIdeaQuery.getResultList();
    }

    @Override
    public List<EntrepreneurIdea> findAllByStutas(String stutas) {
        Session session = sessionFactory.getCurrentSession();
        Query<EntrepreneurIdea> entrepreneurIdeaQuery = session.createQuery("from EntrepreneurIdea i " +
                        " where i.stutas=:stutas",
                EntrepreneurIdea.class);
        entrepreneurIdeaQuery.setParameter("stutas", stutas);
        return entrepreneurIdeaQuery.getResultList();
    }

    @Override
    public List<EntrepreneurIdea> findAllByInvest(String stutas) {
        Session session = sessionFactory.getCurrentSession();
        Query<EntrepreneurIdea> entrepreneurIdeaQuery = session.createQuery("from EntrepreneurIdea i " +
                        " where i.stutas=:stutas",
                EntrepreneurIdea.class);
        entrepreneurIdeaQuery.setParameter("stutas", stutas);
        return entrepreneurIdeaQuery.getResultList();
    }


}
