package com.example.funalltimeapplication.Login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.funalltimeapplication.Data.Entity.User;

import java.util.List;

public class LoginViewModel extends AndroidViewModel {
    private LoginRepository loginRepository;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        loginRepository = new LoginRepository(application);
    }

    LiveData<List<User>> getAllUsers() {
        return loginRepository.getAllUsers();
    }

    void insertUser(User user) {
        loginRepository.insertUser(user);
    }

    User findUser(String id) { return loginRepository.findUser(id); }
}
