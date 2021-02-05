/**
 * @author Joseph Newman
 *
 */
package com.example.week1_homework_1_newman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final static String TAG = "DEBUG";
    public int Id = 0;
    public static ArrayList<TempUser> users = new ArrayList<>();

    /**
     *         Fills the ArrayList for the hard programmed Users into the Database;
     * @param i used for running testing purposes
     * @return returns the user name for when running Android Tests; making sure all is functional;
     */

    public static String fillUsers(int i){
        users.add(new TempUser("Yoda","BabyYoda"));
        users.add(new TempUser("Anakin","Vader"));
        users.add(new TempUser("Obi","Won"));
        users.add(new TempUser("John","Wick"));
        users.add(new TempUser("Android","Studio"));
        users.add(new TempUser("Joseph","Newman"));
        users.add(new TempUser("csumb","otters"));
        users.add(new TempUser("Dr","C"));
        users.add(new TempUser("user","pass"));
        users.add(new TempUser("REST","API"));
        return users.get(i).getUsername();
    }

    /**
     *
     * @param i Index of which you want to search the ArrayList for the password
     * @return Returns the hardcoded Password for testing purposes;
     */
    public static String testPass(int i){
        users.add(new TempUser("Yoda","BabyYoda"));
        users.add(new TempUser("Anakin","Vader"));
        users.add(new TempUser("Obi","Won"));
        users.add(new TempUser("John","Wick"));
        users.add(new TempUser("Android","Studio"));
        users.add(new TempUser("Joseph","Newman"));
        users.add(new TempUser("csumb","otters"));
        users.add(new TempUser("Dr","C"));
        users.add(new TempUser("user","pass"));
        users.add(new TempUser("REST","API"));
        return users.get(i).getPassword();
    }

    /**
     *
     * @return all users within the ArrayList that are hard coded in;
     */
    public static ArrayList<TempUser> getUsers() {
        return users;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillUsers(0);

        EditText User = findViewById(R.id.editUsername);
        EditText Pass = findViewById(R.id.editPassword);
        Button login = findViewById(R.id.loginButton);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass;
                boolean login = true;
                if(User.getText().toString().equals("") || Pass.getText().toString().equals("")){

                    Log.d(TAG,"OnClick:" +"Fields must be filled and completed.");
                }else {

                   for(int i =0; i < users.size();i++){
                       if(users.get(i).username.equals(User.getText().toString()) && users.get(i).Password.equals(Pass.getText().toString())){
                           login = true;
                           Log.d(TAG,"LOGIN SUCCESSFUL");
                           Id = i;
                           break;
                       } else {
                           Log.d(TAG,"not Found in place " + i);
                           login = false;
                           if(i == 9){
                               for(int j =0; j< users.size(); j++){
                                   if(users.get(j).username.equals(User.getText().toString())){
                                       SpannableString str = new SpannableString(Pass.getText().toString());
                                       str.setSpan(new BackgroundColorSpan(Color.YELLOW), 0, Pass.getText().length(), 0);
                                       Pass.setText(str);
                                   }
                               }
                           } else{
                               SpannableString str = new SpannableString(User.getText().toString());
                               str.setSpan(new BackgroundColorSpan(Color.YELLOW), 0, User.getText().length(), 0);
                               User.setText(str);
                           }
                         }
                       }
                        if(login == false){
                            Toast.makeText(getApplicationContext(),"Invalid Login, Please try again",Toast.LENGTH_LONG).show();
                        } else{
                            Intent intent = new Intent(MainActivity.this,LoginConfirmed.class);
                            String value = Integer.toString(Id);
                            intent.putExtra("I", value);
                            startActivity(intent);
                        }
                   }
                }

        });

    }
}