
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

// import javax.xml.transform.stax.StAXSource;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class recpatientsearchController implements Initializable {
    @FXML
    private TableView<patient> tableviewpatient;

    @FXML
    private TableColumn<patient, String> colbloodtype;

    @FXML
    private TableColumn<patient, String> colemail;

    @FXML
    private TableColumn<patient, Integer> colid;

    @FXML
    private TableColumn<patient, String> colpassword;

    @FXML
    private TableColumn<patient, String> colphoneno;

    @FXML
    private TableColumn<patient, String> coladdress;

    @FXML
    private TableColumn<patient, String> colusername;

    @FXML
    private TextField searchrectextfield;

    @FXML
    void handlemouseaction(MouseEvent event) {

    }

    @FXML
    private Button backBTN;

    @FXML
    void backbtnActionHandler(ActionEvent event) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("recetionistpatient.fxml"));

            Scene scene = new Scene(root);
            Stage stage = (Stage) backBTN.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Clinic rec Site ");
            stage.show();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    ObservableList<patient> recserachObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        databaseconnection connnow = new databaseconnection();
        Connection connectDB = connnow.getConnection();

        String recsearchviewquery = " select * from patient;";

        try {
            Statement st = connectDB.createStatement();
            ResultSet queryoutput = st.executeQuery(recsearchviewquery);

            while (queryoutput.next()) {

                Integer queryrecid = queryoutput.getInt("id");
                String queryrecusername = queryoutput.getString("username");
                String queryrecpassword = queryoutput.getString("password");
                String queryrecemail = queryoutput.getString("email");
                String queryrecphone = queryoutput.getString("phone");
                String queryrecbloodtype = queryoutput.getString("bloodtype");
                String queryrecaddress = queryoutput.getString("address");

                recserachObservableList.add(new patient(
                        queryrecid,
                        queryrecusername,
                        queryrecpassword, queryrecemail, queryrecphone, queryrecbloodtype, queryrecaddress));

            }

            colid.setCellValueFactory(new PropertyValueFactory<>("id"));
            colusername.setCellValueFactory(new PropertyValueFactory<>("username"));

            colpassword.setCellValueFactory(new PropertyValueFactory<>("password"));

            colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
            colphoneno.setCellValueFactory(new PropertyValueFactory<>("phone"));
            colbloodtype.setCellValueFactory(new PropertyValueFactory<>("bloodtype"));
            coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));

            tableviewpatient.setItems(recserachObservableList);

            // FilteredList<doctor> filtereddata = new
            // FilteredList<>(doctorserachObservableListlist, b -> true);
            // searchdoctextfield.textFormatterProperty().addListener((Observable, oldvalue,
            // newvalue) -> {
            // filtereddata.setPredicate(doctor -> {
            // if (newvalue.isEmpty() || newvalue.isBlank() || newvalue == null) {
            // return true;

            // }
            // String searchkeyword = newvalue.toLowerCase();
            // if (doctor.getId().toLowerCase.indexOf(searchkeyword) > -1) {
            // return true;
            // } else if (doctor.getUsername().toLowerCase().indexOf(searchkeyword) > -1) {
            // return true;
            // } else
            // return false;
            // });

            // });

            // SortedList<doctor> sorteddata = new SortedList<>(filtereddata);

            // sorteddata.comparatorProperty().bind(tableviewdoc.comparatorProperty());

            // tableviewdoc.setItems(sorteddata);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
