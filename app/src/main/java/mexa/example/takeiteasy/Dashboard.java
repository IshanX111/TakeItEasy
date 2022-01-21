package mexa.example.takeiteasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Dashboard extends AppCompatActivity {
    private Button signUpButton;
    private Button login;
    TextInputLayout username,password;
    Button login_btn;
    String chatName;
    TextView passReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        //regEmail=findViewById(R.id.reg_Email);
        //regPhoneNo=findViewById(R.id.reg_PhoneNo);
        //regPassword=findViewById(R.id.reg_Password);
        //going to signupPage
        signUpButton=(Button) findViewById(R.id.signUp);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });
        //for login nobonee afroza
        /*login=(Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openHomePage();
            }
        });*/
        passReset=findViewById(R.id.forget);
        passReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openResetPage();
            }
        });


        login_btn=findViewById(R.id.login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               openHomePage();
                //loginUser(view);
            }
        });
    }
    public void openResetPage(){
        Intent intent=new Intent(this,ResetPass.class);
        startActivity(intent);
    }
    private Boolean validateUsername(){
        String val=username.getEditText().getText().toString();
        if(val.isEmpty()){
            username.setError("Field can not be empty");
            return false;
        }
        else{
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword(){
        String val=password.getEditText().getText().toString();
        if(val.isEmpty()){
            password.setError("Field can not be empty");
            return false;
        }
        else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }
    public void loginUser(View view){
        if(!validateUsername() | !validatePassword()){
            return;
        }
        else{
            isUser();
        }
    }

    public void isUser() {

        String userEnteredUsername=username.getEditText().getText().toString().trim();
        String userEnteredPassword=password.getEditText().getText().toString().trim();
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");
        Query checkUser=reference.orderByChild("username").equalTo(userEnteredUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    username.setError(null);
                    username.setErrorEnabled(false);
                    String passwordFromDB=dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);
                    if(passwordFromDB.equals(userEnteredPassword)){
                        username.setError(null);
                        username.setErrorEnabled(false);

                        String nameFromDB=dataSnapshot.child(userEnteredUsername).child("name").getValue(String.class);
                        String usernameFromDB=dataSnapshot.child(userEnteredUsername).child("username").getValue(String.class);
                        String phoneNoFromDB=dataSnapshot.child(userEnteredUsername).child("phoneNo").getValue(String.class);
                        String emailFromDB=dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);

                        Intent intent=new Intent(getApplicationContext(),HomePage.class);
                        intent.putExtra("name",nameFromDB);
                        intent.putExtra("username",usernameFromDB);
                        intent.putExtra("email",emailFromDB);
                        intent.putExtra("phoneNo",phoneNoFromDB);
                        intent.putExtra("password",passwordFromDB);
                        chatName=username.getEditText().getText().toString();
                        System.out.println(chatName);
                        //Intent intent=new Intent(this,HomePage.class);
                        intent.putExtra("ChatName",chatName);
                        startActivity(intent);

                        //startActivity(intent);
                    }
                    else{
                        password.setError("Wrong Password");
                        password.requestFocus();
                    }

                }
                else{
                    username.setError("No such User Exist");
                    username.requestFocus();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public void openActivity2(){
        Intent intent=new Intent(this,Signup.class);
        startActivity(intent);
    }
    public void openHomePage(){
        chatName=username.getEditText().getText().toString();
        System.out.println(chatName);
        Intent intent=new Intent(this,HomePage.class);
        intent.putExtra("ChatName",chatName);
        startActivity(intent);
    }

}