#!/bin/bash


# config

project_name=pj_data_compass
path=$(cd `dirname $0`/../;pwd)
jvm_home=/usr/local/java

# ---------------------------------------------------------------------

echo $path

# the file saved process id
pid=$path"/pid/pid.file"
echo $pid

cd $path
nohup $jvm_home/bin/java -Xms1g -Xmx1g -cp .:./lib/*:./jar/pj_data_compass-0.0.1-SNAPSHOT.jar com.yixin.bidata.compassserver.CompassServerApplication>  $path"/log/$project_name.out" 2>&1 &

# Is Sucess?
if [ $? -eq 0 ]
then
        echo $!>$pid
        echo "Start Success ...."
else
        echo "Start Fail ..."
fi
