

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author win10
 */
public class Student implements Users{
    String StudentName;
    String StudentPassword;


    @Override
    public void signup() {
    
        StudentReg v = new StudentReg();
        v.setVisible(true);
        this.setVisible(false);
            
    }

    @Override
    public void login() {
        StudentMain v = new StudentMain();
        v.setVisible(true);
        this.setVisible(false);
      }

    @Override
    public void takeExam() {
       StartExam v = new StartExam();
       v.setVisible(true);
       this.setVisible(false);
    }

    @Override
    public void viewQBank() {
       StudentQBank v = new StudentQBank();
       v.setVisible(true);
       this.setVisible(false); }

   

    @Override
    public void ListProfessors() {}

    @Override
    public void ListStudent() {}

    @Override
    public void ListDepartment() {}

    @Override
    public void ListSubject() {}

    @Override
    public void approveRequest() {}

    @Override
    public void ViewEditQuestion() {}

    @Override
    public void ViewChapter() {}

    @Override
    public void determinExameTime() {}

    @Override
    public void organizeTheStructure() {}

    @Override
    public void ShowResults() {}
 

   

    private void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

   
}
