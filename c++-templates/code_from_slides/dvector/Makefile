CXXFLAGS += --std=c++17

all: test

debug: CXXFLAGS += -g
debug: all

rebuild: clean all

test: test_dvector.cpp
	g++ $(CXXFLAGS) test_dvector.cpp -o test
clean:
	-rm -f *.o *.gch *~ a.out test
