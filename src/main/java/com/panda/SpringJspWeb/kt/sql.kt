package com.panda.SpringJspWeb.kt

import java.io.BufferedWriter
import java.io.FileOutputStream
import java.io.OutputStreamWriter

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

fun model(schema : Int, table : Int, model : String, dropModel : String){
    val writer = BufferedWriter(OutputStreamWriter(FileOutputStream("C:\\Users\\toyz\\sharding\\user-info.sql")))
    val writer1 = BufferedWriter(OutputStreamWriter(FileOutputStream("C:\\Users\\toyz\\sharding\\user-info-drop.sql")))
    var j = 0
    for (i in 1..schema){
        while (j < table){
            writer.write(String.format(model,i,j))
            writer.newLine()
            writer.newLine()
            writer.flush()

            writer1.write(String.format(dropModel,i,j))
            writer1.newLine()
            writer1.newLine()
            writer1.flush()

            j++
            if (j % 10 ==0 )
                break
        }
    }

}

fun main(args: Array<String>) {
    var model = "CREATE TABLE `passport%s`.`sso_user_info_%s` (\n" +
            "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `ppuid` varchar(128) NOT NULL COMMENT '用户唯一标识',\n" +
            "  `user_name` varchar(100) NOT NULL COMMENT '用户名',\n" +
            "  `name` varchar(100) DEFAULT NULL COMMENT '姓名',\n" +
            "  `index_key` varchar(20) DEFAULT NULL COMMENT '老的分库分表规则',\n" +
            "  `face_pic` varchar(50) DEFAULT NULL COMMENT '用户头像，命名规则PPUID.gif',\n" +
            "  `birthday` datetime DEFAULT NULL COMMENT '生日',\n" +
            "  `sex` tinyint(1) NOT NULL DEFAULT '0' COMMENT '性别：0未知 1男 2女',\n" +
            "  `mobile_phone_no` varchar(50) DEFAULT NULL COMMENT '手机',\n" +
            "  `home_phone_no` varchar(50) DEFAULT NULL COMMENT '家庭电话',\n" +
            "  `office_phone_no` varchar(50) DEFAULT NULL COMMENT '办公室电话',\n" +
            "  `post_code` varchar(20) DEFAULT NULL COMMENT '邮政编码',\n" +
            "  `country` varchar(20) DEFAULT NULL COMMENT '国家',\n" +
            "  `province` varchar(20) DEFAULT NULL COMMENT '省份',\n" +
            "  `city` varchar(20) DEFAULT NULL COMMENT '城市',\n" +
            "  `town` varchar(20) DEFAULT NULL COMMENT '区、县',\n" +
            "  `street` varchar(20) DEFAULT NULL COMMENT '乡、镇、街道',\n" +
            "  `other_email` varchar(250) DEFAULT NULL COMMENT '其他邮件',\n" +
            "  `qq` varchar(20) DEFAULT NULL COMMENT 'qq',\n" +
            "  `msn` varchar(200) DEFAULT NULL COMMENT 'msn',\n" +
            "  `profession` varchar(250) DEFAULT NULL COMMENT '职业',\n" +
            "  `home_page` varchar(250) DEFAULT NULL COMMENT '主页',\n" +
            "  `personal_texte` text COMMENT '签名档',\n" +
            "  `favorite` text COMMENT '个人视频喜好',\n" +
            "  `bln_update_user_detail` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否第一次详细填写用户信息',\n" +
            "  `education` varchar(50) DEFAULT NULL COMMENT '学历',\n" +
            "  `income` varchar(50) DEFAULT NULL COMMENT '收入',\n" +
            "  `create_time` datetime DEFAULT NULL COMMENT '创建时间',\n" +
            "  `update_time` datetime DEFAULT NULL COMMENT '更新时间',\n" +
            "  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除主键 (0 :未删除, 1: 已删除)',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `idx_unq_uid` (`ppuid`),\n" +
            "  UNIQUE KEY `idx_unq_user` (`user_name`),\n" +
            "  KEY `idx_name` (`name`),\n" +
            "  KEY `idx_buud` (`bln_update_user_detail`),\n" +
            "  KEY `idx_user` (`user_name`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8\n" +
            "COMMENT '用户信息表-new';"
    val dropModel = "DROP TABLE IF EXISTS `passport%s`.`sso_user_info_%s`;"
    model(8,80,model,dropModel)
}