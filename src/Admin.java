
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
public class Admin implements Users{
  

    @Override
    public void signup() {}

    @Override
    public void login() {
         AdminMain AdLogin = new AdminMain();
         AdLogin.setVisible(true);
         this.setVisible(false);
        
         }       

   
    @Override
    public void takeExam() {}

    @Override
    public void viewQBank() {}

    

    @Override
    public void ListProfessors() {
       ViewProfList v = new ViewProfList();
       v.setVisible(true);
       this.setVisible(false); 
    }

    @Override
    public void ListStudent() {
       ViewStudentList v = new ViewStudentList();
       v.setVisible(true);
       this.setVisible(false);     }

    @Override
    public void ListDepartment() {
        ViewDepartments v = new ViewDepartments();
       v.setVisible(true);
       this.setVisible(false); 
    }

    @Override
    public void ListSubject() {
         ViewSubjects v = new ViewSubjects();
         v.setVisible(true);
         this.setVisible(false); 
    }

    @Override
    public void approveRequest() {}

    @Override
    public void ViewEditQuestion() { 
       profQuestionBank v = new profQuestionBank();
       v.setVisible(true);
       this.setVisible(false); 
    }

    @Override
    public void ViewChapter() {}

    @Override
    public void determinExameTime() {}

    @Override
    public void organizeTheStructure() {}

    @Override
    public void ShowResults() {
    
     ProfStudentResults v = new ProfStudentResults();
       v.setVisible(true);
       this.setVisible(false);  
    
    }

   

    private void setVisible(boolean b) {
    }}
