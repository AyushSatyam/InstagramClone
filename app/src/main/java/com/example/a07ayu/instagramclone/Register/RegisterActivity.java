package com.example.a07ayu.instagramclone.Register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a07ayu.instagramclone.Helper.FirebaseRules;
import com.example.a07ayu.instagramclone.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {
    public FirebaseAuth mAuth;
    public FirebaseAuth.AuthStateListener mAuthListener;
    public static final String TAG = "RegisterActivity";
    Context context = RegisterActivity.this;
    TextInputEditText email,password,name;
    TextView loading;
    Button btRegister;
    ProgressBar progressBar;
    FirebaseRules firebaseRules;
    String stremail,strpassword,strname;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String append;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // setupNavigationIcon();
        //setUpViewPager();
        firebaseRules = new FirebaseRules(RegisterActivity.this);
        Field();
        setupFirebaseAuth();
        init();
    }

    private void Field(){
        email = (TextInputEditText) findViewById(R.id.input_email);
        password = (TextInputEditText) findViewById(R.id.input_password);
        name = (TextInputEditText) findViewById(R.id.input_name);
        btRegister =(Button) findViewById(R.id.btn_register);
        progressBar = (ProgressBar) findViewById(R.id.register_ProgressBar);
        loading  = (TextView) findViewById(R.id.register_Text);

    }

    private void init(){
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stremail = email.getText().toString();
                strpassword = password.getText().toString();
                strname = name.getText().toString();

                if (checkInput(stremail,strname,strpassword)){
                    progressBar.setVisibility(View.VISIBLE);
                    loading.setVisibility(View.VISIBLE);
                    firebaseRules.registerUserEmail(stremail,strname,strpassword);
                }

            }
        });
    }

    private boolean checkInput(String stremail, String strname, String strpassword) {
        if (stremail.equals("")||strpassword.equals("")||strname.equals("")){
            Toast.makeText(context,"Check Fields",Toast.LENGTH_SHORT);
            return false;
        }else{
            return true;
        }
    }
    private void checkUser(FirebaseUser user){
        if (user==null)
        {
            startActivity(new Intent(context, LogInActivity.class));
        }
    }
    private void setupFirebaseAuth(){
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                checkUser(user);
                if(user!=null){
                    Log.d(TAG, "onAuthStateChanged: sign_in"+user.getUid());
                    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (firebaseRules.checkExistsUser(strname,dataSnapshot)){
                                append = databaseReference.getKey();
                            }
                            strname = strname + append;
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }else {
                    Log.d(TAG, "onAuthStateChanged: sign_out");
                }
            }
        };
    }
}

