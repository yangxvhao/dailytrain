/**
 * @author yangxvhao
 * @date 2018-10-23 下午1:59.
 */
public class Widget {
    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public synchronized void doSomeThing(){
        System.out.println("I am Widget");
    }
}
