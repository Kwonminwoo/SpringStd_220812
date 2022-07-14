import javax.swing.*;
public class ThreadTestEx3 {
    // 멀티쓰레드로 두개의 작업을 동시에 진행
    public static void main(String[] args) throws Exception {
        Thread4 tr1 = new Thread4();
        tr1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력."); // 입력창을 띄워 입력값을 받음.
        System.out.println("입력한 값: " + input);
    }
}

class Thread4 extends Thread{
    @Override
    public void run() {
        for(int i = 10;i > 0;i--){
            System.out.println(i);
            try{
                sleep(1000);
            }catch (Exception e){}
        }
    }
}
