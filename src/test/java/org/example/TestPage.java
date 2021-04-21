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


    public void testAllDelete(){
        Integer delete = employeeMapper.delete(null);
        System.out.println(delete);
    }


    public void testPerformance(){
        Employee employee=new Employee();
        employee.setLastName("阿萨谢尔老师");
        employee.setGender("1");
        employee.setEmail("asxr@sina.com");
        employee.setAge(23);
        employeeMapper.insert(employee);
    }

    @Test
    public void testOptimisticLocker(){
        //更新操作
        Employee employee=new Employee();
        employee.setId(9);
        employee.setLastName("Tom");
        employee.setEmail("tom@sina.com");
        employee.setGender("1");
        employee.setAge(22);
        employee.setVersion(2);
        employeeMapper.updateById(employee);

    }
}
