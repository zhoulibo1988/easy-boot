/**
 * 
 */
package com.mos.eboot.im;

import org.apache.commons.lang3.StringUtils;
import org.jim.common.Const;
import org.jim.common.ImConfig;
import org.jim.common.config.PropertyImConfigBuilder;
import org.jim.common.packets.Command;
import org.jim.server.ImServerStarter;
import org.jim.server.command.CommandManager;
import org.jim.server.command.handler.HandshakeReqHandler;
import org.jim.server.command.handler.LoginReqHandler;
import org.tio.core.ssl.SslConfig;

import com.jfinal.kit.PropKit;
import com.mos.eboot.im.command.DemoWsHandshakeProcessor;
import com.mos.eboot.im.listener.ImDemoGroupListener;
import com.mos.eboot.im.service.LoginServiceProcessor;
/**
 * IM服务端DEMO演示启动类;
 * @author Administrator
 * zlb
 *
 */
public class ImServerDemoStart {

	public static void main(String[] args)throws Exception{
		ImConfig imConfig = new PropertyImConfigBuilder("jim.properties").build();
		//初始化SSL;(开启SSL之前,你要保证你有SSL证书哦...)
		initSsl(imConfig);
		//设置群组监听器，非必须，根据需要自己选择性实现;
		imConfig.setImGroupListener(new ImDemoGroupListener());
		ImServerStarter imServerStarter = new ImServerStarter(imConfig);
		/*****************start 以下处理器根据业务需要自行添加与扩展，每个Command都可以添加扩展,此处为demo中处理**********************************/
		HandshakeReqHandler handshakeReqHandler = CommandManager.getCommand(Command.COMMAND_HANDSHAKE_REQ, HandshakeReqHandler.class);
		//添加自定义握手处理器;
		handshakeReqHandler.addProcessor(new DemoWsHandshakeProcessor());
		LoginReqHandler loginReqHandler = CommandManager.getCommand(Command.COMMAND_LOGIN_REQ,LoginReqHandler.class);
		//添加登录业务处理器;
		loginReqHandler.addProcessor(new LoginServiceProcessor());
		/*****************end *******************************************************************************************/
		imServerStarter.start();
	}
	/**
	 * 开启SSL之前，你要保证你有SSL证书哦！
	 * @param imConfig
	 * @throws Exception
	 */
	private static void initSsl(ImConfig imConfig) throws Exception {
		//开启SSL
		if(Const.ON.equals(imConfig.getIsSSL())){
			String keyStorePath = PropKit.get("jim.key.store.path");
			String keyStoreFile = keyStorePath;
			String trustStoreFile = keyStorePath;
			String keyStorePwd = PropKit.get("jim.key.store.pwd");
			if (StringUtils.isNotBlank(keyStoreFile) && StringUtils.isNotBlank(trustStoreFile)) {
				SslConfig sslConfig = SslConfig.forServer(keyStoreFile, trustStoreFile, keyStorePwd);
				imConfig.setSslConfig(sslConfig);
			}
		}
	}
}
