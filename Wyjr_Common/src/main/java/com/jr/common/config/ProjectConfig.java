package com.jr.common.config;

public class ProjectConfig {


    //Redis信息
    public static final String REDISHOST="10.8.161.43";
    public static final int REDISPORT=6379;
    public static final String REDISPASS="";

    //Redis常用的key的设置
    public static final String SMSPRELIMIT="smspre:";//记录手机号一分钟只能发一次 smspre:180515990152 key
    public static final String SMSPREDAY="smsday:";//记录手机号一天只能发20条 smsday:18515990152
    public static final String SMSCODE="smscode:";//
    public static final String TOKENJWT="jwt:";//记录令牌  有效期 30分钟
    public static final String TOKENPHONE="user:";//记录手机号对应的令牌  有效期 30分钟
    public static final String USERLOGINCOUNT="uc:";// uc:手机号  次数  10分钟
    public static final String USERSD="userfreeze:";//手机号 所有冻结的手机号
    public static final String SIGNKEY="usign:ljb";//记录每天签到  Set集合 内容 手机号


    //资源文件的前缀
    public static final String RESOURCEURL="http://localhost:9804/ljbresource/";


    //OSS配置
    // Endpoint以杭州为例，其它Region请按实际情况填写。

    public static final String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    public static final String accessKeyId = "LTAI7q8oJCFvfIHU";
    public static final String accessKeySecret = "3bbb4dXVmfpNdBavpzjX2XVwGe8dT3";
    public static final String bucketName = "zhangyi01";

    // 检人信息的浏览量
    public static final  String  PAGEVIEW = "pageview:";
}
