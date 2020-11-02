package com.snail.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.snail.mapper.BlogsMapper;
import com.snail.entity.Blogs;
import com.snail.service.IBlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yanghaisong
 * @since 2020-05-31
 */
@RestController
@RequestMapping("/blogs")
public class BlogsController extends BaseController {

    @Autowired
    private IBlogsService blogsService;

    @Autowired
    private BlogsMapper blogsMapper;

    @GetMapping("/_all")
    public ResponseEntity findAll() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        QueryWrapper<Blogs> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", authentication.getName());
        return new ResponseEntity(blogsMapper.selectList(queryWrapper), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity add(@RequestBody @Validated Blogs m, BindingResult result, Authentication authentication) {
        m.setUserId(authentication.getName());
        return new ResponseEntity(blogsMapper.insert(m), HttpStatus.OK);
    }

    @PostMapping("/uploadFile")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) { //若文件选择为空,就上传失败
            System.out.println("上传失败,请选择文件!");
        }
        String fileName = UUID.randomUUID().toString() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));//获取文件上传的文件名
        String filePath = "/Users/snail/images"; //指定到上传的文件路径

        File dir = new File(filePath);
        if (!dir.exists()) {  //若路径不存在,则创建一个这样的文件夹
            dir.mkdir();
        }
        try {
            File file1 = new File(filePath, fileName); //创建了一个File对象，名字是file1 ，路径是filePath，名字是fileName。
            //然后就可以调用这个对象的相关方法完成文件创建，删除，读取，写入等操作
            file.transferTo(file1);    //将上传的文件写入创建好的文件中
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(fileName, HttpStatus.OK);
    }
}
