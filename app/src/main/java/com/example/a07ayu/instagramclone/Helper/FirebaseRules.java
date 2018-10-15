package com.example.a07ayu.instagramclone.Helper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.a07ayu.instagramclone.Model.GetInfo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseRules {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    Context context;
    String userID;

    public FirebaseRules(Context mcontext) {
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        context = mcontext;
        if (mAuth.getCurrentUser() != null) {
            userID = mAuth.getCurrentUser().getUid();
        }
    }

    public void registerUserEmail(final String email, final String username, final String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(context, "Email and password",Toast.LENGTH_LONG).show();
                } else {
                    userID = mAuth.getCurrentUser().getUid();
                    Toast.makeText(context, "Successful",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public boolean checkExistsUser(String username, DataSnapshot dataSnapshot){
        GetInfo getInfo = new GetInfo();
        for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
            getInfo.setUsername(dataSnapshot1.getValue(GetInfo.class).getUsername());
            if(getInfo.getUsername().equals(username)){
                username.replace(" ",".");
            }else{
                username.replace("."," ");
            }

        }
        return false;
    }


}
