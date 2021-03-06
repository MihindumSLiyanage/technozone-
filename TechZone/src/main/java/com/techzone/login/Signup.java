package com.techzone.login;

import com.techzone.db.DBConnection;
import javax.swing.JOptionPane;
import java.sql.*;

public class Signup extends javax.swing.JFrame {

   
    public Signup() {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUid = new javax.swing.JTextField();
        txtUname = new javax.swing.JTextField();
        txtCpwd = new javax.swing.JPasswordField();
        btnContinue = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        btnClr = new javax.swing.JButton();
        txtEid = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPwd = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign up");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sign Up");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 61));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel3.setText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 200, 37));

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel4.setText("Confirm Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 200, 37));

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel5.setText("Employee  ID");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 200, 37));

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel6.setText("User ID");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 37));

        txtUid.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txtUid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUidActionPerformed(evt);
            }
        });
        getContentPane().add(txtUid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 240, 30));

        txtUname.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        getContentPane().add(txtUname, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 240, 30));

        txtCpwd.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        getContentPane().add(txtCpwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 240, 30));

        btnContinue.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        btnContinue.setText("Continue ");
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });
        getContentPane().add(btnContinue, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 130, 33));

        btnLogin.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        btnLogin.setText("Back");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 90, 33));

        btnClr.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        btnClr.setText("Clear");
        btnClr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClrActionPerformed(evt);
            }
        });
        getContentPane().add(btnClr, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, -1, 33));

        txtEid.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        getContentPane().add(txtEid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 240, 30));

        jLabel8.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel8.setText("UserName");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 200, 37));

        txtPwd.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txtPwd.setToolTipText("Password must contain atleast 8 characters including Uppercase Letters,Lowercase Letters,Numbers & Symbols");
        txtPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPwdActionPerformed(evt);
            }
        });
        getContentPane().add(txtPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 240, 30));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        Login l=new Login();
        l.setVisible(true);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed
        String eno,uid,uname,pwd;
        eno=txtEid.getText();
        uid=txtUid.getText();
        uname=txtUname.getText();
       // email=txtEmail.getText();
        pwd=txtPwd.getText();
        String cpwd=txtCpwd.getText();
       /* q1=txtQ1.getText();
        a1=txtA1.getText();
        q2=txtQ2.getText();
        a2=txtA2.getText();*/
        if(eno.isEmpty()||uid.isEmpty()||uname.isEmpty()|| /*email.isEmpty()||*/pwd.isEmpty()||cpwd.isEmpty()/*||q1.isEmpty()||a1.isEmpty()||q2.isEmpty()||a2.isEmpty()*/){
            JOptionPane.showMessageDialog(null, "please Do not leave empty");
        }
        else if(ValidatePassword.checkPwd(pwd)==false||ValidatePassword.specialCheck(pwd)==false){
                       JOptionPane.showMessageDialog(null,"Password Must contain atleast 8 characters \nwith one or more of an uppercase letter,a lowercase letter,a number and symbol","Weak Password",JOptionPane.ERROR_MESSAGE);
                       txtPwd.setText(null);
                       txtCpwd.setText(null);
        }
        else if(!pwd.equals(cpwd)){
            JOptionPane.showMessageDialog(rootPane, "Paswords do not match.");
            txtPwd.setText(null);
            txtCpwd.setText(null);
        }
        else{
            DBConnection con=new DBConnection();
            Connection c=con.getConnection();
            try{
                Statement s1=c.createStatement();
                int co=s1.executeUpdate("insert into signup(uid,eno,uname,pwd) values('"+uid+"','"+eno+"','"+uname+"','"+pwd+"')");
                if (co==1){
                    JOptionPane.showMessageDialog(rootPane, "Successful Entry");
                    PwdBackup b = new PwdBackup();
                    PwdBackup.txtUid.setText(uid);
                    b.setVisible(true);
                }
            }
            catch(SQLException e){
                System.out.print(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnContinueActionPerformed

    private void btnClrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClrActionPerformed
       txtCpwd.setText(null);
       txtEid.setText(null);
       txtUid.setText(null);
       txtUname.setText(null);
      txtPwd.setText(null);
    }//GEN-LAST:event_btnClrActionPerformed

    private void txtPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPwdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPwdActionPerformed

    private void txtUidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUidActionPerformed

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
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClr;
    private javax.swing.JButton btnContinue;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField txtCpwd;
    public static javax.swing.JTextField txtEid;
    private javax.swing.JPasswordField txtPwd;
    public static javax.swing.JTextField txtUid;
    public static javax.swing.JTextField txtUname;
    // End of variables declaration//GEN-END:variables
}
