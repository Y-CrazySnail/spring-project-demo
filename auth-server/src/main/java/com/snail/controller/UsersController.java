package com.snail.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.snail.entity.User;
import com.snail.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private IUserService usersService;

    /**
     * 用户注册
     * @param m
     * @return
     */
    @PostMapping("/signin")
    public ResponseEntity getStudents(@RequestBody @Validated User m) {
        User user = usersService.getOne(new QueryWrapper<User>().eq("username", m.getUsername()));
        if (!StringUtils.isEmpty(user)) {
            return new ResponseEntity("用户名重复", HttpStatus.EXPECTATION_FAILED);
        }
        m.setPassword(new BCryptPasswordEncoder().encode(m.getPassword()));
        m.setAccountNonExpired(true);
        m.setAccountNonLocked(true);
        m.setEnabled(true);
        m.setCredentialsNonExpired(true);
        usersService.save(m);
        return new ResponseEntity(m, HttpStatus.OK);
    }
}
