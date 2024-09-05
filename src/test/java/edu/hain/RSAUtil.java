package edu.hain;

import cn.hutool.crypto.asymmetric.RSA;
import com.google.gson.Gson;
import org.junit.Test;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class RSAUtil {

    public static PublicKey getPublicKeyFromString(String publicKeyStr) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(publicKeyStr.getBytes());
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(spec);
    }

    public static PrivateKey getPrivateKeyFromString(String privateKeyStr) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(privateKeyStr.getBytes());
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(spec);
    }

    public static String encrypt(String data, String publicKeyStr) throws Exception {
        PublicKey publicKey = getPublicKeyFromString(publicKeyStr);
        //Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherText = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
    }

    public static String decrypt(String cipherData, String privateKeyStr) throws Exception {
        PrivateKey privateKey = getPrivateKeyFromString(privateKeyStr);
        byte[] bytes = Base64.getDecoder().decode(cipherData);
        //Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedText = cipher.doFinal(bytes);
        return new String(decryptedText);
    }
//2fe8ec6ed4d048fa8f134527f9a6a291
//f1bccc90dd47482f9300d5e437315ded
    public static void main(String[] args) {
        try {
            // 替换为你的公钥和私钥字符串

            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            // 初始化密钥对生成器为2048位长度
            keyPairGenerator.initialize(256);

            // 生成密钥对
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // 获取公钥和私钥对象
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            // 将公钥和私钥转换为Base64编码的字符串
            String publicKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
            String privateKeyString = Base64.getEncoder().encodeToString(privateKey.getEncoded());



            System.out.println("Public Key (Base64 encoded format):");
            System.out.println(publicKeyString);

            System.out.println("\nPrivate Key (Base64 encoded format):");
            System.out.println(privateKeyString);
            // 需要加密的字符串
            String originalString = "Hello, RSA2048 Encryption!";
            System.out.println("Original string: " + originalString);

            // 加密
            String encryptedString = encrypt(originalString, publicKeyString);
            System.out.println("Encrypted string: " + encryptedString);

            // 解密
            String decryptedString = decrypt(encryptedString, privateKeyString);
            System.out.println("Decrypted string: " + decryptedString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void test() throws Exception {
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCK227i8E7oTzixUayd8bj+nLRbg5z4PZVjtxW1oNJYW2w6I4p2WL33GpKESWv3KqIuTP5zSfPXUHOwj5HEqyy+E6xVEc0qSw8dG7AXUOuOcLqBprsz03/QmyaBhrVrkm5DvHSOeu4kFtRmsVVBDiqlRw52BqlWSIvO1PBC0Jc1L0sXCp1eqMwpWM8jY8hXxkqy29zpC16dFbMXXSFJgnG4MolnvRLdBXuePab8pgA10uJkYobC6EqOp4UVWCxH+A2ZCqlYivzQ5bNMxzIbQoLAiOLHb5hPM71h+uvuGMw4xnBzbD2ChaQ4mYMv1LBHqyKd6ZTmvExIZdksPLKBQprhAgMBAAECggEAf+JUn8F+isnbhsOX3Ocw353nJZlzSdU97tZBskNpNmMMrAbrkM9uNVRNuHP+cWbccxQKDJgBcT3xLp0rPRwBWxW3U6nPcLIsOzyy0uZ963O68YljQ/n372HU9tnf4DC+SLgaCNcC2E4GVIXh5MZtVEa69MxxzLuHt3e5x29gs2N91SY6+eOt+RykO0zIUFYDzfBa1ZujSvbbsMeIQmct+dmFNVVxUTX7QGmjQoudg8hzOgjMZ1SZ4Ue5WEBaJopRMaFuoTxZ2Y8Og5vMMa1emba2r3aPalxLvSQjmtFVuY0Hml+zlt5/2zcSgJNOtAlFsL4ivBIQsz8waaSoMhNgAQKBgQC8pINvmEtG93vtvqR2+SpTJvXiahVhNo3E4ptSGUrVdT2jRGwnZPiWlcEnMwcKUNBP9TUwnXs6t35HxQP/eP84jz4e5HrXxiDC8+6fQMLVzgRvsi50apJBDOjmlwCL8x7vCFfgX0Qp4cP3ZpJ0uR3IA49PtCGBAcBI/nuazn9RgQKBgQC8cB5h/EmExGy1Lo4wBO20s+15VGjZvJIQh1keo0VO8hfPMnJOFhYfNLp5reMgnbiu6KHwKGy1fdTMw+G3SygzaKRBWt1/jZYA77oP6HI4hqDqdafAf0WiZYtawdQsyJT3RW+p2l8ywTZGk8Ai3/pXT8PKAJQj7F2Y5TsgK185YQKBgQCFnm3vHMutX91rYE80anc9YOpnzsaIDlFK9UwZUgr8ucfIHs4Q9WdTmo2vS2igOO/kwwZDAjloNNMA2R9k1PrKwEO7NBGDRzargIc0THX1ZbEkwOxAz7/6zb8mnizn9HSj0aAVMMWieOULF5+DiB/9LfBT/35/15Kw4XkCBWSPgQKBgC4BMWm6rjg7vE5/jzcp/N6hDtkQQojmAMMISDmyorkjYay0JDPsMHpt5RjP2yObXftV0DNRqzij/8/+Ap09PBNQ+Mj75he9+WFBJau8lCY4uBCFqO7WI6oCIIOHzsUgMz4rNZfCOHursBSK/d2F0Rh/4MzwVzpt+mvZixXPgPABAoGAG2U759cmNG2b2Vd1mNl7iQ6Uefhj7Od8r+E7Qd13Vxeg6cZuDflNcTnyodEA4+xssLs7AMaz0Gm1ztVUDc2HPvXVsymHq+La70bECDasMnH3UYkeMZvlF/36gtyySLKfgziag+P8yhTAv7YDHyirgjuO3AJGKi59kYWIZHIFOUA=";
        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAittu4vBO6E84sVGsnfG4/py0W4Oc+D2VY7cVtaDSWFtsOiOKdli99xqShElr9yqiLkz+c0nz11BzsI+RxKssvhOsVRHNKksPHRuwF1DrjnC6gaa7M9N/0JsmgYa1a5JuQ7x0jnruJBbUZrFVQQ4qpUcOdgapVkiLztTwQtCXNS9LFwqdXqjMKVjPI2PIV8ZKstvc6QtenRWzF10hSYJxuDKJZ70S3QV7nj2m/KYANdLiZGKGwuhKjqeFFVgsR/gNmQqpWIr80OWzTMcyG0KCwIjix2+YTzO9Yfrr7hjMOMZwc2w9goWkOJmDL9SwR6sinemU5rxMSGXZLDyygUKa4QIDAQAB";

        String encrypt = encrypt("hanajinge@gmail", publicKey);
        System.out.println(encrypt);
        System.out.println(encrypt("hanjing123_",publicKey));

    }

    @Test
    public void testHash(){
        String text = "1259019009@qq.com";

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(text.getBytes());

            // 将字节数组转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            System.out.println("Hashed text: " + hexString.toString());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
