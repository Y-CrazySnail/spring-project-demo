package com.snail.service.impl;

import com.snail.entity.Blogs;
import com.snail.mapper.BlogsMapper;
import com.snail.service.IBlogsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yanghaisong
 * @since 2020-05-31
 */
@Service
public class BlogsServiceImpl extends ServiceImpl<BlogsMapper, Blogs> implements IBlogsService {

}
