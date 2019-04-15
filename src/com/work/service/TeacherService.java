package com.work.service;

import com.work.entity.Teacher;
import com.work.dao.TeacherDaoImp;
import org.apache.commons.fileupload.util.LimitedInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : 徐大伟
 * User: ${和敬清寂}
 * Date: 2019/4/15 0015
 * Time: 22:50
 */
@Service
public class TeacherService {

    @Autowired
    private TeacherDaoImp teacherDaoImp;

    public int add(Teacher teacher){
        return teacherDaoImp.add(teacher);
    }

    public int update(Teacher teacher){
        return teacherDaoImp.update(teacher);
    }

    public int delete(Teacher teacher){
        return teacherDaoImp.delete(teacher);
    }

    public Teacher queryOne(Integer id){
        return teacherDaoImp.queryOne(id);
    }

    public List<Teacher> queryPage(int pageIndex,int pageCount){
        return teacherDaoImp.queryPage(pageIndex,pageCount);
    }

    public int pages(int pageCount){

        return teacherDaoImp.pages(pageCount);
    }
}
