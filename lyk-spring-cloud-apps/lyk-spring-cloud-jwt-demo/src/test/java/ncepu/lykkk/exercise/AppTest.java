package ncepu.lykkk.exercise;

import static org.junit.Assert.assertTrue;

import cn.hutool.core.io.FileUtil;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.InputStream;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    /**
     * 通过jjwt生成和解析jwt令牌，不使用签名算法
     */
    @Test
    public void test1()
    {
        //用于封装jwt的header部分
        Map header = new HashMap();
        header.put("alg","none");//不使用签名算法
        header.put("typ","JWT");//指定令牌的类型 如果是jwt令牌统一都写为JWT

        //用于封装jwt的有效载荷
        Map body = new HashMap();
        body.put("userId","100");
        body.put("account","admin");
        body.put("role","admin");

        //生成jwt令牌
        //id可以不写
        String jwt = Jwts.builder().setHeader(header).setClaims(body).setId("101").compact();
        //jwt: eyJ0eXAiOiJKV1QiLCJhbGciOiJub25lIn0.eyJyb2xlIjoiYWRtaW4iLCJ1c2VySWQiOiIxMDAiLCJhY2NvdW50IjoiYWRtaW4iLCJqdGkiOiIxMDEifQ.
        System.out.println(jwt);

        //使用jjwt提供的API来解析jwt令牌
        Jwt result = Jwts.parser().parse(jwt);
        Header header1 = result.getHeader();
        Object body1 = result.getBody();
        //header1: {typ=JWT, alg=none}
        System.out.println(header1);
        //body1: {role=admin, userId=100, account=admin, jti=101}
        System.out.println(body1);
    }

    //通过jjwt生成和解析jwt令牌，使用HS256签名算法（对称加密）
    @Test
    public void test2(){
        //用于封装jwt的header部分
        Map header = new HashMap();
        header.put("alg", SignatureAlgorithm.HS256.getValue());//不使用签名算法
        header.put("typ","JWT");//指定令牌的类型 如果是jwt令牌统一都写为JWT

        //用于封装jwt的有效载荷
        Map body = new HashMap();
        body.put("userId","100");
        body.put("account","admin");
        body.put("role","admin");

        //生成jwt令牌
        //id可以不写
        String jwt = Jwts.builder().setHeader(header).setClaims(body).setId("101").signWith(SignatureAlgorithm.HS256,"lykkk").compact();
        //jwt: eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiYWRtaW4iLCJ1c2VySWQiOiIxMDAiLCJhY2NvdW5
        // 0IjoiYWRtaW4iLCJqdGkiOiIxMDEifQ.AbbDNbvpQ8_mC61Ru6PHXH6sRveaNsiURI-eTE_GlTY
        System.out.println(jwt);

        //使用jjwt提供的API来解析jwt令牌
        Jwt result = Jwts.parser().setSigningKey("lykkk").parse(jwt);
        Header header1 = result.getHeader();
        Object body1 = result.getBody();
        //header1: {typ=JWT, alg=HS256}
        System.out.println(header1);
        //body1: {role=admin, userId=100, account=admin, jti=101}
        System.out.println(body1);
    }

    //生成一对公钥和私钥，用于RS256
    @Test
    public void test4() throws Exception{
        //自定义随机密码
        String password = "lykkk";

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom(password.getBytes());
        keyPairGenerator.initialize(1024,secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();

        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();

        FileUtil.writeBytes(publicKeyBytes,"F:\\SpringCloudProjects\\spring-cloud-exercise\\lyk-spring-cloud-apps\\lyk-spring-cloud-jwt-demo\\src\\main\\resources\\pub.key");
        FileUtil.writeBytes(privateKeyBytes,"F:\\SpringCloudProjects\\spring-cloud-exercise\\lyk-spring-cloud-apps\\lyk-spring-cloud-jwt-demo\\src\\main\\resources\\pri.key");
    }

    //通过jjwt生成和解析令牌 使用RS256签名算法
    @Test
    public void test5() throws Exception{
        //用于封装jwt的header部分
        Map header = new HashMap();
        header.put("alg", SignatureAlgorithm.RS256.getValue());//不使用签名算法
        header.put("typ","JWT");//指定令牌的类型 如果是jwt令牌统一都写为JWT

        //用于封装jwt的有效载荷
        Map body = new HashMap();
        body.put("userId","100");
        body.put("account","admin");
        body.put("role","admin");

        //私钥生成jwt令牌时需要使用私钥
        PrivateKey privateKey = getPriKey();

        //生成jwt令牌
        //id可以不写
        String jwt = Jwts.builder()
                        .setHeader(header)
                        .setClaims(body).setId("101")
                        .signWith(SignatureAlgorithm.RS256,privateKey)
                        .compact();
        //jwt: eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.
        // eyJyb2xlIjoiYWRtaW4iLCJ1c2VySWQiOiIxMDAiLCJhY2NvdW50IjoiYWRtaW4iLCJqdGkiOiIxMDEifQ.
        // b5nzju3z14r0wMK_ON839AFpTXfnOPf_EDl70apmqXrEAqEMnTnTyjpBR8DUAzmd2e8rBrB1MB7z-A0WDZDXFhJ0JuSwDghonPp9thPFpK
        // n4Mk5wL_AD-86v8Zy5NL9iZosi1N324-HyrDDT8x4J4xaZCuByW6uucV7EUk1NqJk
        System.out.println(jwt);

        PublicKey publicKey = getPubKey();
        //使用jjwt提供的API来解析jwt令牌
        Jwt result = Jwts.parser().setSigningKey(publicKey).parse(jwt);
        Header header1 = result.getHeader();
        Object body1 = result.getBody();
        //header1: {typ=JWT, alg=RS256}
        System.out.println(header1);
        //body1: {role=admin, userId=100, account=admin, jti=101}
        System.out.println(body1);
    }

    //获取私钥
    public PrivateKey getPriKey() throws Exception{
        InputStream resourceAsStream =
                this.getClass().getClassLoader().getResourceAsStream("pri.key");
        DataInputStream dis = new DataInputStream(resourceAsStream);
        byte[] keyBytes = new byte[resourceAsStream.available()];
        dis.readFully(keyBytes);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }

    //获取公钥
    public PublicKey getPubKey() throws Exception{
        InputStream resourceAsStream =
                this.getClass().getClassLoader().getResourceAsStream("pub.key");
        DataInputStream dis = new DataInputStream(resourceAsStream);
        byte[] keyBytes = new byte[resourceAsStream.available()];
        dis.readFully(keyBytes);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }


}
