package com.example.funalltimeapplication.UserChangePassword;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.funalltimeapplication.Data.Entity.User;

public class UserChangePasswordViewModel extends AndroidViewModel {
    private UserChangePasswordRepository userChangePasswordRepository;

    public UserChangePasswordViewModel(@NonNull Application application) {
        super(application);
        userChangePasswordRepository = new UserChangePasswordRepository(application);
    }

    User findUser(String id) { return userChangePasswordRepository.findUser(id); }

    void updatePassword(User user) {
        userChangePasswordRepository.updatePassword(user);
    }
}
