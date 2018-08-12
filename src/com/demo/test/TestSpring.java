package com.demo.test;

import java.util.List;

import com.demo.pojo.Category;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.dao.CategoryDAO;


public class TestSpring {

    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                new String[] { "applicationContext.xml" });
//        CategoryDAO dao = (CategoryDAO) context.getBean("dao");
//        Category c = new Category();
//        c.setName("category yyy");
//
//        //增加
//        dao.save(c);
//
//        //获取
//        Category c2 = dao.get(Category.class, 1);
//
//        //修改
//        c2.setName("category zzz");
//        dao.update(c2);
//
//        //删除
//        dao.delete(c2);

//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                new String[] { "applicationContext.xml" });
//        CategoryDAO dao = (CategoryDAO) context.getBean("dao");
//
//        DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
//        int start =5;//从多少开始查询
//        int count =10;//每页显示数量
//        List<Category> cs= (List<Category>) dao.findByCriteria(dc,start,count);
//        System.out.println(cs);

//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                new String[] { "applicationContext.xml" });
//        CategoryDAO dao = (CategoryDAO) context.getBean("dao");
//
//        List<Long> l = (List<Long>) dao.find("select count(*) from Category c");
//        long total = l.get(0);
//        System.out.println(total);

        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" });
        CategoryDAO dao = (CategoryDAO) context.getBean("dao");

        List<Category> cs = (List<Category>) dao.find("from Category c where c.name like ?", "%c%");

        for (Category c : cs) {
            System.out.println(c.getName());
        }

        DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
        dc.add(Restrictions.like("name", "%c%"));
        cs = (List<Category>) dao.findByCriteria(dc);

        for (Category c : cs) {
            System.out.println(c.getName());
        }

    }

}
