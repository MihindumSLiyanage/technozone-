package com.techzone.login;

import com.techzone.db.DBConnection;
import java.sql.*;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

public class PwdBackup extends javax.swing.JFrame {

    /**
     * Creates new form PwdBackup
     */
    public PwdBackup() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAns1 = new javax.swing.JTextField();
        txtUid = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnClr = new javax.swing.JButton();
        txtAns3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Back Up Password and Set Up Recovery");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Set Up Password Recovery");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 400, 42));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel2.setText("User ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 67, 34));

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel4.setText("Question ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, 34));

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel6.setText("Answer");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 80, 34));

        txtAns1.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        getContentPane().add(txtAns1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 260, 34));

        txtUid.setEditable(false);
        txtUid.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txtUid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUidActionPerformed(evt);
            }
        });
        getContentPane().add(txtUid, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 260, 34));

        btnSubmit.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        btnSubmit.setText("Submit ");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 110, 30));

        btnClr.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        btnClr.setText("Clear");
        btnClr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClrActionPerformed(evt);
            }
        });
        getContentPane().add(btnClr, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, -1, 30));

        txtAns3.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        getContentPane().add(txtAns3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 260, 34));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
         String q1,q2,a1,a2,uid;
         a1=txtAns3.getText();
         //a2=txtAns2.getText();
         q1=txtAns1.getText();
         //q2=cmbQ2.getSelectedItem().toString();
         uid=txtUid.getText();
         Pattern p2=Pattern.compile("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[com]+$");
          
         if(uid.isEmpty()||a1.isEmpty()||q1.isEmpty()/*||a2.isEmpty()||q2.isEmpty()*/){
             JOptionPane.showMessageDialog(rootPane, "Please complete setting up security questions","Complete Signup",WARNING_MESSAGE);
         
         }
         else{
         DBConnection con=new DBConnection();
        Connection c=con.getConnection();
        try{
            Statement s1=c.createStatement();
           int co=s1.executeUpdate("update signup set q1='"+q1+"',a1='"+a1+"' where uid='"+uid+"'");
            int x=JOptionPane.showConfirmDialog(rootPane, "Confirm Your Backup Questions and Log In","Confirm",OK_CANCEL_OPTION,WARNING_MESSAGE);
                if(x==0){
                    Login l=new Login();
                     l.setVisible(true);
                  }      
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
         }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtUidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUidActionPerformed

    private void btnClrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClrActionPerformed

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
            java.util.logging.Logger.getLogger(PwdBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PwdBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PwdBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PwdBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PwdBackup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClr;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtAns1;
    private javax.swing.JTextField txtAns3;
    public static javax.swing.JTextField txtUid;
    // End of variables declaration//GEN-END:variables

}
