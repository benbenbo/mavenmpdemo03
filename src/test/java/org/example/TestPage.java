package org.example;

import com.baomidou.mybatisplus.plugins.Page;
import org.example.beans.Employee;
import org.example.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@RunWith(JUnit4.class)
public class TestPage {
    private ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeMapper employeeMapper=ctx.getBean("employeeMapper",EmployeeMapper.class);
    @Test
    public void testPage(){
        Page<Employee> employeePage = new Page<>(1, 1);
        List<Employee> employees = employeeMapper.selectPage(employeePage, null);
        System.out.println(employees);
        System.out.println("总条数："+employeePage.getTotal());
        System.out.println("总页数："+employeePage.getPages());
        System.out.println("页大小："+employeePage.getSize());
        System.out.println("当前页："+employeePage.getCurrent());
        System.out.println("前一页："+employeePage.hasPrevious());
        System.out.println("后一页："+employeePage.hasNext());

        employeePage.setRecords(employees);
    }
}
