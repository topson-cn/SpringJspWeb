package com.panda.SpringJspWeb.djq;

import com.google.common.collect.Lists;

import javax.annotation.processing.FilerException;
import java.util.LinkedList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class lombokDemo {



    public static RuntimeException sneakyThrow(Throwable t) {
        if (t == null) {
            throw new NullPointerException("t");
        } else {
            sneakyThrow0(t);
            return null;
        }
    }

    private static <T extends Throwable> void sneakyThrow0(Throwable t) throws T {
        throw  (T) t;
    }


    @SuppressWarnings("unchecked")
    public static <T extends List<Integer>> T getList(List<Integer> a) {
        return (T) a;
    }

    public static void main(String[] args) {
        List<Integer> list= Lists.newArrayList();
        LinkedList<Integer> list1 = getList(list);

    }
}
