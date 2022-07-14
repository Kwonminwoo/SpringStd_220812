public class ThreadTestEx1 {
    public static void main(String[] args) {
        Runnable r1 = new Thread1();
        Thread t1 = new Thread(r1);

        Thread2 t2 = new Thread2();

        t1.start();
        t2.start();
    }
}

class Thread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i < 5;i++){
            System.out.println(Thread.currentThread().getName()); // 현재 사용중인 스레드의 이름을 반환
        }
    }
}

class Thread2 extends Thread{
    @Override
    public void run() {
        for(int i = 0;i < 5;i++){
            System.out.println(super.getName());
        }
    }
}