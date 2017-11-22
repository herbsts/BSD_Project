#!/bin/bash

if [ -d ./bin ]; then
   rm -fr ./bin   # clear in a brute force manner
fi
mkdir ./bin

javac -sourcepath ./src -d ./bin ./src/test/TestApp.java
if [ "$?" != "0" ]; then
    echo "compile errors .."
    exit -1
else
    #java -classpath ./bin test.TestApp
    cd ./bin
    jar -cfv ./../../JavaArchives/dbManager.jar ./com/DBManager.class
    cd ../../JavaArchives
    java -jar dbManager.jar
fi
