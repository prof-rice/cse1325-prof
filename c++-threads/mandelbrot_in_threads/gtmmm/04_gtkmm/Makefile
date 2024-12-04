CXXFLAGS = --std=c++17 -pthread
GTKFLAGS = `/usr/bin/pkg-config gtkmm-3.0 --cflags --libs`

all: mandelbrot

mandelbrot: main.o mainwin.o canvas.o mandelbrot.o *.h
	$(CXX) $(CXXFLAGS) main.o mainwin.o canvas.o mandelbrot.o $(GTKFLAGS) -o mandelbrot
main.o: main.cpp *.h
	$(CXX) $(CXXFLAGS) -c main.cpp $(GTKFLAGS) -o main.o
mainwin.o: mainwin.cpp *.h
	$(CXX) $(CXXFLAGS) -c mainwin.cpp $(GTKFLAGS) -o mainwin.o
canvas.o: canvas.cpp *.h
	$(CXX) $(CXXFLAGS) -c canvas.cpp $(GTKFLAGS) -o canvas.o
mandelbrot.o: mandelbrot.cpp *.h
	$(CXX) $(CXXFLAGS) -c mandelbrot.cpp $(GTKFLAGS) -o mandelbrot.o

clean:
	rm -f *.o *.gch ~* a.out mandelbrot

