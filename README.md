### libgdx 使用Android Studio开发
生成工具用的是eclips插件，不太习惯，所以改成了目前默认的路径配置

### android
```
//多配置一个assets路径，将项目下的assets路径作为指向，方面多端公用
sourceSets {
        main {
            assets.srcDirs = ['../assets']
        }
    }
```

### html
1.包名要和core一样，而且必须要有 包名/client 路径
2. build.gradle中 的 gwt配置 
```
//改为java路径
src = files(sourceSets.main.java.srcDirs)
//下面的module路径也要对应时间路径
```