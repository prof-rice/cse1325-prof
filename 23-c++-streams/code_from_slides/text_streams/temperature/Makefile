CXXFLAGS += --std=c++17

all: temps

# Build with the debug option
debug: CXXFLAGS += -g
debug: all

rebuild: clean temps

temps: main.o readings.o reading.o
	$(CXX) $(CXXFLAGS) main.o readings.o reading.o -o temps 

main.o: main.cpp *.h
	$(CXX) $(CXXFLAGS) -c main.cpp -o main.o
readings.o: readings.cpp *.h
	$(CXX) $(CXXFLAGS) -c readings.cpp -o readings.o
reading.o: reading.cpp *.h
	$(CXX) $(CXXFLAGS) -c reading.cpp -o reading.o

clean:
	-rm -f *.o *.gch *~ a.out temps

