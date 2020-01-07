package com.example.funalltimeapplication.EditUserProfile;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.funalltimeapplication.Data.DAO.UserDAO;
import com.example.funalltimeapplication.Data.Database.FunAllTimeDatabase;
import com.example.funalltimeapplication.Data.Entity.User;

import java.util.List;

public class EditUserProfileRepository {
    private LiveData<List<User>> allUsers;
    private UserDAO userDao;

    EditUserProfileRepository(Context context){
        FunAllTimeDatabase funAllTimeDatabase = FunAllTimeDatabase.getDatabase(context.getApplicationContext());
        userDao = funAllTimeDatabase.getUserDao();
        allUsers = userDao.getAllUsers();
    }
}
