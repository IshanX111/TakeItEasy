package mexa.example.takeiteasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CommentPage extends AppCompatActivity {

    private DatabaseReference myDatabase1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_page);

        myDatabase1 = FirebaseDatabase.getInstance().getReference("Message");
        final TextView myText=findViewById(R.id.text1);
        myDatabase1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
                String[] Messages =snapshot.getValue().toString().split(",");
                myText.setText("");
                for(int i=0;i<Messages.length;i++){
                    String[] finalMsg=Messages[i].split("=");
                    myText.append(finalMsg[1]+"\n\n");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                myText.setText("Cancelled");
            }
        });

    }
    public void sendMessage(View view){
        EditText myEditText=findViewById(R.id.editText);
        myDatabase1.child(Long.toString(System.currentTimeMillis())).setValue(myEditText.getText().toString());
        myEditText.setText("");
    }


}