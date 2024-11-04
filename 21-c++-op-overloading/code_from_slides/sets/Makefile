CXXFLAGS = --std=c++17

info:
	@echo
	@printf 'Type e.g., "make auto"  to create program "auto" from auto.cpp\n'
	@printf 'Type       "make all"   to create every program\n'
	@printf 'Type       "make clean" to delete every program\n\n'

set_args: set_args.cpp
	-$(CXX) $(CXXFLAGS) -o set_args set_args.cpp
	@printf "Now type ./set_args to execute the result\n\n"

set_count: set_count.cpp
	-$(CXX) $(CXXFLAGS) -o set_count set_count.cpp
	@printf "Now type ./set_count to execute the result\n\n"

set_primes: set_primes.cpp
	-$(CXX) $(CXXFLAGS) -o set_primes set_primes.cpp
	@printf "Now type ./set_primes to execute the result\n\n"

all:  set_args set_count set_primes

clean:
	rm -f *.o *.gch a.out  set_args set_count set_primes

