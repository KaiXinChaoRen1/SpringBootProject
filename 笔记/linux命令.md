### linux命令
有用的命令随笔:



    pwd  				    | 目前所在的工作目录的对路径名称。

    locate  "*yml*.jar"		|  查找名称中带yml且以.jar结尾的文件

    find  / -name  "*yml*.jar"		|   find [路径] [匹配条件] [动作]

    top -p  进程id     		| 查看进程的cpu /内存占用

    jstat  -gcutil   xxx    1000  20       | 监控xxx进程号JVM的命令

    tar zxvf FileName.tar.gz  |  解压: 

    ps -p  xxx -o  ppid=      | 查询一个进程的父进程:  

    ls -l /proc/xxx        | 查看xxx进程号,对应相关信息,包括位置等



安装jdk:

wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.rpm

sudo yum -y install ./jdk-17_linux-x64_bin.rpm

java -version

        
        
        
    