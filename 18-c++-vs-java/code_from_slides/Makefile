CXXFLAGS = --std=c++17

info:
	@echo
	@printf 'Type e.g., "make auto"  to create program "auto" from auto.cpp\n'
	@printf 'Type       "make all"   to create every program\n'
	@printf 'Type       "make clean" to delete every program\n\n'

array_like: array_like.cpp
	-$(CXX) $(CXXFLAGS) -o array_like array_like.cpp
	@printf "Now type ./array_like to execute the result\n\n"

array_like_heap: array_like_heap.cpp
	-$(CXX) $(CXXFLAGS) -o array_like_heap array_like_heap.cpp
	@printf "Now type ./array_like_heap to execute the result\n\n"

coordinate: coordinate.cpp
	-$(CXX) $(CXXFLAGS) -c -o coordinate.o coordinate.cpp
	@printf "coordinate.o has been created\n\n"

immutables: immutables.cpp
	-$(CXX) $(CXXFLAGS) -o immutables immutables.cpp
	@printf "Now type ./immutables to execute the result\n\n"

overloading: overloading.cpp
	-$(CXX) $(CXXFLAGS) -o overloading overloading.cpp
	@printf "Now type ./overloading to execute the result\n\n"

rot13: rot13.cpp
	-$(CXX) $(CXXFLAGS) -o rot13 rot13.cpp
	@printf "Now type ./rot13 to execute the result\n\n"

rot13_custom: rot13_custom.cpp
	-$(CXX) $(CXXFLAGS) -o rot13_custom rot13_custom.cpp
	@printf "Now type ./rot13_custom to execute the result\n\n"

timer: timer.cpp
	-$(CXX) $(CXXFLAGS) -o timer timer.cpp
	@printf "Now type ./timer to execute the result\n\n"

variables: variables.cpp
	-$(CXX) $(CXXFLAGS) -o variables variables.cpp
	@printf "Now type ./variables to execute the result\n\n"

all:  array_like array_like_heap coordinate immutables overloading rot13 rot13_custom timer variables

clean:
	rm -f *.o *.gch a.out  array_like array_like_heap coordinate immutables overloading rot13 rot13_custom timer variables

