# IJKMediaPlayer
基于IJKPlayer的IJKMediaPlayer

### **ijkPlayer**编译环境配置

1、编译环境

- **编译系统:** ubuntu 14.04
- **编译工具**
		1、JDK(我使用的是open-jdk7)
		2、android-NDK
		3、android-sdk
		4、 git
		5、 yasm

- **环境配置**

open-jdk 在安装之后，环境变量一般都配置好了，无需再次配置。

确保配置文件中ANDROID_SDK=xxx和ANDROID_NDK=xxx正确（注：声明路径变量的名字一定要以ANDROID_SDK和ANDROID_NDK命名，否则后边的编译会出问题，我的路径都声明在了/etc/profile中）

- **开始编译**

1、首先从Bilibili在github上的代码库中可隆一份源码
git clone https://github.com/Bilibili/ijkplayer.git ijkplayer-android （注：需要点时间下载）

2、cd ijkplayer-android (注：定位到此目录下)

3、cd config

rm module.sh

ln -s module-default.sh module.sh

cd ..

cd android/contrib

./compile-ffmpeg.sh clean
(注：这里主要是更改下播放器支持更多的CPU架构类型，大家可以根据自己的需要来更改，不一定非得用默认的)

4、sudo dpkg-reconfigure dash （注：在弹出的选项中选择NO）

5、cd ~/ijkplayer-android

./init-android.sh
（注：定位到ijkplayer-android目录下，执行脚本，去下载跟ffmpeg相关的东西，需要点等待的时间，取决于你的网速）

6、cd android/contrib

./compile-ffmpeg.sh clean

./compile-ffmpeg.sh all（注：如果你的ANDROID_SDK=xxx和ANDROID_NDK=xxx的路径没有问题话，就开始成功执行编译了。这是个漫长的等待过程）

![enter image description here](http://upload-images.jianshu.io/upload_images/145697-627c2ed3d14b0e62.png?imageMogr2/auto-orient/strip%7CimageView2/2)

7、按照上图的提示，我们回到ijkplayer-android/android的目录下，执行这个脚本
cd ..

./compile-ijk.sh all (注：如果去掉all则只会编译出armv7a架构的so文件，否则会是全部)

8、上述所有的命令全部执行成功后，现在就可以/ijkplayer-android/android/目录下的ijkplayer导入Android Studio中了


- **构建项目**

主要使用ijkplayer-java这个module；将编译生成的各种CPU架构so文件放在module main目录下的jniLibs下。编写自己的demo即可
