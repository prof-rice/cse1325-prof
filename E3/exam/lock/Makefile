CXXFLAGS = --std=c++20

keyring: keyring.o lock.o key.o state.o misfit.o *.h
	-$(CXX) $(CXXFLAGS) keyring.o lock.o key.o state.o misfit.o -o keyring

misfit.o: misfit.cpp *.h
	-$(CXX) $(CXXFLAGS) -c misfit.cpp -o misfit.o

key.o: key.cpp *.h
	-$(CXX) $(CXXFLAGS) -c key.cpp -o key.o

keyring.o: keyring.cpp *.h
	-$(CXX) $(CXXFLAGS) -c keyring.cpp -o keyring.o

lock.o: lock.cpp *.h
	-$(CXX) $(CXXFLAGS) -c lock.cpp -o lock.o

state.o: state.cpp *.h
	-$(CXX) $(CXXFLAGS) -c state.cpp -o state.o

clean:
	rm -f *.o *.gch a.out keyring 

