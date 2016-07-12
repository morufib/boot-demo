# 环境搭建

1. Jdk1.8以上版本
2. 安装Eclipse和MariaDB(Demo默认数据库是MariaDB)
3. 修改com.vermisse.boot.Application第25行服务器启动端口
4. 修改application.properties中的数据库信息
5. 打包项目，使用Maven的`clean package`命令
6. 在命令行中使用`java -jar boot.jar`启动项目(压缩包太大没有上传，请自行编译)