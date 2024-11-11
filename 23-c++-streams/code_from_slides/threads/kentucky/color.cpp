#include "color.h"
#include <algorithm>

// Static members MUST be define outside the class declaration
const Color Color::RESET{};
const Color Color::BG     {  0,  0,  0, true}; // Add to color below for background color
const Color Color::BLACK  {  0,  0,  0};
const Color Color::BLUE   {  0,  0,255};
const Color Color::GREEN  {  0,255,  0};
const Color Color::CYAN   {  0,255,255};
const Color Color::RED    {255,  0,  0};
const Color Color::MAGENTA{255,  0,255};
const Color Color::YELLOW {255,255,  0};
const Color Color::GREY   {128,128,128};
const Color Color::WHITE  {255,255,255};

// ////////////
// Constructors
// ////////////

// This resets the terminal to its defaults
Color::Color() : _reset{true} { }

// This forces the parameters to [0,255] with no terminal reset
Color::Color(int red, int green, int blue, bool background)
      : _red  {std::max(0,std::min(255,red  ))},
        _green{std::max(0,std::min(255,green))},
        _blue {std::max(0,std::min(255,blue ))},
        _background{background},
        _reset{false} { }

// ///////////
// Comparisons
// ///////////

// The actual comparison operators are inline in color.h

// This is the "subjective brightness", 
// which is of questionable real-world value
double Color::magnitude() const {
    return (0.21 * (double)_red)
         + (0.72 * (double)_green)
         + (0.07 * (double)_blue);
}

// This returns 1 if the current object is > rhs,
//              0 if equal, or -1 if < rhs
// See operator<=> (the "spaceship operator") in C++ 20, 
//    which can auto-generate the rest!
int Color::cmp(const Color& rhs) const {
   return (magnitude() == rhs.magnitude()) ? 0 : 
         ((magnitude()  > rhs.magnitude()) ? 1 : -1);
}

// ////////////////
// Input and Output
// ////////////////

std::string Color::to_string() {
    return (_background ? "[" : "(") 
               + std::to_string(_red)   + ","
               + std::to_string(_green) + ","
               + std::to_string(_blue)  
           + (_background ? "]" : ")");
}

std::ostream& operator<<(std::ostream& ost, const Color& color) {
    if(color._reset) {
        //  ESC[ 0 m Reset to defaults
        ost << "\033[0m";
    } else {
        //  ESC[ 38;2;⟨r⟩;⟨g⟩;⟨b⟩ m Select RGB foreground color
        //  ESC[ 48;2;⟨r⟩;⟨g⟩;⟨b⟩ m Select RGB foreground color
        ost << "\033[" << (color._background ? 48 : 38) << ";2;" 
            << color._red << ';' 
            << color._green << ';'
            << color._blue << 'm';
    }
    return ost;
}

std::istream& operator>>(std::istream& ist, Color& color) {
    // Of the form "(64, 96, 128)" - remember, >> skips whitespace!
    // Some data validation would be GREAT to add here!  :-D
    char b, c;
    ist >> b >> color._red >> c >> color._green >> c >> color._blue >> c;
    color._background = (b == '[');
    color._reset = false;
    return ist;
}

// //////////////////////
// Addition / Subtraction
// //////////////////////

// + and - add R, G, and B respectively

Color operator+(const Color& lhs, const Color& rhs) {
    return Color{lhs._red        + rhs._red,
                 lhs._green      + rhs._green,
                 lhs._blue       + rhs._blue,
                 lhs._background | rhs._background};
}
Color operator-(const Color& lhs, const Color& rhs) {
    return Color{lhs._red   - rhs._red,
                 lhs._green - rhs._green,
                 lhs._blue  - rhs._blue,
                 lhs._background | rhs._background};
}
Color& Color::operator+=(const Color& rhs) {
    _red += rhs._red;
    _green += rhs._green;
    _blue += rhs._blue;
    _background |= rhs._background;
    return *this;  // Return the current object (to support c1 += c2 + c3)
}

Color& Color::operator-=(const Color& rhs) {
    _red -= rhs._red;
    _green -= rhs._green;
    _blue -= rhs._blue;
    _background |= rhs._background;
    return *this;
}
Color operator+(const Color& lhs, int rhs) {
    return lhs + Color{rhs, rhs, rhs};
}
Color operator-(const Color& lhs, int rhs) {
    return Color{lhs._red   - rhs,
                 lhs._green - rhs,
                 lhs._blue  - rhs};
}
Color operator+(int lhs, const Color& rhs) {
    return rhs + lhs;
}
Color operator-(int lhs, const Color& rhs) {
    return rhs - lhs;
}
Color& Color::operator+=(int rhs) {
     _red += rhs;
    _green += rhs;
    _blue += rhs;
    return *this;  // Return the current object (to support c1 += c2 + c3)
}
Color& Color::operator-=(int rhs) {
     _red -= rhs;
    _green -= rhs;
    _blue -= rhs;
    return *this;
}

Color& Color::operator++() {    // Pre-increment
    *this += 1;
    return *this;
}
Color& Color::operator--() {    // Pre-decrement
    *this -= 1;
    return *this;
}
Color  Color::operator++(int) { // Post-increment
    Color temp{*this};
    operator++();
    return temp;
}
Color  Color::operator--(int) { // Post-decrement
    Color temp{*this};
    operator--();
    return temp;
}

// /////////////////////
// Blending / Unblending
// /////////////////////

Color operator*(const Color& lhs, const Color& rhs) {
    return Color{(lhs._red   + rhs._red)/2,
                 (lhs._green + rhs._green)/2,
                 (lhs._blue  + rhs._blue)/2};
}
Color operator/(const Color& lhs, const Color& rhs) {
    return Color{2*lhs._red   - rhs._red,
                 2*lhs._green - rhs._green,
                 2*lhs._blue  + rhs._blue};
}
Color& Color::operator*=(const Color& rhs) {
    _red   = (_red   + rhs._red)/2;
    _green = (_green + rhs._green)/2;
    _blue  = (_blue  + rhs._blue)/2;
    return *this;
}
Color& Color::operator/=(const Color& rhs) {
    _red   = 2*_red   - rhs._red;
    _green = 2*_green + rhs._green;
    _blue  = 2*_blue  + rhs._blue;
    return *this;
}

