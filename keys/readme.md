# 密钥生成
    1. keytool -genkey -alias myKey -keyalg RSA -keystore D:\projects\toolsProject\mykey.jks  -keysize 1024dirdir
    2. JKS 密钥库使用专用格式。建议使用 "keytool -importkeystore -srckeystore D:\projects\toolsProject\keys\mykey.jks -destkeystore D:\projects\toolsProject\keys\mykey.jks -deststoretype pkcs12" 迁移到行业标准格式 PKCS12。
    3. keytool -export -alias mykey -keystore D:\projects\toolsProject\keys\mykey.jks -file publickey.cer