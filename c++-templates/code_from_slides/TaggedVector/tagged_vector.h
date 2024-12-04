#include <iostream>
#include <sstream>
#include <vector>
#include <ctime>

// This class stores a time-tagged value of type T
template<class T>
class TaggedObject {
  public:
    TaggedObject(time_t date, T value) : _date{date}, _value{value} { }  
      
    time_t _date;
    T _value;
};

// This declares operator << for a TaggedObject
// It must be a template, since we don't know the type of TaggedObject!
template <class T>
std::ostream& operator<< (std::ostream& ost, const TaggedObject<T>& to) {
    std::string date = std::string{ctime(&to._date)};
    date.pop_back(); // ctime appends a newline (seriously???) - remove it
    ost << "'" << to._value << "' (at " << date << ")";
    return ost;
}

// Similarly, we provide a to_string function for TaggedObjects
//   and any other type for which operator << is defined
template <class T>
std::string to_string(const T& value) {
  std::ostringstream oss;
  oss << value;
  return oss.str();
}

// Our TaggedVector at last!
// Access the TaggedObject with subscripting: v[i]
// Access the T value directly with get: v.get(i)
// Access the time_t date with when: v.when(i)
template <class T>
class TaggedVector {
  public:
    void push_back(T element) {v.push_back(TaggedObject(time(0), element));}
    TaggedObject<T>& operator[](int index) {return v[index];}
    T get(int index) {return v[index]._value;}
    time_t when(int index) {return v[index]._date;}
    int size() {return v.size();}
    std::string to_string(int index) {return to_string(v[index]);}
    
  private:
    std::vector<TaggedObject<T>> v;
};

