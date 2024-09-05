package edu.hain;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSAUtila {

    private PublicKey publicKey;
    private PrivateKey privateKey;
//894b9fe98cd84547a82db4b2d5176a84
//6bb2e0877d484d6387809c01294147dc
    public RSAUtila() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    // 后续会添加加密和解密的方法
    public String encrypt(String data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt(String data, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = Base64.getDecoder().decode(data);
        return new String(cipher.doFinal(decryptedBytes));
    }

    public static void main(String[] args) {
        try {
            RSAUtila rsaUtil = new RSAUtila();
            //3c47d57084c943f88133788b47e63884
            // b3d8ecb99fa048608379e5f4b82c51cd
            PrivateKey privateKey = getPrivateKeyFromString("3c47d57084c943f88133788b47e63884");
            PublicKey  publicKey = getPublicKeyFromString("b3d8ecb99fa048608379e5f4b82c51cd");
            String originalData = "Hello, RSA!";
            String encryptedData = rsaUtil.encrypt(originalData, rsaUtil.getPublicKey());
            String decryptedData = rsaUtil.decrypt(encryptedData, privateKey);

            System.out.println("原始数据: " + originalData);
            System.out.println("加密数据: " + encryptedData);
            System.out.println("解密数据: " + decryptedData);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static PublicKey getPublicKeyFromString(String publicKeyStr) throws Exception {
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    // 从Base64编码的字符串中获取私钥
    public static PrivateKey getPrivateKeyFromString(String privateKeyStr) throws Exception {
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }
}
