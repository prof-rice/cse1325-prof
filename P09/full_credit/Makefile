CXXFLAGS += --std=c++17

clock: main.o clock.o *.h
	$(CXX) $(CXXFLAGS) main.o clock.o  -o clock

main.o: main.cpp *.h
	$(CXX) $(CXXFLAGS) -c main.cpp -o main.o

clock.o: clock.cpp *.h
	$(CXX) $(CXXFLAGS) -c clock.cpp -o clock.o

threaded: main_threaded.o clock.o *.h
	$(CXX) $(CXXFLAGS) -pthread main_threaded.o clock.o  -o clock

main_threaded.o: main_threaded.cpp *.h
	$(CXX) $(CXXFLAGS) -c -pthread main_threaded.cpp -o main_threaded.o


clean:
	-rm -f *.o *.gch *~ a.out clock

