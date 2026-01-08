import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TrainingManagement {
    private TraineeForm traineeForm;
    private Scanner scanner;
    private Trainee[] listTrainess = new Trainee[100];
    private Trainee t;
    private byte count = 0;

    public TrainingManagement() {
        this.scanner = new Scanner(System.in);
        this.traineeForm = new TraineeForm(scanner);
    }

    public void menu() {
        String choice;
        do {
            System.out.println("1.  Creating trainee");
            System.out.println("2.  Displaying all trainees");
            System.out.println("3.  Finding trainee based on id");
            System.out.println("4   Finding trainee based name");
            System.out.println("5   Updating the trainee based on id");
            System.out.println("6   Exiting the program");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addTrainee();
                    break;
                case "2":
                    displayAllTrainee();
                    break;
                case "3":
                    System.out.println("nhập id muốn tìm kiếm: ");
                    String i = scanner.nextLine();
                    if (findTraineeById(i) != null) {
                        show(findTraineeById(i));
                    } else {
                        System.out.println("không tìm thấy id");
                    }

                    break;

                case "4":
                    System.out.println("nhập tên muốn tìm kiếm: ");
                    String n = scanner.nextLine();
                    Trainee[] result = findTrainByName(n);

                    if (result != null) {

                        for (Trainee t : result) {
                            show(t);
                        }

                    } else {
                        System.out.println("không tìm thấy");
                    }

                    break;
                case "5":
                    System.out.println("nhập id muốn sửa đổi: ");
                    String id = scanner.nextLine();

                    Trainee updID = traineeForm.getTrainee();
                    updateTrainee(id,updID);
                    break;
            }
        } while (!choice.equals("6"));
    }

    //    add
    private void addTrainee() {
        String id = traineeForm.getId();

        for (int i = 0; i < count; i++) {
            if (listTrainess[i].getId().equals(id)) {
                System.out.println("ID đã tồn tại");
                return;
            }
        }

        Trainee trainee = traineeForm.getTrainee();
        trainee.setId(id);
        listTrainess[count++] = trainee;
        System.out.println("tạo thành công!");
    }

    //    show all
    private void displayAllTrainee() {
        if (count == 0) {
            System.out.println("không có thực tập sinh");
        }

        for (int i = 0; i < count; i++) {
            show(listTrainess[i]);
        }
    }

    //    find trainee by id
    private Trainee findTraineeById(String id) {

        for (int j = 0; j < count; j++) {
            if (listTrainess[j].getId().equals(id)) {
                return listTrainess[j];
            }
        }

        return null;
    }

    //       find trainee by name
    private Trainee[] findTrainByName(String name) {
        String searchName = name.toLowerCase();
        Trainee[] trainee = new Trainee[count];
        int flag = 0;

        for (int i = 0; i < count; i++) {
            if (listTrainess[i].getName().toLowerCase().contains(searchName)) {
                trainee[flag++] = listTrainess[i];
            }
        }
        return Arrays.copyOf(trainee, flag);
    }

    //update Trainee
    private void updateTrainee(String id, Trainee newTrainess) {
    Trainee updId = findTraineeById(id);

        if (updId != null) {

            updId.setName(newTrainess.getName());

            updId.setGender(newTrainess.getGender());

            updId.setAge(newTrainess.getAge());
        }
    }

    public void show(Trainee t) {

        System.out.print("ID " + t.getId());
        System.out.print(" - name " + t.getName());
        System.out.print(" - Gender " + t.getGender());
        System.out.println(" - Age " + t.getAge());

    }

    public static void main(String[] args) {
        TrainingManagement management = new TrainingManagement();
        management.menu();
    }

}
