public class Main {
    public static void main(String[] args) {
        Resources t1 = new Resources(10);
        Resources t2 = new Resources(10);
        t1.start();
        t2.start();
    }
}

class Resources extends Thread{
    static int tickets;
    public Resources(int n){
        tickets = n;
    }
    public void purchase(){
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + "买了一张票,剩余票数：" + --tickets);
        }
    }
    @Override
    public synchronized void run(){
        while (tickets > 0) {
            purchase();
        }
    }
}