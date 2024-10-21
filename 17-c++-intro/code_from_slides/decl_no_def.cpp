double sqrt(double);  // Declaration, but no definition!
double sqrt(double);  // A duplicate declaration (perfectly legal)

int main() {
  double pi{3.14159265};
  double sqrt_pi = sqrt(pi);  // Reference - definition will be required
}

// Never provided a definition (inside { }) for double sqrt(double)
