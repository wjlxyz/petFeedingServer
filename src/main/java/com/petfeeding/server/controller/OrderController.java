package com.petfeeding.server.controller;


import com.petfeeding.server.aspect.log.LogAop;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jinlong
 */
@RestController
@RequestMapping(value = "/server/api/v1/order", produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@LogAop(description = "order controller log aspect")
public class OrderController {


}
