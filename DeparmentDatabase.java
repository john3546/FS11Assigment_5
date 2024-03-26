import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentDatabase {
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/departments";
    private static final String USERNAME="your_username";
    private static final String PASSWORD="your_password";

    public static void main(String[]args) {
        Department dept1=new Department(101,"HR");
        Department dept2=new Department(102,"IT");

        insertDepartment(dept1);
        insertDepartment(dept2);
    }

    private static void insertDepartment(Department department) {
        try (
            Connection connection=DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
            Statement statement=connection.createStatement();
        ) {
            String sql="INSERT INTO department(id,name) VALUES("+department.getId()+",'"+department.getName() + "')";
            statement.executeUpdate(sql);

            System.out.println("Department" +department.getId()+"inserted successfully.");
        } catch(SQLExceptione) {
            e.printStackTrace();
        }
    }
}

class Department {
    private int id;
    private String name;

    public Department(int id,String name) {
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
