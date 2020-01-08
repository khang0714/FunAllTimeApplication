package com.example.funalltimeapplication.UserChangePassword;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.funalltimeapplication.Data.Entity.User;
import com.example.funalltimeapplication.R;

public class UserChangePasswordFragment extends Fragment {
    private String userName;
    EditText editCurrentPassword, editNewPassword, editConfirmPassword;
    Button buttonChangePassword;
    UserChangePasswordViewModel userChangePasswordViewModel;

    public UserChangePasswordFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.change_password, container, false);

        editCurrentPassword = view.findViewById(R.id.editCurrentPassword);
        editNewPassword = view.findViewById(R.id.editNewPassword);
        editConfirmPassword = view.findViewById(R.id.editConfirmPassword);
        buttonChangePassword = view.findViewById(R.id.btnUpdatePassword);

        if(getArguments() != null){
            userName = getArguments().getString("userId");
        }

        userChangePasswordViewModel = ViewModelProviders.of(this).get(UserChangePasswordViewModel.class);

        buttonChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = userChangePasswordViewModel.findUser(userName);

                if(editCurrentPassword.getText().toString().equals(user.getPassword())){
                    if(editNewPassword.getText().toString().equals(editConfirmPassword.getText().toString()) ){
                        Toast.makeText(getActivity(), "Update Successfully",
                                Toast.LENGTH_LONG).show();

                        user.setUsername(userName);
                        user.setPassword(editConfirmPassword.getText().toString());
                        userChangePasswordViewModel.updatePassword(user);
                    }
                    else{
                        Toast.makeText(getActivity(), "New Password not matching with Confirm Password!",
                                Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getActivity(), "Incorrect password!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
}
