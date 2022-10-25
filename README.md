### libgdx 使用Android Studio开发
生成工具用的是eclips插件，不太习惯，而且重要的是，有些java的类无法导包，
虽然不影响编译，但是编写比较难受，所以改成了目前默认的路径配置

### 使用gdx-setup.jar（根目录下） 初始化项目


### android
```
//多配置一个assets路径，将项目下的assets路径作为指向，方面多端共用
sourceSets {
        main {
            assets.srcDirs = ['../assets']
        }
    }
```

### desktop
```
//这个不要了，本身就是正确的
//sourceSets.main.java.srcDirs = [ "src/" ]

//改为实际对应的包名
project.ext.mainClassName = "com.mirkowu.desktop.DesktopLauncher"

```

### html
1.包名要和core一样，而且必须要有 包名/client 路径
2. build.gradle中 的 gwt配置 
```
//改为java路径
src = files(sourceSets.main.java.srcDirs)
//下面的module路径也要对应实际路径
```



### 参考文档
[文档1](https://blog.csdn.net/weixin_57846082/category_11276281.html)
[文档2](https://xiets.blog.csdn.net/article/details/50185655?spm=1001.2101.3001.6650.2&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-2-50185655-blog-124840083.pc_relevant_3mothn_strategy_recovery&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-2-50185655-blog-124840083.pc_relevant_3mothn_strategy_recovery&utm_relevant_index=5)