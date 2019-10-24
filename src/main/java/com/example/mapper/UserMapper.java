package com.example.mapper;

import com.example.entity.UserEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<UserEntity> {
    //List<UserEntity> query();
}
