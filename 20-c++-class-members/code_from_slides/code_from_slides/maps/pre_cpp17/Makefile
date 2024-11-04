CXXFLAGS += -std=c++17
GTKFLAGS = `/usr/bin/pkg-config gtkmm-3.0 --cflags --libs`

all: map_verbose map_easy map_practical map_practical_plus multimap

debug: CXXFLAGS += -g
debug: rebuild

rebuild: clean all

map_verbose: map_verbose.cpp
	$(CXX) $(CXXFLAGS) -o map_verbose map_verbose.cpp
map_easy: map_easy.cpp
	$(CXX) $(CXXFLAGS) -o map_easy map_easy.cpp
map_practical: map_practical.cpp
	$(CXX) $(CXXFLAGS) -o map_practical map_practical.cpp
map_practical_plus: map_practical_plus.cpp
	$(CXX) $(CXXFLAGS) -o map_practical_plus map_practical_plus.cpp
multimap: multimap.cpp
	$(CXX) $(CXXFLAGS) -o multimap multimap.cpp
clean:
	-rm -f *.o *.gch *~ a.out map_verbose map_easy map_practical map_practical_plus multimap 

