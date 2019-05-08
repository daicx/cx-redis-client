package com.lenovo.connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.lenovo.procotol.CxProcotol;


public class CxConnection {
	private Socket socket;
	private String host;
	private int port;
	private InputStream inputStream;
	private OutputStream outputStream;
	public CxConnection(String host, int port) {
		super();
		this.host = host;
		this.port = port;
	}
	//创建连接
	public CxConnection getConnection() {
		try {
			//socket 连接判断,只列举了2个,实际有很多.
			if (socket != null && !socket.isBound()) {
				socket=new Socket(host,port);
			}
			inputStream=socket.getInputStream();
			outputStream=socket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
		
	}
	//发送数据
	public CxConnection snedCommend(CxProcotol.Command command,byte[]...args) throws IOException {
		getConnection();
		CxProcotol.sendCommand(outputStream, command, args);
		return this;
	}
	//获取返回数据
	public String getStatus() throws IOException {
		byte[] bytes=new byte[1024];
		inputStream.read(bytes);
		return new String(bytes);
	}
	
}
