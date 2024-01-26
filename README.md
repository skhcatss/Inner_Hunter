# Inner_Hunter
![即时AI_img](https://github.com/skhcatss/Inner_Hunter/assets/157777995/8de60785-a67f-4667-a127-526cb62b9cec)


Inner_Huner是Qianxin-Hunter鹰图（内网和外网）的一款空间测绘gui图形界面化工具，使用Java语言进行开发

# 🤖🤖简介

Inner_Huner是一款由Qianxin-Hunter鹰图开发的强大工具，它基于JavaFX框架，提供了一个用户友好的图形界面。这款工具专注于空间测绘，让复杂的操作变得简单直观。通过Inner_Huner，用户可以轻松地进行内网和外网的测绘工作，从而更好地管理和利用网络资源。无论是初学者还是专业人士，Inner_Huner都提供了一个简单易用的界面，使得空间测绘工作更加高效和便捷。



本工具基于 Hunter 的 API 进行封装，使用时需要用户/内网用户的 API key。
本工具基于JDK17、JavaFx 17.0.2进行开发
JavaFx下载地址：https://gluonhq.com/products/javafx/


# 😈😈基本使用

首先需要修改hunter.ini文件，将自己的APIKEY写入该文件
<img width="682" alt="image" src="https://github.com/skhcatss/Inner_Hunter/assets/157777995/31a57010-ce95-425d-a25d-13aa833c609c">

使用 Java 运行 Inner_Hunter.jar 文件，需要使用 JDK17，JavaFx17.0.10 运行

```bash
/Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home/bin/java  --module-path /Users/skhcats/Desktop/javafx-sdk-17.0.10/lib/ --add-modules javafx.controls,javafx.fxml -jar demo.jar
```

![image-20240126125219261](/Users/skhcats/Library/Application Support/typora-user-images/image-20240126125219261.png)



#检索语法：输入Hunter的语法

## 热门语法

| 语法说明                                      | 检索语法（新）                                           | 检索语法（旧）                                |
| --------------------------------------------- | -------------------------------------------------------- | --------------------------------------------- |
| 查询包含IP标签"CDN"的资产 (查看枚举值)        | ip.tag="CDN"newhot特色                                   | -                                             |
| 查询与baidu.com:443网站的特征相似的资产       | web.similar="baidu.com:443"hot特色                       | similar="baidu.com:443"                       |
| 查询网站icon与该icon相似的资产                | web.similar_icon=="17262739310191283300"hot特色          | -                                             |
| 查询与该网页相似的资产                        | web.similar_id="3322dfb483ea6fd250b29de488969b35"hot特色 | similar_id="3322dfb483ea6fd250b29de488969b35" |
| 查询包含资产标签"登录页面"的资产 (查看枚举值) | web.tag="登录页面"newhot特色                             | -                                             |
| 搜索主域为"qianxin.com"的网站                 | domain.suffix="qianxin.com"hot                           | domain_suffix="qianxin.com"                   |
| 查询网站icon与该icon相同的资产                | web.icon="22eeab765346f14faf564a4709f98548"hot           | icon="22eeab765346f14faf564a4709f98548"       |
| 搜索开放端口大于2的IP（支持等于、大于、小于） | ip.port_count>"2"hot                                     | port_count>"2"                                |
| 搜索web资产                                   | is_web=truenewhot                                        | -                                             |
| 搜索证书可信的资产                            | cert.is_trust=truehot                                    | -                                             |

更加详细语法请参考：https://hunter.qianxin.com/home/helpCenter?r=8-1



#每页资产条数，可选择10、20、50、100以节省积分

![image-20240126125600600](/Users/skhcats/Library/Application Support/typora-user-images/image-20240126125600600.png)



#鹰图模式选择：内部鹰图和外部鹰图，外部鹰图适合普通用户使用，内部鹰图适用于特殊用户使用

![image-20240126125812786](/Users/skhcats/Library/Application Support/typora-user-images/image-20240126125812786.png)



#资产类型：web资产，非web资产和全部资产，根据特定需求去进行查询

![image-20240126125901080](/Users/skhcats/Library/Application Support/typora-user-images/image-20240126125901080.png)

#API-KEY 不支持页面编辑，默认读取 hunter.ini 配置文件

![image-20240126125954120](/Users/skhcats/Library/Application Support/typora-user-images/image-20240126125954120.png)



#页码 需要输入一个正整数 

![image-20240126130115608](/Users/skhcats/Library/Application Support/typora-user-images/image-20240126130115608.png)



#开始时间，结束时间可以直接进行选择

![image-20240126130208559](/Users/skhcats/Library/Application Support/typora-user-images/image-20240126130208559.png)



#查询功能，输入检索语法，每页资产条数，鹰图模式，资产类型，页码，开始时间，结束时间后点击查询，可以将相关信息展示在图表中，左下方会显示当前查询消耗的积分以及今日剩余积分数量，右侧日志栏区会显示当前查询状态以及一些报错信息

![image-20240126130334698](/Users/skhcats/Library/Application Support/typora-user-images/image-20240126130334698.png)



#导出功能，将当前查询数据导出.csv格式文件，导出完成会在右侧打印文件导出位置，导出内容如下：

![image-20240126130615336](/Users/skhcats/Library/Application Support/typora-user-images/image-20240126130615336.png)

![image-20240126130733782](/Users/skhcats/Library/Application Support/typora-user-images/image-20240126130733782.png)



#清空内容，点击清空内容后，表格中的数据进行重置

![image-20240126130828672](/Users/skhcats/Library/Application Support/typora-user-images/image-20240126130828672.png)



#清空日志，点击清空日志后右侧的日志栏重置

![image-20240126130928904](/Users/skhcats/Library/Application Support/typora-user-images/image-20240126130928904.png)

#日志输出颜色说明

当存在错误信息时，日志栏颜色会置为红色

![image-20240126131043952](/Users/skhcats/Library/Application Support/typora-user-images/image-20240126131043952.png)

当正常运行时，日志栏会置为绿色

![image-20240126131124927](/Users/skhcats/Library/Application Support/typora-user-images/image-20240126131124927.png)

## 🗣🗣Q&A

为什么已经有很多成熟的鹰图API查询工具，自己还要写一个呢？

答：一方面满足特殊用户（内网鹰图）使用者的需求，另一方面是为了学习JavaFx的使用，以及提高Java的变成能力。



## ⚠️ 说明

如果出现了bug，请提交issue，有问题欢迎大家进行交流
