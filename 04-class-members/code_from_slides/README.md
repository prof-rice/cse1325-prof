Code Shown on the Slides
========================

This directory contains code used during the class lecture or contained in the slides.

final
-----

Final.java demonstrates how a final variable can be initialized after it is declared, and also how a final field must be initialized in a constructor (or in-line). But it can only be initialized ONCE, then it cannot be changed (we say it is immutable).  

Final is somewhat similar to const in C.

complex??
---------

This evolves our very simple Complex number class derived during lecture, in 7 steps. We'll come back to this code in Lecture 06.

* complex01 - the simple class, with 2 attributes and a constructor to initialize them
* complex02 - Add a toString method to print in (a,b) format
* complex03 - Add a default constructor that chains to the constructor above, allowing Complex c = new Complex();
* complex04 - Adds testers for comparing primitives and objects 
* complex05 - Implements equals, so that the value of 2 Complex objects can be compared
* complex06 - Adds the magnitude method
* complex07 - Adds static members and a nested enum
