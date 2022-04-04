public class data {
    private String name;
    private String email;
    private String password;
    private int  age;
    private String description;
    public data(String name, String email,String password,int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public data(String email,String password) {
        this.email = email;
        this.password = password;
    }

    public data(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }



    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public int getAge() {
        return age;
    }

}
