More Examples
=============

The files in this folder explore Java capability further than we'll cover in class. This material is for enthusiastic students that like to explore on their own.

Remember, you can look up calls in the online documentation. For example, puzzled by ``System.console()``?

1. Go to the Java 21 documentation at https://docs.oracle.com/en/java/javase/21/.
2. Click "API Documentation" in the upper left.
3. Type "System" in the search box in the upper right (NO Enter) and select java.lang.System.
4. Scroll down to the "Method Summary" section and click on "console()". The documentation will list "public static Console console()", and describe it as "Returns the unique Console object associated with the current Java virtual machine, if any." Notice that "Console" is a hyperlink. Click it!
5. The "Class Console" page lists everything you can do with ``System.console()``. Scroll down to the "Method Summary" section. There's ``printf``! Even better, there's ``readLine`` with the same parameters as ``printf``! This means you can print as complex of a prompt as you want and get a line of text in response from the user in a single call. Convenient!

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

To build one of the Java programs in this directory, just type ``javac File.java``. The result of compiling file A.java is file A.class. 

The exception to this is SwitchPatterns.java, which is a preview feature of OpenJDK 21. To compile it, you must enable preview features:

``javac --enable-preview --source 21 SwitchPatterns.java``

To run the main method inside file A.class, type ``java A``. Not all Java files have a main method!

