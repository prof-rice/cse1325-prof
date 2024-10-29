CXXFLAGS += --std=c++17

nums: nums.cpp *.h
	-$(CXX) $(CXXFLAGS)  nums.cpp -o nums
	@printf "Now type ./nums and some words to execute the result\n\n"

clean:
	rm -f *.o *.gch *~ a.out nums

