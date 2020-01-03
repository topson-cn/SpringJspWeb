package com.panda.SpringJspWeb.djq;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Son extends Father{

    private static String c = "3";

    static {
        System.out.println(c);
    }

    {
        System.out.println("f2");
    }

    private String d = "4";

    {
        System.out.println(d);
    }

    public Son() {
        System.out.println("Son init");
    }


    public static void main(String[] args) {
        Father f = new Son();

        System.out.println( 1 >>> 1);

        System.out.println( -1 >> 31);

        System.out.println( 2 >> 1);

        System.out.println( 1 << 1);

        float x=34.5f;
        float y=68.4f;

        System.out.println( "x+y="+x+"+"+y+"="+(x+y));

    }
}
