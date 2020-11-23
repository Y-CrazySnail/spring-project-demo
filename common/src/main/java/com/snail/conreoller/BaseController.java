package com.snail.conreoller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.snail.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class BaseController<T extends BaseEntity> {

    @Autowired
    private IService<T> service;

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

    @PutMapping("/baseUpdate")
    public ResponseEntity<Object> update(@RequestBody T entity) {
        service.save(entity);
        return ResponseEntity.ok("更新成功");
    }

    @DeleteMapping("/baseUpdate")
    public ResponseEntity<Object> delete(@RequestBody T entity) {
        service.save(entity);
        return ResponseEntity.ok("删除成功");
    }
}
