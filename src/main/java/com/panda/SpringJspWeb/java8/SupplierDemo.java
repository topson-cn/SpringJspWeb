package com.panda.SpringJspWeb.java8;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
class SupplierDemo {

    void invoke(Supplier<String> supplier){
        String o = supplier.get();
        System.out.println(o);
    }

    @Test
    void supplier(){
        SupplierDemo demo = new SupplierDemo();
        demo.invoke(() -> {
            return "1111";
        });
    }
}
