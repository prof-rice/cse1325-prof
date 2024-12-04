CXXFLAGS += -std=c++17 -pthread

all: horserace

debug: CXXFLAGS += -g
debug: horserace

rebuild: clean horserace

horserace: horserace.o horse.o color.o
	g++ $(CXXFLAGS) horserace.o horse.o color.o -o horserace
horserace.o: horserace.cpp horse.h
	g++ $(CXXFLAGS) -c horserace.cpp
horse.o: horse.cpp horse.h
	g++ $(CXXFLAGS) -c horse.cpp
color.o: color.cpp color.h
	g++ $(CXXFLAGS) -c color.cpp
clean:
	-rm -f *.o *~ horserace 

