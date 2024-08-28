Code Shown on the Slides
========================

This directory contains code used during the class lecture or contained in the slides.

---

Other
-----

Args.java
~~~~~~~~~

This is a simple demonstration of handling command line arguments. It just prints them all, using a for-each to iterate over the args array.

ScopeNested.java
~~~~~~~~~~~~~~~~

This code demonstrates the difference between Java's class and method scope. A method may declare a variable of the same name as a field. The field is available as this.x, while the local variable is simply x. C has much more complex scoping rules, which we won't discuss here.

Final.java
~~~~~~~~~~

This code demonstrates how a final variable can be initialized after it is declared, and also how a final field must be initialized in a constructor (or in-line). But it can only be initialized ONCE, then it cannot be changed (we say it is immutable).  

Final is somewhat similar to const in C.

complex??
---------

This evolves our very simple Complex number class derived during lecture, in 7 steps.

complex01 - the simple class, with 2 attributes and a constructor to initialize them
complex02 - Add a toString method to print in (a,b) format
complex03 - Add a default constructor that chains to the constructor above, allowing Complex c = new Complex();
complex04 - Implements equals, so that the value of 2 Complex objects can be compared
complex05 - Adds the magnitude method
complex06 - Adds chained addition, e.g., Complex c = c1.add(c2).add(c3).add(c4)
complex07 - Adds static members and a nested enum
