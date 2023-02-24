JAVA JNI usage example. 

How to work with JNI(with examples in scope of this projext):

1) Declare yor native function in JAVA. Example "static native void goThere(MessageProvider messageProvider);"
2) Generate native headers. Example: "javac .\Main.java .\Callback.java -h ./generated"
3) Rename generated header extension to: *.c"
4) Implement generated native function
5) Complie generated native function. 
Example: "gcc -m64 -c -I"C:/Program Files/Java/jdk-17/include" -I"C:/Program Files/Java/jdk-17/include/win32" .\generated\com_jnidemo_Main.c -o .\generated\TestLib.o
6) Build dynamic library(Windows). Example: "gcc -m64 -shared  -o  .\generated\TestLib.dll .\generated\TestLib.o"
7) Edit java property that defines where to look for native libraries. Example: '"-Djava.library.path="D:\JNI_Demo\lib"'
8) Load library in JAVA implementation: Example: "System.loadLibrary("TestLib");"
