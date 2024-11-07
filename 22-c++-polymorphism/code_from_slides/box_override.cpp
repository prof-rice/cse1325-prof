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

// Test the Box class
int main( ) {
   Box box1(6.0, 7.0, 5.0);
   Box box2(12.0, 13.0, 10.0);

   std::cout << box1.get_description() << std::endl;
   std::cout << "Box 1: volume " << box1.get_volume() << std::endl;
   std::cout << "Box 2: volume " << box2.get_volume() << std::endl << std::endl;

   Tribox tbox1(6.0, 7.0, 5.0);
   Tribox tbox2(12.0, 13.0, 10.0);

   std::cout << tbox1.get_description() << std::endl;
   std::cout << "Box 1: volume " << tbox1.get_volume() << std::endl;
   std::cout << "Box 2: volume " << tbox2.get_volume() << std::endl << std::endl;
}

