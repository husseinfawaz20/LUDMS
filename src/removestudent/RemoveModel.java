

package removestudent;

import database.DataBase;

import java.rmi.ConnectIOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.management.Query;

import com.mysql.cj.jdbc.CallableStatement;

/*
public class RemoveModel {
    DataBase db = new DataBase();
    public int deleteStudent(int idstudents){
        try{
        	
            String query = "DELETE FROM `dorms-registration`.`students` WHERE `idstudents`="+idstudents+";";
            int deleted = db.modifyData(query);       
            return deleted;
            

        }catch(SQLException e){
            System.out.println("failed to get data");
            return 0;
        }
    }
}
*/

public class RemoveModel extends DataBase{
    static DataBase db = new DataBase();
    static Connection conn= db.getConnection();
    
    public int deleteStudent(int idstudents){
        try{
        	java.sql.CallableStatement statement = conn.prepareCall("{call Remove_Student(?)}");	
        	 statement.setInt(1, idstudents);
        	statement.execute();
        	return 1;
       	
        }catch(SQLException e){
            System.out.println("failed to get data");
            return 0;
        }
    }
}

