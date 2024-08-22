CXXFLAGS = --std=c++17

all: clean ant test_cpp_file_io test_cpp_io

ant:
	@ant -silent
	@printf "\n===================================================\n"
	@printf "\nType java TestJavaArgs with command line parameters\n"
	@printf "\nType java TestJavaFileIO to verify that files can be read from Java\n"
	@printf "\nType java TestJavaIO and answer the question to test Java console I/O\n"

test_cpp_file_io: test_cpp_file_io.cpp
	@$(CXX) $(CXXFLAGS) -o test_cpp_file_io test_cpp_file_io.cpp
	@printf "\nType ./test_cpp_file_io to verify files can be read from C++\n"

test_cpp_io: test_cpp_io.cpp
	@$(CXX) $(CXXFLAGS) -o test_cpp_io test_cpp_io.cpp
	@printf "\nType ./test_cpp_io and answer the questions to test C++ console I/O\n"

clean:
	@rm -f *.o *.gch a.out  test_cpp_file_io test_cpp_io
	@ant -silent clean

