1、请先导入数据库，请使用mysql8，如果是5版本，请转换相关的字符

2、请更改相关的数据库源链接；

3、默认的登录账号是：admin，密码是：000000

4、请使用nginx配置一个资源服务器，以便前端项目访问。
   相关的nginx配置可以看nginx.conf,可以引“niudao-server.conf”
   如，在nginx主配置文件引入：
       #导入牛刀服务配置
       include niudao/*.conf;  
       #或者：
       include niudao/niudao-server.conf
       
 5、nginx的启动、停止相关命令
 
 启动 ：sudo nginx 
 重启：nginx -s reload
 nginx -t 测试配置文件修改是否正常
 
 ——————————————
 
 a、查询Nginx主线程
   ps -el|grep nginx
 b、正常停止
   sudo kill -QUIT 进程号
 c、快速停止
   sudo kill -TERM 进程号
   