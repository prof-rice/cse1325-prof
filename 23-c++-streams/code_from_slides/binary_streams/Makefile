CXXFLAGS = --std=c++17

info:
	@echo
	@printf 'Type e.g., "make auto"  to create program "auto" from auto.cpp\n'
	@printf 'Type       "make all"   to create every program\n'
	@printf 'Type       "make clean" to delete every program\n\n'

binary_buffers: binary_buffers.cpp
	-$(CXX) $(CXXFLAGS) -o binary_buffers binary_buffers.cpp
	@printf "Now type ./binary_buffers to execute the result\n\n"

binary_bytes: binary_bytes.cpp
	-$(CXX) $(CXXFLAGS) -o binary_bytes binary_bytes.cpp
	@printf "Now type ./binary_bytes to execute the result\n\n"

all:  binary_buffers binary_bytes

clean:
	rm -f *.o *.gch a.out  binary_buffers binary_bytes

