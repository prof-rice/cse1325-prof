CXXFLAGS = --std=c++17

info:
	@echo
	@printf 'Type e.g., "make jack"  to create program "jack"\n'
	@printf 'Type       "make all"   to create every program\n'
	@printf 'Type       "make clean" to delete every program\n\n'

box_nonpoly_assign: box_nonpoly_assign.cpp
	-$(CXX) $(CXXFLAGS) -o box_nonpoly_assign box_nonpoly_assign.cpp
	@printf "Now type ./box_nonpoly_assign to execute the result\n\n"

box_nonpoly: box_nonpoly.cpp
	-$(CXX) $(CXXFLAGS) -o box_nonpoly box_nonpoly.cpp
	@printf "Now type ./box_nonpoly to execute the result\n\n"

box_nonpoly_override: box_nonpoly_override.cpp
	# -$(CXX) $(CXXFLAGS) -o box_nonpoly_override box_nonpoly_override.cpp
	@printf "box_nonpoly_override will not compile - see slides\n\n"

box_override: box_override.cpp
	-$(CXX) $(CXXFLAGS) -o box_override box_override.cpp
	@printf "Now type ./box_override to execute the result\n\n"

box_poly: box_poly.cpp
	-$(CXX) $(CXXFLAGS) -o box_poly box_poly.cpp
	@printf "Now type ./box_poly to execute the result\n\n"

downcast_bad: downcast_bad.cpp
	-$(CXX) $(CXXFLAGS) -o downcast_bad downcast_bad.cpp
	@printf "Now type ./downcast_bad to execute the result\n\n"

downcast_bad_pointer: downcast_bad_pointer.cpp
	-$(CXX) $(CXXFLAGS) -o downcast_bad_pointer downcast_bad_pointer.cpp
	@printf "Now type ./downcast_bad_pointer to execute the result\n\n"

downcast_bad_static_cast: downcast_bad_static_cast.cpp
	# -$(CXX) $(CXXFLAGS) -o downcast_bad_static_cast downcast_bad_static_cast.cpp
	@printf "downcast_bad_static_cast  will not compile - see slides\n\n"

downcast_bad_void_star: downcast_bad_void_star.cpp
	-$(CXX) $(CXXFLAGS) -o downcast_bad_void_star downcast_bad_void_star.cpp
	@printf "Now type ./downcast_bad_void_star to execute the result\n\n"

downcast_c++_style: downcast_c++_style.cpp
	-$(CXX) $(CXXFLAGS) -o downcast_c++_style downcast_c++_style.cpp
	@printf "Now type ./downcast_c++_style to execute the result\n\n"

downcast_c_style: downcast_c_style.cpp
	-$(CXX) $(CXXFLAGS) -o downcast_c_style downcast_c_style.cpp
	@printf "Now type ./downcast_c_style to execute the result\n\n"

downcast_direct: downcast_direct.cpp
	# -$(CXX) $(CXXFLAGS) -o downcast_direct downcast_direct.cpp
	@printf "downcast_direct  will not compile - see slides\n\n"

downcast_dynamic2: downcast_dynamic2.cpp
	-$(CXX) $(CXXFLAGS) -o downcast_dynamic2 downcast_dynamic2.cpp
	@printf "Now type ./downcast_dynamic2 to execute the result\n\n"

downcast_dynamic: downcast_dynamic.cpp
	-$(CXX) $(CXXFLAGS) -o downcast_dynamic downcast_dynamic.cpp
	@printf "Now type ./downcast_dynamic to execute the result\n\n"

jack: jack.cpp
	-$(CXX) $(CXXFLAGS) -o jack jack.cpp
	@printf "Now type ./jack to execute the result\n\n"

mem_layout: mem_layout.cpp
	-$(CXX) $(CXXFLAGS) -o mem_layout mem_layout.cpp
	@printf "Now type ./mem_layout to execute the result\n\n"

nested_scopes: nested_scopes.cpp
	-$(CXX) $(CXXFLAGS) -o nested_scopes nested_scopes.cpp
	@printf "Now type ./nested_scopes to execute the result\n\n"

scopes: scopes.cpp
	# -$(CXX) $(CXXFLAGS) -o scopes scopes.cpp
	@printf "scopes  will not compile - see slides\n\n"

upcast_bad: upcast_bad.cpp
	-$(CXX) $(CXXFLAGS) -o upcast_bad upcast_bad.cpp
	@printf "Now type ./upcast_bad to execute the result\n\n"

upcast: upcast.cpp
	-$(CXX) $(CXXFLAGS) -o upcast upcast.cpp
	@printf "Now type ./upcast to execute the result\n\n"

void_star: void_star.cpp
	# -$(CXX) $(CXXFLAGS) -o void_star void_star.cpp
	@printf "void_star  will not compile - see optional section at end of slides\n\n"

void_star_fltk: void_star_fltk.cpp
	@printf "===> This code requires installation of FLTK - see https://www.fltk.org/software.php\n\n"
	-$(CXX) $(CXXFLAGS) -o void_star_fltk void_star_fltk.cpp
	@printf "Now type ./void_star_fltk to execute the result\n\n"

all:  box_nonpoly_assign box_nonpoly box_nonpoly_override box_override box_poly downcast_bad downcast_bad_pointer downcast_bad_static_cast downcast_bad_void_star downcast_c++_style downcast_c_style downcast_direct downcast_dynamic2 downcast_dynamic jack mem_layout nested_scopes scopes upcast_bad upcast void_star void_star_fltk

clean:
	rm -f *.o *.gch a.out  box_nonpoly_assign box_nonpoly box_nonpoly_override box_override box_poly downcast_bad downcast_bad_pointer downcast_bad_static_cast downcast_bad_void_star downcast_c++_style downcast_c_style downcast_direct downcast_dynamic2 downcast_dynamic jack mem_layout nested_scopes scopes upcast_bad upcast void_star void_star_fltk

