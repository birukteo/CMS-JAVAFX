import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class firstadminController {

    @FXML
    private Button doctorBTN;

    @FXML
    private Button patientBTN;

    @FXML
    private Button recepionistBTN;
    @FXML
    private Button backBTN;

    @FXML
    void backbtnActionHandler(ActionEvent event) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

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
    void doctorinfoActionhandler(ActionEvent event) {
        admindoctorinfo();

    }

    @FXML
    void patientInfoActionhandler(ActionEvent event) {
        adminpatientinfo();

    }

    @FXML
    void recepionistinfoActionhandler(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("adminreceptionist.fxml"));
            Stage stage = (Stage) recepionistBTN.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("admin/receptionist");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void adminpatientinfo() {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("adminpatient.fxml"));
            Stage stage = (Stage) patientBTN.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("admin/patient");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void admindoctorinfo() {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("admindoctor.fxml"));
            Stage stage = (Stage) doctorBTN.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("admin/doctor");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
