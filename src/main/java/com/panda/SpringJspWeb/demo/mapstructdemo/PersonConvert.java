package com.panda.SpringJspWeb.demo.mapstructdemo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Mapper
public interface PersonConvert {

    PersonConvert INSTANCE = Mappers.getMapper(PersonConvert.class);

    @Mappings({
            @Mapping(source = "user.age", target = "age"),
            @Mapping(source = "birthday", target = "birthDateFormat", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "birthExpressionFormat", expression = "java(org.apache.commons.lang3.time.DateFormatUtils.format(person.getBirthday(),\"yyyy-MM-dd HH:mm:ss\"))"),
            @Mapping(source = "birthday", target = "birth")
    }
    )
    PersonDTO domain2dto(Person person);
}
