/**
 * @author yangxvhao
 * @date 2018-10-23 下午2:01.
 */
public class Test {
    static class ClassA{
        private String a;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            System.out.println(a);
            this.a = a;
        }
        
        
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        String s2 = new String("1");
        s2.intern();
        String s1 = "1";
        String s3 = new String("1") + new String("1");
        
        s3.intern();
        String s4 = "11";
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(s1 == s2);
//        LoggingWidget loggingWidget = new LoggingWidget();
//        Thread thread = new Thread(loggingWidget::doSomeThing);
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread.start();
//        ClassA classA = new ClassA();
//        CountDownLatch countDownLatch = new CountDownLatch(10);
//        ExecutorService service = Executors.newFixedThreadPool(10);
//        
//        for(int i = 0; i < 10; i ++) {
//            int finalI = i;
////            countDownLatch.countDown();
//            service.execute(new Runnable() {
//                @Override
//                public void run() {
//                    synchronized (this){
//                        classA.setA(Thread.currentThread().getName() + " set ");
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        System.out.println(Thread.currentThread().getName() + " get " + classA.getA());
//                    }
//                    
//                }
//            });
//        }
//        countDownLatch.await();
        
    }
}
