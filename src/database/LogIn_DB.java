package database;

public class LogIn_DB {

    //     Class.forName("Driver Name ");
    //Connection con = DriverManager.getConnection("", "", "");
   /* public boolean initialPasswordLogin(LogInUserDetails logInUser){
        String userName=logInUser.getUserName();
        String password=logInUser.getPassword();
        String pass_ip=logInUser.getPass_ip();
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        try {
            ResultSet rs = stmt.executeQuery("select * from ***   where username && password query");
            if (rs.last()){
                return rs.getRow()!=0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }*/
  /*  public boolean phasePasswordLogin(LogInUserDetails logIn) {
        if (logIn.getPass_ip().trim().equals(logIn.getPhase_ip().trim())){
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            try {
                ResultSet rs = stmt.executeQuery("select * from ***   where phase password query");
                if (rs.last()){
                    return rs.getRow()!=0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }*/
}
