CXXFLAGS += --std=c++17

all: test_vector

debug: CXXFLAGS += -g
debug: test_lifo

rebuild: clean all

test_vector: test_vector.o
	g++ $(CXXFLAGS) -o test_vector test_vector.o
test_vector.o: test_vector.cpp vector.h
	g++ $(CXXFLAGS) -c test_vector.cpp
clean:
	-rm -f *.o *.gch *~ test_vector
