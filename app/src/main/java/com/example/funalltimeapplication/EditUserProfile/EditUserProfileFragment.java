package com.example.funalltimeapplication.EditUserProfile;

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
import com.example.funalltimeapplication.R;

import java.util.List;

public class EditUserProfileFragment extends Fragment {

    private String userName;
    EditText editFirstName, editLastName, editEmail;
    Button buttonUpdate;
    EditUserProfileViewModel editUserProfileViewModel;

    public EditUserProfileFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.edit_user_profile, container, false);

        if(getArguments() != null){
            userName = getArguments().getString("userId");
        }

        editFirstName = view.findViewById(R.id.editFirstName);
        editLastName = view.findViewById(R.id.editLastName);
        editEmail = view.findViewById(R.id.editEmail);
        buttonUpdate = view.findViewById(R.id.btnUpdate);

        editUserProfileViewModel = ViewModelProviders.of(this).get(EditUserProfileViewModel.class);

        editUserProfileViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                StringBuilder text = new StringBuilder();
                for(int i = 0; i < users.size(); i++) {
                    User user = users.get(i);
                }
            }
        });

        if(editUserProfileViewModel.findUser(userName).getUsername().equals(userName)){
            User user = editUserProfileViewModel.findUser(userName);

            editFirstName.setText(user.getFirstName());
            editLastName.setText(user.getLastName());
            editEmail.setText(user.getEmail());
        }

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = editUserProfileViewModel.findUser(userName);

                user.setUsername(userName);
                user.setFirstName(editFirstName.getText().toString());
                user.setLastName(editLastName.getText().toString());
                user.setEmail(editEmail.getText().toString());

                editUserProfileViewModel.updateUser(user);
            }

        });

        return view;
    }
}
