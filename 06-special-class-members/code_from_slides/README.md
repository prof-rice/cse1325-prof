Code Shown on the Slides
========================

This directory contains code used during the class lecture or contained in the slides.

---

autoboxing/Autoboxing.java
--------------------------

This demonstrates Java happily casting between ``int`` and ``Integer``, and between ``double`` and ``Double``, with no explicit casts required.

coin
----

These classes focus on demonstrating special methods such as ``equals``, ``compareTo``, and ``hashCode``. We'll also use them to demonstrate how to randomly select a enumerated value from an enum.

complex_redux
-------------

We demonstrated *constructor* chaining in earlier lectures. This code (further evolved from the code in earlier lectures) demonstrates *method* chaining.  

puml
----

This shows how to write and generate your own UML class diagrams. We provide the PlantUML code in file exam_example.puml, along with 3 translations:

* resulting_diagram.png - This is the image file that I usually use
* resulting_diagram.txt - This is an ASCII Art rendering (use a monospaced font!)
* resulting_diagram.url - This URL should take to to the PlantUML website with the example diagram pre-loaded!

spheres
-------

These two classes demonstrate scope - field, parameter, and local.

triangles
---------

These 3 programs in Java, C, and C++, illustrate the differences in memory management strategy between the 3 languages.

* C is an *unmanaged* language. You allocate with ``malloc``, but must remember to release the memory with ``free`` to avoid a leak.
* C++ is also an *unmanaged* language, but you allocate with ``new`` and release the memory with ``delete`` to avoid a leak.
* Java is a *managed* language. You allocate with ``new``, but Java itself will delete / free the allocated memory once you no longer have a reference to it. (We  have no idea WHEN or even IF it will release the memory. That's a feature in most non-hard real-time system, though!)

