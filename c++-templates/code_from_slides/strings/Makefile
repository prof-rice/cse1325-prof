CXXFLAGS += --std=c++17

all: test_strings

debug: CXXFLAGS += -g
debug: test_strings

rebuild: clean all

test_strings: test_strings.o to_string.h stox.h
	g++ $(CXXFLAGS) -o test_strings test_strings.o
test_strings.o: test_strings.cpp to_string.h stox.h
	g++ $(CXXFLAGS) -c test_strings.cpp
clean:
	-rm -f *.o *.gch *~ test_strings

