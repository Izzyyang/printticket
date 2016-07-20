# printticket module

##目录简介

* src/main
    + src/main/resources 存放数据信息的json文件
        - src/main/resources/good_info.json 存储商店所有商品信息
        - src/main/resources/discount_info.json 存储目前支持的折扣信息
    + src/main/java   主要逻辑源代码
        - /code  主要的类
        - /DiscountTypes  打折信息类
        - /util  工具类

* src/test   测试类文件夹
    + 测试读取json信息
    + 测试单个商品的没打折  95折  买二免一  三种打折方式
    + 测试两种打折方式混合
    + 测试三种打折方式混合
    + 测试多个相同商品分开列和列在一行的情况(比如: item000001重复出现三次和item000001-3的情况)


##用到的设计模式

+ 工厂模式
+ 单例模式

## 集成测试

[printticket](https://travis-ci.org/Izzyyang/printticket.svg?branch=master)

## 特点

* 可扩展性  运用了工厂模式  增加打折方式的时候比较容易扩展
* 代码整洁性 将数据和逻辑代码分开  显得干净
* 自动化  运用了gradle和ci技术   自动构建和集成测试

