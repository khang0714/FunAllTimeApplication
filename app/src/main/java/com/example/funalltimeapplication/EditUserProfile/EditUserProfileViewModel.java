package com.example.funalltimeapplication.EditUserProfile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.funalltimeapplication.Data.Entity.User;

import java.util.List;

public class EditUserProfileViewModel extends AndroidViewModel {
    private EditUserProfileRepository editUserProfileRepository;

    public EditUserProfileViewModel(@NonNull Application application) {
        super(application);
        editUserProfileRepository = new EditUserProfileRepository(application);
    }

    LiveData<List<User>> getAllUsers() {
        return editUserProfileRepository.getAllUsers();
    }

    User findUser(String id) { return editUserProfileRepository.findUser(id); }

    void updateUser(User user) {
        editUserProfileRepository.updateUser(user);
    }
}
