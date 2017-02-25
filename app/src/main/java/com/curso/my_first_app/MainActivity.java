package com.curso.my_first_app;

import android.content.Context;
import android.support.v7.app.*;
import android.os.Bundle;
import android.test.ApplicationTestCase;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.id;

public class MainActivity extends AppCompaActivity{
    private EditText username;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R,id,usernameEditText);
        password =(EditText)findViewById(R,id,passwordEditText);
        Button login =(Button)findViewById(R,id,loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passValidation()){
                    checkCredentials();
                }
            }
        });
    }

    private boolean checkCredentials() {
        boolean rigthCredentials = true;
        username.setError(null);
        password.setError(null);
        String usernameText =username.getText().toString();
        String passwordText =password.getText().toString();
        if(usernameText.equalsIgnoreCase("vivi")){
            if(passwordText.equalsIgnoreCase("hola123")){
                //Las credenciales son correctas
                Toast.makeText(getApplicationContext(),"Credenciales correctas", Toast.LENGTH_LONG);
            }else{
                password.setError("password incorrecto");
                rigthCredentials = false;
            }
        }else{
            username.setError("Usuario incorrecto");
            rigthCredentials= false;
        }
        return rigthCredentials;
    }

    private boolean passValidation() {
        boolean passValidation = true;
        username.setError(null);
        String usernameText = username.getText().toString();
        if(usernameText.length()==0){
            username.setError("Username no puede estar vacio");
            passValidation = false;
        }
        String passwordText = password.getText().toString();
        if(passwordText.length()==0){
            password.setError("password no puede estar vacio");
            passValidation = false;
        }
        return passValidation;
    }



}
