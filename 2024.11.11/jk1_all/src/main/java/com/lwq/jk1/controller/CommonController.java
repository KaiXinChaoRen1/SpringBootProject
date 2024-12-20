package com.lwq.jk1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Api(tags = "@Api(tags=\"hello\")")
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

}
