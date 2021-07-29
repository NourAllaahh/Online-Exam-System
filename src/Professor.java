/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author win10
 */
public class Professor implements Users{

    @Override
    public void signup() {
     ProfReg v = new ProfReg();
        v.setVisible(true);
        this.setVisible(false);
    
    }

    @Override
    public void login() {
    
      ProfMain v = new ProfMain();
       v.setVisible(true);
       this.setVisible(false);
    }

    @Override
    public void takeExam() {}

    @Override
    public void viewQBank() {}

    
      
    
    

    @Override
    public void ListProfessors() {}

    @Override
    public void ListStudent() {}

    @Override
    public void ListDepartment() {}

    @Override
    public void ListSubject() {}

    @Override
    public void approveRequest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ViewEditQuestion() {
       profQuestionBank v = new profQuestionBank();
       v.setVisible(true);
       this.setVisible(false); 
    }

    @Override
    public void ViewChapter() {
       ProfChp v = new ProfChp();
       v.setVisible(true);
       this.setVisible(false); 
       
    }

    @Override
    public void determinExameTime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void organizeTheStructure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ShowResults() {
ProfStudentResults v = new ProfStudentResults();
       v.setVisible(true);
       this.setVisible(false);     }

   
    private void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
