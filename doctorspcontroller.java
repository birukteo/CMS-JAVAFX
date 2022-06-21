// import java.lang.StackWalker.Option;
// import java.net.URL;
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.ResourceBundle;
// import com.mysql.cj.xdevapi.Result;
// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;
// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
// import javafx.fxml.Initializable;

// import javafx.scene.control.Button;
// import javafx.scene.control.CheckBox;
// import javafx.scene.control.TableColumn;
// import javafx.scene.control.TextField;
// import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class doctorspcontroller {

    @FXML
    private TextField AgeTF;

    @FXML
    private Button DBackBTN;

    @FXML
    private Button DSendBTN;

    @FXML
    private TextField DeagnosisTF;

    @FXML
    private TextField IdTF;

    @FXML
    private TextField NameTF;

    @FXML
    private TextField dateTF;

    @FXML
    private TextField labtestTF;

    @FXML
    void Backtodocpage(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Doctorsentry.fxml"));

            Scene scene = new Scene(root);
            Stage Stage = (Stage) DBackBTN.getScene().getWindow();
            Stage.setScene(scene);
            Stage.setTitle("clinic managment page");
            Stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void sendtoAdmin(ActionEvent event) {
        if (dateTF.getText().isBlank() == false && IdTF.getText().isBlank() == false
                && NameTF.getText().isBlank() == false && AgeTF.getText().isBlank() == false
                && DeagnosisTF.getText().isBlank() == false && labtestTF.getText().isBlank() == false) {

            send();

        } else {
            new Label("Added");
        }
    }

    public void send() {
        databaseconnection c = new databaseconnection();
        Connection con = c.getConnection();

        String sql = ("insert into examination(Date,Patientid,PatintName,Age,Diagnosis,LabTest) values(?,?,?,?,?,?)");
        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, dateTF.getText());
            st.setString(2, IdTF.getText());
            st.setString(3, NameTF.getText());
            st.setString(4, AgeTF.getText());
            st.setString(5, DeagnosisTF.getText());
            st.setString(6, labtestTF.getText());

            st.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
};

// if ( (dateTF.getText().isBlank()==false && IdTF.getText().isBlank()==false &&
// NameTF.getText().isBlank()==false && AgeTF.getText().isBlank()==false &&
// DeagnosisTF.getText().isBlank()==false
// // && WeilCBX.isSelected() && CbcCBX.isSelected()&& BloodCBX.isSelected()&&
// WdalCBX.isSelected()&& StEcBX.isSelected()&& UaCBX.isSelected()
// )
// ) {
// include();

// } else {

// }
// }

// public void include(){

// dbconn c = new dbconn();
// Connection con = c.getconnection();

// String sql = ("insert into labexamination(date,id,name,age,deagnosis)
// values(?,?,?,?,?)");
// try {
// PreparedStatement st = con.prepareStatement(sql);

// st.setString(1, dateTF.getText());
// st.setString(2, IdTF.getText());
// st.setString(3, NameTF.getText());
// st.setString(4, AgeTF.getText());
// st.setString(5, DeagnosisTF.getText());
// st.executeUpdate();

// } catch (Exception e) {
// System.out.println(e);
// }
// };

// dbconn c = new dbconn();
// Connection con = c.getconnection();
// PreparedStatement prs = null;
// ResultSet rs = null;

// try {

// } catch (Exception e) {
// }
// private CheckBox checkbox1, checkbox2,
// checkbox3,checkbox4,checkbox5,checkbox6;
// private ObservableList<String> checkboxlList =
// FXCollections.observableArrayList();

// CheckBox1 = new CheckBox("CBC");
// CheckBox1.setOnAction(e ->{
// checkboxlList.add(checkbox1.getText());
// });
// CheckBox2 = new CheckBox("weil/slex");
// CheckBox2.setOnAction(e ->{
// checkboxlList.add(checkbox2.getText());
// });
// CheckBox3 = new CheckBox("bloodgroup");
// CheckBox3.setOnAction(e ->{
// checkboxlList.add(checkbox3.getText());
// });
// CheckBox4 = new CheckBox("widal test");
// CheckBox4.setOnAction(e ->{
// checkboxlList.add(checkbox4.getText());
// });
// CheckBox5 = new CheckBox("stol");
// CheckBox5.setOnAction(e ->{
// checkboxlList.add(checkbox5.getText());
// });
// CheckBox6 = new CheckBox("urin");
// CheckBox6.setOnAction(e ->{
// checkboxlList.add(checkbox6.getText());
// });

// CheckBox1.requestFocus();
// CheckBox2.requestFocus();
// CheckBox3.requestFocus();
// CheckBox4.requestFocus();
// CheckBox5.requestFocus();
// CheckBox6.requestFocus();

// if (rs.getString("LabTest") != null){
// checkbox1.setSelected(false);
// checkbox2.setSelected(false);
// checkbox3.setSelected(false);
// checkbox4.setSelected(false);
// checkbox5.setSelected(false);
// checkbox6.setSelected(false);

// }
// String CheckBoxString =
// rs.getString("LabTest").replace("[","").replace("]","");
// sytem.out.println(CheckBoxString);
// List<String> testlist = Arrays.asList(CheckBoxString.split(","));
// system.out.println(testlist);
// for (String test : testlist){
// switch (test){
// case "CBC" : checkbox1.setSelected(true);
// break;
// case "weil/slex" : checkbox2.setSelected(true);
// break;
// case "bloodgroup" : checkbox3.setSelected(true);
// break;
// case "widal test" : checkbox4.setSelected(true);
// break;
// case "stol" : checkbox5.setSelected(true);
// break;
// case "urin" : checkbox5.setSelected(true);
// break;
// default : checkbox1.setSelected(false);
// checkbox2.setSelected(false);
// checkbox3.setSelected(false);
// checkbox4.setSelected(false);
// checkbox5.setSelected(false);
// checkbox6.setSelected(false);
// }
// // } else{
// // checkbox1.setSelected(false);
// // checkbox1.setSelected(false);
// // checkbox1.setSelected(false);
// // checkbox1.setSelected(false);
// // checkbox1.setSelected(false);
// // checkbox1.setSelected(false);

// // }
