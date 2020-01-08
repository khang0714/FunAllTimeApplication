package com.example.funalltimeapplication.UserChangePassword;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.funalltimeapplication.Data.DAO.UserDAO;
import com.example.funalltimeapplication.Data.Database.FunAllTimeDatabase;
import com.example.funalltimeapplication.Data.Entity.User;

import java.util.List;

public class UserChangePasswordRepository {

    private LiveData<List<User>> allUsers;
    private UserDAO userDao;

    UserChangePasswordRepository(Context context){
        FunAllTimeDatabase funAllTimeDatabase = FunAllTimeDatabase.getDatabase(context.getApplicationContext());
        userDao = funAllTimeDatabase.getUserDao();
        allUsers = userDao.getAllUsers();
    }

    void updatePassword(User user) {
        new UpdatePasswordAsyncTask(userDao).execute(user);
    }

    User findUser(String id){ return userDao.findUser(id); }

    static class UpdatePasswordAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDAO userDao;

        UpdatePasswordAsyncTask(UserDAO userDao){this.userDao = userDao;}

        @Override
        protected Void doInBackground(User... users) {
            userDao.updateUser(users[0]);
            return null;
        }
    }

}
