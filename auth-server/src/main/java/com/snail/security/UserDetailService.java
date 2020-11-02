package com.snail.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.snail.mapper.UserMapper;
import com.snail.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 用户信息服务
 * 用于登录验证
 */
@Configuration
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        // 设置用户权限
        user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList("user:add"));
        return user;
    }
}
