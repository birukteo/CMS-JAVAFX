import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class receptionistlogincontroller {

    @FXML
    private Button backBTN;

    @FXML
    private Button canclebutton;

    @FXML
    private Button loginbutton;

    @FXML
    private Label loginmessagelabel;

    @FXML
    private PasswordField passwordtextfield;

    @FXML
    private TextField usernametextfield;

    @FXML
    void backbtnActionHandler(ActionEvent event) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("entrypage.fxml"));

            Scene scene = new Scene(root);
            Stage stage = (Stage) backBTN.getScene().getWindow(); // new Stage();
            stage.setScene(scene);
            stage.setTitle("Clinic entry Site ");
            stage.show();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    @FXML
    void canclebuttononaction(ActionEvent event) {
        Stage stage = (Stage) canclebutton.getScene().getWindow();
        stage.close();

    }

    @FXML
    void loginbuttononaction(ActionEvent event) {
        if (usernametextfield.getText().isBlank() == false &&
                passwordtextfield.getText().isBlank() == false) {
            // loginmessagelabel.setText("you try to login");
            receptionistvalidatelogin();

        } else {
            loginmessagelabel.setText("please enter username and password");

        }

    }

    public void receptionistvalidatelogin() {
        databaseconnection connectNow = new databaseconnection();
        Connection connectDB = connectNow.getConnection();

        String verifylogin = "SELECT count(1) FROM receptionist WHERE username = '"
                + usernametextfield.getText()
                + "' AND password ='" + passwordtextfield.getText() + "'";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifylogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    // loginmessagelabel.setText("WELCOME");
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("recetionistpatient.fxml"));
                        Scene scene = new Scene(root);
                        Stage stage = (Stage) loginbutton.getScene().getWindow();
                        stage.setScene(scene);
                        stage.setTitle("Clinic admin Site ");
                        stage.show();

                    } catch (Exception e) {
                        System.out.println("error");
                        e.printStackTrace();

                    }

                } else {
                    loginmessagelabel.setText("INVALID LOGIN.PLEASE TRY AGAIN");

                }

            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
