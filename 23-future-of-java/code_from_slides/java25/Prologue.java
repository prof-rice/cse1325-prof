class Person {
  protected int age;
  public void printAge() {
      System.out.println("Age is " + age);
  }
  public Person(int age) {
      if(age < 0) throw new IllegalArgumentException("Negative age: " + age);
      this.age = age;
      printAge();
  }
}
class Employee extends Person {
  public Employee(int age) {
      if(age < 18)                                // prologue
          throw new IllegalArgumentException("Too young: " + age);
      super(age);                                 // chaining
      System.out.println("Welcome to the team!"); // epilogue
  }
}
public class Prologue {
    public static void main(String[] args) {
        try {
            Employee employee = new Employee(15);
            System.out.println(employee);
        } catch(IllegalArgumentException e) {
            System.out.println("Not hired: " + e);
        }
    }
}
