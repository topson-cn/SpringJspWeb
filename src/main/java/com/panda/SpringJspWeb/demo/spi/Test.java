package com.panda.SpringJspWeb.demo.spi;

import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Test {

    public static void main(String[] args) {
        Iterator<SPIService> providers = Service.providers(SPIService.class);
        ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);

        while (providers.hasNext()){
            providers.next().execute();
        }

        System.out.println("-------------------------");

        Iterator<SPIService> iterator = load.iterator();
        while (iterator.hasNext()){
            iterator.next().execute();
        }
    }
}
