import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;


public class Main {
    private static SessionFactory factory;

    public static void main(String[] args) {
        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        System.out.println("connected");
        Session session = factory.openSession();
        Pais mexico = new Pais(1, "MEXICO");
        Transaction tx = session.beginTransaction();
        //session.save(mexico);
        tx.commit();

/*
        Main m = new Main();

        String[] values = { "hoalksdhfj", "aksdhfa", "alskdhjfalksjdf", "askjdhf", "afsdioruawe", "aksdfhas", "asiodferewar", "aowsieurawe" };
        for (int i = 0; i < values.length; i++) {
            double pais = 1;
            double estado = (double) i + 1;
            String nombre = values[i];
            m.addEstado(pais, estado, nombre);
        }
*/

        String sql = "\n" +
                "select p.nombre, e.nombre,  ci.nombre, co.nombre from Pais p, Estado e, Ciudad ci, Colonia co\n" +
                "where p.id_pais = e.id_pais and\n" +
                "\t\t\te.id_pais = ci.id_pais and\n" +
                "\t\t\te.id_estado = ci.id_estado and\n" +
                "            ci.id_pais = co.id_pais and\n" +
                "            ci.id_estado = co.id_estado and\n" +
                "            ci.id_ciudad = co.id_ciudad\n";

        Query query = session.createQuery(sql);
        List<Object[]> results = query.getResultList();
        int counter = 0;
        for (Object[] p : results) {
            System.out.println(Arrays.toString(p));
            counter++;
        }
        System.out.println(counter + " results");
        System.exit(0);
    }

    public void addEstado(double id_pais, double id_estado, String nombre) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Estado estado = new Estado(id_pais, id_estado, nombre);
            System.out.println(estado);
            session.save(estado);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
