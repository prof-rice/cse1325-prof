CXXFLAGS = --std=c++17

info:
	@echo
	@printf 'Type e.g., "make auto"  to create program "auto" from auto.cpp\n'
	@printf 'Type       "make all"   to create every program\n'
	@printf 'Type       "make clean" to delete every program\n\n'

read: read.cpp
	-$(CXX) $(CXXFLAGS) -o read read.cpp
	@printf "Now type ./read to execute the result\n\n"

stringstreams: stringstreams.cpp
	-$(CXX) $(CXXFLAGS) -o stringstreams stringstreams.cpp
	@printf "Now type ./stringstreams to execute the result\n\n"

write: write.cpp
	-$(CXX) $(CXXFLAGS) -o write write.cpp
	@printf "Now type ./write to execute the result\n\n"

all:  read stringstreams write

clean:
	rm -f *.o *.gch a.out  read stringstreams write test.txt

