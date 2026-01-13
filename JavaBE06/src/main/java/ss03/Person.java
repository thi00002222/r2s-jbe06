package ss03;

public class Person {
    String id;
    String name;
    String email;

    public Person(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void show(){
        System.out.println(id+" "+" "+name+" "+email);
    }
}
