package MD5Instance;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static String md5(String text) throws NoSuchAlgorithmException {
        //生成一个MD5加密计算摘要
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //对字符串进行加密
        md5.update(text.getBytes());
        //获得加密后的数据
        byte[] secretBytes = md5.digest();
        //加密后的转化为16进制的数字
        String md5code = new BigInteger(1, secretBytes).toString(16);
        //如果生成数字未满32位,需要在前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;

    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(md5("helloworld"));
    }
}
