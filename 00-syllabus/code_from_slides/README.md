Code Shown on the Slides
========================

This directory contains code used during the class lecture or contained in the slides.

## Building the Code

For Lecture 00 only, we have some C, C++, and Python code as well as Java code. Type ``make`` at the bash command line for your options to build and run these programs.

### Missing Some Build Tools?

You'll need the Java Development Kit 21 (earlier versions will work for most code) to run code this semester. 

* If missing from Linux, install in one simple command using ``sudo apt install openjdk-21-jdk``.

* For other operating systems, see https://learn.microsoft.com/en-us/java/openjdk/install for guidance.

**For Lecture 00 ONLY**, you'll also need the gcc / g++ compiler and the Python 3 environment - but just to run the "Hello, World!" example if you like.

* If missing from Linux, install them both in one simple command using ``sudo apt install python3 build-essential``.

* For other operating systems, see  https://www.python.org/downloads/ and https://gcc.gnu.org/install/binaries.html for guidance.

## Running the Programs Manually

For Java applications, the executable is a class file - for example, Hello.java compiles into Hello.class. Then ``java Hello`` will run the Hello.class program.

For C++ applications, the executable is a filename with the "execute bit" set. For example, per the Makefile, hello.cpp compiles into an executable named hello. Then ``./hello`` will run that executable. (``./`` means run the hello in the current directory.)

For Python applications, a simple ``./hello.py`` usually runs it directly. If that doesn't work, try ``python3 hello.py``. (Python compiles its source code automagically when first run.)
