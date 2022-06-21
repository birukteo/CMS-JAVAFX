import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class entrycontroller {

    @FXML
    private Button adminBTN;

    @FXML
    private Button doctorBTN;

    @FXML
    private Button receptionistBTN;

    @FXML
    void adminehandler(ActionEvent event) {
        adminpage();

    }

    @FXML
    void doctorhandler(ActionEvent event) {
        doctorpage();

    }

    @FXML
    void receptionisthandler(ActionEvent event) {
        receptionistpage();

    }

    public void adminpage() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) adminBTN.getScene().getWindow();

            stage.setScene(scene);
            stage.setTitle("Clinic Admin Site ");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void doctorpage() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("doclogin.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) doctorBTN.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Clinic doctor Site ");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void receptionistpage() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("receptionistlogin.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) receptionistBTN.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Clinic receptionist Site ");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}