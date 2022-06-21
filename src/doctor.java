// import java.lang.reflect.Constructor;
// import java.sql.Connection;
// import java.sql.DriverManager;

// import javafx.beans.Observable;
// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;

public class doctor {
    int id;
    String username, password, email, bloodtype, specialization;
    String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public doctor(int id, String username, String password, String email,
            String phone,
            String bloodtype, String specialization) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.bloodtype = bloodtype;
        this.specialization = specialization;

    }

}
