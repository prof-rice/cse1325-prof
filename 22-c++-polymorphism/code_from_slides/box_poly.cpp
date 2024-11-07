#include <iostream>

// Box and Tribox classes

class Box {
  public:
     Box (double len, double bre, double hei)
        : length(len), breadth(bre), height(hei) { }
     virtual double get_volume(void) {return length * breadth * height;}
     virtual std::string get_description() {return "Rectangular box";}

  protected:
     double length;      // Length of a box
     double breadth;     // Breadth of a box
     double height;      // Height of a box
};

class Tribox : public Box {
   public:
      Tribox (double len, double bre, double hei)
        : Box(len, bre, hei) { }
     double get_volume(void) override {return length * breadth * height / 2;}
     std::string get_description() override {return "Triangular box";}
};

// Call by value, reference, and pointer
void print_volume(Box b) {
   std::cout << b.get_description() << " volume is " << b.get_volume() << std::endl;
}

void print_volume_ref(Box& b) {
   std::cout << b.get_description() << " volume is " << b.get_volume() << std::endl;
}

void print_volume_p(Box* b) {
   std::cout << b->get_description() << " volume is " << b->get_volume() << std::endl;
}

// Test the Box class
int main( ) {
   Box box1(6.0, 7.0, 5.0);
   Tribox tbox1(6.0, 7.0, 5.0);

   std::cout << "\nAccess derived class methods directly:" << std::endl;
   print_volume(box1);
   print_volume(tbox1);

   std::cout << "\nAccess derived class methods via reference:" << std::endl;
   print_volume_ref(box1);
   print_volume_ref(tbox1);

   std::cout << "\nAccess derived class methods via pointers:" << std::endl;
   print_volume_p(&box1);
   print_volume_p(&tbox1);
}
