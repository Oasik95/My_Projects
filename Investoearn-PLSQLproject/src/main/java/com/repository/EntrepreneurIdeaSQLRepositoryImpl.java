package com.repository;

import com.domain.EntrepreneurIdea;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.OracleCallableStatement;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.hibernate.query.procedure.ProcedureParameter;
import org.hibernate.result.Output;
import org.hibernate.result.ResultSetOutput;
import org.hibernate.result.UpdateCountOutput;
import org.springframework.stereotype.Repository;

import javax.persistence.ParameterMode;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EntrepreneurIdeaSQLRepositoryImpl implements EntrepreneurIdeaRepository {

    private SessionFactory sessionFactory;

    public EntrepreneurIdeaSQLRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public EntrepreneurIdea create(EntrepreneurIdea entrepreneurIdea) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entrepreneurIdea);
        return entrepreneurIdea;

    }

    public void  createUsingProcedure(EntrepreneurIdea entrepreneurIdea) {
        Session session = sessionFactory.getCurrentSession();
        ProcedureCall call = session.createStoredProcedureCall("add_idea");


        ProcedureParameter<String> in_title_paramerter=call.registerParameter(1, String.class, ParameterMode.IN);
        call.setParameter(in_title_paramerter,entrepreneurIdea.getTitle());

        ProcedureParameter<BigDecimal> in_amount_paramerter=call.registerParameter(2, BigDecimal.class, ParameterMode.IN);
        call.setParameter(in_amount_paramerter,entrepreneurIdea.getAmount());

        ProcedureParameter<String> in_description_paramerter=call.registerParameter(3, String.class, ParameterMode.IN);
        call.setParameter(in_description_paramerter,entrepreneurIdea.getDescription());


        ProcedureParameter<Long> in_entrepreneur_id_paramerter=call.registerParameter(4, Long.class, ParameterMode.IN);
        call.setParameter(in_entrepreneur_id_paramerter,entrepreneurIdea.getEntrepreneur().getId());
        call.getOutputs();

    }



     /*public EntrepreneurIdea delete(EntrepreneurIdea entrepreneurIdea) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(entrepreneurIdea);
        return entrepreneurIdea;

    }*/

    public EntrepreneurIdea delete(EntrepreneurIdea entrepreneurIdea) {
        Session session = sessionFactory.getCurrentSession();
        session.doWork(connection -> {

            OracleCallableStatement call = (OracleCallableStatement)
                    connection.prepareCall("BEGIN :1 := DeleteIdea(:2); END;");
            call.registerOutParameter( 1, OracleTypes.VARCHAR );
            call.setLong(2,entrepreneurIdea.getId());

            System.out.println(call.execute());

            System.out.println(  call.getString(1));
        });


        return entrepreneurIdea;

    }
   /*
   Old
   public List<EntrepreneurIdea> getAll() {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery("SELECT * from idea");


        List<Object[]> rows = query.list();
        List<EntrepreneurIdea> datalist= new ArrayList<>();
        for(Object[] row : rows){
            EntrepreneurIdea idea = new EntrepreneurIdea();
            idea.setId(Long.parseLong(row[0].toString()));
            idea.setTitle(row[1].toString());
            idea.setAmount(new BigDecimal(row[2].toString()));
            idea.setDescription(row[3].toString());
            idea.setStutas(Optional.ofNullable(row[4]).map(Object::toString).orElse(""));
            datalist.add(idea);
            System.out.println(idea);
        }
        return datalist;
    }*/

    public List<EntrepreneurIdea> getAll() {
        Session session = sessionFactory.getCurrentSession();
        ProcedureCall call = session.createStoredProcedureCall( "GetAllIdeas");
        call.registerParameter(1, Class.class, ParameterMode.REF_CURSOR);

        Output output = call.getOutputs().getCurrent();
        List<Object[]> rows = ( (ResultSetOutput) output ).getResultList();

       // List<Object[]> rows = query.list();
        List<EntrepreneurIdea> datalist= new ArrayList<>();
        for(Object[] row : rows){
            EntrepreneurIdea idea = new EntrepreneurIdea();
            idea.setId(Long.parseLong(row[0].toString()));
            idea.setTitle(row[1].toString());
            idea.setAmount(new BigDecimal(row[2].toString()));
            idea.setDescription(row[3].toString());
            idea.setStutas(Optional.ofNullable(row[4]).map(Object::toString).orElse(""));
            datalist.add(idea);
            System.out.println(idea);
        }
        return datalist;
    }

    public void updateUsingProcedure(EntrepreneurIdea entrepreneurIdea){
        Session session=sessionFactory.getCurrentSession();
        ProcedureCall call = session.createStoredProcedureCall("update_idea_status");

        ProcedureParameter<Long> in_Id_paramerter=call.registerParameter(1, Long.class, ParameterMode.IN);
        call.setParameter(in_Id_paramerter,entrepreneurIdea.getId());

        ProcedureParameter<String> in_status_paramerter=call.registerParameter(2, String.class, ParameterMode.IN);
        call.setParameter(in_status_paramerter,entrepreneurIdea.getStutas());
        call.getOutputs();

    }

    @Override
    public List<EntrepreneurIdea> findAllByInvest(String stutas) {
        Session session = sessionFactory.getCurrentSession();
        List<EntrepreneurIdea> datalist= new ArrayList<>();
        session.doWork(connection -> {

            OracleCallableStatement call = (OracleCallableStatement) connection.prepareCall("BEGIN :1 := GetInvestedIdeas(); END;");
            call.registerOutParameter( 1, OracleTypes.CURSOR ); // or whatever it is

            System.out.println(call.execute());

            ResultSet rs = call.getCursor(1);
            while (rs.next()){
                EntrepreneurIdea idea = new EntrepreneurIdea();
                idea.setId(rs.getLong(1));
                idea.setTitle(rs.getString(2));
                idea.setAmount(rs.getBigDecimal(3));
                idea.setDescription(rs.getString(4));
                idea.setStutas(Optional.ofNullable(rs.getString(5)).orElse(""));
                datalist.add(idea);
            }
        });
        return datalist;
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


    /*@Override
    public List<EntrepreneurIdea> findAllByInvest(String stutas) {
        Session session = sessionFactory.getCurrentSession();
        Query<EntrepreneurIdea> entrepreneurIdeaQuery = session.createQuery("from EntrepreneurIdea i " +
                        " where i.stutas=:stutas",
                EntrepreneurIdea.class);
        entrepreneurIdeaQuery.setParameter("stutas", stutas);
        return entrepreneurIdeaQuery.getResultList();
    }*/
    @Override
    public List<EntrepreneurIdea> findAllByreject(String stutas) {
        Session session = sessionFactory.getCurrentSession();
        Query<EntrepreneurIdea> entrepreneurIdeaQuery = session.createQuery("from EntrepreneurIdea i " +
                        " where i.stutas=:stutas",
                EntrepreneurIdea.class);
        entrepreneurIdeaQuery.setParameter("stutas", stutas);
        return entrepreneurIdeaQuery.getResultList();
    }


}
