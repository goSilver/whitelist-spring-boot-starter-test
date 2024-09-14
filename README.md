# 白名单组件测试工程
主项目工程：https://github.com/goSilver/whitelist-spring-boot-starter

## 一、工程结构
```java
whitelist-spring-boot-starter-test
└── src
    └── main
        └── java
            ├── cn.gosilver.middleware.whitelist.test
            │   ├── interfaces
            │   │   ├── UserController.java
            │   │   └── UserInfo.java
            │   └── ApiTestApplication.java
            └── resources
                └── META-INF 
                    └── application.yml

```

测试工程主要包括启动类 ApiTestApplication、Api接口类 UserController、配置信息 application.yml，这三面内容。

另外在工程 Maven 配置中会引入到我们开发好的白名单中间件服务，如下：
```java
<dependency>
    <groupId>cn.gosilver.middleware</groupId>
    <artifactId>whitelist-spring-boot-starter</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>

```

## 二、在yml配置白名单用户
```java
server:
  port: 8081

# 白名单用户
gosilver:
  whitelist:
    users: aaa,bbb,ccc

```
以上的这种配置方式只是基于本地的配置，并没有服务端注册中心那种方式。

## 三、测试结果
白名单用户访问
接口：`http://localhost:8081/api/queryUserInfo?userId=aaa`
```java
{
    "code": "0000",
    "info": "success",
    "name": "虫虫:aaa",
    "age": 19,
    "address": "天津市东丽区万科赏溪苑14-0000"
}

```

非白名单用户访问
接口：`接口：http://localhost:8081/api/queryUserInfo?userId=123`
```java
{
    "code": "1111",
    "info": "非白名单可访问用户拦截！",
    "name": null,
    "age": null,
    "address": null
}

```


