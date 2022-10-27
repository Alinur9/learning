package com.example.worldc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;
public class BoardCusTblController implements Initializable {
        @FXML
        private DatePicker source_date_picker;
        @FXML
        private Button source_insert;
        @FXML
        private Button source_update;
        @FXML
        private Button source_remove;
        @FXML
        private Button source_confirm_winner;
        @FXML
        private Button source_confirm;
        @FXML
        private TableView<Record_TvT> custom_tv;
        @FXML
        private TableColumn<Record_TvT, String> col_mtm;
        @FXML
        private TableColumn<Record_TvT, String> col_t1;
        @FXML
        private TableColumn<Record_TvT, String> col_t2;
        @FXML
        private TableColumn<Record_TvT,String> col_group_stage;
        @FXML
        private TableColumn<Record_TvT, String> col_game_type;
        @FXML
        private TableColumn<Record_TvT, String> col_venue;
        @FXML
        private TableColumn<Record_TvT,String> col_result_tvt;
        @FXML
        private TableColumn<Record_TvT, String> col_date;
        @FXML
        private Label id_user;
        @FXML
        private TextField tf_gStage;
        @FXML
        private TextField tf_gameType;
        @FXML
        private TextField tf_t1;
        @FXML
        private TextField tf_t2;
        @FXML
        private TextField tf_tom;
        @FXML
        private TextField tf_venue;
        @FXML
        private TextField tf_MID;
        @FXML
        private PasswordField tf_pass_verify;
        @FXML
        private TextField tf_result;
        @FXML
        private Pane pane_for_verify;
        @FXML
        private Button event_source;
        Connection connection;
        PreparedStatement pst;
        public Connection getConnection() {
                if (connection != null) {
                        return connection;
                }
                try {
                        connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cricket", "root", "Ahsan123@");
                        return connection;
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }
        public ObservableList<Record_TvT> getRecordList() {
                ObservableList<Record_TvT> recordTvTList = FXCollections.observableArrayList();
                connection = getConnection();
                String query = "SELECT * FROM team_vs_team";

                try {
                        pst = connection.prepareStatement(query);
                        ResultSet resultSet = pst.executeQuery();
                        Record_TvT recordTvT;
                        while (resultSet.next()) {
                                recordTvT = new Record_TvT(
                                        resultSet.getInt("id"),
                                        resultSet.getString("gameType"),
                                        resultSet.getInt("match_id"),
                                        resultSet.getString("team1"),
                                        resultSet.getString("date"),
                                        resultSet.getString("tom"),
                                        resultSet.getString("team2"),
                                        resultSet.getString("venue"),
                                        resultSet.getString("result"),
                                        resultSet.getString("groupStage")
                                );
                                recordTvTList.add(recordTvT);
                        }
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
                return recordTvTList;
        }
        public void showTable() {
                ObservableList<Record_TvT> list = getRecordList();
                col_t1.setCellValueFactory(new PropertyValueFactory<>("team1"));
                col_t2.setCellValueFactory(new PropertyValueFactory<>("team2"));
                col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
                col_mtm.setCellValueFactory(new PropertyValueFactory<>("tom"));
                col_game_type.setCellValueFactory(new PropertyValueFactory<>("gameType"));
                col_venue.setCellValueFactory(new PropertyValueFactory<>("venue"));
                col_result_tvt.setCellValueFactory(new PropertyValueFactory<>("result"));
                col_group_stage.setCellValueFactory(new PropertyValueFactory<>("groupStage"));
                custom_tv.setItems(list);
        }
        @FXML
        void onMouseClick(MouseEvent event) {
                Record_TvT recordTvT = custom_tv.getSelectionModel().getSelectedItem();
                tf_MID.setText(String.valueOf(recordTvT.getMatch_id()));
                tf_gStage.setText(recordTvT.getGroupStage());
                tf_gameType.setText(recordTvT.getGameType());
                tf_t1.setText(recordTvT.getTeam1());
                source_date_picker.setAccessibleText(recordTvT.getDate());
                tf_tom.setText(recordTvT.getTom());
                tf_t2.setText(recordTvT.getTeam2());
                tf_venue.setText(recordTvT.getVenue());
                tf_result.setText(recordTvT.getResult());
        }
        @FXML
        void btn_DatePicker(ActionEvent event){
                source_date_picker.getValue();
        }
        @FXML
        void btn_cancel(ActionEvent event){
                pane_for_verify.setVisible(false);
        }
        @FXML
        void btn_confirm(ActionEvent event) throws SQLException {
                if ( Objects.equals(tf_pass_verify.getText(), DataBase.getPwd(id_user.getText()))) {
                        if (event_source == source_insert) {
                                if (DataBase.getMatchId(tf_MID.getText()) != null) {
                                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                        alert.setContentText("MID Already exists !");
                                        alert.show();
                                } else {
                                        connection = getConnection();
                                        pst = connection.prepareStatement("INSERT INTO team_vs_team" + "(match_id,team1,team2,tom,gameType,venue,date,groupStage)" + "VALUES (?,?,?,?,?,?,?,?)");
                                        pst.setString(1, tf_MID.getText());
                                        pst.setString(2, tf_t1.getText());
                                        pst.setString(3, tf_t2.getText());
                                        pst.setString(4, tf_tom.getText());
                                        pst.setString(5, tf_gameType.getText());
                                        pst.setString(6, tf_venue.getText());
                                        pst.setDate(7, Date.valueOf(source_date_picker.getValue()));
                                        pst.setString(8,tf_gStage.getText());
                                        pst.executeUpdate();
                                        pane_for_verify.setVisible(false);
                                        event_source = null;
                                        tf_pass_verify.setText("");
                                        showTable();
                                }
                        }
                        if (event_source == source_update){
                                String query = "UPDATE team_vs_team SET  team1 = '" + tf_t1.getText() + "' ,team2 = '" + tf_t2.getText() + "' , tom = '" + tf_tom.getText() + "' , date = '" + source_date_picker.getValue() + "', groupStage = '" + tf_gStage.getText() + "', gameType = '" + tf_gameType.getText() + "' , venue = '" + tf_venue.getText() + "'  WHERE match_id = '" + tf_MID.getText() + "';";
                                DataBase.update(query);
                                event_source = null;
                                tf_pass_verify.setText("");
                                pane_for_verify.setVisible(false);
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setContentText("Successfully updated !");
                                alert.show();
                                showTable();
                        }
                        if (event_source == source_remove){
                                String query = "DELETE FROM team_vs_team WHERE match_id = " + tf_MID.getText() + "";
                                executeQuery(query);
                                event_source = null;
                                tf_pass_verify.setText("");
                                pane_for_verify.setVisible(false);
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setContentText("Successfully removed !");
                                alert.show();
                                showTable();
                        }
                        if ( event_source == source_confirm_winner){
                                String query = "UPDATE users_teams SET  result = '" + tf_result.getText() + "'  WHERE match_id = '" + tf_MID.getText() + "';";
                                DataBase.update(query);
                        }
                }else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("Password Incorrect !");
                        alert.show();
                }
        }
        @FXML
        void onInsert(ActionEvent event) throws SQLException {
                if (!tf_t1.getText().isEmpty() && tf_t1.getText() != null && !tf_t2.getText().isEmpty() && tf_t2.getText() != null && !tf_tom.getText().isEmpty() && tf_tom.getText() != null && !tf_gameType.getText().isEmpty() && tf_gameType.getText() != null && !tf_venue.getText().isEmpty() && tf_venue.getText() != null && !tf_gStage.getText().isEmpty() && tf_gStage.getText() != null) {
                pane_for_verify.setVisible(true);
                event_source = source_insert;
                }
                else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("Give details about match !");
                        alert.show();
                }
                        }
        @FXML
        void onUpdate(ActionEvent event) throws SQLException {

                        if (!tf_t1.getText().isEmpty() && tf_t1.getText() != null && !tf_t2.getText().isEmpty() && tf_t2.getText() != null && !tf_tom.getText().isEmpty() && tf_tom.getText() != null && !tf_gameType.getText().isEmpty() && tf_gameType.getText() != null && !tf_venue.getText().isEmpty() && tf_venue.getText() != null && !tf_gStage.getText().isEmpty() && tf_gStage.getText() != null) {
                                pane_for_verify.setVisible(true);
                                event_source = source_update;
                        }
                        else {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setContentText("Give details about match !");
                                alert.show();
                        }
                }
        @FXML
        void onRemove(ActionEvent event) throws SQLException {
                        pane_for_verify.setVisible(true);
                        event_source = source_remove;
        }
          @FXML
        void btn_confirm_winner(ActionEvent event){
                if (tf_result.getText() != null && !tf_result.getText().isEmpty() && tf_MID.getText() != null && !tf_MID.getText().isEmpty()) {
                        pane_for_verify.setVisible(true);
                        event_source = source_confirm_winner;
                }else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("Give details about result and match id !");
                        alert.show();
                }
        }
        @FXML
        void onLogOut(ActionEvent event) throws IOException {
                HelloApplication.setScene(null,"log-in.fxml","LogIn");
        }
        @FXML
        void onSports(ActionEvent event) throws IOException, SQLException {
               DataBase.logIn(id_user.getText(),DataBase.getPwd(id_user.getText()), "access");
        }
        void userInformation(String user){
                id_user.setText(user);
                showTable();
        }
        void executeQuery(String query) throws SQLException {
                connection = getConnection();
                pst = connection.prepareStatement(query);
                pst.executeUpdate();
        }
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                tf_pass_verify.setText("");
                showTable();
        }
}



