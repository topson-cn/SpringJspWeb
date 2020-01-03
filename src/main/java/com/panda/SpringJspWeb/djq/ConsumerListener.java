package com.panda.SpringJspWeb.djq;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.formula.functions.T;

import java.util.function.Consumer;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ConsumerListener {

    private static final Log logger = LogFactory.getLog(ConsumerListener.class);

    protected static void invoke(Runnable run){
        logger.info("start ...");
        run.run();
        logger.info("end ...");
    }


    public static void onMessage(Message message){
        invoke(() -> {
//            String data = message.getStringProperty("data");
//            JSONObject jsonObject = JSONObject.parseObject(data);
//            String uid = jsonObject.getString(UID);
//            memberGradeService.createMember(uid);
            System.out.println("invokeing..." + message.getMessage());
        });
    }

    public static void main(String[] args) {
        onMessage(new Message("22222"));
    }

    @Data
    @AllArgsConstructor
    static class Message{
        private String message;
    }
}
