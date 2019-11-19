package com.example;

import com.example.entity.UserEntity;
import com.example.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        String args = "1,2,3,4";
        String[] strs = args.split(",");
        List<String> list = Arrays.asList(strs);

        List<UserEntity> collect = list.stream().filter(Objects::nonNull)
                .map(id -> {
                    UserEntity entity = userMapper.selectByPrimaryKey(id);
                    if (entity==null){
                        return null;
                    }
                    return entity;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        System.out.println(collect + "------");
    }



}
