/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.regex.Pattern;

/**
 *
 * @author 2ndyrGroupB
 */
public class Validate {
    private String name;
    private int age ;
    private String username;
    private String password;
    private String confirm;
    //private String confirmPassword;

    public int regValidator(String name, int age, String username, String password, String confirm) {
        Pattern specailCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
        Pattern lowerCasePatten = Pattern.compile("[a-z ]");
        Pattern digitCasePatten = Pattern.compile("[0-9 ]");
        int state = 0;
        
        if(username == null || " ".equals(username)){
            System.out.println("Username field must be filled!");
            state++;
        }
        if (!password.equals(confirm)) {
            System.out.println("password and confirm password does not match");
            state++;
        }
        if (password.length() < 8) {
            System.out.println("Password length must have alleast 8 character !!");
            state++;
        }
        if (!specailCharPatten.matcher(password).find()) {
            System.out.println("Password must have atleast one special character !!");
            state++;
        }
        if (!UpperCasePatten.matcher(password).find()) {
            System.out.println("Password must have atleast one uppercase character !!");
            state++;
        }
        if (!lowerCasePatten.matcher(password).find()) {
            System.out.println("Password must have atleast one lowercase character !!");
            state++;
        }
        if (!digitCasePatten.matcher(password).find()) {
            System.out.println("Password must have atleast one digit character !!");
            state++;
        }
        if (age < 18) {
            System.out.println("Minors are not allowed to register!");
            state++;
        }
        
        return state;
    }
}