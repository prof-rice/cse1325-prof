#ifndef __COLOR_H
#define __COLOR_H

#include <iostream>

// When streamed to an ostream, sets the foreground or background color of the text, e.g.,
//     Color UTA_ORANGE{245,128,38}; // Red = 245, Green = 128, Blue = 38; all between 0 and 255
//     std::cout << Color{0,100,177} << "UTA Blue and " << UTA_ORANGE << "UTA Orange.\n"; 
//     std::cout << Color::RED << "This text is red\n";
//     for(Color c{Color::BLACK}; c<Color::WHITE; ++c) std::cout << c << 'X'; 
//     std::cout << Color::RED << Color::BLUE + Color::BG << "Red on blue text" << std::endl;

class Color {
  public:
    Color(); // Resets the terminal
    Color(int red, int green, int blue, bool background=false);

    // Human output (to_string) and input (>>), and terminal control (<<)
    std::string to_string();
    friend std::ostream& operator<<(std::ostream& ost, const Color& color);
    friend std::istream& operator>>(std::istream& ist, Color& color);

    // Adds / subtracts corresponding reds, greens, and blues or int to all 3
    friend Color operator+(const Color& lhs, const Color& rhs);
    friend Color operator-(const Color& lhs, const Color& rhs);
    friend Color operator+(const Color& lhs, int rhs);
    friend Color operator-(const Color& lhs, int rhs);
    friend Color operator+(int lhs, const Color& rhs);
    friend Color operator-(int lhs, const Color& rhs);
    Color& operator+=(const Color& rhs);
    Color& operator-=(const Color& rhs);
    Color& operator+=(int rhs);
    Color& operator-=(int rhs);
    Color& operator++();    // Pre-increment
    Color& operator--();    // Pre-decrement
    Color  operator++(int); // Post-increment
    Color  operator--(int); // Post-decrement

    // Blends / unblends (averages corresponding reds, greens, and blues)
    friend Color operator*(const Color& lhs, const Color& rhs);
    friend Color operator/(const Color& lhs, const Color& rhs);
    Color& operator*=(const Color& rhs);
    Color& operator/=(const Color& rhs);

    // Compares corresponding reds, greens, and blues
    // Inline methods generate code where called rather than in the class
    inline bool operator==(const Color& rhs) {return cmp(rhs) == 0;}
    inline bool operator!=(const Color& rhs) {return cmp(rhs) != 0;}
    inline bool operator< (const Color& rhs) {return cmp(rhs) < 0;}
    inline bool operator> (const Color& rhs) {return cmp(rhs) > 0;}
    inline bool operator<=(const Color& rhs) {return cmp(rhs) <= 0;}
    inline bool operator>=(const Color& rhs) {return cmp(rhs) >= 0;}
    
    // Constant colors, e.g., Color::BLACK
    static const Color RESET; // Resets the terminal
    static const Color BG;    // Add to color below to make it a background color
    static const Color BLACK;
    static const Color BLUE;
    static const Color GREEN;
    static const Color CYAN;
    static const Color RED;
    static const Color MAGENTA;
    static const Color YELLOW;
    static const Color GREY;
    static const Color WHITE;

  private:
    int _red;
    int _green;
    int _blue;
    bool _background; // If true, set background rather than foreground color
    bool _reset;      // If true, ignore all other fields and reset the terminal

    // Utility functions for comparisons
    int cmp(const Color& rhs) const; // 1 if > rhs, 0 if ==, -1 if <
    double magnitude() const;        // The "subjective brightness"
};
#endif

