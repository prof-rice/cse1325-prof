CXXFLAGS = --std=c++17

info:
	@echo
	@printf 'Type e.g., "make auto"  to create program "auto" from auto.cpp\n'
	@printf 'Type       "make all"   to create every program\n'
	@printf 'Type       "make clean" to delete every program\n\n'

main: main.cpp
	-$(CXX) $(CXXFLAGS) -o main main.cpp
	@printf "Now type ./main to execute the result\n\n"

all:  main

clean:
	rm -f *.o *.gch a.out  main

