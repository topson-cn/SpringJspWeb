package com.panda.SpringJspWeb.shiro;

import com.panda.SpringJspWeb.mapper.IAdminUserMapper;
import com.panda.SpringJspWeb.mapper.IPermissionMapper;
import com.panda.SpringJspWeb.mapper.IRoleMapper;
import com.panda.SpringJspWeb.mapper.entity.AdminUserDO;
import com.panda.SpringJspWeb.mapper.entity.RoleDO;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private IAdminUserMapper adminUserMapper;

    @Autowired
    private IRoleMapper roleMapper;

    @Autowired
    private IPermissionMapper permissionMapper;

    /**
     * 角色权限和对应权限添加
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取登录名
        String userName = (String) principalCollection.getPrimaryPrincipal();
        AdminUserDO adminUser = adminUserMapper.getUserByName(userName);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        roleMapper.findRolesByIds(adminUser.getRoles()).forEach(
                r ->{
                    simpleAuthorizationInfo.addRole(r.getRoleName());
                    permissionMapper.findPermissionsByIds(r.getPermissions()).forEach(
                            p -> {
                                simpleAuthorizationInfo.addStringPermission(p.getPermissionId());
                            }
                    );
                }
        );
        return simpleAuthorizationInfo;
    }

    /**
     * 用户认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String name = authenticationToken.getPrincipal().toString();
        AdminUserDO adminUser = adminUserMapper.getUserByName(name);
        if (adminUser == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, adminUser.getPassword(), getName());
            return simpleAuthenticationInfo;
        }
    }
}
