package com.snail.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.snail.conreoller.BaseController;
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
@RequestMapping("/user")
public class UserController extends BaseController<User> {

    @Autowired
    private IUserService usersService;

    /**
     * @param user 用户
     * @return
     */
    @PostMapping("/signIn")
    public ResponseEntity<Object> signIn(@RequestBody @Validated User user) {
        user = usersService.getOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        if (!StringUtils.isEmpty(user)) {
            return new ResponseEntity<>("用户名重复", HttpStatus.EXPECTATION_FAILED);
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);
        usersService.save(user);
        return ResponseEntity.ok(user);
    }
}
