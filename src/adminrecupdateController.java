
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

public class adminrecupdateController implements Initializable {

    @FXML
    private TextField IDTextField;

    @FXML
    private TextField bloodtypetextfield;

    @FXML
    private TableView<receptionist> tableviewrec;

    @FXML
    private TableColumn<receptionist, String> colbloodtype;

    @FXML
    private TableColumn<receptionist, String> colemail;

    @FXML
    private TableColumn<receptionist, Integer> colid;

    @FXML
    private TableColumn<receptionist, String> colpassword;

    @FXML
    private TableColumn<receptionist, String> colphoneno;

    @FXML
    private TableColumn<receptionist, String> coladdress;

    @FXML
    private TableColumn<receptionist, String> colusername;

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
    private TextField userNameTextField;

    @FXML
    private void handlemouseaction(MouseEvent event) {

        receptionist rec = tableviewrec.getSelectionModel().getSelectedItem();
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
        // System.out.println("you clicked me");
        if (event.getSource() == updateBTN) {
            updaterecord();

        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        showreceptionist();

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

    public ObservableList<receptionist> getreceptionnistList() {
        ObservableList<receptionist> receptionistlist = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "select * from receptionist";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            receptionist rec;
            while (rs.next()) {
                rec = new receptionist(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("bloodtype"),
                        rs.getString("address"));

                receptionistlist.add(rec);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return receptionistlist;
    }

    public void showreceptionist() {
        ObservableList<receptionist> list = getreceptionnistList();

        colid.setCellValueFactory(new PropertyValueFactory<receptionist, Integer>("id"));
        colusername.setCellValueFactory(new PropertyValueFactory<receptionist, String>("username"));

        colpassword.setCellValueFactory(new PropertyValueFactory<receptionist, String>("password"));

        colemail.setCellValueFactory(new PropertyValueFactory<receptionist, String>("email"));

        colphoneno.setCellValueFactory(new PropertyValueFactory<receptionist, String>("phone"));

        colbloodtype.setCellValueFactory(new PropertyValueFactory<receptionist, String>("bloodtype"));
        coladdress.setCellValueFactory(new PropertyValueFactory<receptionist, String>("address"));

        tableviewrec.setItems(list);

    }

    @FXML
    private Button backBTN;

    @FXML
    void backbtnActionHandler(ActionEvent event) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("adminreceptionist.fxml"));

            Scene scene = new Scene(root);
            Stage stage = (Stage) backBTN.getScene().getWindow(); // new Stage();
            stage.setScene(scene);
            stage.setTitle("Clinic rec Site ");
            stage.show();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    private void updaterecord() {
        String query = " UPDATE receptionist SET username = '" + userNameTextField.getText()
                + "',password='" + passwordTextField.getText()
                + "',email='" + emailtextfield.getText()
                + "',phone=" + phoneTextField.getText()
                + ",bloodtype='" + bloodtypetextfield.getText()
                + "',address= '" + addresstextfield.getText() + "' WHERE id = " + IDTextField.getText()
                + "";

        executeQuery(query);
        showreceptionist();

    }

    // private void deleterecord() {
    // String query = "DELETE FROM doctor1 WHERE id = " + IDTextField.getText() +
    // "";
    // executeQuery(query);
    // showdoctors();

    // }

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
