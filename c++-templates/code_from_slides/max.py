#/usr/bin/env python
import math
class Coordinate:
  # The constructor (variables spring into existance on first assignment)
  def __init__(self, x=0, y=0, z=0):
    self.x = x
    self.y = y
    self.z = z

  # The magnitude calculation (self is equivalent to *this for C++ folks)
  def magnitude(self):
    return math.sqrt(self.x*self.x + self.y*self.y + self.z*self.z)

  # overload operator<< in code (for C++ folks)
  def __str__(self):
    return "(" +str(self.x) + "," + str(self.y) + "," + str(self.z) + ")"

  # overload operator<< in an interactive session (not available for C++ folks)
  def __repr__(self):
    return __str__()

  # overload operator> (for C++ folks)
  def __gt__(self,other):
    return(self.magnitude() > other.magnitude())
  

def max(lhs, rhs):  # two comparable types
  return lhs if lhs>rhs else rhs

print("The larger of 3 and 42 is {}".format(max(3,42)))
print("The larger of 3.1415 and 2.718 is {}".format(max(3.1415,2.718)))
print("The larger of (1,2,3) and (2,1,-4) is {}".format(max(Coordinate(1,2,3),Coordinate(2,1,-4))))

