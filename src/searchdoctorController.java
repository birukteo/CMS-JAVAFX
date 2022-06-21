import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

//import javax.xml.transform.stax.StAXSource;

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

public class searchdoctorController implements Initializable {
    @FXML
    private TableView<doctor> tableviewdoc;

    @FXML
    private TableColumn<doctor, String> colbloodtype;

    @FXML
    private TableColumn<doctor, String> colemail;

    @FXML
    private TableColumn<doctor, Integer> colid;

    @FXML
    private TableColumn<doctor, String> colpassword;

    @FXML
    private TableColumn<doctor, String> colphoneno;

    @FXML
    private TableColumn<doctor, String> colspecialization;

    @FXML
    private TableColumn<doctor, String> colusername;

    @FXML
    private TextField searchdoctextfield;

    @FXML
    void handlemouseaction(MouseEvent event) {

    }

    @FXML
    private Button backBTN;

    @FXML
    void backbtnActionHandler(ActionEvent event) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("admindoctor.fxml"));

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

    ObservableList<doctor> doctorserachObservableListlist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        databaseconnection connnow = new databaseconnection();
        Connection connectDB = connnow.getConnection();

        String doctorsearchviewquery = " select * from doctor1;";

        try {
            Statement st = connectDB.createStatement();
            ResultSet queryoutput = st.executeQuery(doctorsearchviewquery);

            while (queryoutput.next()) {

                Integer querydocid = queryoutput.getInt("id");
                String querydocusername = queryoutput.getString("username");
                String querydocpassword = queryoutput.getString("password");
                String querydocemail = queryoutput.getString("email");
                String querydocphone = queryoutput.getString("phone");
                String querydocbloodtype = queryoutput.getString("bloodtype");
                String querydocspecialization = queryoutput.getString("specialization");

                doctorserachObservableListlist.add(new doctor(querydocid, querydocusername,
                        querydocpassword, querydocemail, querydocphone, querydocbloodtype, querydocspecialization));

            }

            colid.setCellValueFactory(new PropertyValueFactory<>("id"));
            colusername.setCellValueFactory(new PropertyValueFactory<>("username"));

            colpassword.setCellValueFactory(new PropertyValueFactory<>("password"));

            colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
            colphoneno.setCellValueFactory(new PropertyValueFactory<>("phone"));
            colbloodtype.setCellValueFactory(new PropertyValueFactory<>("bloodtype"));
            colspecialization.setCellValueFactory(new PropertyValueFactory<>("specialization"));

            tableviewdoc.setItems(doctorserachObservableListlist);

            FilteredList<doctor> filtereddata = new FilteredList<>(doctorserachObservableListlist, b -> true);
            searchdoctextfield.textProperty().addListener((Observable, oldvalue, newvalue) -> {
                filtereddata.setPredicate(doctor -> {
                    if (newvalue.isEmpty() || newvalue.isBlank() || newvalue == null) {
                        return true;
                    }

                    String searchkeyword = newvalue.toLowerCase();
                    if (String.valueOf(doctor.getId()).toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;
                    } else if (doctor.getUsername().toLowerCase().indexOf(searchkeyword) > -1) {
                        return true;
                    } else
                        return false;
                });

            });

            SortedList<doctor> sorteddata = new SortedList<>(filtereddata);

            sorteddata.comparatorProperty().bind(tableviewdoc.comparatorProperty());

            tableviewdoc.setItems(sorteddata);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}