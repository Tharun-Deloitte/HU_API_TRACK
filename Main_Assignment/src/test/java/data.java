public class data {
    private String name;
    private String email;
    private String password;
    private int  age;
    private String token;
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

    public data(String token) {
        this.token = token;
    }

    public String gettoken() {
        return token;
    }

    public void settoken(String name) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}