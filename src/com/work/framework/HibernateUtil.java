package com.work.framework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : 徐大伟
 * User: ${和敬清寂}
 * Date: 2019/4/15 0015
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory=null;
    private static Session session=null;

    static {

        // 注册服务
        Configuration configuration = new Configuration().configure();

        // sessionFactory
        sessionFactory=configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){ // 获取sessionFactory工厂
        return sessionFactory;
    }

    public static Session getSession(){ // 获取session
        session=getSessionFactory().openSession();
        return session;
    }
}
