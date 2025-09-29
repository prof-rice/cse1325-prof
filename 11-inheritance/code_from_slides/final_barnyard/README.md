# This Code Won't Build!

This is intentional.

As shown in the error message, we declared the count() method 
in superclass Critter as final, but then tried to override (replace) it 
for subclass Chicken.

You CANNOT override a final method from your superclass!

