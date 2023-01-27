package com.toy.toy_springboots.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toy.toy_springboots.dao.UserDao;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public Object getList(Object dataMap) {
        String sqlMapId = "User.selectListByUId";
        Object result = userDao.getList(sqlMapId, dataMap);
        return result;
    }
}
