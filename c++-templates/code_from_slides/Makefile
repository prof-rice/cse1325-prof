CXXFLAGS += --std=c++17

all: max max_template max.py code_generator.py preprocessor

debug: CXXFLAGS += -g
debug: all

rebuild: clean all

max: max.o
	g++ $(CXXFLAGS) -o max max.o
max.o: max.cpp
	g++ $(CXXFLAGS) -c max.cpp
max_template: max_template.o
	g++ $(CXXFLAGS) -o max_template max_template.o
max_template.o: max_template.cpp
	g++ $(CXXFLAGS) -c max_template.cpp
preprocessor: preprocessor.o
	g++ $(CXXFLAGS) -o preprocessor preprocessor.o
code_generator.o: code_generator.cpp
	g++ $(CXXFLAGS) -c code_generator.o
max.py: FORCE
	python3 max.py
code_generator.py: FORCE
	python3 code_generator.py
FORCE:
clean:
	-rm -f *.o *.gch *~ max max_template preprocessor
