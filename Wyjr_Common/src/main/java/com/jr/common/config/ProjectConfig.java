package com.jr.common.config;

import java.util.HashMap;
import java.util.Map;

public class ProjectConfig {
    //初识积分-新用户
    public static final int INITNEWSCORE=50;
    public static final int INITNEWSEXPIRE=30;


    //Redis信息
/*    public static final String REDISHOST="10.8.161.43";
    public static final int REDISPORT=6379;
    public static final String REDISPASS="";*/

    //Redis信息
    public static final String REDISHOST="39.105.189.141";
    public static final int REDISPORT=6380;
    public static final String REDISPASS="qfjava";

    //Redis常用的key的设置
    public static final String SMSPRELIMIT="smspre:";//记录手机号一分钟只能发一次 smspre:180515990152 key
    public static final String SMSPREDAY="smsday:";//记录手机号一天只能发20条 smsday:18515990152
    public static final String SMSCODE="smscode:";//
    public static final String TOKENJWT="jwt:";//记录令牌  有效期 30分钟
    public static final String TOKENPHONE="user:";//记录手机号对应的令牌  有效期 30分钟
    public static final String USERLOGINCOUNT="uc:";// uc:手机号  次数  10分钟
    public static final String USERSD="userfreeze:";//手机号 所有冻结的手机号
    public static final String SIGNKEY="usign:ljb";//记录每天签到  Set集合 内容 手机号
    public static final String TOKENHEAD="usertoken";//请求消息头的名称，记录令牌 前端

    //短信配置
    public static final String SMSKEY="c3ce2a94f03df2477f160c2e591c97ac";
    public static final String SMSTEMPID="165171";

    public static Map<Integer,String> projects;
    static {
        projects=new HashMap<>();
        projects.put(10001,"我的检人");

    }

    //激活地址
    public static final String ACTIVEURL="";
    public static final String AESKEYACTIVECODE="Sr766D1d0ir+q61J2ho7rQ==";


    //资源文件的前缀
    public static final String RESOURCEURL="http://localhost:9906/wyjrresource/";


    //OSS配置
    // Endpoint以杭州为例，其它Region请按实际情况填写。

    public static final String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    public static final String accessKeyId = "LTAI7q8oJCFvfIHU";
    public static final String accessKeySecret = "3bbb4dXVmfpNdBavpzjX2XVwGe8dT3";
    public static final String bucketName = "zhangyi01";

    // 检人信息的浏览量
    public static final  String  PAGEVIEW = "pageview:";

    //问答状态相关常量
    //未采纳状态
    public static final Integer AdoptState = 1;
    //采纳状态
    public static final Integer NoAdoptState = 0;
}
