package com.xd.controller;

import com.xd.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    private static List<Student> myList = new ArrayList<Student>(0);
    private static int idIndex;

    static {
        Student stu1 = new Student(1, "张三", new Date(), java.sql.Date.valueOf("2000-03-02"), "男", new String[]{"足球", "篮球"});
        Student stu2 = new Student(2, "李四", new Date(), java.sql.Date.valueOf("2001-03-02"), "女", new String[]{"足球", "乒乓球"});
        Student stu3 = new Student(3, "王五", new Date(), java.sql.Date.valueOf("2002-03-02"), "女", new String[]{"篮球", "乒乓球"});
        Student stu4 = new Student(4, "钱六", new Date(), java.sql.Date.valueOf("2003-03-02"), "男", new String[]{});
        myList.add(stu1);
        myList.add(stu2);
        myList.add(stu3);
        myList.add(stu4);
        idIndex = 5;
    }
    /**
     * 添加
     * @param stu
     * @return
     */
    @RequestMapping("/add")
    public String add(Student stu, HttpServletRequest request){
        System.out.println("正在添加学生");
        String text = "添加失败！";
        try {
            stu.setId(idIndex++);
            myList.add(stu);
            text = "添加成功！";
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("text",text);
        request.setAttribute("location","selectAll");
        return "/tz.html";
    }
    /**
     * 查询全部
     *
     * @param map
     * @return
     */
    @RequestMapping("/selectAll")
    public String selectAll(Map<String, Object> map) {
        System.out.println("正在查询全部");
        map.put("list", myList);
        return "/list.html";
    }

    /**
     * 根据Id查询
     *
     * @param map
     * @param id
     * @return
     */
    @RequestMapping("selectById")
    public String selectById(Map<String, Object> map, Integer id) {
        for (Student stu : myList) {
            if(stu.getId()==id){
                map.put("stu",stu);
                break;
            }
        }
        return "/update";
    }

    /**
     * 修改
     * @param stu
     * @return
     */
    @RequestMapping("/update")
    public String update(Student stu ,Map<String,Object> map){
        String text = "修改失败！";
        try {
            for (Student student
                    : myList) {
                if(stu.getId()==student.getId()){
                    text = "修改成功！";
                    student.setName(stu.getName());
                    student.setSex(stu.getSex());
                    student.setBirth(stu.getBirth());
                    student.setHobby(stu.getHobby());
                    student.setJoin(stu.getJoin());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("text",text);
        map.put("location","selectAll");
        return "/tz";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public ModelAndView delete(Integer id){
        for (Student student
                : myList) {
            if(id==student.getId()){
                myList.remove(student);
                break;
            }
        }
        return new ModelAndView("redirect:selectAll");//重定向
    }

}
