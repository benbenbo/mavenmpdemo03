package org.example.service.impl;

import org.example.beans.Employee;
import org.example.mapper.EmployeeMapper;
import org.example.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhengbingyuan
 * @since 2021-04-17
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
