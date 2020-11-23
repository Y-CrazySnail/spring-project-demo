package com.snail.controller;

import com.snail.conreoller.BaseController;
import com.snail.entity.Price;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price")
public class PriceController extends BaseController<Price> {

}
