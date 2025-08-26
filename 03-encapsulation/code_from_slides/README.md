Code Shown on the Slides
========================

This directory contains code used during the class lecture or contained in the slides.

---

dateC
-----

This code demonstrates some of the issues with structured programming, for example, lack of data validation and direct but erroneous manipulation of struct members. This is why we need encapsulation - to limit data access to methods with (we hope) approved, tested, and reusable code.

dateCpp
-------

This is the C++ version of the dateC code, which we won't cover in class.

date-simple-enum
-----------------

A simple enum (enumerated type) in Java representing the months of the year. Notice that in Java (unlike in C or C++), printing an enumerated variable prints the enumerator text itself rather than an integer!

date-class
----------

Date.java demonstrates a simple Java implementation of a Date class.

date-enum-constructor
---------------------

Month has been enhanced with a field (the numeric representation of the month), a constructor (which initializes the field for each Month variable), and an asInt method (which returns the numeric representation).

date-enum-gemstones
-------------------

Month now also includes the gemstone associated with each month, initialized by the updated constructor.

date-enum-toString
------------------

We've added a toString() special method to Month, which Java will automatically use whenever a string representation of a Month variable is needed.

roll_with_class
---------------

This is a re-implementation of the Roll example from Lecture 02, with the dice-specific code moved into a simple Die class (a die is a platonic solid with the sides marked by natural numbers; the plural is dice).

The Roll program now uses an array of Die objects rather than ints. Notice the for-each loop that does the printing and summing.

The HighLow program demonstrates code reuse. The game reuses the Die class with no modifications whatsoever to roll one of each platonic solid dice, then allows the player to guess the sum while offering "higher" or "lower" clues.

traffic_light
-------------

Another example class is TrafficLight, which models one side of a standard green-yellow-red traffic light. Class Main provides a visual animation of a traffic light with 2 faces (and thus 2 linked instances of TrafficLight) - press Control-C to exit.

Compare the TrafficLight.java implementation (and Color.java enum) to its UML class diagram in the TrafficLight.svg image (the source code for PlantUML is in TrafficLight.uml). For P02 (the second assignment), you'll be given the class diagram as an aid in writing the solution, so be sure to understand the UML notation. 

Ask if you have questions!


