package com.panda.SpringJspWeb.java8;


import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class OptionalDemo {

    @Test
    public void of(){
        Object obj = null;
        Optional<Object> obj1 = Optional.ofNullable(obj);// ofNullable 不要求非空,如果为空就new 一个空的object
        User user = new User("xiaoming");
        Optional.ofNullable(user)
                .ifPresent(user1 -> {
                    String userName = user1.getUserName();
                    System.out.println(userName);
                });
    }
}
