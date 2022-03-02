package com.itech.wisherbirthdaywishapp.views.ui.loginFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.itech.wisherbirthdaywishapp.R;


public class SignIn extends Fragment {

    TextView signIn, fillInCredentials;
    TextInputEditText email, password;
    Button login;
    public SignIn() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        signIn = view.findViewById(R.id.signInText);
        fillInCredentials = view.findViewById(R.id.fillInCredentials);
        email= view.findViewById(R.id.EnterEmail);
        password = view.findViewById(R.id.Enterpassword);
        login = view.findViewById(R.id.login);
        return view;
    }
}