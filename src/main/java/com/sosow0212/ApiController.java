package com.sosow0212;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK) // 정상적으로 받으면 OK
    public String getApiTest() {

        return "{\"result\":\"ok\"}";
    }
    // http://localhost:8080/api/test


    @RequestMapping(value = "/api/test2", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK) // 정상적으로 받으면 OK
    public String getApiTest2() {

        return "{\"result\":\"ok2\"}";
    }
    // http://localhost:8080/api/test2
    //dd
}
