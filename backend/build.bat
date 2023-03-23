tar -xf apache-maven-3.9.1-bin.zip

set PATH=%PATH%;%CD%\apache-maven-3.9.1\bin

@echo off
cd /d %~dp0
mvn clean install
pause
