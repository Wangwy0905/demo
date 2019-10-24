package com.example.Controller;

import com.example.entity.UserEntity;
import com.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "用户模块",description = "用户模块")
public class UserController {

    @Autowired
    private UserService userService=null;

    @RequestMapping(value = "query",method = RequestMethod.GET)
    @ApiOperation(value = "查询所有用户")
    public List<UserEntity> query(){
        List<UserEntity> userEntities = userService.query();
        System.out.println(userEntities+"----------");
        return userEntities;
    }
}
