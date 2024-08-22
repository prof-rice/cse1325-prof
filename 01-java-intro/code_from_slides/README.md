Code Shown on the Slides
========================

This directory contains code used during the class lecture or contained in the slides.

---

To build all of the Java programs in this directory and its subdirectories, just type ``ant``. This uses the rules in the build.xml file in the current directory to issue all of the needed ``javac`` and related commands. It's *automagic*.

Type ``java For3`` to run the main method in class For3 in file For3.java (of course!). But watch out - not all classes have main methods!

To delete all of the class files created by the ``ant`` command, type ``ant clean``.  Keep those ants busy!

You may copy build.xml from this directory to your own P01/full_credit directory to use ant on your first homework. It's fairly universal.

---

For this lecture only, a Makefile is also provided. Remember those from your C days? 

Type ``make`` for instructions on building all of these programs, since that's what Makefile defines. Type ``make clean`` to remove all of the .class files.

