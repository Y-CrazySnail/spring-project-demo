package com.snail.service.impl;

import com.snail.mapper.UserMapper;
import com.snail.service.IUserService;
import com.snail.entity.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
