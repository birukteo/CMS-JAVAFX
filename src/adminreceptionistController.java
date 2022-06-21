import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class adminreceptionistController {

    @FXML
    private Button DeleterecBTN;

    @FXML
    private Button SearchrecBTN;

    @FXML
    private Button UpdaterecBTN;

    @FXML
    private Button addrecBTN;

    @FXML
    private Button backBTN;

    @FXML
    void DeleterecActionHandler(ActionEvent event) {
        admindeletereceptionist();

    }

    @FXML
    void SearchrecActionHandler(ActionEvent event) {
        adminsearchreceptionist();

    }

    @FXML
    void UpdaterecActionHandler(ActionEvent event) {
        adminupdatereceptionist();

    }

    @FXML
    void addrecActionHandler(ActionEvent event) {
        adminaddreceptionist();

    }

    @FXML
    void backbtnActionHandler(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("firstadmin.fxml"));

            Scene scene = new Scene(root);
            Stage stage = (Stage) backBTN.getScene().getWindow(); // new Stage();
            stage.setScene(scene);
            stage.setTitle("Clinic admin Site ");
            stage.show();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void adminaddreceptionist() {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("adminaddreceptionist.fxml"));
            Stage stage = (Stage) addrecBTN.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("adding receptionist");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void adminupdatereceptionist() {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("adminrecupdate.fxml"));
            Stage stage = (Stage) addrecBTN.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(" updating receptionist");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void adminsearchreceptionist() {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("adminrecsearch.fxml"));
            Stage stage = (Stage) addrecBTN.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("searching receptionist");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void admindeletereceptionist() {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("adminrecdelete.fxml"));
            Stage stage = (Stage) addrecBTN.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("deleting receptionist");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
