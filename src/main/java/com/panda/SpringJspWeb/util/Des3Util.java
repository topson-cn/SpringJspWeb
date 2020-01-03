package com.panda.SpringJspWeb.util;

import lombok.SneakyThrows;
import org.apache.commons.codec.binary.Base64;
import org.apache.shiro.codec.Hex;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.net.URLEncoder;
import java.security.spec.AlgorithmParameterSpec;
 
/**
 * Des加解密工具类
 *
 * @author toyz
 */
public class Des3Util {
 

    static AlgorithmParameterSpec iv = null;// 加密算法的参数接口，IvParameterSpec是它的一个实现
    private static SecretKey key = null;

    public Des3Util(String desKey, String desIv) throws Exception {
        byte[] DESkey = Hex.decode(desKey);
        byte[] DESIV = Hex.decode(desIv);
        iv = new IvParameterSpec(DESIV);// 设置向量
        DESedeKeySpec KeySpec = new DESedeKeySpec(DESkey);
        SecretKeyFactory KeyFactory = SecretKeyFactory.getInstance("DESede");// 获得密钥工厂
        key = KeyFactory.generateSecret(KeySpec);// 得到密钥对象
    }

    /**
     * 加密
     * @param data 待加密的数据
     * @return 加密后的数据
     */
    public String encode(String data) throws Exception {
        Cipher enCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");// 得到加密对象Cipher
        enCipher.init(Cipher.ENCRYPT_MODE, key, iv);// 设置工作模式为加密模式，给出密钥和向量
        byte[] pasByte = enCipher.doFinal(data.getBytes("utf-8"));
        return Base64.encodeBase64String(pasByte);
    }


    /**
     * 解密
     * @param data  解密前的数据
     * @return 解密后的数据
     */
    public String decode(String data) throws Exception {
        Cipher deCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        deCipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] pasByte = deCipher.doFinal(Base64.decodeBase64(data));
        return new String(pasByte, "UTF-8");
    }

    /**
     * 加密
     * @param data 待加密的数据
     * @return 加密后的数据
     */
    @SneakyThrows
    public static String encode(String desKey, String desIv,String data){
        byte[] DESkey = Hex.decode(desKey);
        byte[] DESIV = Hex.decode(desIv);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(DESIV);
        DESedeKeySpec KeySpec = new DESedeKeySpec(DESkey);
        SecretKeyFactory KeyFactory = SecretKeyFactory.getInstance("DESede");
        SecretKey secretKey = KeyFactory.generateSecret(KeySpec);
        Cipher enCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");// 得到加密对象Cipher
        enCipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);// 设置工作模式为加密模式，给出密钥和向量
        byte[] pasByte = enCipher.doFinal(data.getBytes("utf-8"));
        return Base64.encodeBase64String(pasByte);
    }

    /**
     * 解密
     * @param data  解密前的数据
     * @return 解密后的数据
     */
    @SneakyThrows
    public static String decode(String desKey, String desIv,String data){
        byte[] DESkey = Hex.decode(desKey);
        byte[] DESIV = Hex.decode(desIv);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(DESIV);
        DESedeKeySpec KeySpec = new DESedeKeySpec(DESkey);
        SecretKeyFactory KeyFactory = SecretKeyFactory.getInstance("DESede");
        SecretKey secretKey = KeyFactory.generateSecret(KeySpec);
        Cipher deCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        deCipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        byte[] pasByte = deCipher.doFinal(Base64.decodeBase64(data));
        return new String(pasByte, "UTF-8");
    }


    public static void main(String[] args) throws Exception {
//        String s1 = new String(HexUtils.fromHexString("29028A7698EF4C6D3D252F02F4F79D5815389DF18525D326"));
        Des3Util desUtil = new Des3Util("29028A7698EF4C6D3D252F02F4F79D5815389DF18525D326","70706C6976656F6B");
        String encode = desUtil.encode("username=19256321411&password=123456");
        System.out.println(URLEncoder.encode(encode, "UTF-8"));
//        String decode = desUtil.decode("dyQuoT3iUsLU0+qvuvl9IvsMwD7kslV5ne4CI7OVFSTAKHU1W1GVqvOju264jWhzijvfG+KVFrO1l2/2li+Bdj1iJJTXqy8x3ZxXaDi/8RFRGiOhHhSYYEeZnz8VVKEmEdY3WVL7u4u7sUT7C6PZ/640UzKDcbhP1wDcfdhDzK1e0/sDOyf9egFMYQktLtYSUHmlIypXP6YDhQtGPsd7FaF6HL6gAqcv5rYEMpn2LfNLiDvI1X1ritCeA/QtJ7PZ1qHbtdruZYpC8NuRneKAg3R093Po8o2wQASbJJc9MQr9FlIK4aIpn3eZmgmQjLc9uCnpkW96GwI=");
//        String s = new String(Hex.decode("29028A7698EF4C6D3D252F02F4F79D5815389DF18525D326"),"utf-8");
//        System.out.println(1);
//
//        String aaa = "+Ey6WR3pg72W92h7wSKJW6AEHes246WDRn6NTlYc+12gu0jFy3uMo0ipxVUni+ox4TH9VwlPwYQJNm2abxrKYnOfY1F4olfYQe3GNTi5STZHYjfRC5xsoLEbeaDz3H24VQre2B8rjaER5cWoDwawwMKlzLxyCTKuTyv03ggBtn0ZA56knM2Iki3y6fPRGSxqbrCFr7BLfvekn8/u2M7l7U9TRDaR9k/SkJDr8NTtnKY+RwYNWFe+1+8gvFyWjSbr8dMWlT9pI8FB/nrC5T+DA+Wr4QHpRq7ZAR5MH/Rpczwu99Chi0WvTDJ83ZsRwyMGTUdxFVK81Y8JeVgk1IQdm1RcWVuXe3wG2S1Ttw3tV8z8hAcSsHV/uulCJ3J/KWhIRaYiMH/okOCLHHWw5a9VaNndE2enjXNH4J80NPAdUyhDBfn3whU2t7NIlJmM1WocJOlWuqq9Q7vVScU8iP9gOWSBSMpzAep3k+Vem8BCu/HSSvqqaTtefh0aZ+rwCqcQEwLiNR9SDJazVDxJDiRD2fSou0OnDCX1zT8onXDLrE/ZO98qLuAWi8dK+k+ouT56I/Sb3nUaXA/N9gKkF0LLvVX/qcmC8KASmtzKGRkElpqYqSN6pT+TcYU2t1pM9XHKIXTb7G1GrvCjJiQx83/571t2wWA55JZY/SF93OG59Wl70v5uDB/Ij66vxM6UJ864corbTCPQdb9qi1/pbzAfGYkfFAfP3kpQD479xDMroA9BQ3VGEBEHXhsNbvtI65HmBsD9Li8OpNcvsg51Kw5v6YU54TwUEdAu9tRXHKjadfkcMKSbqpOKc9QbjJcgSgZCFO19+aqjBV3ZkmKisNyoCzvNHyKjPgLUyKq/TgfbPy18E5LlBa8iwSYEGVV1248DmxmqGFLhRMY=";
//        System.out.println(desUtil.decode(aaa));

    }

}
