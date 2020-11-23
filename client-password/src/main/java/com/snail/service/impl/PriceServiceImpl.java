package com.snail.service.impl;

import com.snail.entity.Price;
import com.snail.mapper.PriceMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snail.service.IPriceService;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl extends ServiceImpl<PriceMapper, Price> implements IPriceService {

}
