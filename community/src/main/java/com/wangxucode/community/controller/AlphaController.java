package com.wangxucode.community.controller;

import com.wangxucode.community.dao.AlphaDao;
import com.wangxucode.community.service.AlphaService;
import com.wangxucode.community.util.CommunityConstant;
import com.wangxucode.community.util.CommunityUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.coyote.OutputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

//@Controller
//@RequestMapping("/alpha")
//public class AlphaController {
//
//    @Autowired
//    private AlphaService alphaService;
//
//    @RequestMapping("/hello")
//    @ResponseBody
//    public String sayHello() {
//        return "Hello HansSama";
//    }
//
//    @RequestMapping("/data")
//    @ResponseBody
//    public String getData() {
//        return alphaService.find();
//    }
//
//    @RequestMapping("/http")
//    public void http(HttpServletRequest request, HttpServletResponse response) {
//
//        //获取请求数据
//        System.out.println(request.getMethod());
//        System.out.println(request.getServletPath());
//        Enumeration<String> enumeration = request.getHeaderNames();
//        while (enumeration.hasMoreElements()) {
//            String name = enumeration.nextElement();
//            String value = request.getHeader(name);
//            System.out.println(name + ": " + value);
//        }
//        System.out.println(request.getParameter("code"));
//
//        //返回相应数据
//        response.setContentType("text/html;charset=utf-8");
//        try (
//                PrintWriter writer = response.getWriter();
//        ) {
//            writer.write("<h1>王旭code</h1>");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    //GRT请求
//
//    // /students?current=1&limit=20
//    @RequestMapping(path = "/students", method = RequestMethod.GET)
//    @ResponseBody
//    public String getStudents(
//            @RequestParam(name = "current", required = false, defaultValue = "1") int current,
//            @RequestParam(name = "limit", required = false, defaultValue = "10") int limit) {
//        System.out.println(current);
//        System.out.println(limit);
//        return "some students";
//    }
//
//    // /student/123
//    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public String getStudent(@PathVariable("id") int id) {
//        System.out.println(id);
//        return "a student";
//    }
//
//    // POST请求
//    @RequestMapping(path = "/student", method = RequestMethod.POST)
//    @ResponseBody
//    public String saveStudent(String name, int age) {
//        System.out.println(name);
//        System.out.println(age);
//        return "success";
//    }
//
//    //相应HTML数据
//    @RequestMapping(path = "teacher", method = RequestMethod.GET)
//    public ModelAndView getTeacher() {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("name", "王旭");
//        mav.addObject("age", "16");
//        mav.setViewName("/demo/view");
//        return mav;
//    }
//
//    @RequestMapping(path = "/school", method = RequestMethod.GET)
//    public String getSchool(Model model) {
//        model.addAttribute("name", "beijingdaxue");
//        model.addAttribute("age", 18);
//        return "/demo/view";
//    }
//
//    //相应JSON数据（异步请求）
//    //Java对象  ——>  JSON字符串 ——>  JS对象
//    @RequestMapping(path = "/emp", method = RequestMethod.GET)
//    @ResponseBody
//    public Map<String, Object> getEmp() {
//        Map<String, Object> emp = new HashMap<>();
//        emp.put("name", "王旭");
//        emp.put("age", 6);
//        emp.put("salary", 9000.00);
//        return emp;
//    }
//
//    @RequestMapping(path = "/emps", method = RequestMethod.GET)
//    @ResponseBody
//    public List<Map<String, Object>> getEmps() {
//        List<Map<String, Object>> list = new ArrayList<>();
//
//        Map<String, Object> emp = new HashMap<>();
//        emp.put("name", "王旭1");
//        emp.put("age", 1);
//        emp.put("salary", 111.111);
//        list.add(emp);
//
//        emp = new HashMap<>();
//        emp.put("name", "王旭2");
//        emp.put("age", 2);
//        emp.put("salary", 222.222);
//        list.add(emp);
//
//        emp = new HashMap<>();
//        emp.put("name", "王旭3");
//        emp.put("age", 3);
//        emp.put("salary", 333.333);
//        list.add(emp);
//
//        emp = new HashMap<>();
//        emp.put("name", "王旭4");
//        emp.put("age", 4);
//        emp.put("salary", 444.444);
//        list.add(emp);
//
//        emp = new HashMap<>();
//        emp.put("name", "王旭5");
//        emp.put("age", 5);
//        emp.put("salary", 555.555);
//        list.add(emp);
//
//        return list;
//    }
@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello Spring Boot.";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getData() {
        return alphaService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
        // 获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + ": " + value);
        }
        System.out.println(request.getParameter("code"));

        // 返回响应数据
        response.setContentType("text/html;charset=utf-8");
        try (
                PrintWriter writer = response.getWriter();
        ) {
            writer.write("<h1>牛客网</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // GET请求

    // /students?current=1&limit=20
    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name = "current", required = false, defaultValue = "1") int current,
            @RequestParam(name = "limit", required = false, defaultValue = "10") int limit) {
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    // /student/123
    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id) {
        System.out.println(id);
        return "a student";
    }

    // POST请求
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, int age) {
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    // 响应HTML数据

    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "张三");
        mav.addObject("age", 30);
        mav.setViewName("/demo/view");
        return mav;
    }

    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model) {
        model.addAttribute("name", "北京大学");
        model.addAttribute("age", 80);
        return "/demo/view";
    }

    // 响应JSON数据(异步请求)
    // Java对象 -> JSON字符串 -> JS对象

    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getEmp() {
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "张三");
        emp.put("age", 23);
        emp.put("salary", 8000.00);
        return emp;
    }

    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getEmps() {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "张三");
        emp.put("age", 23);
        emp.put("salary", 8000.00);
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name", "李四");
        emp.put("age", 24);
        emp.put("salary", 9000.00);
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name", "王五");
        emp.put("age", 25);
        emp.put("salary", 10000.00);
        list.add(emp);

        return list;
    }
    //cookie实例
    @RequestMapping(path = "/cookie/set", method = RequestMethod.GET)
    @ResponseBody
    public String setCookie(HttpServletResponse response) {
        // 创建cookie
        Cookie cookie = new Cookie("code", CommunityUtil.generateUUID());
        // 设置cookie生效的范围
        cookie.setPath("/community/alpha");
        // 设置cookie的生存时间
        cookie.setMaxAge(60 * 10);
        // 发送cookie
        response.addCookie(cookie);

        return "set cookie";
    }

    @RequestMapping(path = "/cookie/get", method = RequestMethod.GET)
    @ResponseBody
    public String getCookie(@CookieValue("code") String code) {
        System.out.println(code);
        return "get cookie";
    }

    //session示例
    @RequestMapping(path = "/session/set", method = RequestMethod.GET)
    @ResponseBody
    public String setSession(HttpSession session) {
        session.setAttribute("id", 1);
        session.setAttribute("name", "Test");
        return "set session";
    }

    @RequestMapping(path = "/session/get", method = RequestMethod.GET)
    @ResponseBody
    public String getSession(HttpSession session) {
        System.out.println(session.getAttribute("id"));
        System.out.println(session.getAttribute("name"));
        return "get session";
    }

}
