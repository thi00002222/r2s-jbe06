import java.util.Scanner;

public class HelloWorld {



    public static void main(String[] args) {
        String name, address;
        int age;
        Scanner scanner = new Scanner(System.in);

//        input
        System.out.println("vui lòng nhập tên của bạn:");
        name = scanner.nextLine();

        System.out.println("vui lòng nhập địa chỉ của bạn:");
        address = scanner.nextLine();

        do {
            System.out.println("vui lòng nhập tuổi của bạn:");
            age = Integer.parseInt(scanner.nextLine());
        }
        while (age <= 18);


//        output
        System.out.println(name + " " + age + " " + address);
    }
}


