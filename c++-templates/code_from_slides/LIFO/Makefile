# Use ‘make’ to create a regression test binary
# Use ‘make delete’ to verify that any copy attempts cause a compile error

CXXFLAGS += --std=c++17

all: test_lifo demo_lifo

debug: CXXFLAGS += -g
debug: test_lifo

delete: CXXFLAGS += -D_TEST_DELETES_  # This defines  preprocessor var _TEST_DELETES_
delete: rebuild

rebuild: clean all

test_lifo: test_lifo.o
	g++ $(CXXFLAGS) -o test_lifo test_lifo.o
test_lifo.o: test_lifo.cpp lifo.h
	g++ $(CXXFLAGS) -c test_lifo.cpp
demo_lifo: demo_lifo.o
	g++ $(CXXFLAGS) -o demo_lifo demo_lifo.o
demo_lifo.o: demo_lifo.cpp lifo.h
	g++ $(CXXFLAGS) -c demo_lifo.cpp
clean:
	-rm -f *.o *.gch *~ test_lifo demo_lifo
