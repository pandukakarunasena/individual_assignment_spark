import com.panduka.ncms.utils.db.ConnectionPool;
import com.panduka.ncms.utils.db.TomcatJDBCConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) {
        try {
            Connection connection = TomcatJDBCConnectionPool.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from student");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                System.out.print(rs.getString("firstname") + " ");
                System.out.println(rs.getString("lastname"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
