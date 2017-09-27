package be.vdab.entiteiten;

public class User {
    private int idUser;
    private String userName;
    private String password;


    public User(int id, String userName, String password) {
        this.idUser = id;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return idUser;
    }

    public void setId(int id) {
        this.idUser = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return getId() == user.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + idUser +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
