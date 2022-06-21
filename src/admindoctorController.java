import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class admindoctorController {

    @FXML
    private Button DeletedoctorBTN;

    @FXML
    private Button SearchdoctorBTN;

    @FXML
    private Button UpdatedoctorBTN;

    @FXML
    private Button adddoctorBTN;

    @FXML
    void DeletedoctorActionHandler(ActionEvent event) {
        adminedoctordelete();

    }

    @FXML
    void SearchdoctorActionHandler(ActionEvent event) {
        adminedoctorsearch();

    }

    @FXML
    void UpdatedoctorActionHandler(ActionEvent event) {
        adminedoctorupdate();

    }

    @FXML
    void adddoctorActionHandler(ActionEvent event) {
        adminadddoctor();

    }

    @FXML
    private Button backBTN;

    @FXML
    void backbtnActionHandler(ActionEvent event) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("firstadmin.fxml"));

            Scene scene = new Scene(root);
            Stage stage = (Stage) backBTN.getScene().getWindow();
            stage.setScene(scene);
            stage.resizableProperty().setValue(false);
            stage.setTitle("Clinic entry Site ");
            stage.show();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void adminadddoctor() {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("tableviewdoctor.fxml"));
            Stage stage = (Stage) adddoctorBTN.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.resizableProperty().setValue(false);
            stage.setTitle("adding and updating doctor");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void adminedoctorupdate() {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("adminedoctorupdate.fxml"));
            Stage stage = (Stage) UpdatedoctorBTN.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.resizableProperty().setValue(false);
            stage.setTitle("adding and updating doctor");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void adminedoctordelete() {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("adminedoctordelete.fxml"));
            Stage stage = (Stage) DeletedoctorBTN.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.resizableProperty().setValue(false);
            stage.setTitle("adding and updating doctor");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void adminedoctorsearch() {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("searchadmindoctor.fxml"));
            Stage stage = (Stage) SearchdoctorBTN.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.resizableProperty().setValue(false);
            stage.setTitle("adding and updating doctor");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
