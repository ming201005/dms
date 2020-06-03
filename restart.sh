#!/bin/sh

PROJECT_PATH=/usr/local/share/applications/
PROJECT_NAME=api-service-0.0.1-SNAPSHOT.jar
PROJECT_ALL_LOG_NAME=niudao.log
# stop process
tpid=`ps -ef|grep $PROJECT_NAME|grep -v grep|grep -v kill|awk '{print $2}'`
if [ ${tpid} ]; then
    echo '停止服务...'
    # 是先关闭和其有关的程序,再将其关闭
    kill -15 $tpid
fi
sleep 5

tpid=`ps -ef|grep $PROJECT_NAME|grep -v grep|grep -v kill|awk '{print $2}'`
if [ ${tpid} ]; then
    echo '已杀掉进程!'
    kill -9 $tpid
else
    echo '停止服务成功!'
fi

# start process
tpid=`ps -ef|grep $PROJECT_NAME|grep -v grep|grep -v kill|awk '{print $2}'`
if [ ${tpid} ]; then
    echo '牛刀应用已经在运行...'
else
    echo '牛刀应用没有运行...'

    nohup java -jar $PROJECT_PATH$PROJECT_NAME>> ist.log &
    echo Start Success!
    sleep 2
    tail -f $PROJECT_PATH$PROJECT_ALL_LOG_NAME
    echo '牛刀应用启动成功...'
fi