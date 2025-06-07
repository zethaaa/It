package dao;

import modelo.Medico;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import modelo.HibernateUtil;

public class MedicoDao {

    public Medico findByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "FROM Medico WHERE email = :email";
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            return (Medico) query.uniqueResult();
        } finally {
            session.close();
        }
    }
}
