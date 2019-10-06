package com.enter.print.context.secret.sha1;

import com.enter.print.context.secret.IrreversibleEncryptible;
import com.enter.util.exception.AesException;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * @author Liquid
 * @类名： Sha1Encrypt
 * @描述：
 * @date 2019/4/14
 */
@Component("sha1")
public class Sha1Encrypt implements IrreversibleEncryptible {

    private static HashFunction hashFunction = Hashing.sha1();

    private static Charset charset = Charset.forName("UTF-8");

    @Override
    public String encrypt(String data) {
        return hashFunction.newHasher().putString(data, charset).hash().toString();
    }

    public static String getSHA1(String token, String timestamp, String nonce, String encrypt) throws AesException {
        try {
            String[] array = new String[]{token, timestamp, nonce, encrypt};
            StringBuffer sb = new StringBuffer();
            // 字符串排序
            Arrays.sort(array);
            for (int i = 0; i < 4; i++) {
                sb.append(array[i]);
            }
            String str = sb.toString();
            // SHA1签名生成
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            byte[] digest = md.digest();

            StringBuffer hexstr = new StringBuffer();
            String shaHex = "";
            for (int i = 0; i < digest.length; i++) {
                shaHex = Integer.toHexString(digest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexstr.append(0);
                }
                hexstr.append(shaHex);
            }
            return hexstr.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new AesException(AesException.ComputeSignatureError);
        }
    }
}
