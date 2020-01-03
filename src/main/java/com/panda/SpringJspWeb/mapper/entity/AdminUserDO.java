package com.panda.SpringJspWeb.mapper.entity;

import lombok.Data;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Data
public class AdminUserDO {

    private Long id;

    /**
     * 用户角色
     */
    private String roles;

    /**
     * 用户名
     */
    private String userName;
    /**
     * 加密密码
     */
    private String password;
    /**
     * 逻辑删除标识位
     */
    private Boolean deleted;
}
