package com.panda.SpringJspWeb.pptv;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.net.URLEncoder;
import java.util.Date;

public class TokenGenerateUtil {
	private static final String TOKEN_VERSION = "2.0";
	private static final Log logger = LogFactory.getLog(TokenGenerateUtil.class);
	
	/**
	 * 生成旧版token
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public static String generateToken(String username) throws Exception{
		RSAPrivateKeyEncrypterToken rSAPrivateKeyEncrypterToken = new RSAPrivateKeyEncrypterToken();
		Date now = new Date();
		long expireTime = now.getTime() + 14 * 24 * 3600 * 1000;
		String token = rSAPrivateKeyEncrypterToken.encrypt(username + "&"
				+ expireTime + "&"
				+ RandomUtil.generate(8));
		logger.info("token[v1.0]------>" + token + "------->username------->" + username);
		token = URLEncoder.encode(token, "UTF-8");
		
		return token;
	}
	

}
