//package com.panda.SpringJspWeb;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.*;
//
///**
// * 〈一句话功能简述〉<br>
// *
// * @author 18048474
// * @see [相关类/方法]（可选）
// * @since [产品/模块版本] （可选）
// */
//public class ForkJoinDemo {
//
//
//    static class DemoTask extends RecursiveTask<Map>{
//
//        private int taskid;
//
//        private CyclicBarrier cyclicBarrier;
//
//        public DemoTask(int taskid, CyclicBarrier cyclicBarrier) {
//            this.taskid = taskid;
//            this.cyclicBarrier = cyclicBarrier;
//        }
//
//        @Override
//        protected Map compute() {
//            if (cyclicBarrier.getParties() == 4){
//                HashMap<Object, Object> map = new HashMap<>();
//                map.put("ob"+ taskid , "1");
//                try {
//                    int await = cyclicBarrier.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
//                return map;
//            }
//
//
//        }
//    }
//
//    public static void main(String[] args) {
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
//        ForkJoinPool pool = new ForkJoinPool();
//        DemoTask demoTask1 = new DemoTask(1,cyclicBarrier);
//        DemoTask demoTask2 = new DemoTask(2,cyclicBarrier);
//        pool.submit(demoTask1);
//        pool.submit(demoTask2);
//        ForkJoinTask<Map> fork = demoTask1.fork();
//        ForkJoinTask<Map> fork1 = demoTask2.fork();
//        Map join = demoTask1.join();
//        join.putAll(fork1.join());
//        System.out.println(join);
//    }
//}
