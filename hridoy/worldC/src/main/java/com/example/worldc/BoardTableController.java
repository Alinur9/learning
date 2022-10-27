package com.example.worldc;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
public class BoardTableController implements Initializable {
    @FXML
    private DatePicker source_date_picker;
    @FXML
    private TextField filterField;
    @FXML
    private Button btn_cancel;
    @FXML
    private ComboBox<String> comBox_1;
    @FXML
    private TableColumn<Record_TvT, String> id_colT1;
    @FXML
    private TableColumn<Record_TvT, String> id_colT2;
    @FXML
    private TableColumn<Record_TvT, String> id_colMtm;
    @FXML
    private TableColumn<Record_TvT, String> col_Tom;
    @FXML
    private TableColumn<Record_TvT,String> col_group_stage;
    @FXML
    private TableColumn<Record_TvT, String> col_game_type;
    @FXML
    private TableColumn<Record_TvT, String> col_venue;
    @FXML
    private TableColumn<Record_TvT, String> col_result_tvt;
    @FXML
    private TableColumn<Record_TvT, String> col_date;
    @FXML
    private TableColumn<Record_TvT, String> col_date_ut;
    @FXML
    private TableView<Record_TvT> user_tv_tvt;
    @FXML
    private TableView<RecordUsersTeam> ut_team_view;
    @FXML
    private TableColumn<RecordUsersTeam, String> col_game;
    @FXML
    private TableColumn<RecordUsersTeam,String> col_group_stage_ut;
    @FXML
    private TableColumn<RecordUsersTeam, String> col_game_type_selectedTeam;
    @FXML
    private TableColumn<RecordUsersTeam, String> col_votedTeam;
    @FXML
    private TableColumn<RecordUsersTeam, String> col_result;

    @FXML
    private Text text_gameType;
    @FXML
    private Text text_gStage;
    @FXML
    private Text text_T1;
    @FXML
    private Text text_T2;
    @FXML
    private Text text_date;
    @FXML
    private Text text_Tom;
    @FXML
    private Text text_id;
    @FXML
    private Text text_matchId;
    @FXML
    private Text text_usersTm_MID;
    @FXML
    private Label profile_user;
    @FXML
    private PasswordField tf_pass_verify;
    @FXML
    private Button btn_back;
    @FXML
    private Button btn_UTP_back;
    @FXML
    private Button btn_selected_team;
    @FXML
    private Pane pane_for_verify;
    @FXML
    private Pane pane_body;
    @FXML
    private Pane pane_user_team;
    @FXML
    private Button btn_change;
    private int id_user;
    private String role;
    private String updateTeam;
    private String MID;
    private Record_TvT recordTvT;
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

    public ResultSet executeQuery(String data, String query) throws SQLException {
        connection = getConnection();
        pst = connection.prepareStatement(query);
        pst.setString(1, data);
        return pst.executeQuery();
    }

