package com.lenovo.procotol;

import java.io.IOException;
import java.io.OutputStream;

/**
 * redis协议规则拼装
 * For Simple Strings the first byte of the reply is "+"
For Errors the first byte of the reply is "-"
For Integers the first byte of the reply is ":"
For Bulk Strings the first byte of the reply is "$"
For Arrays the first byte of the reply is "*"
 *
 * @author daicx2
 *
 */
public class CxProcotol {
	private static final String DOLLOR_STRING="$";
	private static final String STAR_STRING="*";
	private static final String BLANK_STRING="\r\n";
	
	/**
	 * @Description: TODO(组装数据) 
	 * @author dcx 
	 * @date 2019年5月8日 下午5:18:50
	 * @param:            
	 * @throws IOException 
	 * @throws
	 * 下面是截取jredis发送给redis的数据
	 	*3 --->命令长度,0开始
		$3
		SET
		$3
		dcx
		$2
		12
	 */
	public static void sendCommand(OutputStream outputStream,Command command,byte[]...params) throws IOException {
		StringBuilder sb = new StringBuilder();
		//*3
		sb.append(STAR_STRING).append(params.length+1).append(BLANK_STRING);
		//$3  
		sb.append(DOLLOR_STRING).append(command.name().length()).append(BLANK_STRING);
		//SET
		sb.append(command.name()).append(BLANK_STRING);
		for (byte[] param : params) {
			sb.append(DOLLOR_STRING).append(param.length).append(BLANK_STRING);
			sb.append(new String(param)).append(BLANK_STRING);
		}
		outputStream.write(sb.toString().getBytes());
	}
	public static enum Command{
		GET,SET,KEYS
	}
	
}
