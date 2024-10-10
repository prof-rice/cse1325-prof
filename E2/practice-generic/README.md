Baseline
--------

In directory E2/practice-generic/baseline, class ``Top3`` accepts integers via the ``add(Integer x)`` method.

``Top3`` uses fields ``first``, ``second``, and ``third`` to retain the 3 largest integers added, using the ``compareTo`` method. These may be accessed using the ``getFirst()``, ``getSecond()``, and ``getThird()`` getter methods.

The ``main`` method asks the user to enter integers, which it adds to a ``Top3`` instance. After each integer is entered, it outputs the top 3 values entered thus far. For example:

.. code::

 Enter any integer (Ctrl-C to exit): 17
 Top 3 are: 17
 Enter any integer (Ctrl-C to exit): 42
 Top 3 are: 42 17
 Enter any integer (Ctrl-C to exit): 11
 Top 3 are: 42 17 11
 Enter any integer (Ctrl-C to exit): 91
 Top 3 are: 91 42 17
 Enter any integer (Ctrl-C to exit): -3
 Top 3 are: 91 42 17
 Enter any integer (Ctrl-C to exit): 

Also in the baseline directory is the class ``Triple``, similar to a 3D vector including methods for ``magnitude``, ``compareTo``, ``equals``, ``hashCode``, and ``toString``.

Assignment
----------

Make class ``Top3`` generic, so that it will work with any suitable class, not just ``Integer``.

Once modified, update method ``main`` to use the new generic version of ``Top3`` to retain the top 3 largest ``Integer`` objects.

Finally, modify ``main`` to use the generic version of ``Top3`` to instead retain the top 3 largest ``Triple`` objects. Output may look like this:

.. code::

 Enter any 3 integers (Ctrl-C to exit): 1 2 3
 Top 3 are: (1,2,3)
 Enter any 3 integers (Ctrl-C to exit): 2 3 4
 Top 3 are: (2,3,4) (1,2,3)
 Enter any 3 integers (Ctrl-C to exit): -3 -4 -5
 Top 3 are: (-3,-4,-5) (2,3,4) (1,2,3)
 Enter any 3 integers (Ctrl-C to exit): 12 0 0
 Top 3 are: (12,0,0) (-3,-4,-5) (2,3,4)
 Enter any 3 integers (Ctrl-C to exit): 9 0 0
 Top 3 are: (12,0,0) (9,0,0) (-3,-4,-5)
 Enter any 3 integers (Ctrl-C to exit): 

Suggested Solution
------------------

The suggested solution is in the suggested-solution subdirectory.

