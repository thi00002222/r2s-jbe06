public class Employee {
    String code, name, address;
    int bYear;

    void input() {

    }

    public Employee() {
    }

    public Employee(String code, String name, int bYear, String address) {
        this.code = code;
        this.name = name;
        this.bYear = bYear;
        this.address = address;
    }

    public String toString() {
        return "Code " + code + " name " + name + " year " + bYear + " adreess " + address;
    }
}
