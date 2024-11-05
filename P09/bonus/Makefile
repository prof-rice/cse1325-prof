CXXFLAGS += --std=c++17

main: main.o clock.o timer.o *.h
	$(CXX) $(CXXFLAGS) main.o clock.o timer.o -o timer 

main.o: main.cpp *.h
	$(CXX) $(CXXFLAGS) -c main.cpp -o main.o

clock.o: clock.cpp *.h
	$(CXX) $(CXXFLAGS) -c clock.cpp -o clock.o

timer.o: timer.cpp *.h
	$(CXX) $(CXXFLAGS) -c timer.cpp -o timer.o

clean:
	-rm -f *.o *.gch *~ a.out clock timer

