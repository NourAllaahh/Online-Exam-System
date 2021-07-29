/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author win10
 */
public class UsersFactory {
    
    public Users getUsers(String userType){
            
    if(userType==null){
        
        return null;
            }
    
    if(userType.equalsIgnoreCase("ADMIN")){
    return new Admin();
    }
    else if (userType.equalsIgnoreCase("PROFESSOR")){
    return new Professor();
    }
    else if (userType.equalsIgnoreCase("STUDENT")){
    return new Student();
    }
    return null;
    }
    
}
