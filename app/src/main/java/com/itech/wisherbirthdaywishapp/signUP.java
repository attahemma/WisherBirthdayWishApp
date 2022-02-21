package com.itech.wisherbirthdaywishapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class signUP extends Fragment {
  TextView signUp, fillInCredentials, emailText, fullNameText, passwordText, confirmPasswordText;
  EditText email, fullName, password, confirmPassword;
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
        emailText = view.findViewById(R.id.EmailText);
        fullNameText = view.findViewById(R.id.FullNameText);
        passwordText = view.findViewById(R.id.PasswordText);
        confirmPasswordText = view.findViewById(R.id.ConfirmPasswordText);

        email= view.findViewById(R.id.EnterEmail);
        fullName = view.findViewById(R.id.EnterFullname);
        password = view.findViewById(R.id.Enterpassword);
        confirmPassword = view.findViewById(R.id.EnterConfirmPassword);

        return view;
   }
}