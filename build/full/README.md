# Full build.xml

UPDATE: The menu package has been added to the Javadoc generation list.

This build.xml file is suitable for the class project. 

* ``ant`` or ``ant compile`` will build Java source files from the specified subdirectory (default is "src") to the specified class file subdirectory (default is "target"), thus keeping the source files and class files separate. 
* ``ant javadoc`` will build the JavaDoc documentation into the specified directory (default is "target/doc/api"). 
* ``ant dist`` will create a single JAR file containing all class and JavaDoc files.

This file is not *quite* universal. You must adjust the first 4 “property” tags to fit your project.

* Appname is the name you’ve give your project.
* Author is your name, as it want it shown on the documentation website.
* License is the license under which *your documentation* is released.
* Packages is the comma-separated list of reusable packages for which documentation should be generated, each followed by "-*". 

The custom ``license.agreement`` tag is supported for including a license agreement reference in the JavaDoc.

This file will name the JAR file appname-YYYYMMDD-HHMM.jar, where YYYYMMDD is the year, month, and day and HHMM is the hour and minute that the JAR file was created. This makes it trivial to keep several built versions of your code readily available during testing.

To run a class file using on the JAR file, type

``java -cp appname-YYYYMMDD-HHMM.jar package.MainClass``, where appname-YYYYMMDD-HHMM.jar is your JAR file name and package.MainClass is the fully-qualified package and class name containing the selected main method.

