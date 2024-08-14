__해당 페이지는 연습용 개발서버 설정에 대해 기술한다. __

# Web Server

버전 : nginx1.18

## 서버(ubuntu)에 설치된 항목

설치 명령어를 작성

```bash
// net-tools
$ sudo apt-get install net-tools

// nginx
$ sudo apt-get install nginx

// unzip
$ sudo apt-get install unzip

// wget
$ sudo apt-get install weget

// java tar 설치
// 경로 : ~/usr/local/java

// tomcat tar 설치
// 경로 : ~/opt/tomcat

```

## nginx1.18 설치 (Ubuntu)

### apt-get 명령어 업데이트

```bash
$ sudo apt-get update
$ sudo apt-get upgrade
```

### nginx  설치

```bash
$ sudo apt-get install nginx
```

### nginx 설치된 경로

```bash
// 설치 경로(apt-get 으로 설치한 경우)
$ cd /etc/nginx**

// 그 외 nginx 경로 찾는 명령어
$ sudo find / -name nginx.conf
```

### nginx 버전 확인

```bash
$ nginx -v
nginx version: nginx/1.18.0 (Ubuntu)
```

### nginx 명령어

```bash
// 시작
$ sudo service nginx start
$ sudo systemctl start nginx
$ sudo /etc/init.d/nginx start

// 재시작
$ sudo service nginx restart
$ sudo systemctl restart nginx
$ sudo /etc/init.d/nginx restart

// 중지
$ sudo service nginx stop
$ sudo systemctl stop nginx
$ sudo /etc/init.d/nginx stop

// 상태
$ sudo service nginx status
$ sudo systemctl status nginx

// 설정 reload
$ sudo service nginx reload
$ sudo systemctl reload nginx
$ sudo nginx -s reload

// configuration file syntax check
$ sudo nginx -t
```

## Java1.8 설치

