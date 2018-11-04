package com.zz.vta.front.service;

import com.zz.vta.front.db2map.AdminMapper;
import com.zz.vta.front.entity.AdminEntity;
import com.zz.vta.front.frontentity.AdminShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminMapper mapper;

    /**
     * 登录验证
     */
    public boolean checkLogin(String user,String password){
        if(mapper.checkUser(user,password)!=null){
            return true;
        }else {
            return false;
        }
    }



    /**
     * 查询所有管理员
     */
    public List<AdminShow> getAdminAll(ArrayList<AdminShow> showArrayList){
        for (AdminEntity entity:mapper.findAll()) {
            showArrayList.add(new AdminShow(entity.getA_name(),entity.getA_air(),entity.getA_tel()));
        }
        return showArrayList;
    }

}
