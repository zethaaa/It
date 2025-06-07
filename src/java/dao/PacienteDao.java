package dao;

import modelo.Pacientes;
import modelo.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PacienteDao {

    public List<Pacientes> consultaPacientes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Pacientes> lista = session.createQuery("FROM Pacientes").list();
        session.close();
        return lista;
    }

    public void guardarPaciente(Pacientes paciente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(paciente);
        tx.commit();
        session.close();
    }

    // CAMBIO: de int a Long
    public Pacientes obtenerPacientePorId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Pacientes paciente = (Pacientes) session.get(Pacientes.class, id);
        session.close();
        return paciente;
    }

    public void actualizarPaciente(Pacientes paciente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(paciente);
        tx.commit();
        session.close();
    }

    // CAMBIO: de int a Long
    public void eliminarPaciente(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Pacientes paciente = (Pacientes) session.get(Pacientes.class, id);
        if (paciente != null) {
            session.delete(paciente);
        }
        tx.commit();
        session.close();
    }
}
