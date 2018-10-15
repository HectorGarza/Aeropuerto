import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;


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
        String sql = "SELECT paises.nombre as PAIS, estados.NOMBRE as ESTADO FROM paises, estados where " +
                "paises.id_pais = estados.id_pais and estados.id_estado = 2 order by paises.id_pais";
        SQLQuery query = session.createSQLQuery(sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        Object[] results = query.list().toArray();

        for (Object p : results) {
            System.out.println(p);
        }
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