- Oracle  홈페이지에서 Java 1.8 .tar 다운로드
([https://www.oracle.com/kr/java/technologies/javase/javase-jdk8-downloads.html](https://www.oracle.com/kr/java/technologies/javase/javase-jdk8-downloads.html))

```bash
// 아래 경로에 다운로드 받은 파일 이동 후 압축 풀기
$ mkdir usr/local/java

// 환경변수 등록
$ cd /etc/profile

# JAVA_HOME
JAVA_HOME=/usr/local/java/jdk1.8.0_291
JRE_HOME=$JAVA_HOME/jre
PATH=$PATH:$JAVA_HOME/bin:$JRE_HOME/bin
exprot JAVA_HOME
export JRE_HOME
export PATH

// 등록 후 소스 적용
$ source /etc/profile

// java 버전 확인으로 설치 확인
$ java -version 
$ echo $JAVA_HOME
```

## Tomcat 8.5 설치

```bash
// Tomcat 다운로드
$ wget https://mirror.navercorp.com/apache/tomcat/tomcat-8/v8.5.65/bin/apache-tomcat-8.5.65-windows-x64.zip

// 경로 이동
$ mv apache-tomcat-8.5.65-windows-x64.zip opt/tomcat

// 압축 풀기
$ unzip apache-tomcat-8.5.65-windows-x64.zip

// 파일 링크
$ sudo ln -s /opt/tomcat/apache-tomcat-8.5.37 /opt/tomcat/latest

// *.sh 실행을 위한 권한 부여
$ sh -c 'chmod +x /opt/tomcat/latest/bin/*.sh'

// 시스템에 tomcat을 등록하기 위한 tomcat.service 생성
$ vi /etc/systemd/system/tomcat.service

// tomcat.service 의 내용(서버의 내용이 바뀌면 아래 내용도 없데이트 해줘야함)

[Unit]
Description=Tomcat 8.5 servlet container
After=network.target

[Service]
Type=forking

User=root
Group=root

Environment="JAVA_HOME=/usr/local/java/jdk1.8.0_291"
Environment="JAVA_OPTS=-Djava.security.egd=file:///dev/urandom"
Environment="CATALINA_BASE=/opt/tomcat/latest"
Environment="CATALINA_HOME=/opt/tomcat/latest"
Environment="CATALINA_PID=/opt/tomcat/latest/temp/tomcat.pid"
Environment="CATALINA_OPTS=-Xms512M -Xmx1024M -server -XX:+UseParallelGC"

ExecStart=/opt/tomcat/latest/bin/startup.sh
ExecStop=/opt/tomcat/latest/bin/shutdown.sh

[Install]
WantedBy=multi-user.target

// 서비스 등록
$ systemctl enable tomcat.service

// Tomcat 작동 명령어
$ systemctl start tomcat.service //실행 
$ systemctl stop tomcat.service //종료 
$ systemctl enable tomcat.service //활성화 
$ systemctl disable tomcat.service //비활성화
$ systemctl status tomcat.service // 상태확인
```

### Tomcat 설치된 경로

```bash
// 설치 경로
$ cd /opt/tomcat
```

## Nginx, Tomcat 연동

### :80 → :8080 으로  Redirect

```bash
// nginx 설정파일 
$ cd /etc/nginx/conf.d
$ vi newtest.conf
// newtest.conf 파일에 아래와 같이 작성
upstream newtest {
        server localhost:8080;
}

$ cd /etc/nginx/sites-enabled
$ vi newtest

// newtest 파일에 아래와 같이 작성
server {
        listen 80 default_server;
        listen [::]:80 default_server;

				root /var/www/html;

        # Add index.php to the list if you are using PHP
        index index.html index.htm index.nginx-debian.html;

        server_name localhost;

        location /api {
                proxy_pass http://newtest;
                proxy_set_header Host $host;
                proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
                proxy_connect_timeout 300;
                proxy_send_timeout 300;
                proxy_read_timeout 300;
                send_timeout 300;
        }
}
```

## Jenkins 설치

```bash
// Jenkins 키 발급
$ wget -q -O - https://pkg.jenkins.io/debian/jenkins-ci.org.key | sudo apt-key add -
$ sudo sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'

// Jenkins 설치
$ sudo apt-get update
$ sudo apt-get install jenkins

// 시스템에 등록된 Jenkins의 설정파일에서 Java경로 잡아주기
$ vi /etc/init.d/jenkins

// java 경로로 변경
PATH=/usr/local/java/jdk1.8.0_291/bin:/usr/bin:/sbin:/usr/sbin

// 변경된 사항 적용
$ sudo systemctl daemon-reload

// Jenkins 포트 변경
$ vi /etc/default/jenins

// :9090 포트로 변경
HTTP_PORT=9090

// 명령어
$ systemctl stop jenkins.service // 중지
$ systemctl start jenkins.service // 시작
$ systemctl stop jenkins.service // 상태
```

## Vue.js 설치

```bash
// npm  설치
$ sudo apt-get install npm

// Vue 설치
$ npm install vue@2.6.11

// Vue-cli  설치
$ npm install @vue/cli@4.5.12

// webpack 설치
$ cd /var/www/html
$ vue init webpack [directory name]

// 빌드 후 dist 생성
$ cd [directory name]
$ npm run build
```

### nginx 설정 변경

```bash
$ cd /etc/nginx/sites-enabled

server {
        listen 80 default_server;
        listen [::]:80 default_server;

        root /var/www/html/[directory name]/dist;

        index index.html index.htm ;

        server_name _;

        location / {
                try_files $uri $uri/ @rewrites;
        }

        location @rewrites {
                rewrite ^(.+)$ /index.html last;
        }

				location /api {
                proxy_pass http://newtest;
                proxy_redirect off;
                charset utf-8;

                proxy_set_header X-Real-IP $remote_addr;
                proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
                proxy_set_header X-Forwarded_Proto $scheme;
                proxy_set_header X-Nginx-Proxy true;
                proxy_set_header Host $host;

                proxy_connect_timeout 300;
                proxy_send_timeout 300;
                proxy_read_timeout 300;
                send_timeout 300;
        }
}
```