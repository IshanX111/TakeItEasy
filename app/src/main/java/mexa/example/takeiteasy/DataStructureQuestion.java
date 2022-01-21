package mexa.example.takeiteasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DataStructureQuestion extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "Which of these is not an application of a linked list?",
            " What is the time complexity of inserting at the end in dynamic arrays?",
            " Process of removing an element from stack is called __________",
            "Entries in a stack are “ordered”. What is the meaning of this statement?",
            "Queues serve major role in ______________",
            "A data structure in which elements can be inserted or deleted at/from both ends but not in the middle is?",
            "What is the maximum number of children that a binary tree node can have?",
            " Which of the following is not a disadvantage to the usage of array?",
            "What is the space complexity for deleting a linked list?",
            "Circular Queue is also known as ________"
    };
    String answers[] = {"Random Access of elements","Either O(1) or O(n)","pop","There is a Sequential entry that is one by one","Simulation of limited resource allocation","Dequeue","2","Accessing elements at specified positions","O(1)","Curve Buffer"};
    String opt[] = {
            "To implement file systems ","For separate chaining in hash-tables"," To implement non-binary trees","Random Access of elements ",
            "O(1)","O(n)","O(nlogn)","Either O(1) or O(n)",
            "Create","Pop","Push","Evaluation",
            "A collection of stacks is sortable","Stack entries may be compared with the ‘<‘ operation","There is a Sequential entry that is one by one","The entries are stored in a linked list",
            "Simulation of recursion","Simulation of arbitrary linked list","Simulation of limited resource allocation","Simulation of heap sort",
            "Queue","Dequeue"," Circular queue","Priority queue",
            "2","1","3","Infinite",
            "Fixed size","There are chances of wastage of memory space if elements inserted in an array are lesser than the allocated size","Insertion based on position","Accessing elements at specified positions",
            "O(1)","O(n)","O(nlogn)","Either O(1) or O(n)",
            " Ring Buffer","Square Buffer","Rectangle Buffer","Curve Buffer"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_structure_question);
        final TextView score = (TextView)findViewById(R.id.textView4);
        //TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        //String name= intent.getStringExtra("myname");

        // if (name.trim().equals(""))
        //textView.setText("Hello User");
        //else
        //textView.setText("Hello " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }
}