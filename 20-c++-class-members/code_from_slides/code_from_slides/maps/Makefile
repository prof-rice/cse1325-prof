CXXFLAGS = --std=c++17

info:
	@echo
	@printf 'Type e.g., "make auto"  to create program "auto" from auto.cpp\n'
	@printf 'Type       "make all"   to create every program\n'
	@printf 'Type       "make clean" to delete every program\n\n'

map_easy: map_easy.cpp
	-$(CXX) $(CXXFLAGS) -o map_easy map_easy.cpp
	@printf "Now type ./map_easy to execute the result\n\n"

map_overloads: map_overloads.cpp
	-$(CXX) $(CXXFLAGS) -o map_overloads map_overloads.cpp
	@printf "Now type ./map_overloads to execute the result\n\n"

map_overloads_multimap: map_overloads_multimap.cpp
	-$(CXX) $(CXXFLAGS) -o map_overloads_multimap map_overloads_multimap.cpp
	@printf "Now type ./map_overloads_multimap to execute the result\n\n"

map_practical: map_practical.cpp
	-$(CXX) $(CXXFLAGS) -o map_practical map_practical.cpp
	@printf "Now type ./map_practical to execute the result\n\n"

map_practical_plus: map_practical_plus.cpp
	-$(CXX) $(CXXFLAGS) -o map_practical_plus map_practical_plus.cpp
	@printf "Now type ./map_practical_plus to execute the result\n\n"

map_verbose: map_verbose.cpp
	-$(CXX) $(CXXFLAGS) -o map_verbose map_verbose.cpp
	@printf "Now type ./map_verbose to execute the result\n\n"

multimap_vehicle: multimap_vehicle.cpp
	-$(CXX) $(CXXFLAGS) -o multimap_vehicle multimap_vehicle.cpp
	@printf "Now type ./multimap_vehicle to execute the result\n\n"

multimap_vehicle_with_std_pair: multimap_vehicle_with_std_pair.cpp
	-$(CXX) $(CXXFLAGS) -o multimap_vehicle_with_std_pair multimap_vehicle_with_std_pair.cpp
	@printf "Now type ./multimap_vehicle_with_std_pair to execute the result\n\n"

all:  map_easy map_overloads map_overloads_multimap map_practical map_practical_plus map_verbose multimap_vehicle multimap_vehicle_with_std_pair

clean:
	rm -f *.o *.gch a.out  map_easy map_overloads map_overloads_multimap map_practical map_practical_plus map_verbose multimap_vehicle multimap_vehicle_with_std_pair

