CXXFLAGS = --std=c++17

info:
	@echo
	@printf 'Type e.g., "make auto"  to create program "auto" from auto.cpp\n'
	@printf 'Type       "make all"   to create every program\n'
	@printf 'Type       "make clean" to delete every program\n\n'

bad_iteration: bad_iteration.cpp
	@printf "This compilation SHOULD fail - demonstrating const_iterator\n\n"
	-$(CXX) $(CXXFLAGS) -o bad_iteration bad_iteration.cpp
	@printf "Now type ./bad_iteration to execute the result\n\n"

const_iteration: const_iteration.cpp
	-$(CXX) $(CXXFLAGS) -o const_iteration const_iteration.cpp
	@printf "Now type ./const_iteration to execute the result\n\n"

elaborated_iteration: elaborated_iteration.cpp
	-$(CXX) $(CXXFLAGS) -o elaborated_iteration elaborated_iteration.cpp
	@printf "Now type ./elaborated_iteration to execute the result\n\n"

iteration: iteration.cpp
	-$(CXX) $(CXXFLAGS) -o iteration iteration.cpp
	@printf "Now type ./iteration to execute the result\n\n"

all: const_iteration elaborated_iteration iteration

clean:
	rm -f *.o *.gch a.out  bad_iteration const_iteration elaborated_iteration iteration

