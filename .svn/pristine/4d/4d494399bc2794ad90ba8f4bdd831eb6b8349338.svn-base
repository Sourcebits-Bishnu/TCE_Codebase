@echo off
rem detect current dir
set current=%~dp0
pushd ..
set parent=%cd%
popd
@echo on

set "PROJECT_HOME=%parent%"
set PROFILE_NAME=tce-school
set JAVA_HOME=C:\Program Files\Java\jdk8u202-b08
set MAVEN_HOME=C:\myapps\apache-maven-3.6.0
set MAVEN_OPTS= -Dmaven.repo.local=%PROJECT_HOME%\maven-repo -Dproject.dir=%PROJECT_HOME% -Dserver.type=school-server

@echo off
if "%1" == "setup-server" (
	call %MAVEN_HOME%\bin\mvn.cmd -P %PROFILE_NAME% clean package
) ELSE (
	call %MAVEN_HOME%\bin\mvn.cmd -P %PROFILE_NAME% -pl %* clean package 
)