    private void onComboBoxChange(Observable observable) {
        boolean access = true;
        try {
            String team = comBox_1.getSelectionModel().getSelectedItem();
            String query = "SELECT * FROM users_teams WHERE username = ?";
            ResultSet resultSet = executeQuery(profile_user.getText(), query);
            while (resultSet.next() && team != null) {
                MID = String.valueOf(resultSet.getInt("match_id"));
                String youTeam = resultSet.getString("team");
                id_user = resultSet.getInt("id");
                if (MID.equals(text_matchId.getText()) && youTeam.equals(text_T1.getText()) || youTeam.equals(text_T2.getText())) {
                    if (!youTeam.equals(comBox_1.getSelectionModel().getSelectedItem())) {
                        pane_for_verify.setVisible(true);
                        updateTeam = comBox_1.getSelectionModel().getSelectedItem();
                        access = false;

                        break;
                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("You Already Voted on this team");
                        alert.show();
                        pane_for_verify.setVisible(false);
                        access = false;
                        break;
                    }
                }
            }
            if (team != null && access && connection != null) {
                connection = getConnection();
                pst = connection.prepareStatement("INSERT INTO users_teams " + "(username ,match_id,team,tom,game,gameType,date,groupStageUT)" + "VALUES (?,?,?,?,?,?,?,?)");
                pst.setString(1, profile_user.getText());
                pst.setString(2, text_matchId.getText());
                pst.setString(3, team);
                pst.setString(4, text_Tom.getText());
                pst.setString(5, text_T1.getText() + " vs " + text_T2.getText());
                pst.setString(6, text_gameType.getText());
                pst.setString(7,text_date.getText());
                pst.setString(8,text_gStage.getText());

                pst.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText(" Best Of Luck " + profile_user.getText());
                alert.show();

                text_T1.setText("");
                text_T2.setText("");
                text_Tom.setText("");
                user_team();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void onMouseClick(MouseEvent event) {
        Record_TvT recordTvT = user_tv_tvt.getSelectionModel().getSelectedItem();
        text_gameType.setText(recordTvT.getGameType());
        text_gStage.setText(recordTvT.getGroupStage());
        text_T1.setText(recordTvT.getTeam1());
        text_T2.setText(recordTvT.getTeam2());
        text_date.setText(recordTvT.getDate());
        text_Tom.setText(recordTvT.getTom());
        text_id.setText(String.valueOf(recordTvT.getId()));
        text_matchId.setText(String.valueOf(recordTvT.getMatch_id()));
        pane_for_verify.setVisible(false);

        if (text_date.getText() != null) {
            comBox_1.setPromptText(text_T1.getText() + " vs " + text_T2.getText());
            ObservableList<String> list = FXCollections.observableArrayList(text_T1.getText(), text_T2.getText());
            comBox_1.setItems(list);
        }

    }


    @FXML
    void onBodyMouseClick(MouseEvent event) {
        pane_for_verify.setVisible(false);
    }
    public void userInformation(String username) {
        profile_user.setText(username);
        onSports();
    }
    @FXML
    public void btn_UTP_back(ActionEvent event) {
        pane_user_team.setVisible(false);
        btn_selected_team.setVisible(true);
        filterField.setVisible(true);
    }
    @FXML
    void btn_selected(ActionEvent event) {
        pane_user_team.setVisible(true);
        pane_for_verify.setVisible(false);
        btn_UTP_back.setVisible(true);
        btn_selected_team.setVisible(false);
        filterField.setVisible(false);
        user_team();
    }
    @FXML
    void btn_cancel(ActionEvent event) {
        pane_for_verify.setVisible(false);
        tf_pass_verify.setText("");
    }
    @FXML
    void buttonChange(ActionEvent event) throws SQLException {
        if (tf_pass_verify.getText().equals(DataBase.getPwd(profile_user.getText()))) {
            String query2 = "UPDATE users_teams SET  team = '" + updateTeam + "'  WHERE id = '" + id_user + "';";
            DataBase.update(query2);
            user_team();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Successfully changes your team ");
            alert.show();
            pane_for_verify.setVisible(false);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Password Incorrect !");
            alert.show();
        }
    }
    @FXML
    public void onSports() {
        try {
            this.role = DataBase.getRole(profile_user.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (this.role == null) {
            btn_back.setVisible(false);
        } else {
            btn_back.setVisible(true);
        }
    }

    public void buttonBack() throws SQLException {
        DataBase.logIn(profile_user.getText(), DataBase.getPwd(profile_user.getText()), null);
    }

    @FXML
    void buttonLogOut(ActionEvent event) throws IOException {
        HelloApplication.setScene(null, "log-in.fxml", "LogIn");
    }
@FXML
public void user_team() {
    ObservableList<RecordUsersTeam> recordListUserTeam = FXCollections.observableArrayList();
    String query = "SELECT * FROM users_teams WHERE username = ?";
    try {
        ResultSet resultSet = executeQuery(profile_user.getText(), query);
        RecordUsersTeam recordUsersTeam;
        while (resultSet.next()) {
            recordUsersTeam = new RecordUsersTeam(
                    resultSet.getInt("id"),
                    resultSet.getString("gameType"),
                    resultSet.getString("game"),
                    resultSet.getInt("match_id"),
                    resultSet.getString("team"),
                    resultSet.getString("date"),
                    resultSet.getString("tom"),
                    resultSet.getString("result"),
                    resultSet.getString("groupStageUT")
            );
            recordListUserTeam.add(recordUsersTeam);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    col_game_type_selectedTeam.setCellValueFactory(new PropertyValueFactory<>("gameType"));
    col_group_stage_ut.setCellValueFactory(new PropertyValueFactory<>("groupStageUT"));
    col_game.setCellValueFactory(new PropertyValueFactory<>("game"));
    col_votedTeam.setCellValueFactory(new PropertyValueFactory<>("team"));
    col_date_ut.setCellValueFactory(new PropertyValueFactory<>("date"));
    col_Tom.setCellValueFactory(new PropertyValueFactory<>("tom"));
    col_result.setCellValueFactory(new PropertyValueFactory<>("result"));
    ut_team_view.setItems(recordListUserTeam);
}
   @FXML
    void team_vs_team(){
        ObservableList<Record_TvT> recordTvTList = FXCollections.observableArrayList();
        connection = getConnection();
        String query = "SELECT * FROM team_vs_team";
        try {
            pst = connection.prepareStatement(query);
            ResultSet resultSet = pst.executeQuery();

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
            col_game_type.setCellValueFactory(new PropertyValueFactory<>("gameType"));
            col_group_stage.setCellValueFactory(new PropertyValueFactory<>("groupStage"));
            id_colT1.setCellValueFactory(new PropertyValueFactory<>("team1"));
            id_colT2.setCellValueFactory(new PropertyValueFactory<>("team2"));
            col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
            id_colMtm.setCellValueFactory(new PropertyValueFactory<>("tom"));
            col_venue.setCellValueFactory(new PropertyValueFactory<>("venue"));
            col_result_tvt.setCellValueFactory(new PropertyValueFactory<>("result"));
            user_tv_tvt.setItems(recordTvTList);


            FilteredList<Record_TvT> filteredList = new FilteredList<>(recordTvTList, b -> true);
            filterField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredList.setPredicate(recordTvT -> {
                    if (newValue.isBlank() || newValue.isEmpty()) {
                        return true;
                    }
                    String searchKey = newValue.toLowerCase();
                    if (recordTvT.getGameType().toLowerCase().indexOf(searchKey) > -1) {
                        return true;
                    }  else if (recordTvT.getTom().toLowerCase().indexOf(searchKey) > -1) {
                        return true;
                    } else {
                        return false;
                    }
                });
            });
            SortedList<Record_TvT> sortedList = new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(user_tv_tvt.comparatorProperty());
            user_tv_tvt.setItems(sortedList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pane_for_verify.setVisible(false);
        btn_UTP_back.setVisible(false);
        onSports();
        comBox_1.valueProperty().addListener(this::onComboBoxChange);
        user_team();
// team_vs_team tv view & search filter
        team_vs_team();
    }
}




