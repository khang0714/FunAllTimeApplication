package com.example.funalltimeapplication.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.funalltimeapplication.Data.Entity.User;
import com.example.funalltimeapplication.EditUserProfile.EditUserProfileFragment;
import com.example.funalltimeapplication.R;

import java.util.List;

public class LoginFragment extends Fragment {
    EditText editUsername, editPassword;
    Button btnLogin;
    LoginViewModel loginViewModel;

    public LoginFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login, container,false); //Inflate layout

        editUsername = view.findViewById(R.id.editUsername);
        editPassword = view.findViewById(R.id.editPassword);
        btnLogin = view.findViewById(R.id.btnLogin);

//        User user = new User("abc123","abc123",
//                "Kevin", "Durant", "kevin@yahoo.com");
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
//        loginViewModel.insertUser(user);
//
//        loginViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
//            @Override
//            public void onChanged(List<User> users) {
//                StringBuilder text = new StringBuilder();
//                for(int i = 0; i < users.size(); i++) {
//                    User user = users.get(i);
//                }
//            }
//        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(loginViewModel.findUser(editUsername.getText().toString()).getPassword().equals(editPassword.getText().toString())){
                    EditUserProfileFragment editUserProfileFragment = new EditUserProfileFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("userId", editUsername.getText().toString());
                    editUserProfileFragment.setArguments(bundle);

                    getFragmentManager().beginTransaction().replace(getId(), editUserProfileFragment).commit();
                }

            }
        });

        return view;
    }

}
