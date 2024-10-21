CXXFLAGS = --std=c++17

info:
	@echo
	@printf 'Type e.g., "make auto"  to create program "auto" from auto.cpp\n'
	@printf 'Type       "make all"   to create every program\n'
	@printf 'Type       "make clean" to delete every program\n\n'

calculator: calculator.cpp
	-$(CXX) $(CXXFLAGS) -o calculator calculator.cpp
	@printf "Now type ./calculator to execute the result\n\n"

all:  calculator

clean:
	rm -f *.o *.gch a.out  calculator

