package com.toy.toy_springboots.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toy.toy_springboots.dao.UserDao;
import com.toy.toy_springboots.utils.Paginations;

@Service
public class UserService {UserDao userDao;

    public Object getList(Object dataMap) {
        String sqlMapId = "User.selectListByUId";
        Object result = userDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object getOne(Object dataMap){
        String sqlMapId = "User.selectByUID";

        Object result = userDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object getTotal(Object dataMap){
        String sqlMapId = "User.selectTotal";

        Object result = userDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object getListWithPagination(Object dataMap) {
        Map<String, Object> result = new HashMap<String, Object>();
        int totalCount = (int) this.getTotal(dataMap);
        int currentPage = (int) ((Map<String, Object>) dataMap).get("currentPage");
        Paginations paginations = new Paginations(totalCount, currentPage);
        result.put("paginations", paginations);
        ((Map<String, Object>) dataMap).put("pageBegin", paginations.getPageBegin());
        result.put("resultList", this.getList(dataMap));
        return result;
    }
}
