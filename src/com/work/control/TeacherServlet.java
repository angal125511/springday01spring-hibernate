package com.work.control;

import com.work.entity.Teacher;
import com.work.service.TeacherService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : 徐大伟
 * User: ${和敬清寂}
 * Date: 2019/4/15 0015
 * Time: 23:01
 */
@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String action = request.getParameter("action");
        System.out.println(action);
        if("queryPage".equals(action)){
            queryPage(request,response);
        }else if("add".equals(action)){
            add(request, response);
        }else if("update".equals(action)){
            update(request, response);
        }else if("delete".equals(action)){
            delete(request, response);
        }else if("queryOne".equals(action)){
            queryOne(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring.xml");
        TeacherService service = applicationContext.getBean("teacherService", TeacherService.class);

        int pageIndex=1; // 初始化页码
        String index = request.getParameter("pageIndex"); // 获取参数
        if(index !=null){
            pageIndex=Integer.parseInt(index);
        }

        int pageCount=5; // 每页条数
        int pages = service.pages(pageCount);
        List<Teacher> teacherList = service.queryPage(pageIndex,pageCount);
        request.setAttribute("pages",pages);
        request.setAttribute("teacherList",teacherList);

        request.getRequestDispatcher("/query.jsp").forward(request,response);

    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
        TeacherService service = ac.getBean("teacherService", TeacherService.class);
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        int num = service.add(new Teacher(name, Integer.parseInt(age),sex));
        if(num>0){
            System.out.println("添加成功");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }else{
            System.out.println("添加失败");
        }
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
        TeacherService service = ac.getBean("teacherService", TeacherService.class);
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        int num = service.update(new Teacher(Integer.parseInt(id), name,Integer.parseInt(age), sex));
        if(num>0){
            System.out.println("update success!");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }else{
            System.out.println("update fail!");
        }
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
        TeacherService service = ac.getBean("teacherService", TeacherService.class);
        String id = request.getParameter("id");
        Teacher s = service.queryOne(Integer.parseInt(id));
        if (s != null) {
            System.out.println("根据id查询成功");
            int num=service.delete(s);
            if(num>0){
                System.out.println("delete success!!");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }else{
                System.out.println("delete success!!");

            }
        } else {
            System.out.println("根据id查询失败!");
        }
    }
    protected void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
        TeacherService service = ac.getBean("teacherService", TeacherService.class);
        String id = request.getParameter("id");
        Teacher studentById = service.queryOne(Integer.parseInt(id));
        if(studentById!=null){
            System.out.println("根据id查询到对象");
            request.setAttribute("studentById", studentById);
            request.getRequestDispatcher("/update.jsp").forward(request, response);
        }else{
            System.out.println("没有根据id查询到对象");
        }
    }

}
