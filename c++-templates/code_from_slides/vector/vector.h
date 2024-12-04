#ifndef __VECTOR_H
#define __VECTOR_H


// Here's a quick look a very simplified std::vector-like template.
// std::vector isn't magic - somebody wrote it! Somebody... like you?

#include <cassert>

template <class T>
class Vector {
  public:
    Vector(int s = 10) : _size{0}, _max(s), _elem{new T[s]} { }
    // RULE OF 3
    //   --> Destructor - Free the allocated array from the heap
    ~Vector() {delete[] _elem; }
    //   --> Copy Constructor - Create a new array and copy the data
    Vector(const Vector<T>& v) {
        _size=v._size; 
        _max=v._max;
        _elem = new T[_size];
        for (int i=0; i<_size; ++i) _elem[i] = v._elem[i];
    }
    //   --> Copy Assignment Operator - Create a new array and copy the data
    Vector<T>& operator= (const Vector<T>& v) {
        if(this == &v) return *this;
        delete[] _elem;
        _size = v._size;
        _max=v._max;
        _elem = new T[_size];
        for (int i=0; i<_size; ++i) _elem[i] = v._elem[i];
        return *this;
    }
    int size() {return _size;}
    void push_back(T t) {_elem[_size] = t; assert(_size++ < _max);}
    void pop_back() {assert(_size-- > 0);}
    T& back() {return operator[](_size-1);}
    T& operator[](int n) {assert(0 <= n && n < _size); return _elem[n]; } 
  private:
    int _max;  // size of the array
    int _size; // next array element
    T*  _elem; // a pointer to the elements
};

#endif
