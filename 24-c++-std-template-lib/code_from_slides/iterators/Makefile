CXXFLAGS = --std=c++17

info:
	@echo
	@printf 'Type e.g., "make auto"  to create program "auto" from auto.cpp\n'
	@printf 'Type       "make all"   to create every program\n'
	@printf 'Type       "make clean" to delete every program\n\n'

const_iteration: const_iteration.cpp
	-$(CXX) $(CXXFLAGS) -o const_iteration const_iteration.cpp
	@printf "Now type ./const_iteration to execute the result\n\n"

elaborated_iteration: elaborated_iteration.cpp
	-$(CXX) $(CXXFLAGS) -o elaborated_iteration elaborated_iteration.cpp
	@printf "Now type ./elaborated_iteration to execute the result\n\n"

iteration: iteration.cpp
	-$(CXX) $(CXXFLAGS) -o iteration iteration.cpp
	@printf "Now type ./iteration to execute the result\n\n"

map_interators: map_interators.cpp
	-$(CXX) $(CXXFLAGS) -o map_interators map_interators.cpp
	@printf "Now type ./map_interators to execute the result\n\n"

all:  const_iteration elaborated_iteration iteration map_interators

clean:
	rm -f *.o *.gch a.out  bad_iteration const_iteration elaborated_iteration iteration map_interators

