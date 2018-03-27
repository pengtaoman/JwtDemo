package com.me.security.controller;

import com.me.model.security.User;
import com.me.rest.Result;
import com.me.security.service.RegisterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class RegisterRestController {
    private Logger logger = LogManager.getLogger(UserRestController.class);

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)

    public @ResponseBody
    Result register(@RequestBody User user) {


        System.out.println("#######"+user.getUsername());
        logger.info("###############@@@@@@ register ..........." );
       //  String result=registerService.addUser(user);

        Result result =new Result();
        result.setMessage(registerService.addUser(user));
        return result;
    }


}
