package com.panda.SpringJspWeb.djq;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Father {

    private static String a = "1";

    static {
        System.out.println(a);
    }

    {
        System.out.println("f1");
    }

    private String b = "2";

    {
        System.out.println(b);
    }

    public Father() {
        System.out.println("father init");
    }
}
