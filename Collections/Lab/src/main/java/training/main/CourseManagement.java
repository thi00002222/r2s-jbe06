package training.main;

import training.entities.Course;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseManagement {
    private ArrayList<Course> courses = new ArrayList<>();

    public CourseManagement() {
    }

    public CourseManagement(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void input(Scanner sc) {
        Course course = new Course();
        course.input(sc, courses);
        courses.add(course);
        System.out.println("Course added successfully!");
    }

    public ArrayList<Course> sreach(String type, Course course) {
        ArrayList<Course> result = new ArrayList<>();

        switch (type.toLowerCase()) {
            case "code":
                for (Course c : courses) {
                    if (c.getCode().equalsIgnoreCase(course.getCode())) {
                        result.add(c);
                    }
                }
                break;
            case "name":
                for (Course c : courses) {
                    if (c.getName().toLowerCase().contains(course.getName().toLowerCase())) {
                        result.add(c);
                    }
                }
                break;
            case "status":
                for (Course c : courses) {
                    if (c.isStatus() == course.isStatus()) {
                        result.add(c);
                    }
                }
                break;
            case "duration":
                for (Course c : courses) {
                    if (c.getDuration() == course.getDuration()) {
                        result.add(c);
                    }
                }
                break;
            case "flag":
                for (Course c : courses) {
                    if (c.getFlag().equalsIgnoreCase(course.getFlag())) {
                        result.add(c);
                    }
                }
                break;
            default:
                System.out.println("Invalid search type!");
        }

        return result;
    }

    public void displayAll() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        for (Course c : courses) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseManagement cm = new CourseManagement();
        while (true) {
            System.out.println("\nCourse Management System");
            System.out.println("1. Add Course");
            System.out.println("2. Search Course");
            System.out.println("3. Display All Courses");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    cm.input(scanner);
                    break;
                case "2":
                    System.out.print("Enter search type (code, name, status, duration, flag): ");
                    String type = scanner.nextLine();
                    Course searchCourse = new Course();
                    switch (type.toLowerCase()) {
                        case "code":
                            System.out.print("Enter course code to search: ");
                            searchCourse.setCode(scanner.nextLine());
                            break;
                        case "name":
                            System.out.print("Enter course name to search: ");
                            searchCourse.setName(scanner.nextLine());
                            break;
                        case "status":
                            System.out.print("Enter course status to search (true/false): ");
                            searchCourse.setStatus(Boolean.parseBoolean(scanner.nextLine()));
                            break;
                        case "duration":
                            System.out.print("Enter course duration to search: ");
                            searchCourse.setDuration(Short.parseShort(scanner.nextLine()));
                            break;
                        case "flag":
                            System.out.print("Enter course flag to search: ");
                            searchCourse.setFlag(scanner.nextLine());
                            break;
                        default:
                            System.out.println("Invalid search type!");
                            continue;
                    }
                    ArrayList<Course> results = cm.sreach(type, searchCourse);
                    if (results.isEmpty()) {
                        System.out.println("No courses found.");
                    } else {
                        for (Course c : results) {
                            System.out.println(c);
                        }
                    }
                    break;
                case "3":
                    cm.displayAll();
                    break;
                case "4":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

}
