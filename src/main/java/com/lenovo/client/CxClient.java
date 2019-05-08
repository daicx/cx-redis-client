package com.lenovo.client;

import java.io.IOException;

import com.lenovo.connection.CxConnection;
import com.lenovo.procotol.CxProcotol;

public class CxClient {
		
	private CxConnection cxConnection;
	public CxClient(String host,int port) {
		this.cxConnection=new CxConnection(host, port);
	}
	
	public String set(String key,String value) throws IOException {
		cxConnection.snedCommend(CxProcotol.Command.SET, key.getBytes(),value.getBytes());
		return cxConnection.getStatus();
	}
	public String get(String key) throws IOException {
		cxConnection.snedCommend(CxProcotol.Command.GET, key.getBytes());
		return cxConnection.getStatus();
	}
}
