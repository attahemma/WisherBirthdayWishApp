package com.itech.wisherbirthdaywishapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class signUP extends Fragment {
  TextView signUp, fillInCredentials;
  TextInputEditText email, fullName, password, confirmPassword;
  Button register;
    public signUP() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_sign_u_p, container, false);

        signUp = view.findViewById(R.id.signUpText);
        fillInCredentials = view.findViewById(R.id.fillInCredentials);
        email= view.findViewById(R.id.EnterEmail);
        fullName = view.findViewById(R.id.EnterFullname);
        password = view.findViewById(R.id.Enterpassword);
        confirmPassword = view.findViewById(R.id.EnterConfirmPassword);
         register = view.findViewById(R.id.Register);
        return view;
   }
}