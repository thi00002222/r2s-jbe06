public class HR {
    public static void main(String[] args) {
        Employee employee = new Employee("C123","Minh",2000,"1	Ba	Trieu");
        Employee employee1 = new Employee();
        System.out.println(employee.toString());

        System.out.println(employee.name.length());
    }
}
