


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author win10
 */
public class StartExam extends javax.swing.JFrame {

    /**
     * Creates new form StartExam
     */
        public StartExam() {
        initComponents();
        connect();
        LoadQuestions();
    }
         Connection con;
         PreparedStatement pst;
          ResultSet rs;
          Timer time;
          
          
          int answercheck=0;
          int marks=0;
          int min =0;
          int sec =0;
          
          
          String cor=null;
          String Answer=null;
          Statement stat;
          
          
          public boolean answerCheck(){
          
              
          String Answer="";
          if(r1.isSelected())
          {
          Answer= r1.getText();
          }
          else if (r2.isSelected())
          {
          Answer = r2.getText();
          }
           else if (r3.isSelected())
          {
          Answer = r3.getText();
          }
           else if (r4.isSelected())
          {
          Answer = r4.getText();
          }
          
          if(Answer.equals(cor)){
          marks=marks +1;
          txtmarks.setText(String.valueOf(marks));
          
          
        }
          
          else if (!Answer.equals(cor)&& Answer !=null){
            
              //only deduct if marks greater than zero
              if(marks > 0){
              marks = marks-1;
              }
          
             txtmarks.setText(String.valueOf(marks));

              }
          
          
          //to store answers
          if(!Answer.equals("")){
          try{
              String query ="UPDATE qbank SET GivenAnswer = ? WHERE Question =?";
              pst = con.prepareStatement(query);
              pst.setString(1, Answer);
              pst.setString(2, jLabel2.getText());
              pst.execute();
          } catch (SQLException ex){
                  ex.printStackTrace();
                  }
          return true;
          
          }
          //when no button is selected
          return false;
          
          
          }
          
          public void NullGivenAnswer(){
          
          try{
          
          String query = "UPDATE qbank Set GivenAnswer =?";
          pst = con.prepareStatement(query);
          pst.setString(1,null);
          pst.execute();
        }
          catch (SQLException ex){
          ex.printStackTrace();
          }
          
          }
          
          public boolean AlreadyAnswerd(){
          
          try{
          String query = "SELECT GivenAnswer FROM qbank WHERE question ='"+jLabel2.getText()+"'";
          stat = con.prepareStatement(query);
          ResultSet res = stat.executeQuery(query);
          
          while (res.next()){
          
          Answer = res.getString("GivenAnswer");
          if(Answer == null){
          return false;
          }
          break;
          }
          if (r1.getText().equals(Answer)){
          r1.setSelected(true);
          }
          else if (r2.getText().equals(Answer)){
          r2.setSelected(true);
          }
           else if (r3.getText().equals(Answer)){
          r3.setSelected(true);
          }
           else if (r4.getText().equals(Answer)){
          r4.setSelected(true);
          }
          }
          catch (SQLException ex){
          System.out.println("Execption Caught");
          ex.printStackTrace();
          }
          return true;
          }
        
         public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam?zeroDateTimeBehavior=convertToNull","root","");
        } catch (SQLException ex) {
            Logger.getLogger(StudentReg.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentReg.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    }
    public void LoadQuestions(){
        String query = "select*from qbank ORDER BY RAND() limit 5";
        Statement stat = null;
        
        try {
            stat = con.createStatement();
            rs=stat.executeQuery(query);
            
            while(rs.next())
            {
            
            jLabel3.setText(rs.getString(1));
            jLabel2.setText(rs.getString(2));
            r1.setText(rs.getString(4));
            r2.setText(rs.getString(5));
            r3.setText(rs.getString(6));
            r4.setText(rs.getString(7));
            cor = rs.getString(3);
            break;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StartExam.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setLocationRelativeTo(this);
        time = new Timer(1000,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                LabelSec.setText(String.valueOf(sec));
                LabelMin.setText(String.valueOf(min));
                
                if(sec==60){
                
                sec=0;
                min++;
                if (min==10){
                time.stop();
                answerCheck();
                System.exit(0);
                }
                }
                sec++;
            }
        });
        
time.start();


}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        r1 = new javax.swing.JRadioButton();
        r2 = new javax.swing.JRadioButton();
        r3 = new javax.swing.JRadioButton();
        r4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtmarks = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LabelMin = new javax.swing.JLabel();
        LabelSec = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(r1);
        r1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        r1.setText("jRadioButton1");

        buttonGroup1.add(r2);
        r2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        r2.setText("jRadioButton2");

        buttonGroup1.add(r3);
        r3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        r3.setText("jRadioButton3");
        r3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(r4);
        r4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        r4.setText("jRadioButton4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(r1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                    .addComponent(r2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(r3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(r4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(711, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(r1)
                .addGap(18, 18, 18)
                .addComponent(r2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(r3)
                .addGap(18, 18, 18)
                .addComponent(r4)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Online Exam");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Questions");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("No");

        txtmarks.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtmarks.setForeground(new java.awt.Color(255, 0, 0));
        txtmarks.setText("Marks");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Time");

        LabelMin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelMin.setText("00");

        LabelSec.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelSec.setText("00");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Submit");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(539, 539, 539)
                        .addComponent(jLabel1)
                        .addGap(421, 421, 421)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelMin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelSec))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(35, 35, 35)
                        .addComponent(txtmarks)))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(LabelMin)
                    .addComponent(LabelSec))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtmarks)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void r3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   
        if (answerCheck()){
    try{
    
    
    if(rs.next())
    {
            jLabel2.setText(rs.getString("Question"));
            r1.setText(rs.getString(4));
            r2.setText(rs.getString(5));
            r3.setText(rs.getString(6));
            r4.setText(rs.getString(7));
            
            cor=rs.getString(3);
            
            if(AlreadyAnswerd()){
            
            buttonGroup1.clearSelection();
            }
    }
    else{
        
        JOptionPane.showMessageDialog(this,"Exam Finished");
        
        String Submit =JOptionPane.showInputDialog(this,"Please Enter Your Password To Submit");
        
        JOptionPane.showMessageDialog(this,"your Result is" +txtmarks.getText());
        
            pst = con.prepareStatement("update student set mark=? where StPass =?");
            pst.setString(1, txtmarks.getText());
            pst.setString(2, Submit);
            
            int P =   pst.executeUpdate();
        
       
         StudentMain a = new StudentMain();
         a.setVisible(true);
         this.setVisible(false);
        
    }
            }
    catch(Exception e)
    {
    e.printStackTrace();
    }
     }


    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartExam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelMin;
    private javax.swing.JLabel LabelSec;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    private javax.swing.JRadioButton r3;
    private javax.swing.JRadioButton r4;
    private javax.swing.JLabel txtmarks;
    // End of variables declaration//GEN-END:variables
}
