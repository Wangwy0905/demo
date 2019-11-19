package com.example.Controller;

import com.example.entity.UserEntity;
import com.example.service.UserService;
import com.example.util.ReadCsvUtil;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "�û�ģ��", description = "�û�ģ��")
public class UserController {

    @Autowired
    private UserService userService = null;

    @RequestMapping(value = "query", method = RequestMethod.GET)
    @ApiOperation(value = "��ѯ�����û�")
    public List<UserEntity> query() {
        List<UserEntity> userEntities = userService.query();
        System.out.println(userEntities + "----------");
        return userEntities;
    }


    @RequestMapping(value = "import", method = RequestMethod.GET)
    @ApiOperation(value = "����")
    public Boolean importCsv(String path) throws IOException {
        List<UserEntity> resource = ReadCsvUtil.getResource(path);
        System.out.println(resource + "-----------");
        return true;
    }


}
