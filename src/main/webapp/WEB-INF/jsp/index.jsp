<%--
  Created by IntelliJ IDEA.
  User: toyz
  Date: 2018/11/13
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<script src="static/crypto-js.js"></script>
<script src="static/lgq/js/jquery.js"></script>
<script>
    function des(message) {
        var keyHex = CryptoJS.enc.Hex.parse('29028A7698EF4C6D3D252F02F4F79D5815389DF18525D326');
        var decrypt_str = CryptoJS.TripleDES.decrypt(message, keyHex, {
            iv:CryptoJS.enc.Hex.parse('70706C6976656F6B'),
            mode: CryptoJS.mode.CBC,
            padding: CryptoJS.pad.Pkcs7});
        console.log(decrypt_str.toString(CryptoJS.enc.Utf8));

        CryptoJS.TripleDES.encrypt
    }

    $("#mmm").on("click", function () {
        des($("#dada").val())
    })
</script>
<body>
<button id="mmm" onclick="des('dyQuoT3iUsLU0+qvuvl9IvsMwD7kslV5ne4CI7OVFSTAKHU1W1GVqvOju264jWhzijvfG+KVFrO1l2/2li+Bdj1iJJTXqy8x3ZxXaDi/8RFRGiOhHhSYYEeZnz8VVKEmEdY3WVL7u4u7sUT7C6PZ/640UzKDcbhP1wDcfdhDzK1e0/sDOyf9egFMYQktLtYSUHmlIypXP6YDhQtGPsd7FaF6HL6gAqcv5rYEMpn2LfNLiDvI1X1ritCeA/QtJ7PZ1qHbtdruZYpC8NuRneKAg3R093Po8o2wQASbJJc9MQr9FlIK4aIpn3eZmgmQjLc9uCnpkW96GwI=')">解</button>
</body>
</html>
