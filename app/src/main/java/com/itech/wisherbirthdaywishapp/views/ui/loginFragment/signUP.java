package com.itech.wisherbirthdaywishapp.views.ui.loginFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.itech.wisherbirthdaywishapp.R;

public class signUP extends Fragment implements View.OnClickListener {
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

        View view = inflater.inflate(R.layout.fragment_sign_u_p, container, false);

        signUp = view.findViewById(R.id.signUpText);
        fillInCredentials = view.findViewById(R.id.fillInCredentials);
        email = view.findViewById(R.id.EnterEmail);
        fullName = view.findViewById(R.id.EnterFullname);
        password = view.findViewById(R.id.Enterpassword);
        confirmPassword = view.findViewById(R.id.EnterConfirmPassword);
        register = view.findViewById(R.id.Register);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Navigation.findNavController(view).navigate(R.id.overview);
    }


}