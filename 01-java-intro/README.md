Lecture 01
==========

The files in this folder represent the anticipated
evolution of files to be developed "live" in this lecture.
But you never know where we may wander in class!

---

To compare 2 files, use either diff (command line)
or meld (GUI, recommended if your environment isn't CPU-starved -
get it from https://meldmerge.org/ ).

So, to compare A.java to B.java:

* In a narrow terminal

``diff A.java B.java``

* In a wide terminal

``diff -y A.java B.java``

* In a GUI

``meld A.java B.java``

---

To build one of the Java programs in this directory, just type ``javac file.java``. The result of compiling file A.java is file A.class. 

The exception to this is SwitchPatterns.java, which is a preview feature of OpenJDK 21. To compile it, you must enable preview features:

``javac --enable-preview --source 21 SwitchPatterns.java``

To run the main method inside file A.class, type ``java A``. Not all Java files have a main method!

For the program in the hello package / directory, you must compile using ``javac hello/HelloJava.java`` and run using ``java hello.HelloJava``. Package and directory hierarchies always mirror each other!

HelloJava will also verify that you can run Swing applications, by the way!
