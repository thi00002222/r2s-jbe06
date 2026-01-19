package training.untils;

import training.entities.Course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Validator {
    public static boolean validateCode(String code) {
        return code != null && code.matches("^RA\\d{3}$");
    }

    public static boolean isDuplicatedCode(String code, ArrayList<Course> courses) {
        return courses.stream().anyMatch(c -> c.getCode() != null && c.getCode().equalsIgnoreCase(code));

    }

    public static Boolean validateStatus(String status) {
        if (status == null) return false;
        if (status.equalsIgnoreCase("1")) return true;
        if (status.equalsIgnoreCase("2")) return false;
        return null;
    }


    private static  final List<String> validFlags = Arrays.asList("optional", "prerequisite", "N/A");

    public static boolean validateFlag(String flag) {
        if (flag == null) return false;

        String normalizedFlag = flag.trim().toLowerCase();
        if (normalizedFlag.isEmpty()){
            return false;
        }
        return validFlags.contains(normalizedFlag);
    }

    public static boolean validateDuration(short duration) {
        return duration > 0;
    }


}