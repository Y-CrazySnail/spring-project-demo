package com.snail.service.impl;

import com.snail.mapper.RoleMapper;
import com.snail.entity.Role;
import com.snail.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
