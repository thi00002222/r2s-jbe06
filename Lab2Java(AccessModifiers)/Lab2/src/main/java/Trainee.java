public class Trainee {
    private String id, name, gender;
    private byte age;

    //  PTKT
    public Trainee() {
    }

    public Trainee(String id, String name, String gender, byte age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    //    Get
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public byte getAge() {
        return age;
    }

    //    set
    public void setId(String id) {
        if (this.id == null) {
            System.out.println("id không được để trống");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (this.name == null || this.name.trim().isEmpty()) {
            System.out.println("tên không được để trống");
        }
        this.name = name;
    }

    public void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            System.out.println("Vui lòng nhập giới tính");
            return;
        }

        if (!gender.equalsIgnoreCase("male")
                && !gender.equalsIgnoreCase("female")) {
            System.out.println("Giới tính chỉ được là male hoặc female");
            return;
        }

        this.gender = gender;

    }

    public void setAge(byte age) {
        if (age<6){
            System.out.println("tuổi phải hơn 6");
        }
        this.age = age;
    }
}
