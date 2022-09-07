package com.example.steponstep;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class SigninTabFragment extends Fragment {

EditText Name, Email, Password,RePassword;
Button SIGN;
float v =0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container,false);

        Name = root.findViewById(R.id.Name);
        Email = root.findViewById(R.id.EmailS);
        Password = root.findViewById(R.id.PasswordS);
        RePassword = root.findViewById(R.id.Password2S);
//        SIGN = root.findViewById(R.id.button);

        Name.setTranslationX(800);
        Email.setTranslationX(800);
        Password.setTranslationX(800);
        RePassword.setTranslationX(800);

        Name.setAlpha(v);
        Email.setAlpha(v);
        Password.setAlpha(v);
        RePassword.setAlpha(v);

        Name.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        Email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        Password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        RePassword.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        return root;
    }
}
