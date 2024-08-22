info:
	@echo
	@echo "Type 'make hello.cpp' to run the C++ version."
	@echo "Type 'make hello.c' to run the C version."
	@echo "Type 'make hello.py' to run the Python version."
	@echo "Type 'make Hello.java' or 'ant ; java Hello' to run the Java version."
	@echo "Type 'make clean' to delete all built files and start over."
	@echo

.PHONY: hello.cpp hello.c hello.py Hello.java clean

hello.cpp: 
	$(CXX) hello.cpp -o hello 
	./hello

hello.c:
	cc hello.c
	./a.out

hello.py:
	chmod a+x hello.py
	./hello.py

Hello.java:
	javac Hello.java
	java Hello

clean:
	-rm -f *.o *~ *.class hello a.out
