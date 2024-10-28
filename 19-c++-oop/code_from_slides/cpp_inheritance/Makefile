CXXFLAGS = --std=c++17

info:
	@echo
	@printf 'Type e.g., "make auto"  to create program "auto"\n'
	@printf 'Type       "make all"   to create every program\n'
	@printf '  IMPORTANT: Several classes include illustrative errors!\n'
	@printf 'Type       "make clean" to delete every program\n\n'

barnyard_animals_2: barnyard_animals_2.cpp
	-$(CXX) $(CXXFLAGS) -o barnyard_animals_2 barnyard_animals_2.cpp
	@printf "Now type ./barnyard_animals_2 to execute the result\n\n"

barnyard_animals: barnyard_animals.cpp
	-$(CXX) $(CXXFLAGS) -o barnyard_animals barnyard_animals.cpp
	@printf "Now type ./barnyard_animals to execute the result\n\n"

barnyard_animals_op_overload: barnyard_animals_op_overload.cpp
	-$(CXX) $(CXXFLAGS) -o barnyard_animals_op_overload barnyard_animals_op_overload.cpp
	@printf "Now type ./barnyard_animals_op_overload to execute the result\n\n"

barnyard_animals_op_overload_fixed: barnyard_animals_op_overload_fixed.cpp
	-$(CXX) $(CXXFLAGS) -o barnyard_animals_op_overload_fixed barnyard_animals_op_overload_fixed.cpp
	@printf "Now type ./barnyard_animals_op_overload_fixed to execute the result\n\n"

barnyard_animals_poly: barnyard_animals_poly.cpp
	-$(CXX) $(CXXFLAGS) -o barnyard_animals_poly barnyard_animals_poly.cpp
	@printf "Now type ./barnyard_animals_poly to execute the result\n\n"

barnyard_animals_pure_virtual: barnyard_animals_pure_virtual.cpp
	-$(CXX) $(CXXFLAGS) -o barnyard_animals_pure_virtual barnyard_animals_pure_virtual.cpp
	@printf "Now type ./barnyard_animals_pure_virtual to execute the result\n\n"

barnyard_simple: barnyard_simple.cpp
	-$(CXX) $(CXXFLAGS) -o barnyard_simple barnyard_simple.cpp
	@printf "Now type ./barnyard_simple to execute the result\n\n"

destructor: destructor.cpp
	-$(CXX) $(CXXFLAGS) -o destructor destructor.cpp
	@printf "Now type ./destructor to execute the result\n\n"

downcast_bad: downcast_bad.cpp
	-$(CXX) $(CXXFLAGS) -o downcast_bad downcast_bad.cpp
	@printf "Now type ./downcast_bad to execute the result\n\n"

downcast_bad_pointer: downcast_bad_pointer.cpp
	-$(CXX) $(CXXFLAGS) -o downcast_bad_pointer downcast_bad_pointer.cpp
	@printf "Now type ./downcast_bad_pointer to execute the result\n\n"

downcast_bad_static_cast: downcast_bad_static_cast.cpp
	-$(CXX) $(CXXFLAGS) -o downcast_bad_static_cast downcast_bad_static_cast.cpp
	@printf "Now type ./downcast_bad_static_cast to execute the result\n\n"

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
	-$(CXX) $(CXXFLAGS) -o downcast_direct downcast_direct.cpp
	@printf "Now type ./downcast_direct to execute the result\n\n"

downcast_dynamic: downcast_dynamic.cpp
	-$(CXX) $(CXXFLAGS) -o downcast_dynamic downcast_dynamic.cpp
	@printf "Now type ./downcast_dynamic to execute the result\n\n"

friends: friends.cpp
	-$(CXX) $(CXXFLAGS) -o friends friends.cpp
	@printf "Now type ./friends to execute the result\n\n"

multiple_inheritance: multiple_inheritance.cpp
	-$(CXX) $(CXXFLAGS) -o multiple_inheritance multiple_inheritance.cpp
	@printf "Now type ./multiple_inheritance to execute the result\n\n"

pure_virtual_bad: pure_virtual_bad.cpp
	-$(CXX) $(CXXFLAGS) -o pure_virtual_bad pure_virtual_bad.cpp
	@printf "Now type ./pure_virtual_bad to execute the result\n\n"

pure_virtual_fixed: pure_virtual_fixed.cpp
	-$(CXX) $(CXXFLAGS) -o pure_virtual_fixed pure_virtual_fixed.cpp
	@printf "Now type ./pure_virtual_fixed to execute the result\n\n"

upcast_bad: upcast_bad.cpp
	-$(CXX) $(CXXFLAGS) -o upcast_bad upcast_bad.cpp
	@printf "Now type ./upcast_bad to execute the result\n\n"

upcast: upcast.cpp
	-$(CXX) $(CXXFLAGS) -o upcast upcast.cpp
	@printf "Now type ./upcast to execute the result\n\n"

all:  barnyard_animals_2 barnyard_animals barnyard_animals_op_overload barnyard_animals_op_overload_fixed barnyard_animals_poly barnyard_animals_pure_virtual barnyard_simple destructor downcast_bad downcast_bad_pointer downcast_bad_static_cast downcast_bad_void_star downcast_c++_style downcast_c_style downcast_direct downcast_dynamic friends multiple_inheritance pure_virtual_bad pure_virtual_fixed upcast_bad upcast

clean:
	rm -f *.o *.gch a.out  barnyard_animals_2 barnyard_animals barnyard_animals_op_overload barnyard_animals_op_overload_fixed barnyard_animals_poly barnyard_animals_pure_virtual barnyard_simple destructor downcast_bad downcast_bad_pointer downcast_bad_static_cast downcast_bad_void_star downcast_c++_style downcast_c_style downcast_direct downcast_dynamic friends multiple_inheritance pure_virtual_bad pure_virtual_fixed upcast_bad upcast

