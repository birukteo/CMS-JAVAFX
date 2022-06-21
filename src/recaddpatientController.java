
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
import javafx.scene.Node;
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

public class recaddpatientController implements Initializable {

    @FXML
    private TextField IDTextField;

    @FXML
    private Button addBTN;

    @FXML
    private TextField bloodtypetextfield;

    @FXML
    private TableView<patient> tableviewrpatient;

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
    private TextField addresstextfield;

    @FXML
    private Button updateBTN;

    @FXML
    private Button backBTN;

    @FXML
    void backbtnActionHandler(ActionEvent event) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("recetionistpatient.fxml"));

            Scene scene = new Scene(root);

            Stage stage = (Stage) backBTN.getScene().getWindow(); // new Stage();
            stage.setScene(scene);
            stage.setTitle("Clinic receptionist Site ");
            stage.show();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    @FXML
    private TextField userNameTextField;

    @FXML
    private void handlemouseaction(MouseEvent event) {

        patient rec = tableviewrpatient.getSelectionModel().getSelectedItem();
        IDTextField.setText(" " + rec.getId());
        userNameTextField.setText(rec.getUsername());
        passwordTextField.setText(rec.getPassword());
        emailtextfield.setText(rec.getEmail());
        phoneTextField.setText(rec.getPhone());
        bloodtypetextfield.setText(rec.getBloodtype());
        addresstextfield.setText(rec.getaddress());

    }

    @FXML
    private void handlebuttonaction(ActionEvent event) {
        System.out.println("you clicked me");
        if (event.getSource() == addBTN) {
            addrecord();
        } else {
            System.out.println("clicked me");
        }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        showpatientlist();

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

    public ObservableList<patient> getpatientlist() {
        ObservableList<patient> patientList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "select * from patient";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            patient pat;
            while (rs.next()) {
                pat = new patient(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("bloodtype"),
                        rs.getString("address"));

                patientList.add(pat);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return patientList;
    }

    public void showpatientlist() {
        ObservableList<patient> list = getpatientlist();

        colid.setCellValueFactory(new PropertyValueFactory<patient, Integer>("id"));
        colusername.setCellValueFactory(new PropertyValueFactory<patient, String>("username"));

        colpassword.setCellValueFactory(new PropertyValueFactory<patient, String>("password"));

        colemail.setCellValueFactory(new PropertyValueFactory<patient, String>("email"));

        colphoneno.setCellValueFactory(new PropertyValueFactory<patient, String>("phone"));

        // colphoneno.setCellValueFactory(new PropertyValueFactory<receptionist,
        // String>("phone"));

        colbloodtype.setCellValueFactory(new PropertyValueFactory<patient, String>("bloodtype"));
        coladdress.setCellValueFactory(new PropertyValueFactory<patient, String>("address"));

        tableviewrpatient.setItems(list);

    }

    private void addrecord() {
        String query = "INSERT INTO patient VALUES (" + IDTextField.getText()
                + ",'" + userNameTextField.getText()
                + "','" + passwordTextField.getText()
                + "','" + emailtextfield.getText()
                + "'," + phoneTextField.getText()
                + ",'" + bloodtypetextfield.getText()
                + "','" + addresstextfield.getText() + "')";
        executeQuery(query);
        showpatientlist();

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
