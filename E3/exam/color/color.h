#pragma once

#include "red.h"
#include "green.h"
#include "blue.h"

#include <iostream>

class Color : public Red, public Green, public Blue {
  public:
    Color(int red, int green, int blue);
    friend std::ostream& operator<<(std::ostream& ost, const Color& color);
};
