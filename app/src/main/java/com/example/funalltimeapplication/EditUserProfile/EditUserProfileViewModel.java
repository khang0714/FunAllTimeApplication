package com.example.funalltimeapplication.EditUserProfile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class EditUserProfileViewModel extends AndroidViewModel {
    private EditUserProfileRepository editUserProfileRepository;

    public EditUserProfileViewModel(@NonNull Application application) {
        super(application);
        editUserProfileRepository = new EditUserProfileRepository(application);
    }
}
