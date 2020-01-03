package com.panda.SpringJspWeb.mapper;

import com.panda.SpringJspWeb.mapper.entity.AdminUserDO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Repository
public interface IAdminUserMapper {

    @Select("select * from admin_user where userName = #{name} and deleted= false")
    AdminUserDO getUserByName(String name);
}
