package Programming;

/**
 * 
 * @author zhangy10 671205
 *
 *         Oct 3, 2015
 *
 *         ExceptionHandler.java
 */
public final class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        System.out.println(
                ex + " " + thread.getName() + " " + this.getClass().getName());
    }

}