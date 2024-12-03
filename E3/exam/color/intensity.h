#pragma once

class Intensity {
  public:
    Intensity(int value);
    int value() const;
  protected:
    int _value; // 0-255
};
