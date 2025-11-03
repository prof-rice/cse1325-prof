# Comparison of Generic Programming Strategies

The code here compares strategies for generic programming of methods using a code generator, Python 3 (a dynamic language for which generics are implicit), the C preprocessor, C++ templates, and Java generics.

* The Python and code generator examples require installation of Python 3 (see https://wiki.python.org/moin/BeginnersGuide/Download).
* The C++ and preprocessor examples require installation of the Gnu Compiler Collection (gcc) or similar C++ compiler (for example, try the ``sudo apt install build-essential`` command in Ubuntu and compatible Linux environments or see https://gcc.gnu.org/install/).
* The Java examples require installation of the OpenJDK or JDK SE environment (see https://openjdk.java.net/install/ or https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html respectively).

## Running the Examples

To build and run all examples, type ``make`` (this requires Makefile support, e.g., by the ``sudo apt install build-essential`` command in Ubuntu and compatible Linux environments). To remove all unneeded files, type ``make clean``.

To build the Java examples, type ``ant`` (this requires Ant support, for which see https://ant.apache.org/manual/install.html). To remove the resulting .class files, type ``ant clean``.

Or use the following commands from a bash shell (replace ``g++`` with your C++ compiler).

```bash
# ============ code_generator.py ============
python3 code_generator.py

# ============ max.py ============
python3 max.py

# ============ max.cpp ============
g++ --std=c++17 -c max.cpp
g++ --std=c++17 -o max max.o
./max

# ============ max_template.cpp ============
g++ --std=c++17 -c max_template.cpp
g++ --std=c++17 -o max_template max_template.o
./max_template

# ============ preprocessor.cpp ============
g++ --std=c++17 -c preprocessor.cpp
g++ --std=c++17 -o preprocessor preprocessor.o
./preprocessor

# ============ Max.java ============
javac Max.java
java Max

# ============ MaxGeneric.java ============
javac MaxGeneric.java
java MaxGeneric

```


