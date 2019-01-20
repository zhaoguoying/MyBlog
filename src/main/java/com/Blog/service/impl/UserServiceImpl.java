package com.Blog.service.impl;

/*
 * 作者：赵国应
 * 时间：2019-1-6
 * 描述：user表接口具体业务逻辑
 */

import com.Blog.constant.Constants;
import com.Blog.constant.RoleConstant;
import com.Blog.mapper.UserMapper;
import com.Blog.model.User;
import com.Blog.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserByPhone(String phone) {
        return userMapper.findUserByPhone(phone);
    }

    @Override
    public String findUsernameById(int id) {
        return userMapper.findUsernameById(id);
    }

    @Override
    public String insert(User user) {
        if(userIdExit(user.getPhone())){
            /*
             * 返回 "1"
             */
            return Constants.STATIC_ONE;
        }
        if("man".equals(user.getGender())){
            user.setAvatarImgUrl("./img/man.JPG");
        }else {
            user.setAvatarImgUrl("./img/woman.JPG");
        }
        userMapper.insert(user);
        int userId = userMapper.findUserIdByPhone(user.getPhone());
        insertRole(userId, RoleConstant.ROLE_USER);
        /*
         * 返回 "2"
         */
        return Constants.STATIC_TWO;
    }

    @Override
    public int findUserIdByPhone(String phone) {
        return userMapper.findUserIdByPhone(phone);
    }

    @Override
    public void updatePasswordByPhone(String phone, String password) {
        userMapper.updatePassword(phone,password);
    }

    @Override
    public String findPhoneByUsername(String username) {
        return userMapper.findPhoneByUsername(username);
    }

    @Override
    public int findIdByUsername(String username) {
        return userMapper.findIdByUsername(username);
    }

    @Override
    public User findUsernameByPhone(String phone) {
        return userMapper.findUsernameByPhone(phone);
    }

    @Override
    public void updateRecentlyLanded(String username, String recentlyLanded) {
        String phone = userMapper.findPhoneByUsername(username);
        userMapper.updateRecentlyLanded(phone,recentlyLanded);
    }

    @Override
    public boolean usernameIsExit(String username) {
        User user = userMapper.findUsernameByUsername(username);
        return user != null;
    }

    @Override
    public boolean isSuperAdmin(String phone) {
        int userId = userMapper.findUserIdByPhone(phone);
        List<Object> roleIds = userMapper.findRoleIdByUserId(userId);

        for (Object i : roleIds) {
            if ((int) i == 3) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateAvatarImgUrlById(String avatarImgUrl, int id) {
        userMapper.updateAvatarImgUrlById(avatarImgUrl,id);
    }

    @Override
    public JSONObject getHeadPortraitUrl(int id) {
        JSONObject jsonObject = new JSONObject();
        String avatarImgUrl = userMapper.getHeadPortraitUrl(id);

        if (!"".equals(avatarImgUrl) && avatarImgUrl != null){
            jsonObject.put("status",200);
            jsonObject.put("avatarImgUrl",avatarImgUrl);
        }
        //System.out.println(jsonObject.getString("avatarImgUrl"));
        return jsonObject;
    }

    @Override
    public JSONObject getUserPersonalInfoByUsername(String username) {
        User user = userMapper.getUserPersonalInfoByUsername(username);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",200);
        JSONObject userJon = new JSONObject();
        userJon.put("phone",user.getPhone());
        userJon.put("username",user.getUsername());
        userJon.put("gender",user.getGender());
        userJon.put("trueName",user.getTrueName());
        userJon.put("birthday",user.getBirthday());
        userJon.put("email",user.getEmail());
        userJon.put("personalBrief",user.getPersonalBrief());
        userJon.put("avatarImgUrl",user.getAvatarImgUrl());
        jsonObject.put("result",userJon);
        //System.out.println(jsonObject.getString("result"));
        return jsonObject;
    }

    @Override
    public JSONObject savePersonalDate(User user, String username) {
        JSONObject returnJson = new JSONObject();

        //改了昵称
        if(!user.getUsername().equals(username)){
            if(usernameIsExit(user.getUsername())){
                returnJson.put("status",500);
                return returnJson;
            }
            returnJson.put("status",200);
            //注销当前登录用户
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        //没改昵称
        else {
            returnJson.put("status",201);
        }
        userMapper.savePersonalDate(user, username);

        return returnJson;
    }

    @Override
    public String getHeadPortraitUrlByUserId(int userId) {
        return userMapper.getHeadPortraitUrl(userId);
    }

    @Override
    public int countUserNum() {
        return userMapper.countUserNum();
    }

    /*
     * 增加用户权限
     */
    private void insertRole(int uderId,int roleId){
        userMapper.insertRole(uderId,roleId);
    }

    /*
     * 通过手机号判定用户是否存在
     */
    private boolean userIdExit(String phone){
        User user = userMapper.findUserByPhone(phone);
        return user != null;
    }

}
