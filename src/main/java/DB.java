
import java.sql.*;
import java.util.Date;

public class DB {

    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB_NAME = "my_db3";
    private final String LOGIN = "bestuser";
    private final String PASSWORD = "bestuser";
    private final String TIME_ZONE = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private Connection dbConnect = null;

    private Connection getDbConnect() throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME + TIME_ZONE;
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(connStr, LOGIN, PASSWORD);
    }

    public void isConnected() throws ClassNotFoundException, SQLException {
        dbConnect = getDbConnect();
        System.out.println(dbConnect.isValid(1000));
    }

    public void insertData(String id, String event, String v_0) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO my_db3.lab2(id, idUser,  last_event,  speed,  time_) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = getDbConnect().prepareStatement(sql);
        preparedStatement.setString(1, null);
        preparedStatement.setString(2, id);
        preparedStatement.setString(3, event);
        preparedStatement.setString(4, v_0);
        preparedStatement.setString(5, String.valueOf(new Date()));
        preparedStatement.executeUpdate();
    }

    public void deleteAllData() throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM lab2";
        PreparedStatement preparedStatement = getDbConnect().prepareStatement(sql);
        preparedStatement.executeUpdate();
    }

    // test connected to db
    public static void main(String[] args) {
        DB db = new DB();

        try {
            db.isConnected();
            db.deleteAllData();
            //db.insertData("1","11","111");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
