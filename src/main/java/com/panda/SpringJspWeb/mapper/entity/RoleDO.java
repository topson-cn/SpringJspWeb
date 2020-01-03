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
public class RoleDO {

    private Long id;

    /**
     * 角色权限
     */
    private String permissions;

    /**
     * 角色名
     */
    private String roleName;
    /**
     * 逻辑删除标识位
     */
    private Boolean deleted;
}
