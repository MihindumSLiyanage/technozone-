package com.techzone.login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidatePassword {
   public static boolean checkPwd(String pwd){
       if(pwd.length()>7){
           
          if(chckchar(pwd)) {
             return true;
          }
          else{
              return false;
          }
       }
       else{ 
           return false;
       }
   } 
   
   public static boolean chckchar(String  Password){
       boolean haslc=false,hasuc=false,hasnum=false;char c;
       for(int i=0;i<Password.length();i++){
       c=Password.charAt(i);
       if(Character.isDigit(c)){
           
           hasnum=true;
       }
       if(Character.isUpperCase(c)){
           hasuc=true;
       }
       if(Character.isLowerCase(c)){
           haslc=true;
       }
       if(hasnum&&haslc&&hasuc){
           return true;
       }
       }
      return false;
   }
   
   public static boolean specialCheck(String password){
       Pattern ps=Pattern.compile("^[a-zA-Z0-9]*");
       Matcher ms=ps.matcher(password);
       if(ms.matches()){
           return false;
           
       }
       
   return true;    
   }
   
   
}
