package training.entities;

import training.untils.Validator;

import java.util.ArrayList;
import java.util.Scanner;

public class Course {
    private String code;
    private String name;
    private boolean status;
    private short duration;
    private String flag;

    public Course() {
    }

    public Course(String code, String name, boolean status, short duration, String flag) {
        this.code = code;
        this.name = name;
        this.status = status;
        this.duration = duration;
        this.flag = flag;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public boolean isStatus() {
        return status;
    }

    public short getDuration() {
        return duration;
    }

    public String getFlag() {
        return flag;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Course{" + "code='" + code + '\'' + ", name='" + name + '\'' + ", status=" + (status ? "active" : "in-active") + ", duration=" + duration + ", flag='" + flag + '\'' + '}';
    }

    public void input(Scanner scanner, ArrayList<Course> courses) {
//        input code
        while (true) {
            System.out.print("Enter course code: ");
            String code = scanner.nextLine().toUpperCase();

            if (Validator.validateCode(code)) {
                if (Validator.isDuplicatedCode(code, courses)) {
                    System.out.println("Code is duplicate!");
                } else {
                    this.setCode(code);
                    break;
                }
            } else {
                System.out.println("Code must be in format RAxxx (x is digit)!");
            }

            System.out.println("Code is not valid!");


        }

//        input name
        while (true) {
            System.out.print("Enter course name: ");
            String name = scanner.nextLine();

            if (!name.isEmpty()) {
                this.setName(name);
                break;
            }

            System.out.println("Name is not null!");
        }

//        input status
        while (true) {
            System.out.println("Enter status (active / in-active): ");
            System.out.println("1. active: ");
            System.out.println("2. in-active: ");
            System.out.print("please choice 1 or 2: ");

            String statusInput = scanner.nextLine();

            Boolean status = Validator.validateStatus(statusInput);

            if (status == null) {
                System.out.println("Invalid status! Please enter active or in-active.");
                continue;
            }

            this.setStatus(status);
            break;

        }

//        input duration
        while (true) {
            try {

                System.out.print("Enter course duration (in hours): ");
                short duration = Short.parseShort(scanner.nextLine());

                if (duration > 0) {
                    this.setDuration(duration);
                    break;
                }

                System.out.println("Duration must be more than 0");

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }

        }

//        input flag
        while (true) {
            try {
                System.out.println("choice course flag: ");
                System.out.println("1. optional");
                System.out.println("2. prerequisite");
                System.out.println("3. N/A");
                byte flag = Byte.parseByte(scanner.nextLine());

                if (flag == 1) {
                    this.setFlag("optional");
                    break;
                } else if (flag == 2) {
                    this.setFlag("prerequisite");
                    break;
                } else if (flag == 3) {
                    this.setFlag("N/A");
                    break;
                }
                System.out.println("please choice 1 to 3");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }
}
