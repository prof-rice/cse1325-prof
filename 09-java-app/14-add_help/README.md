Running Roving Robots
=====================

To compile this game, use ``ant`` or ``javac Controller.java``.

To play this game without hitting Enter after each move, set the following alias from the bash command line:

``alias rr='stty raw && java Controller && stty cooked'``

Then run the game by simply typing rr.

If the game ever aborts, the terminal may be left in "raw" mode. Type ``stty cooked`` to restore normal operation.
