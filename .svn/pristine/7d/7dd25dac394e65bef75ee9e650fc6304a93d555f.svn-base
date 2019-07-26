@echo off

set JAVA_HOME=C:\Program Files\Java\jdk8u202-b08
set DB_URL=localhost:3306
set DB_PREFIX=school
set DB_USR=root
set DB_PWD=tce#12345

set current=%~dp0
pushd ..
set parent=%cd%
popd
@echo on
set "CLASSEDGE_HOME=%parent%"

set JAVA_OPTS=
set JAVA_OPTS=%JAVA_OPTS%  -Xmx1024m -XX:MaxPermSize=256m
set JAVA_OPTS=%JAVA_OPTS% -Djava.net.preferIPv4Stack=true -Dorg.apache.catalina.loader.WebappClassLoader.ENABLE_CLEAR_REFERENCES=false
set JAVA_OPTS=%JAVA_OPTS% -Dfile.encoding=UTF8 -Duser.timezone=IST -Djava.rmi.server.hostname=127.0.0.1
set JAVA_OPTS=%JAVA_OPTS% -Dserver.mode=school-server -Ddb.url=%DB_URL% -Ddb.prefix=%DB_PREFIX% -Ddb.usr=%DB_USR% -Ddb.pwd=%DB_PWD%
set JAVA_OPTS=%JAVA_OPTS% -Dsolr.solr.home=%CLASSEDGE_HOME%\data\solr
set JAVA_OPTS=%JAVA_OPTS% -Dclassedge.data.dir=%CLASSEDGE_HOME%\data
set JAVA_OPTS=%JAVA_OPTS% -Dspring.config.location=file:%CLASSEDGE_HOME%\launch\conf\application.properties

call %ANT_HOME%\bin\ant -f ./conf/cleanup.xml 

start /D ..\tomcat\bin startup.bat