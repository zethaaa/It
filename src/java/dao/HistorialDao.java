package dao;

import modelo.Historial;
import modelo.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import org.hibernate.Query;

public class HistorialDao {

    public void guardarHistorial(Historial historial) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(historial);
        tx.commit();
        session.close();
    }

    public void actualizarHistorial(Historial historial) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(historial);
        tx.commit();
        session.close();
    }

    public Historial obtenerPorCitaId(Long citaId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("FROM modelo.Historial WHERE idCita = :citaId");
            query.setParameter("citaId", citaId);
            return (Historial) query.uniqueResult();
        } finally {
            session.close();
        }
    }

    public List<Historial> obtenerPorPacienteId(Long pacienteId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Historial> lista = session.createQuery(
                "FROM Historial WHERE cita.idPaciente = :pacienteId"
        ).setParameter("pacienteId", pacienteId).list();
        session.close();
        return lista;
    }

    public List<Historial> listarHistoriales() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Historial> lista = session.createQuery("FROM Historial").list();
        session.close();
        return lista;
    }

    public void eliminarHistorial(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Historial historial = (Historial) session.get(Historial.class, id);
            if (historial != null) {
                session.delete(historial);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public Historial obtenerPorId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (Historial) session.get(Historial.class, id); // Busca por id primario
        } finally {
            session.close();
        }
    }

}
