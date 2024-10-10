Data File
---------

In directory E2/practice-jcl-files, file ev-sales.dat alternates the name of each US state (and the District of Columbia) with the number of Electric Vehicles (EVs) sold in that state in 2022. For example:

.. code::

 Alabama
 8730
 Alaska
 1970
 Arizona
 65780

Assignment
----------

Write a main method that does the following:

1. Create a ``HashMap`` using the state name (a String) as the key and the number of EVs sold (an int) as the value.
2. Using try-with-resources, open file ev-sales.dat for input.
3. Read each state and its sales figure from the file.
   a. Add each state and EV sales figure pair to the ``HashMap``.
   b. Keep a running total of sales in all states.
5. If an error occurs, print an error message to the standard error channel, print a stack trace, and then exit with code -1.
6. Using try-with-resources, open file ev-percentages.dat for output.
7. Iterate over your ``HashMap``. 
   a. For each state, calculate the percentage of its sales compared to the entire US. For example, if Alabama sold 8,730 EVs and 2,442,270 EVs were sold across the US, the percentage is 6220 / 2442270 or 0.36%.
   b. Write the state, the sales figure, and then the percentage to the output file on separate lines.
   c. Print the data to the console. For example, for Alabama print "Alabama bought 8730 EVs or  0.4%".
8. If an error occurs, print an error message to the standard error channel, print a stack trace, and then exit with code -2.
9. Print the total number of EVs bought in the US in 2022. For example, "Total EVs  bought  were  2442270".

Bonus
-----

After completing the assignment, notice that the states are no longer listed in alphabetical order. By changing only *four characters* (and perhaps adding an import), both print and save all states in alphabetical order again.

Suggested Solution
------------------

Correct output would look something like this:

.. code::

    North Carolina bought  45590 EVs or  1.9%
           Indiana bought  17710 EVs or  0.7%
           Wyoming bought    840 EVs or  0.0%
              Utah bought  28050 EVs or  1.1%
           Arizona bought  65780 EVs or  2.7%
 (the remaining states follow)
 Total EVs  bought  were  2442270

The output data file should begin something like this:

.. code::

 North Carolina
 45590
 1.8667059743599193%
 Indiana
 17710
 0.7251450494826535%
 Wyoming
 840
 0.034394231596015186%
 Utah
 28050
 1.1485216622240784%
 Arizona
 65780
 2.693395898078427%

The suggested solution is in the suggested-solution subdirectory.

