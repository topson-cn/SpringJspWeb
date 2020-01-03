package com.panda.SpringJspWeb.mapper;

import com.panda.SpringJspWeb.mapper.entity.PermissionDO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Repository
public interface IPermissionMapper {

    @Select("select * from permission where find_in_set(id,${ids}) and deleted = false")
    List<PermissionDO> findPermissionsByIds(String ids);
}
