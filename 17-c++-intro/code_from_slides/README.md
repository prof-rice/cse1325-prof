Code Shown on the Slides
========================

This directory contains code used during the class lecture or contained in the slides.

Building Programs
-----------------

Type ``make all`` to build all of these programs, or ``make [program]`` to just build [program].cpp.

**IMPORTANT**

Note that auto.cpp SHOULD generate the following error:

        declaration of ‘auto duh’ has no initializer

This is because it's not possible to determine duh's type.

|

Note that decl_no_def.cpp SHOULD generate the following error:

        undefined reference to `sqrt(double)'

This is because we declared sqrt(double), but never defined it.

Cleaning Up Executables
-----------------------

Type "make clean" to delete all of the executables.
