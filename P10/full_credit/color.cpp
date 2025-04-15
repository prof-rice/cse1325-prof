#include "color.h"

#include <map>

std::map<Color_mode, int> code =
    {{Color_mode::FOREGROUND, 38},
     {Color_mode::BACKGROUND, 48},
     {Color_mode::RESET,       0}};

Color::Color(int red, int green, int blue, Color_mode mode)
      : _red{red}, _green{green}, _blue{blue}, _mode {mode} {
    if(red   < 0 || red   > 255) throw std::invalid_argument{"Invalid red"};
    if(green < 0 || green > 255) throw std::invalid_argument{"Invalid green"};
    if(blue  < 0 || blue  > 255) throw std::invalid_argument{"Invalid blue"};
}

Color::Color() : _mode{Color_mode::RESET} { }

int average(int a, int b) {
    return 255-(255-a)*(255-b)/255;
}

Color Color::operator+(const Color& c) {
    return Color{average(_red, c._red), 
                 average(_green, c._green), 
                 average(_blue, c._blue)};
}

void Color::output(std::ostream& ost) const {
    ost << ANSI::CSI << code[_mode];
    if(_mode != Color_mode::RESET) 
        ost << RGB << _red << ';' << _green << ';' << _blue;
    ost << 'm';
}

const std::string Color::RGB = ";2;";

