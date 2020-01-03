package com.panda.SpringJspWeb.kt

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

fun main(args: Array<String>) {
    //总用户
    var originUsers = "C:\\Users\\toyz\\Desktop\\kt\\02379497391.txt"
    //总用户转成sql格式
    var allUsersFile="C:\\Users\\toyz\\Desktop\\kt\\allUsersFile.txt"
    //已升级用户
    var upgradeUser="C:\\Users\\toyz\\Desktop\\kt\\upgradeUser.txt"
    //未升级用户
    var noupgradeUser="C:\\Users\\toyz\\Desktop\\kt\\noupgradeUser.txt"
    //未升级用户sql格式
    var noupgradeUserSql="C:\\Users\\toyz\\Desktop\\kt\\noupgradeUserSql.txt"
    //融合用户
    var mergeredUser="C:\\Users\\toyz\\Desktop\\kt\\mergeredUser.txt"
    //未升级未融合用户
    var nomergeredUser="C:\\Users\\toyz\\Desktop\\kt\\nomergeredUser.txt"
    //将原用户拼成查询sql的格式写到allUsersFile
    IoUtils.write(IoUtils.readLine(originUsers),allUsersFile,true)
    //比较sql查出来的所有已升级的用户upgradeUser,找出与总用户的差集写到noupgradeUser
    IoUtils.write(CollectUtils.difference(IoUtils.readLine(originUsers), IoUtils.readLine(upgradeUser)),noupgradeUser)
    //将未升级的用户拼成插叙sql的格式写到noupgradeUserSql
    IoUtils.write(IoUtils.readLine(noupgradeUser),noupgradeUserSql,true)
    //比较sql查询出来的融合的账户,将未升级未融合的写入nomergeredUser
    IoUtils.write(CollectUtils.difference(IoUtils.readLine(noupgradeUser), IoUtils.readLine(mergeredUser)),nomergeredUser)


}

