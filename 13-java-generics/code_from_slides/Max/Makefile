CXXFLAGS += --std=c++17

all: clean code_generator.py max.py max max_template preprocessor Max.class MaxGeneric.class

debug: CXXFLAGS += -g
debug: all

rebuild: clean all

Max.class: Max.java
	@echo '============ Max.java ============'
	javac Max.java
	java Max
MaxGeneric.class: MaxGeneric.java
	@echo '============ MaxGeneric.java ============'
	javac MaxGeneric.java
	java MaxGeneric
max: max.o
	$(CXX) $(CXXFLAGS) -o max max.o
	./max
max.o: max.cpp
	@echo '============ max.cpp ============'
	$(CXX) $(CXXFLAGS) -c max.cpp
max_template: max_template.o
	$(CXX) $(CXXFLAGS) -o max_template max_template.o
	./max_template
max_template.o: max_template.cpp
	@echo '============ max_template.cpp ============'
	$(CXX) $(CXXFLAGS) -c max_template.cpp
preprocessor: preprocessor.o
	$(CXX) $(CXXFLAGS) -o preprocessor preprocessor.o
	./preprocessor
preprocessor.o: preprocessor.cpp
	@echo '============ preprocessor.cpp ============'
	$(CXX) $(CXXFLAGS) -c preprocessor.cpp
max.py: FORCE
	@echo '============ max.py ============'
	python3 max.py
code_generator.py: FORCE
	@echo '============ code_generator.py ============'
	python3 code_generator.py
FORCE:
clean:
	-rm -f *.o *.gch *~ *.class max max_template preprocessor
