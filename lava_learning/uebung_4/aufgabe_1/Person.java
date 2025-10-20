public class Person {
  String name;
  float alter;

  public Person(String _name, float _alter) {
    this.name = _name;
    this.alter = _alter;
  }

  void printDetails() {
    System.out.format("%s : %f\n", this.name, this.alter);
  }

  public static void main(String[] args) {
    Person p0 = new Person("Alex", 22.0f);
    Person p1 = new Person("Steve", 992.0f);

    p0.printDetails();
    p1.printDetails();
  }

}
