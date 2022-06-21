
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class admindoctordeleteController implements Initializable {

    @FXML
    private TextField IDTextField;

    @FXML
    private TextField bloodtypetextfield;

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
    private Button deleteBTN;

    @FXML
    private TextField emailtextfield;

    @FXML
    private AnchorPane idtextfield;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TextField specializationtextfield;

    @FXML
    private TextField userNameTextField;

    @FXML
    private Button backBTN;

    @FXML
    void backbtnActionHandler(ActionEvent event) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("admindoctor.fxml"));

            Scene scene = new Scene(root);
            Stage stage = (Stage) backBTN.getScene().getWindow(); // new Stage();
            stage.setScene(scene);
            stage.resizableProperty().setValue(false);
            stage.setTitle("Clinic entry Site ");
            stage.show();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    @FXML
    private void handlemouseaction(MouseEvent event) {

        doctor doc = tableviewdoc.getSelectionModel().getSelectedItem();
        IDTextField.setText(" " + doc.getId());
        userNameTextField.setText(doc.getUsername());
        passwordTextField.setText(doc.getPassword());
        emailtextfield.setText(doc.getEmail());
        phoneTextField.setText(doc.getPhone());
        bloodtypetextfield.setText(doc.getBloodtype());
        specializationtextfield.setText(doc.getSpecialization());

    }

    @FXML
    private void handlebuttonaction(ActionEvent event) {
        System.out.println("you clicked me");
        if (event.getSource() == deleteBTN) {
            deleterecord();

        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        showdoctors();

    }

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/logintryi",
                    "root",
                    "mama2121");
            return conn;

        } catch (Exception e) {
            System.out.println("error");
            return null;
        }
    }

    public ObservableList<doctor> getdoctorslList() {
        ObservableList<doctor> doctorlList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "select * from doctor1";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            doctor drs;
            while (rs.next()) {
                drs = new doctor(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("bloodtype"),
                        rs.getString("specialization"));

                doctorlList.add(drs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorlList;
    }

    public void showdoctors() {
        ObservableList<doctor> list = getdoctorslList();

        colid.setCellValueFactory(new PropertyValueFactory<doctor, Integer>("id"));
        colusername.setCellValueFactory(new PropertyValueFactory<doctor, String>("username"));

        colpassword.setCellValueFactory(new PropertyValueFactory<doctor, String>("password"));

        colemail.setCellValueFactory(new PropertyValueFactory<doctor, String>("email"));

        colphoneno.setCellValueFactory(new PropertyValueFactory<doctor, String>("phone"));

        colbloodtype.setCellValueFactory(new PropertyValueFactory<doctor, String>("bloodtype"));
        colspecialization.setCellValueFactory(new PropertyValueFactory<doctor, String>("specialization"));

        tableviewdoc.setItems(list);

    }

    private void deleterecord() {
        String query = "DELETE FROM doctor1 WHERE id = " + IDTextField.getText() + "";
        executeQuery(query);
        showdoctors();

    }

    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
