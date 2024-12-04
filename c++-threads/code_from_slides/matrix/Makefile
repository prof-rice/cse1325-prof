CXXFLAGS += -std=c++17
THREADFLAGS += -pthread
TIMEFORMAT = "    real %e\n    user %U\n    sys  %S\n    load %P"

all: main threads
	@echo "Results and time with NO THREADS"
	@time -f $(TIMEFORMAT) ./main
	@echo " "
	@echo "Results and time WITH 8 THREADS"
	@time -f $(TIMEFORMAT) ./threads
	@echo " "
	@echo "'real' is time experienced by you."
	@echo "'user' is sum of time spent by each core."
	@echo "'sys'  is time spent by the kernel supporting this program."
	@echo "'load' is (user + sys) / real, the system load."
debug: CXXFLAGS += -g
debug: rebuild

rebuild: clean all

main: main.cpp
	$(CXX) $(CXXFLAGS) -o main main.cpp
threads: threads.cpp
	$(CXX) $(CXXFLAGS) $(THREADFLAGS) -o threads threads.cpp

clean:
	-rm -f *.o *.gch *~ a.out main threads

