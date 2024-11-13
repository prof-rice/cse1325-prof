CXXFLAGS = --std=c++17

info:
	@echo
	@printf 'Type e.g., "make auto"  to create program "auto" from auto.cpp\n'
	@printf 'Type       "make all"   to create every program\n'
	@printf 'Type       "make clean" to delete every program\n\n'

count: count.cpp
	-$(CXX) $(CXXFLAGS) -o count count.cpp
	@printf "Now type ./count to execute the result\n\n"

findall: findall.cpp
	-$(CXX) $(CXXFLAGS) -o findall findall.cpp
	@printf "Now type ./findall to execute the result\n\n"

find: find.cpp
	-$(CXX) $(CXXFLAGS) -o find find.cpp
	@printf "Now type ./find to execute the result\n\n"

find_map_key: find_map_key.cpp
	-$(CXX) $(CXXFLAGS) -o find_map_key find_map_key.cpp
	@printf "Now type ./find_map_key to execute the result\n\n"

shuffle_and_sort: shuffle_and_sort.cpp
	-$(CXX) $(CXXFLAGS) -o shuffle_and_sort shuffle_and_sort.cpp
	@printf "Now type ./shuffle_and_sort to execute the result\n\n"

all:  count findall find find_map_key shuffle_and_sort

clean:
	rm -f *.o *.gch a.out  count findall find find_map_key shuffle_and_sort

