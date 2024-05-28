package com.repository;

import com.domain.Users;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersRepositoryImpl implements UsersRepository {

    private SessionFactory sessionFactory;

    public UsersRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Users> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Users> userQuery = session.createQuery("froms Users", Users.class);
        return userQuery.getResultList();
    }

    public Users create(Users users) {
        Session session = sessionFactory.getCurrentSession();
        session.save(users);
        return users;
    }

    public Users get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Users.class, id);
    }

   /* public Users update(Users users) {
        Session session = sessionFactory.getCurrentSession();
        session.update(users);
        return users;
    }*/
   public Users update(Users users) {
       Session session = sessionFactory.getCurrentSession();
       session.doWork(connection -> {

           OracleCallableStatement call = (OracleCallableStatement) connection.prepareCall("BEGIN :1 := ResetPassword(:2,:3); END;");
           call.registerOutParameter( 1, OracleTypes.VARCHAR );
           call.setString(2,users.getUsername());
           call.setString(3,users.getPassword());

           System.out.println(call.execute());

           System.out.println(  call.getString(1));
       });

       return users;
   }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Users users = get(id);
        if (users != null) {
            session.delete(users);
        }
    }

    @Override
    public Users getByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query<Users> userQuery = session.createQuery("from Users where username = :username", Users.class);
        userQuery.setParameter("username", username);
        return userQuery.getSingleResult();
    }
}
