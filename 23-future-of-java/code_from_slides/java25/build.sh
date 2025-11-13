#!/usr/bin/env bash
echo "IMPORTANT: This code will ONLY compile with Java 25!"
javac HelloAnonymousClass.java
javac HelloByName.java
javac Hello.java
javac HelloStudents.java
javac --release 25 --enable-preview Primitives.java
javac Prologue.java

