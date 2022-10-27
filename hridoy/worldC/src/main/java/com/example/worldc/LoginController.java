package com.example.worldc;

import java.sql.SQLException;

public class LoginController {


    public void updatePassword(String email, String confirmPass, String newPass) throws SQLException {
        if(newPass.equals(confirmPass)){
            String query = "UPDATE user_data SET  password = '" + confirmPass + "'  WHERE email = '" + email + "';";
            DataBase.update(query);
            String user = DataBase.getUserName(email,"SELECT * FROM user_data WHERE email = ?");
            DataBase.logIn(user, confirmPass,null );
        }
    }
}
