package com.panda.SpringJspWeb.springevent;

import org.springframework.context.ApplicationEvent;

/**
 * 〈一句话功能简述〉<br>
 * 曾小杰被离职事件
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ZengxiaojieEvent extends ApplicationEvent {
    private static final long serialVersionUID = -3929680329948737067L;

    public ZengxiaojieEvent(Object source) {
        super(source);
    }

    public String fired(){
        return "请曾小杰挑选公司";
    }
}
