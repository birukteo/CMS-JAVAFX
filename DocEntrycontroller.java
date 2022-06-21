import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class DocEntrycontroller implements Initializable {

    @FXML
    private ImageView imageIV;

    @FXML
    private TextField patientNameTF;

    @FXML
    private Button backtopBTN;

    @FXML
    private Button subsMedBTN;

    @FXML
    private TextField patientSearchTF;

    @FXML
    void Searchpatient(KeyEvent event) {
    }

    @FXML
    private Button backBTN;

    @FXML
    private Button hitoryBTN;

    @FXML
    private Button newappointBTN;

    @FXML
    private Button viewBTN;

    @FXML
    private Button examinationOrderBTN;

    @FXML
    void ExaminationOrder(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("doctorspage.fxml"));

            Scene scene = new Scene(root);
            Stage Stage = (Stage) examinationOrderBTN.getScene().getWindow();
            Stage.setScene(scene);
            Stage.setTitle("Examination detail");
            Stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void previousPage(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("entrypage.fxml"));

            Scene scene = new Scene(root);
            Stage Stage = (Stage) backBTN.getScene().getWindow();
            Stage.setScene(scene);
            Stage.setTitle("clinic managment page");
            Stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void VIEW(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("viewdocorder.fxml"));

            Scene scene = new Scene(root);
            Stage Stage = (Stage) viewBTN.getScene().getWindow();
            Stage.setScene(scene);
            Stage.setTitle("Doctor's order page");
            Stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void viewHistory(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("docPatientHistory.fxml"));

            Scene scene = new Scene(root);
            Stage Stage = (Stage) hitoryBTN.getScene().getWindow();
            Stage.setScene(scene);
            Stage.setTitle("Patient History page ");
            Stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void subscription(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("subscription.fxml"));

            Scene scene = new Scene(root);
            Stage Stage = (Stage) hitoryBTN.getScene().getWindow();
            Stage.setScene(scene);
            Stage.setTitle("Medicine subscription page ");
            Stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

}
