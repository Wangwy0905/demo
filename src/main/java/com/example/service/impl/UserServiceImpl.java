package com.example.service.impl;

import com.example.entity.UserEntity;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper=null;
    @Override
    public List<UserEntity> query() {
        return userMapper.selectAll();
    }

}
