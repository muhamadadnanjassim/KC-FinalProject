package com.example.steponstep;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class LoginTabFragment extends Fragment {

    EditText Emailg, Passwordg;
    Button LOGIN;
    float v =0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container,false);

        Emailg = root.findViewById(R.id.Email);
        Passwordg = root.findViewById(R.id.Passwors);
//        LOGIN = root.findViewById(R.id.B1);

        Emailg.setTranslationX(800);
        Passwordg.setTranslationX(800);
//        LOGIN.setTranslationX(800);

        Emailg.setAlpha(v);
        Passwordg.setAlpha(v);
//        LOGIN.setAlpha(v);

        Emailg.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        Passwordg.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(600).start();
//        LOGIN.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        return root;
    }
}
