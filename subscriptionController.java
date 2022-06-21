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

public class subscriptionController {

    @FXML
    private Button BkBTN;

    @FXML
    private Label patientsIdLB;

    @FXML
    private TextField idTF;

    @FXML
    private TextField medOrdTF;

    @FXML
    private Button sendDTN;

    @FXML
    void backAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Doctorsentry.fxml"));

            Scene scene = new Scene(root);
            Stage Stage = (Stage) BkBTN.getScene().getWindow();
            Stage.setScene(scene);
            Stage.setTitle("clinic managment page ");
            Stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void sends(ActionEvent event) {

        if ((medOrdTF.getText().isBlank() == false)) {
            order();

        } else {
            new Label("Successfully added subscription");
        }
    }

    public void order() {
        databaseconnection c = new databaseconnection();
        Connection con = c.getConnection();

        String sql = ("insert into subscription(patientID,subscribedMed) values(?,?)");
        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, idTF.getText());
            st.setString(2, medOrdTF.getText());

            st.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    };

}
