package tables;

import db.MySQLConnector;
import objects.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentTables extends AbsTables {

    public StudentTables() {
        super("student");
        columns = new HashMap<>();
        columns.put("id", "bigint PRIMARY KEY AUTO_INCREMENT");
        columns.put("fio", "varchar(100)");
        columns.put("sex", "varchar(9)");
        columns.put("id_group", "int");
        create();
    }
    public ArrayList<Student> selectAll(){
        String sqlQuery = String.format("SELECT * FROM %s", tableName);
        return selectByQuery(sqlQuery);
    }

    public ArrayList<Student> selectByType(String type){
        String sqlQuery = String.format("SELECT * FROM %s WHERE type = '%s'",
                tableName, type);
        return selectByQuery(sqlQuery);
    }

    private ArrayList<Student> selectByQuery(String sqlQuery){
        ArrayList<Student> students = new ArrayList<>();
        db = new MySQLConnector();
        ResultSet rs = db.executeRequestWithAnswer(sqlQuery);
        try {
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("fio"),
                        rs.getString("sex"),
                        rs.getInt("id_group")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.close();
        }
        return students;
    }

    public void insert(Student student){
        db = new MySQLConnector();
        String sqlQuery = String.format("INSERT INTO %s (id, fio, sex, id_group) " +
                        "VALUES ('%d', '%s', '%s', '%d')",
                tableName, student.getId(), student.getFio(),
                student.getSex(), student.getId_group());
        db.executeRequest(sqlQuery);
        db.close();
    }

    public void update(Student student){
        db = new MySQLConnector();
        String sqlQuery = String.format("UPDATE %s SET " +
                        "fio='%s', sex='%s', id_group='%d', WHERE id = %d ",
                tableName,
                student.getFio(),
                student.getSex(),
                student.getId_group(),
                student.getId());
        db.executeRequest(sqlQuery);
        db.close();
    }

    public void delete(long id){
        db = new MySQLConnector();
        String sqlQuery = String.format("DELETE FROM %s WHERE id='%d'",
                tableName, id
        );
        db.executeRequest(sqlQuery);
        db.close();
    }
}