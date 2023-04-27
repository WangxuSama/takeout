package com.wangxucode.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangxucode.order.entity.Employee;
import com.wangxucode.order.mapper.EmployeeMapper;
import com.wangxucode.order.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService{
}
