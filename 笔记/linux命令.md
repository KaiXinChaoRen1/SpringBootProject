### linux命令
有用的命令随笔:

    查看操作系统内核信息---------uname -a
    查看操作系统版本信息----------cat  /proc/version
            引申/proc:
                /proc 目录是一个虚拟文件系统，它提供了一种机制来访问内核和进程信息。这个目录下的信息并不是存储在磁盘上的文件，而是由内核在运行时生成的。/proc 目录通常包含以下几类信息：
                进程信息：每个运行中的进程在 /proc 目录下都有一个以其进程ID命名的目录，例如 /proc/1234，其中包含了该进程的详细信息，如运行状态、内存使用情况、打开的文件等。
                系统信息：/proc 目录下还有一些特殊的文件，如 /proc/cpuinfo、/proc/meminfo、/proc/version 等，它们提供了关于CPU、内存和内核版本的信息。
                设备信息：/proc 目录还包含了设备驱动程序的信息，例如 /proc/ide、/proc/bus 等。
                内核配置：/proc 目录下的某些文件可以用来查看和修改内核的运行时配置，例如 /proc/sys 目录。
                网络信息：/proc 目录下的 /proc/net 包含了网络相关的统计信息和配置。
                文件系统信息：/proc/mounts 显示了当前系统上挂载的文件系统列表。

    ls -l /proc/xxx         ------> 查看xxx进程号,对应相关信息,包括位置等
    ll    /proc/xxx         ------>查看xxx进程号,对应相关信息,包括位置等


    
    ls [ -l  -a -h  ] [指定路径]         ------> h显示详细大小

    mkdir 【-p】 xxx        ------>make directory  -p代表创建不存在的父目录，适用于一次性创建多级目录

    touch  xxx/xxx.txt      ------>创建文件

    cat   xxx/xxx.txt       ------>一次性查看所有文件内容

    more xxx/xxx.txt        ------>翻页查看文件内容，空格翻页

    .                       ------>当前路经

    ..                      ------>上一级

    ~                       ------>HOME

    cd                      ------>Change Directory

    pwd  				    ------> print work directory

    locate  "*yml*.jar"		------>  查找名称中带yml且以.jar结尾的文件

    find  /   -name  "*yml*.jar"		    ------>   find [路径] [匹配条件] [动作]

    top -p  进程id     		                ------> 查看进程的cpu /内存占用

    jstat  -gcutil   xxx    1000  20        ------> 监控xxx进程号JVM的命令

    tar zxvf FileName.tar.gz   ------>  解压: 

    ps -p  xxx -o  ppid=       ------> 查询一个进程的父进程:  




在 Vim中搜索文本：
    打开文件后，进入正常模式（Normal Mode）。
    输入/符号，进入搜索模式（Search Mode）。
    输入你想要搜索的文本。
    按下回车键，Vim 会搜索并高亮显示第一个匹配的文本。

    如果你想搜索下一个匹配项，可以按n键。
    如果你想搜索上一个匹配项，可以按N键

在 Vim中撤回操作：
    在 Vim 中，你可以使用u命令来撤回上一个操作。这个命令在正常模式下使用。每次执行u命令，Vim 都会撤回你的上一个编辑操作，包括插入、删除或修改字符等。如果你执行了一系列的编辑操作，你可以连续按u键来逐步撤回这些操作，直到你到达希望回到的状态。 
    此外，如果你想撤回多个步骤，你可以使用U;命令。这个命令可以撤回你在当前行上的所有修改，使该行恢复到你开始编辑它之前的状态。






        
        
        
    