# DemoSession

This main program demonstrates two DataRange objects (one with each constructor),
then creates 3 Course objects, 3 Tutor and 3 Student objects, and finally
3 tutoring Session objects.

All are printed along with what you *might* expect to see, although your output
formats are permitted to vary a bit.

## Using DemoSession

IMPORTANT: You MUST do the following for this code to work:

* You must reorganize your code into packages per the requirements.
* You must implement `Session` and `DateRange` in package `session` per the requirements.
* You must copy the DemoSession.java file provided here into your `demo` package at P07/src/demo/DemoSession.java.
* You must use the NEW build.xml, copied from cse1325-prof/build/full/build.xml into your P07 directory.
* You must build from the P07 directory using `ant`. 
* You must run from the P07/target directory created by ant using the command `java demo.DemoSession`.

If `ant` doesn't work for you, you can compile from P07 using the following bash command 
(do NOT include lines starting with triple-backtics, if visible, use ONLY the single long command):

```bash
  mkdir -p target ; cd src ; for f in people rating session demo test ; do javac -d ../target ${f}/*.java ; done ; cd ../target
```

Run as above.

## Expected output

While your output may vary a bit, this is what the suggested solution generates on Antares.

```
Creating DateRange objects

  DateRange 2025-10-03 10:15 - 11:00 (45 minutes) with duration 45
  Should be 2025-10-03 10:15 - 11:00 (45 minutes)
  DateRange 2026-01-31 12:15 - 14:15 (120 minutes) with duration 120
  Should be 2026-01-31 12:15 - 14:15 (120 minutes)
  Exact formats are permitted to vary!

Creating courses

          CSE1310 CSE1320 CSE1325
should be CSE1310 CSE1320 CSE1325

Creating people

  Charlie Bright (cub6279@mavs.uta.edu) (tutor for CSE1310)
  Chandra Tutorful (cat8831@mavs.uta.edu) (tutor for CSE1320)
  Aisha GoodTutor (alt1399@mavs.uta.edu) (tutor for CSE1325)
  Isabella Studious (ies9120@mavs.uta.edu, #0) (taking [CSE1310])
  Roger Wilcompete (row5381@mavs.uta.edu, #1) (taking [CSE1320, CSE1325])
  Hai Codesense (ies9120@mavs.uta.edu, #2) (taking [CSE1325])

Creating sessions

  Session on CSE1310 at 2025-11-05 13:00 - 16:00 (180 minutes)
  Tutor:    Charlie Bright (cub6279@mavs.uta.edu)
  Students: Isabella Studious (ies9120@mavs.uta.edu, #0)

  Session on CSE1320 at 2025-11-07 08:00 - 09:30 (90 minutes)
  Tutor:    Chandra Tutorful (cat8831@mavs.uta.edu)
  Students: Roger Wilcompete (row5381@mavs.uta.edu, #1)

  Session on CSE1325 at 2025-11-12 17:00 - 19:00 (120 minutes)
  Tutor:    Aisha GoodTutor (alt1399@mavs.uta.edu)
  Students: Roger Wilcompete (row5381@mavs.uta.edu, #1), Hai Codesense (ies9120@mavs.uta.edu, #2)
```


## Thoughts on ZonedDateTime

Also, if you didn't implement the ``ZonedDateTime`` version of DateRange,
the ``date`` format could be literally anything! 

If you implemented the ``ZonedDateTime`` version, it fully enforces
the yyyy-mm-dd ``date`` and HH:mm ``startTime`` and ``endTime`` formats.
In addition, your sessions could cross midnight boundaries for extreme
students. To test these, feel free to add demonstrations to this class!

