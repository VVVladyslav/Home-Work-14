package com.example.demo.Hibernate;
import com.example.demo.Entity.Note;
import lombok.Getter;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateConfig {
    private static final HibernateConfig INSTANCE;

    @Getter
    private SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateConfig();
    }

    private HibernateConfig() {
        try {
            sessionFactory = new Configuration()
                    .addAnnotatedClass(Note.class)
                    .buildSessionFactory();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public static HibernateConfig getInstance() {
        return INSTANCE;
    }

}

