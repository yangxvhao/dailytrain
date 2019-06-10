package jvm.gc;

/**
 * @author yangxvhao
 * @date 2018-10-30 下午2:52.
 */
public class TestGC {
    private static TestGC GC;
    
    public void isAlive(){
        System.out.println("yes , i am still alive");
    }

    /**
     * 只会执行一次
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        
        //自救
        GC = this;
    }

    public static void main(String[] args) throws InterruptedException {
        GC = new TestGC();
        GC = null;
        
        System.gc();
        
        Thread.sleep(500);
        if(GC != null){
            GC.isAlive();
        }else {
            System.out.println("no, i am dead");
        }

        GC = null;

        System.gc();

        Thread.sleep(500);
        if(GC != null){
            GC.isAlive();
        }else {
            System.out.println("no, i am dead");
        }
    }
}
