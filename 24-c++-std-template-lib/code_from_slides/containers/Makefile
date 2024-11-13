CXXFLAGS = --std=c++17

info:
	@echo
	@printf 'Type e.g., "make auto"  to create program "auto" from auto.cpp\n'
	@printf 'Type       "make all"   to create every program\n'
	@printf 'Type       "make clean" to delete every program\n\n'

order_book: order_book.cpp
	-$(CXX) $(CXXFLAGS) -o order_book order_book.cpp
	@printf "Now type ./order_book to execute the result\n\n"

pqueue2: pqueue2.cpp
	-$(CXX) $(CXXFLAGS) -o pqueue2 pqueue2.cpp
	@printf "Now type ./pqueue2 to execute the result\n\n"

pqueue: pqueue.cpp
	-$(CXX) $(CXXFLAGS) -o pqueue pqueue.cpp
	@printf "Now type ./pqueue to execute the result\n\n"

queue: queue.cpp
	-$(CXX) $(CXXFLAGS) -o queue queue.cpp
	@printf "Now type ./queue to execute the result\n\n"

set_args: set_args.cpp
	-$(CXX) $(CXXFLAGS) -o set_args set_args.cpp
	@printf "Now type ./set_args to execute the result\n\n"

set_count: set_count.cpp
	-$(CXX) $(CXXFLAGS) -o set_count set_count.cpp
	@printf "Now type ./set_count to execute the result\n\n"

set_primes: set_primes.cpp
	-$(CXX) $(CXXFLAGS) -o set_primes set_primes.cpp
	@printf "Now type ./set_primes to execute the result\n\n"

stack: stack.cpp
	-$(CXX) $(CXXFLAGS) -o stack stack.cpp
	@printf "Now type ./stack to execute the result\n\n"

all:  order_book pqueue2 pqueue queue set_args set_count set_primes stack

clean:
	rm -f *.o *.gch a.out  order_book pqueue2 pqueue queue set_args set_count set_primes stack

