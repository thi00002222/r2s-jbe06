import java.util.Scanner;

public class TraineeForm {
    private Scanner scanner = new Scanner(System.in);

    public String getId() {
        while (true) {
            System.out.println("nhập id");
            String id = scanner.nextLine();

            if (id != null && !id.trim().isEmpty()) {
                return id;
            }
            System.out.println("id không được để trống!");
        }
    }

    public TraineeForm() {

    }

    public TraineeForm(Scanner scanner) {
        this.scanner = scanner;
    }

    public Trainee getTrainee() {
        String name = name();
        String gender = gender();
        byte age = age();
        return new Trainee("ID", name, gender, age);
    }

    public String name() {
        do {
            System.out.println("nhập tên: ");
            String name = scanner.nextLine();

            if (name != null && !name.trim().isEmpty()) {
                return name;
            }
            System.out.println("tên không hợp lệ");
        } while (true);
    }

    public  String gender(){
        do {
            System.out.println("nhập giới tính: ");
            String gender = scanner.nextLine();

            if (gender.equalsIgnoreCase("male")||gender.equalsIgnoreCase("female")){
                return gender.toLowerCase();
            }
            System.out.println("giới tính không phù hợp");
        }while (true);
    }

    public byte age(){
        do {
            try{

            System.out.println("nhập tuổi: ");
            byte age = Byte.parseByte(scanner.nextLine());

            if (age>=6){
                return  age;
            }
            System.out.println("tuổi phải hơn 6");
            } catch (NumberFormatException e){
                System.out.println("vui lòng nhập số");
            }

        }while (true);
    }

}
