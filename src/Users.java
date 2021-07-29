/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author win10
 */
public interface Users {
    
     
    void signup();
    void login();
    
    //Student
     void takeExam();
     void viewQBank();
    
  
    //Admin Only
    void ListProfessors(); // add edit and View Professors // assign Subjects 
    void ListStudent(); // add edit and View Professors // assign Subjects 
    void ListDepartment();// add ,edit and delete Departments 
    void ListSubject(); //edit subject
    void approveRequest(); // approve Requests
  
   //professor and admin
     void ViewEditQuestion();// add, edit and view questions
     void ViewChapter(); // add and edit chapters 
     void determinExameTime();
     void organizeTheStructure();
     void ShowResults();
     
  
   
     

  
    
}
