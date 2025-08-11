Code to Test Your Java Environment
==================================

This directory contains code that will verify that you can build command line applications in Java.

## Build all applications

``ant``

This will compile all Java applications.

You *may* see a few warnings such as "Trying to override old definition of task javac". Ignore those.

But pay attention to any other warning or error messages! That's what you are checking with this build.

## Run each application

After ``ant`` above, if you have no errors or unexpected warnings, try to run each of the test programs below. 

### TestJavaArgs

This program reads command line parameters and prints them to the terminal. So

``java TestJavaArgs one two three``

should print to the terminal:

one

two

three

### TestJavaFileIO

This program simply prints its own source code to the terminal to verify file reads.

### TestJavaIO

This program asks for the grade you'd like to receive in the class. 

If you respond A, B, C, D, F, or I, it will encourage you.

Otherwise, it will output an error message and ask again.

## Testing Graphics

We will do some demonstration code this semester using the graphics capabilities of Java - because a picture
is worth a thousand words, or so I'm told. You will NOT be required to write the actual graphics code yourself,
though, so you don't need to ensure this code works.

If you want to verify that you'll be able to run these demonstrations anyway, go to cse1325-prof/stddraw
and run ``ant`` to build them OR use ``javac *.java``. Then run ``java Demo``, ``java Butterfly``, and ``java Sunflower``.
You'll press Enter in the terminal to advance and eventually exit each program.

I would NOT expect these to work on a GitHub codespace or on a remote server. They SHOULD work
on your local laptop environment or in a local virtual machine such as WSL or CSE-VM, but no promises.

Again, you don't *need* to run these this semester. But if you want to see the pics, you can check now.


