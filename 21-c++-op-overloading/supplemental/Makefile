CXXFLAGS = --std=c++17

main: main.o date.o
	$(CXX) $(CXXFLAGS) main.o date.o -o main

00_main: 00_main.o 00_date.o
	$(CXX) $(CXXFLAGS) 00_main.o 00_date.o -o 00_main

01_main: 01_main.o 01_date.o
	$(CXX) $(CXXFLAGS) 01_main.o 01_date.o -o 01_main

02_main: 02_main.o 02_date.o
	$(CXX) $(CXXFLAGS) 02_main.o 02_date.o -o 02_main

03_main: 03_main.o 03_date.o
	$(CXX) $(CXXFLAGS) 03_main.o 03_date.o -o 03_main

04_main: 04_main.o 04_date.o
	$(CXX) $(CXXFLAGS) 04_main.o 04_date.o -o 04_main

05_main: 05_main.o 05_date.o
	$(CXX) $(CXXFLAGS) 05_main.o 05_date.o -o 05_main

06_main: 06_main.o 06_date.o
	$(CXX) $(CXXFLAGS) 06_main.o 06_date.o -o 06_main

07_main: 07_main.o 07_date.o
	$(CXX) $(CXXFLAGS) 07_main.o 07_date.o -o 07_main

all: main 00_main 01_main 02_main 03_main 04_main 05_main 06_main 07_main

clean:
	rm -f *.o *.gch ~* a.out main ??_main

