package com.example.loginsingupapp;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

enum ErrorResult
{
    TRUE,FALSE,INCORRECT_EMAIL,INCORRECT_PASSWORD,EMPTY_FIELDS
}
public class Utilities {

        private static Utilities instance;

        public Utilities() {
        }

        public static Utilities getInstance() {
            if (instance == null) {
                instance = new Utilities();
            }

            return instance;
        }


    public boolean verifyEmail(AppCompatActivity activity, String email) {
        // split string and check if we have formal email structure
        String[] splitString = email.split("@");

        if (splitString.length != 2) {
            Toast.makeText(activity, "Username or password are incorrect!", Toast.LENGTH_SHORT).show();
            return false;
        }

        String username = splitString[0];
        String domain = splitString[1];
        String[]splitusername=username.split("");
        if (splitusername.length!=1){
            Toast.makeText(activity, "username or password are incorrect", Toast.LENGTH_SHORT).show();
            return false;
        }
        char first=username.charAt(0);
        if (!(first>='a' & first<='z'|| first == '_')) {
            Toast.makeText(activity, "username or password are incorrect", Toast.LENGTH_SHORT).show();
            return false;

        }
        if (username.length()>70)
        {
            Toast.makeText(activity, "", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (username.length()<3){
            Toast.makeText(activity, "username or password are incorrect ", Toast.LENGTH_SHORT).show();
            return false;
        }
        for (int i=0;i<username.length();i++){
            char p=username.charAt(i);
            if (!(p>='a' & p<='z' || p<='A' & p<='Z' || p=='_' || p>='0' & p<='9')){
                Toast.makeText(activity, "username or password are in correct ", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

return true;
    }

    public boolean validatePassword(AppCompatActivity activity, String password) {
        int countLetterssmail = 0, countnnumber = 0, countwildcard = 0, countLettersbig = 0;
        if (password.length() >= 8 && password.length() <= 30)
            Toast.makeText(activity, " password are incorrect!", Toast.LENGTH_SHORT).show();

        for (int i = 0; i <= password.length(); i++) {
            if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z')
                countLetterssmail++;
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z')
                countLettersbig++;
            if (password.charAt(i) >= 0 && password.charAt(i) <= 9)
                countnnumber++;
            for (int j = 0; j < 9; j++) {
                if (password.charAt(i) != i) {
                    if (password.charAt(i) < 'A' && password.charAt(i) > 'Z')
                        countwildcard++;
                }
            }
        }
        if (countLetterssmail >= 1)
            if (countnnumber >= 1)
                if (countwildcard >= 1)
                    if (countLettersbig >= 1)
                        return true;
        return false;
    }

}




