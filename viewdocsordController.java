import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

// import com.mysql.cj.xdevapi.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class viewdocsordController implements Initializable {

    @FXML
    private TableColumn<examinations, String> PatNameCol;

    @FXML
    private TableView<examinations> Tableviewexa;

    @FXML
    private TableColumn<examinations, Integer> PidCol;

    @FXML
    private TableColumn<examinations, Integer> ageCol;

    @FXML
    private Button backbt;

    @FXML
    private TableColumn<examinations, Integer> dateCol;

    @FXML
    private TableColumn<examinations, String> diagnCol;

    @FXML
    private TableColumn<examinations, String> labteCol;

    @FXML
    private TextField searchTF;

    @FXML
    private Button searchbtn;

    @FXML
    void back(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("Doctorsentry.fxml"));

            Scene scene = new Scene(root);
            Stage stage = (Stage) backbt.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("examination info Site ");
            stage.show();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    @FXML
    void search(ActionEvent event) {
    }

    ObservableList<examinations> serachObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        databaseconnection connnow = new databaseconnection();
        Connection connectD = connnow.getConnection();

        String searchviewquery = " select * from examination;";

        try {
            Statement st = connectD.createStatement();
            ResultSet queryoutput = st.executeQuery(searchviewquery);

            while (queryoutput.next()) {

                Integer queryDate = queryoutput.getInt("Date");
                Integer queryPatientid = queryoutput.getInt("Patientid");
                Integer queryAge = queryoutput.getInt("Age");
                String queryPatientName = queryoutput.getString("Patient Name");
                String queryDiagnosis = queryoutput.getString("Diagnosis");
                String queryLabTest = queryoutput.getString("LabTest");

                serachObservableList.add(new examinations(
                        queryDate,
                        queryPatientid,
                        queryAge, queryPatientName, queryDiagnosis, queryLabTest));

            }

            dateCol.setCellValueFactory(new PropertyValueFactory<>("Date"));
            PidCol.setCellValueFactory(new PropertyValueFactory<>("Patientid"));

            ageCol.setCellValueFactory(new PropertyValueFactory<>("Age"));

            PatNameCol.setCellValueFactory(new PropertyValueFactory<>("Patient Name"));
            diagnCol.setCellValueFactory(new PropertyValueFactory<>("Diagnosis"));
            labteCol.setCellValueFactory(new PropertyValueFactory<>("LabTest"));

            Tableviewexa.setItems(serachObservableList);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
