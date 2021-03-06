package com.halo.service.impl;

import com.halo.dao.AdminDao;
import com.halo.entity.Admin;
import com.halo.service.AdminInfoService;
import com.halo.util.DigestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SAIKAII
 * @date 2018/6/6
 */
@Service
public class AdminInfoServiceImpl implements AdminInfoService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public boolean verityByUsername(String username) {
        if(null != adminDao.getAdminInfoByUsername(username)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean verify(String username, String pwd) {
        Admin admin = adminDao.getAdminInfoByUsername(username);
        if(null == admin){
            return false;
        }
        String password = admin.getPwd();
        String salt = admin.getSalt();
        return DigestUtil.verify(pwd, salt, password);
    }

    @Override
    public void insertAdmin(Admin admin) {
        String salt = DigestUtil.generateSalt();
        String password = DigestUtil.sha256(admin.getPwd() + salt);
        admin.setPwd(password);
        admin.setSalt(salt);

        adminDao.insertAdminInfo(admin);
    }


}
