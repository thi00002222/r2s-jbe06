import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Student[] listStudent = new Student[100];
        Scanner scanner = new Scanner(System.in);
        String choice;

        int count = 0;
        do {
            System.out.println("add student");
            System.out.println("display all");
            System.out.println("exit");
            System.out.println("choice: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    Student student = new Student();
                    System.out.println("nhập tên sinh viên: ");
                    student.name = scanner.nextLine();
                    System.out.println("nhập điểm môn thứ 1: ");
                    student.mark1 = Float.parseFloat(scanner.nextLine());
                    System.out.println("nhập điểm môn thứ 2: ");
                    student.mark2 = Float.parseFloat(scanner.nextLine());
                    System.out.println("nhập điểm môn thứ 3: ");
                    student.mark3 = Float.parseFloat(scanner.nextLine());
                    listStudent[count++] = student;
                    break;
                case "2":
                    if(count == 0){
                        System.out.println("no studen!");
                        break;
                    }
                    for (int i = 0; i < count; i++) {


                        System.out.println(listStudent[i].name);
                        System.out.println(listStudent[i].mark1);
                        System.out.println(listStudent[i].mark2);
                        System.out.println(listStudent[i].mark3);
                        System.out.println(listStudent[i].total());
                        System.out.println(listStudent[i].total());
                    }
                    break;


            }
        }
        while (!choice.equals("0"));

    }
}
