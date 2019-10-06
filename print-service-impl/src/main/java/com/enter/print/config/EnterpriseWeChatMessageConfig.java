package com.enter.print.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import java.nio.charset.Charset;

@Slf4j
public class EnterpriseWeChatMessageConfig {
    public static final String TOKEN = "huizekeji";
    public static Charset CHARSET = Charset.forName("utf-8");
    public static  final String EncodingAESKey ="hAMvyRnsAFwaFlKwfZhqcTBMdcAgBuS2vKpdOyPO2ds";
    public static final byte[] AES_KEY = Base64.decodeBase64(EncodingAESKey+"=");
    public static final byte[] REPLAY_AES_KEY = Base64.decodeBase64("jWmYm7qr5nMoAUwZRjGtBxmz3KA1tkAj3ykkR6q2B2C=");
    public static final String RECEIVE_ID = "ww069a1e0d963addb1";

}
