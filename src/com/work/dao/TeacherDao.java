package com.work.dao;

import java.util.List;
import com.work.entity.Teacher;
/**
 * Created by IntelliJ IDEA.
 *
 * @author : 徐大伟
 * User: ${和敬清寂}
 * Date: 2019/4/15 0015
 * Time: 22:06
 */
public interface TeacherDao {

    public int add(Teacher teacher);

    public int update(Teacher teacher);

    public int delete(Teacher teacher);

    public Teacher queryOne(Integer id);

    public List<Teacher> queryPage(int pageIndex,int pageCount);

    public int pages(int pageCount); // 总页数
}
