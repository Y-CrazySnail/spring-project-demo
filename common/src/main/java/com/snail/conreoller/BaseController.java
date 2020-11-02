package com.snail.conreoller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.snail.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BaseController<T extends BaseEntity> {

    private final IService<T> service;

    @Autowired
    public BaseController(IService<T> service) {
        this.service = service;
    }

    @GetMapping("getById")
    public ResponseEntity<Object> getById(Long id) {
        T entity = service.getById(id);
        return ResponseEntity.ok(entity);
    }

    @PostMapping("/baseSave")
    public ResponseEntity<Object> save(@RequestBody T entity) {
        service.save(entity);
        return ResponseEntity.ok("保存成功");
    }
}
