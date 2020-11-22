package com.myerlang.erlapi.controller;

import com.myerlang.erlapi.logic.Analysis;
import org.springframework.web.bind.annotation.*;
// mark this class as a controller to handle /demo requests
// Following Medium guide : https://medium.com/swlh/build-deploy-a-rest-api-from-scratch-using-spring-boot-and-aws-ecs-eb369137a020

@RestController
@RequestMapping(value = "/demo")
public class Endpoint {
    // create GET endpoint to serve demo data at /demo/data
    @GetMapping(value = "/data")
    public String getDemoData() {
        return "Demo Data";
    }

    @PostMapping("/code-analysis")
    public String postBody(@RequestBody String code) {
        return Analysis.analyse(code);
    }
}
