package dao;

import modelo.Historial;
import modelo.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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
        Historial historial = (Historial) session.createQuery("FROM Historial WHERE cita.id = :citaId")
                .setParameter("citaId", citaId).uniqueResult();
        session.close();
        return historial;
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
        Transaction tx = session.beginTransaction();
        Historial historial = (Historial) session.get(Historial.class, id);
        if (historial != null) {
            session.delete(historial);
        }
        tx.commit();
        session.close();
    }

}
