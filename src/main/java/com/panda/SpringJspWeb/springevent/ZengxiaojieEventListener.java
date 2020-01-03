package com.panda.SpringJspWeb.springevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class ZengxiaojieEventListener implements ApplicationListener<ZengxiaojieEvent> {

    @Override
    public void onApplicationEvent(ZengxiaojieEvent zengxiaojieEvent) {
        System.out.println(zengxiaojieEvent.fired());
    }
}
