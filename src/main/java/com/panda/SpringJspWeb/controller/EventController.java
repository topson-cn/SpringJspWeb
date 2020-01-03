package com.panda.SpringJspWeb.controller;

import com.panda.SpringJspWeb.springevent.ZengxiaojieEvent;
import com.panda.SpringJspWeb.springevent.ZengxiaojieEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
public class EventController {

    @Autowired
    private ZengxiaojieEventPublisher publisher;

    @RequestMapping("/event/demo")
    public String demo(){
        ZengxiaojieEvent event = new ZengxiaojieEvent("");
        publisher.publish(event);
        return "success";
    }
}
