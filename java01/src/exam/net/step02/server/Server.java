package exam.net.step02.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import exam.net.step02.Receiver;
import exam.net.step02.Sender;

public class Server {

  public static void main(String[] args) throws Exception {
    Scanner keyScan = new Scanner(System.in);
    
    // 1. 요청을 받는 역할을 수행할 서버 소켓 생성
    ServerSocket ss = new ServerSocket(9080);
    
    // 2. 클라이언트의 요청을 기다리고 승인한다. => 클라이언트와 데이터를 주고 받을 소켓 리턴
    Socket socket = ss.accept();
    
    // 3. 소켓으로 데이터를 보내고, 소켓으로부터 데이터를 읽는 객체 준비
    InputStream in = socket.getInputStream();
    Scanner in2 = new Scanner(in);
    
    OutputStream out = socket.getOutputStream();
    PrintStream out2 = new PrintStream(out);
    
    // 상대 편에게 데이터를 보내고 받을 조수 준비!
    Sender senderThread = new Sender(keyScan, out2);
    Receiver receiverThread = new Receiver(in2);
    
    // 조수에게 작업을 시작하라고 명령을 내린다.
    senderThread.start();
    receiverThread.start();
    
    /*
    keyScan.close();
    in2.close();
    in.close();
    out2.close();
    out.close();
    socket.close();
    ss.close();
    */
  }

}

















