package dao;

import modelo.Cita;
import modelo.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class CitaDao {

    public List<Cita> listarCitas() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Cita> lista = session.createQuery("FROM Cita").list();
        session.close();
        return lista;
    }

    public void guardarCita(Cita cita) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(cita);
        tx.commit();
        session.close();
    }

    public void actualizarCita(Cita cita) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(cita);
        tx.commit();
        session.close();
    }

    public void eliminarCita(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Cita cita = (Cita) session.get(Cita.class, id);
        if (cita != null) session.delete(cita);
        tx.commit();
        session.close();
    }

    public Cita obtenerCitaPorId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Cita cita = (Cita) session.get(Cita.class, id);
        session.close();
        return cita;
    }
}
