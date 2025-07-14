# CSE1325-001 and 002
## Fall 2025

This repository includes code that complements each lecture, suggested solutions for each assignment and (often) exams, and additional example code for my Object-Oriented Programming in Java course.

## Cloning to your local machine

The commands below are based on the bash shell and its cousins. Installing git on Windows adds a bash shell, and Linux and Mac include bash and zsh (a bash-like shell) respectively by default. Similarly, GitHub Codespaces includes a bash shell within the provided VS Code environment, although some configuration will be required as discussed in the first lecture, call (appropriately enough for a programming course) Lecture 00.

To create a folder in your virtual machine that is linked to this repository, go to your home directory (``cd``), copy the following command (select and Ctrl-c) and paste it into your bash or zsh terminal (generally, use right-click -> Paste, Edit -> Paste, or Shift-Control-V):

``git clone https://github.com/prof-rice/cse1325-prof.git``

To download changes within your terminal at any later time, change to your cse1325-prof directory (``cd ~/cse1325-prof``) and type:

``git pull``

If that doesn't work, or the repository has issues, just delete it and clone it again.

## Viewing files

On Linux you can open ANY filename from the terminal (using the associated application, which may be graphical) with 

``xdg-open filename``

If you're using the CSE-VM virtual machine or the bash enhancements discussed in lecture (see them at https://github.com/prof-rice/cse-vm.git), this is shorter and perhaps easier to remember:

``e filename``

In bash and its cousins on any operating system, you can usually print text files to the console using this.

``cat filename``

Longer files can be viewed (with PgUp and PgDn, or ``q`` to quit) using

``less filename``

(If ``less`` doesn't work, use ``more`` instead. More is less with less features but is more commonly installed. Linux is fun.)

## Editing files

To edit a text file within the terminal on Linux or a Mac, try 

``nano filename`` 

Recently, Windows added a terminal-based text editor (finally!) modeled after the ancient but well-regarded QBasic editor named, logically, "Edit". So try this:

``edit filename``

If that doesn't work on Windows, but after you've installed git, you can certainly use this.

'C:\Program Files\Git\usr\bin\nano.exe' filename

If you're using gedit, the executable's name is (logically) "gedit":

``gedit filename``

If you're using VS Code, the executable's name is "code" - this also works in GitHub Codespaces:

``code filename``

If you're using Sublime Text, the executable's name is "subl":

``subl filename``

If you're using Notepad++ on Windows, the executable's name is "notepad++" but it requires "start" (unless you update your path):

``start notepad++ filename``

Or, in any OS, just use your favorite programming editor to edit code and other text files, and your favorite applications to edit other file types. Beware of complex Integrated Development Environments (IDEs), though - you want to focus on learning object-oriented programing in Java this semester, not how to use VS Code or Eclipse!

## Students from previous semesters

If you have used this repository during a previous semester, be advised that it is restarted each semester. Previous editions have been renamed as shown below (named for start of term in YYYYMM format except the first, for which the "date" is simply cpp). 

And before upcoming students get *too* excited, assignments change *every semester*, so ixnay on any eatingchay plans! ;-) 

Spring 2021 and earlier (C++ and gtkmm only): https://github.com/prof-rice/cse1325-prof-cpp

Fall 2021 (Java and Swing only): https://github.com/prof-rice/cse1325-prof-202108

Spring 2022 - Spring 2023 (Java and Swing with a touch of C++ but with no gtkmm): https://github.com/prof-rice/cse1325-prof-202301

Fall 2023 (Java with no Swing and C++ with no gtkmm): https://github.com/prof-rice/cse1325-prof-202308

Spring 2024 (Java with no Swing and C++ with no gtkmm): https://github.com/prof-rice/cse1325-prof-202401

Fall 2024 (Java with no Swing and C++ with no gtkmm, threads, or templates): https://github.com/prof-rice/cse1325-prof-202408

Spring 2025 (Java with no Swing and C++ with no gtkmm, threads, or templates): https://github.com/prof-rice/cse1325-prof-202501

