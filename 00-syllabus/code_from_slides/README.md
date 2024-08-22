Code Shown on the Slides
========================

This directory contains code used during the class lecture or contained in the slides.

## Building the Code

For Lecture 00 only, we have some C, C++, and Python code as well as Java code. Type ``make`` at the bash command line for your options to build and run these programs.

### Missing Some Build Tools?

You'll need the Java Development Kit 17, Python 3, and the Gnu Compiler Collection (gcc, g++) for these programs to run, although you will NOT otherwise need Python 3 this semester. 

* If missing from Linux, install them all in one simple command using ``sudo apt install openjdk-17-jdk python3 build-essential``.

* For other operating systems, see https://learn.microsoft.com/en-us/java/openjdk/install,  https://www.python.org/downloads/, and https://gcc.gnu.org/install/binaries.html for guidance.

## Running the Programs Manually

For Java applications, the executable is a class file - for example, Hello.java compiles into Hello.class. Then ``java Hello`` will run the Hello.class program.

For C++ applications, the executable is a filename with the "execute bit" set. For example, per the Makefile, hello.cpp compiles into an executable named hello. Then ``./hello`` will run that executable. (``./`` means run the hello in the current directory.)

For Python applications, a simple ``./hello.py`` usually runs it directly. If that doesn't work, try ``python3 hello.py``. (Python compiles its source code automagically when first run.)
