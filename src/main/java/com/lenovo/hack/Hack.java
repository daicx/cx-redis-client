package com.lenovo.hack;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟redis服务端,通过这个查看jredis发送的指令.
 * @author daicx2
 *
 */
public class Hack {
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		ServerSocket serverSocket= new ServerSocket(6379);
		Socket socket = serverSocket.accept();
		byte[] bytes=new byte[1024];
		socket.getInputStream().read(bytes);
		System.out.println(new String(bytes));
	}
}
