## 环境说明

前端：
- Node 16+
- Vue

后端：
- SpringBoot
- java 11

## 本地开发

前端启动

```aidl
cd web
npm i
npm run dev
```

后端启动
```aidl
cd backend 
./gradlew bootrun

# 如果是用 idea 可以直接启动了..
```

## 如何打包构建

前端：
```aidl
cd web
npm run build
docker build -t aceysx/xinqiu-web:v1 .  //把 aceysx 换成自己的 docker hub username
```

后端
```aidl
cd backend
./gradlew clean build
docker build -t aceysx/xinqiu-be:v1 .  //把 aceysx 换成自己的 docker hub username
```

### 本地容器运行
1. 执行完本地打包构建步骤后
2. 在项目根目录下执行
```aidl
docker-compose up -d  // 需要修改 docker-compose.yml 文件中镜像的信息
```

### 发布镜像
```aidl
docker push aceysx/xinqiu-web:v1 //把 aceysx 换成自己的 docker hub username
docker push aceysx/xinqiu-be:v1 //把 aceysx 换成自己的 docker hub username
```
最后只需要把 docker-compose.yml 文件copy到所在的服务器执行 docker-compose up -d 即可



