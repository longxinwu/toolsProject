package com.lonxinwu.util;

import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class KeyToolUtil {
    public static void main(String args[]) throws Exception{
        System.out.println("从证书获取的公钥为:" + getPublicKey("D:/projects/toolsProject/keys/publickey.cer"));
        System.out.println("从证书获取的私钥为:" + getPrivateKey("D:/projects/toolsProject/keys/mykey.jks", "mykey", "123456", "123456"));
    }

    private static String getPublicKey(String cerPath) throws Exception {
        CertificateFactory certificatefactory = CertificateFactory.getInstance("X.509");
        FileInputStream fis = new FileInputStream(cerPath);
        X509Certificate Cert = (X509Certificate) certificatefactory.generateCertificate(fis);
        PublicKey pk = Cert.getPublicKey();
        String publicKey = new BASE64Encoder().encode(pk.getEncoded());
        return publicKey;
    }

    private static String getPrivateKey(String storePath, String alias, String storePw, String keyPw) throws Exception {
        FileInputStream is = new FileInputStream(storePath);
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(is, storePw.toCharArray());
        is.close();
        PrivateKey key = (PrivateKey) ks.getKey(alias, keyPw.toCharArray());
        //System.out.println("privateKey:" + new BASE64Encoder().encode(key.getEncoded()));
        String privateKey = new BASE64Encoder().encode(key.getEncoded());
        return privateKey;
    }

}
