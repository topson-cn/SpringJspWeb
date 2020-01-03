package com.panda.SpringJspWeb.java8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CollectionDemo {

    @Test
    public void stream(){
        String[] a = {"1111","222"};
        String s = Arrays.stream(a)
                .filter(v -> Objects.equals("111", v))
                .findFirst().orElse("333");
        System.out.println(s);
    }
}
