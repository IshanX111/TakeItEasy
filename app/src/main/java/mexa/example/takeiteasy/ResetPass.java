package mexa.example.takeiteasy;

//import androidx.appcompat.app.AppCompatActivity;

//import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPass extends AppCompatActivity {
    EditText send_email;
    Button btn_reset;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_reset_pass);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);

        send_email = findViewById(R.id.send_email);
        btn_reset = findViewById(R.id.btn_reset);

        firebaseAuth = FirebaseAuth.getInstance();

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = send_email.getText().toString();

                if (email.equals("")){
                    Toast.makeText(ResetPass.this, "All fields are required!", Toast.LENGTH_SHORT).show();
                } else {
                    firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(ResetPass.this, "Please check your Email", Toast.LENGTH_SHORT).show();
                                //startActivity(new Intent(MainActivity.this, loginPage.class));
                            } else {
                                String error = task.getException().getMessage();
                                Toast.makeText(ResetPass.this, error, Toast.LENGTH_SHORT).show();
                                openLoginPage();
                            }
                        }
                    });
                }
            }
        });



    }
    public void openLoginPage(){

        Intent intent=new Intent(this,Dashboard.class);
        startActivity(intent);

    }

}