/**
 * @author yangxvhao
 * @date 2018-10-23 下午2:00.
 */
public class LoggingWidget extends Widget {
    @Override
    public synchronized void doSomeThing() {
        System.out.println("I am LoggingWidget");
        super.doSomeThing();
    }
}
