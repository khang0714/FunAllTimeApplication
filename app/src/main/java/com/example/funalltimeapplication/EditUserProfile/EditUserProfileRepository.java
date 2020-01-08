package com.example.funalltimeapplication.EditUserProfile;

import android.content.Context;
import android.os.AsyncTask;

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

    LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    void updateUser(User user) {
        new UpdateUserAsyncTask(userDao).execute(user);
    }

    User findUser(String id){ return userDao.findUser(id); }

    static class FindUserAsyncTask extends AsyncTask<String, Void, Void> {
        private UserDAO userDao;

        FindUserAsyncTask(UserDAO userDao){this.userDao = userDao;}

        @Override
        protected Void doInBackground(String... strings) {
            userDao.findUser(strings[0]);
            return null;
        }
    }

    static class UpdateUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDAO userDao;

        UpdateUserAsyncTask(UserDAO userDao){this.userDao = userDao;}

        @Override
        protected Void doInBackground(User... users) {
            userDao.updateUser(users[0]);
            return null;
        }
    }
}
