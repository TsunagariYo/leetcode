package MD5Instance;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;

public class HmacMD5 {


    public static String encryptHmac(byte[] data) throws Exception {
        //生成密钥
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5"); // 可填入 HmacSHA1，HmacSHA256 等
        SecretKey key = keyGenerator.generateKey();
        byte[] keyBytes = key.getEncoded();
        SecretKey secretKey = new SecretKeySpec(keyBytes, "HmacMD5");

        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(secretKey);

        byte[] resultBytes = mac.doFinal(data);
        String resultString = new BigInteger(1, resultBytes).toString(16);
        return resultString;
    }

    public static void main(String[] args) throws Exception {
        byte[] bytes = "helloworld".getBytes();
        System.out.println(encryptHmac(bytes));
        System.out.println("f3d08e0e5a7325387e7677945f9df79f8e7014659a2c74d715da2fc5178a1c0f6cbe51715605de52ed9bec0b3b11d6133115c7c32f07ca88790065828f758d04".length());



    }
}
