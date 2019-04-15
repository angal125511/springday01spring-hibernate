package com.work.dao;

import com.work.framework.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import org.springframework.stereotype.Repository;
import com.work.entity.Teacher;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : 徐大伟
 * User: ${和敬清寂}
 * Date: 2019/4/15 0015
 * Time: 22:16
 */
@Repository
public class TeacherDaoImp implements TeacherDao{


    @Override
    public int add(Teacher teacher) {
        Session session = HibernateUtil.getSession(); // 获取session
        int num = 1;
        try {
            session.save(teacher);
            session.beginTransaction().commit(); // 事务提交
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public int update(Teacher teacher) {
        Session session = HibernateUtil.getSession();
        int num =1;
        try {
            session.update(teacher);
            session.beginTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return num;
    }

    @Override
    public int delete(Teacher teacher) {
        Session session =HibernateUtil.getSession();
        int num=1;
        try {
            session.delete(teacher);
            session.beginTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return num;
    }

    @Override
    public Teacher queryOne(Integer id) {

        Session session = HibernateUtil.getSession();
        Teacher teacher = session.get(Teacher.class, id);
        session.close();
        return teacher;
    }

    @Override
    public List<Teacher> queryPage(int pageIndex, int pageCount) {
        List<Teacher> list = null;
        Session session = null;
        try {
            list = new ArrayList<>();
            session = HibernateUtil.getSession();
            session.beginTransaction();

            Query query = session.createQuery("from Teacher");
            query.setFirstResult((pageIndex-1)*pageCount); // 索引
            query.setMaxResults(pageCount); // 每页条数
            list=query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return list;
    }

    @Override
    public int pages(int pageCount) {

        int pages=1;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Query query = session.createQuery("select count (*) from Teacher");

        Number number  = (Number) query.uniqueResult();
        pages = (number.intValue()+pageCount-1)/pageCount;
        session.getTransaction().commit();
        session.close();
        return pages;
    }
    @Test
    public void add() {
        Session session= HibernateUtil.getSession();
        session.beginTransaction();
        int num = 1;
        try {
            for (int i=0;i<20;i++){
                Teacher user = new Teacher();
                user.setName("admin"+i);
                user.setAge(i*5+1);
                user.setSex("女");
                session.save(user);
            }
        } catch (Exception e) {
            num = 0;
            e.printStackTrace();
        }
        session.close();
    }
}
