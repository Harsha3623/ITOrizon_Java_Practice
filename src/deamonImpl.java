public class deamonImpl {
    public static void main(String[] args) throws InterruptedException {
        deamonThread t1 = new deamonThread();
        miss t2 = new miss();
        //t2.setDaemon(true);

        t1.start();
        t1.join();
        //t1.join();
        t1.notify();
        t2.start();

        System.out.println(t1.getName());
    }
}
