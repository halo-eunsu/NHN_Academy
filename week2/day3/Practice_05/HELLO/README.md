##배운것

jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05$  /usr/bin/env /usr/lib/jvm/java-11-openjdk-amd64/bin/java @/tmp/cp_ajgeby959gx1smcp3nhrfr0ng.argfile com.nhnacademy.hello.Main 
Hello java!
더하기:30
빼기:10
나누기:2
곱하기:200
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05$ ls
HELLO
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05$ cd 
.vscode/ HELLO/   
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05$ cd 
.vscode/ HELLO/   
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05$ cd HELLO/
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO$ ls
README.md  bin  lib  out  src
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO$ javac ./src/com/nhnacademy/hello/*.java -d ./out/ --class-path ./lib/calculator.jar
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO$ rm hello.jar
rm: 'hello.jar'를 지울 수 없음: 그런 파일이나 디렉터리가 없습니다
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO$ java -jar hello.jar
Error: Unable to access jarfile hello.jar
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO$ cd 
.vscode/ bin/     lib/     out/     src/     
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO$ cd out/
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ ls
com  hello.jar  unzip
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ java -jar hello.jar 
hello, java!
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ rm hello.jar
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ ls
com  unzip
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ cd ..
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO$ javac ./src/com/nhnacademy/hello/*.java -d ./out/
./src/com/nhnacademy/hello/Main.java:3: error: package com.nhnacademy.hello.util does not exist
import com.nhnacademy.hello.util.Calculator;
                                ^
./src/com/nhnacademy/hello/Main.java:11: error: cannot find symbol
    System.out.println("더하기:" + Calculator.plus(20,10));
                                ^
  symbol:   variable Calculator
  location: class Main
./src/com/nhnacademy/hello/Main.java:12: error: cannot find symbol
    System.out.println("빼기:" + Calculator.subtract(20,10));
                               ^
  symbol:   variable Calculator
  location: class Main
./src/com/nhnacademy/hello/Main.java:13: error: cannot find symbol
    System.out.println("나누기:" + Calculator.divide(20,10));
                                ^
  symbol:   variable Calculator
  location: class Main
./src/com/nhnacademy/hello/Main.java:14: error: cannot find symbol
    System.out.println("곱하기:" + Calculator.multiply(20,10));
                                ^
  symbol:   variable Calculator
  location: class Main
5 errors
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO$ javac ./src/com/nhnacademy/hello/*.java -d ./out/ --class-path ./lib/calculator.jar
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO$ jar --file hello.jar --main-class com.nhnacademy.hello.Main -c ./com
./com: 해당 파일 또는 디렉토리가 없습니다.
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO$ javac ./src/com/nhnacademy/hello/*.java -d ./out/ --class-path ./lib/calculator.jar
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO$ jar --file hello.jar --main-class com.nhnacademy.hello.Main -c ./com
./com: 해당 파일 또는 디렉토리가 없습니다.
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO$ cd out
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ javac ./src/com/nhnacademy/hello/*.java -d ./out/ --class-path ./lib/calculator.jar
error: file not found: ./src/com/nhnacademy/hello/*.java
Usage: javac <options> <source files>
use --help for a list of possible options
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ jar --file hello.jar --main-class com.nhnacademy.hello.Main -c ./com
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ java -jar hello.jar 
Hello java!
Exception in thread "main" java.lang.NoClassDefFoundError: com/nhnacademy/hello/util/Calculator
        at com.nhnacademy.hello.Main.main(Main.java:11)
Caused by: java.lang.ClassNotFoundException: com.nhnacademy.hello.util.Calculator
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:581)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:527)
        ... 1 more
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ java -cp "./hello.jar:./calculator.jar" com.nhnacademy.hello.Main
Hello java!
Exception in thread "main" java.lang.NoClassDefFoundError: com/nhnacademy/hello/util/Calculator
        at com.nhnacademy.hello.Main.main(Main.java:11)
Caused by: java.lang.ClassNotFoundException: com.nhnacademy.hello.util.Calculator
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:581)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:527)
        ... 1 more
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ cd ..
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO$ java -cp "./hello.jar:./calculator.jar" com.nhnacademy.hello.Main
오류: 기본 클래스 com.nhnacademy.hello.Main을(를) 찾거나 로드할 수 없습니다.
원인: java.lang.ClassNotFoundException: com.nhnacademy.hello.Main
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO$ cd out
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ ls
com  hello.jar  unzip
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ cd com
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out/com$ ls
nhnacademy
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out/com$ ls
nhnacademy
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out/com$ cd ..
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ ls
com  hello.jar  unzip
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ cd ..
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO$ javac ./src/com/nhnacademy/hello/
Main.java      TestMain.java  
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO$ javac ./src/com/nhnacademy/hello/
Main.java      TestMain.java  
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO$ javac ./src/com/nhnacademy/hello/*.java -d ./out/ --class-path ./lib/calculator.jar
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO$ cd out
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ ls
com  hello.jar  unzip
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ rm hello.jar
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ cd ..
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO$ jar --file hello.jar --main-class com.nhnacademy.hello.Main -c ./com
./com: 해당 파일 또는 디렉토리가 없습니다.
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO$ cd out
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ jar --file hello.jar --main-class com.nhnacademy.hello.Main -c ./com
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ ls
com  hello.jar  unzip
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ java -jar hello.jar 
Hello java!
Exception in thread "main" java.lang.NoClassDefFoundError: com/nhnacademy/hello/util/Calculator
        at com.nhnacademy.hello.Main.main(Main.java:11)
Caused by: java.lang.ClassNotFoundException: com.nhnacademy.hello.util.Calculator
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:581)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:527)
        ... 1 more
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ java -cp "./hello.jar:./calculator.jar" com.nhnacademy.hello.Main
Hello java!
Exception in thread "main" java.lang.NoClassDefFoundError: com/nhnacademy/hello/util/Calculator
        at com.nhnacademy.hello.Main.main(Main.java:11)
Caused by: java.lang.ClassNotFoundException: com.nhnacademy.hello.util.Calculator
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:581)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:527)
        ... 1 more
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ java -cp "./hello.jar:./calculator.jar" com.nhnacademy.hello.Main
Hello java!
Exception in thread "main" java.lang.NoClassDefFoundError: com/nhnacademy/hello/util/Calculator
        at com.nhnacademy.hello.Main.main(Main.java:11)
Caused by: java.lang.ClassNotFoundException: com.nhnacademy.hello.util.Calculator
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:581)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:527)
        ... 1 more
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ java -cp"/home/jeongeunsu/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/lib/calculator.jar" com.nhnacademy.hello.Main
Unrecognized option: -cp/home/jeongeunsu/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/lib/calculator.jar
Error: Could not create the Java Virtual Machine.
Error: A fatal exception has occurred. Program will exit.
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ java -cp"/home/jeongeunsu/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/lib/calculator.jar" "/home/jeongeunsu/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/src/com/nhnacademy/hello/Main.java"
Unrecognized option: -cp/home/jeongeunsu/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/lib/calculator.jar
Error: Could not create the Java Virtual Machine.
Error: A fatal exception has occurred. Program will exit.
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ java -cp "/home/jeongeunsu/문서/NHN_git_test/NHN_Acade
my/week2/day3/Practice_05/HELLO/lib/calculator.jar" "/home/jeongeunsu/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/src/com/nhnacademy/hello/Main.
java"
Hello java!
더하기:30
빼기:10
나누기:2
곱하기:200
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ java -cp "./hello.jar:../lib/calculator.jar" com.nhnac
ademy.hello.Main
Hello java!
더하기:30
빼기:10
나누기:2
곱하기:200
jeongeunsu@jeongeunsu-Inspiron-14-5420:~/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/out$ 


-> java -cp "/home/jeongeunsu/문서/NHN_git_test/NHN_Acade
my/week2/day3/Practice_05/HELLO/lib/calculator.jar" "/home/jeongeunsu/문서/NHN_git_test/NHN_Academy/week2/day3/Practice_05/HELLO/src/com/nhnacademy/hello/Main.
java" 

 : 절대경로
->


-> 

java -cp "./hello.jar:../lib/calculator.jar" com.nhnac

: 상대경로
-> 빠르다
-> ../ : 현재 위치 상위 ./ :현위치

## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
