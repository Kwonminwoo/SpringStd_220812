public class ThreadTestEx2 {
    // 멀티 쓰레드로 돌려, 걸리는 시간을 측정
    static long startTime = 0;

    public static void main(String[] args) {
        Thread3 tr1 = new Thread3();
        tr1.start();
        startTime = System.currentTimeMillis();

        for(int i = 0;i < 500;i++){
            System.out.printf("%s", new String("-")); // 시간이 오래 걸리도록 new String()을 사용
        }
        System.out.print("소요시간1: " + (System.currentTimeMillis() - startTime));
    }
}
class Thread3 extends Thread{
    @Override
    public void run() {
        for(int i = 0;i < 500;i++){
            System.out.printf("%s", new String("|"));
        }
        System.out.print("소요시간2: " + (System.currentTimeMillis() - ThreadTestEx2.startTime));
    }
}