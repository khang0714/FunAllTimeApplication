package com.example.funalltimeapplication.Login;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.funalltimeapplication.Data.DAO.UserDAO;
import com.example.funalltimeapplication.Data.Database.FunAllTimeDatabase;
import com.example.funalltimeapplication.Data.Entity.User;

import java.util.List;

public class LoginRepository {
    private LiveData<List<User>> allUsers;
    private UserDAO userDao;


    LoginRepository(Context context) {
        FunAllTimeDatabase funAllTimeDatabase = FunAllTimeDatabase.getDatabase(context.getApplicationContext());
        userDao = funAllTimeDatabase.getUserDao();
        allUsers = userDao.getAllUsers();
    }

    LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    User findUser(String id){ return userDao.findUser(id); }

    void insertUser(User user) {
        new InsertAsyncTask(userDao).execute(user);
    }

    static class InsertAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDAO userDao;

        InsertAsyncTask(UserDAO userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.insertUser(users[0]);
            return null;
        }
    }

    static class FindUserAsyncTask extends AsyncTask<String, Void, Void> {
        private UserDAO userDao;

        FindUserAsyncTask(UserDAO userDao){this.userDao = userDao;}

        @Override
        protected Void doInBackground(String... strings) {
            userDao.findUser(strings[0]);
            return null;
        }
    }


}
