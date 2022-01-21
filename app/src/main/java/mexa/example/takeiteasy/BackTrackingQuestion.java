package mexa.example.takeiteasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BackTrackingQuestion extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "Which of the problems cannot be solved by backtracking method?",
            " Backtracking algorithm is implemented by constructing a tree of choices called as?",
            "What happens when the backtracking algorithm reaches a complete solution?",
            "In general, backtracking can be used to solve?",
            "Which one of the following is an application of the backtracking algorithm?",
            "Which of the following logical programming languages is not based on backtracking?",
            "The problem of finding a list of integers in a given specific range that meets certain conditions is called?",
            "Who coined the term ‘backtracking’?",
            "The problem of finding a subset of positive integers whose sum is equal to a given positive integer is called as?",
            "The problem of placing n queens in a chessboard such that no two queens attack each other is called as?"
    };
    String answers[] = {"travelling salesman problem","State-space tree"," It continues searching for other possible solutions","Combinatorial problems","Crossword","Fortran","Constraint satisfaction problem","Lehmer","subset sum problem","n-queen problem"};
    String opt[] = {
            "n-queen problem","subset sum problem"," hamiltonian circuit problem","travelling salesman problem",
            "State-space tree","State-chart tree","Node tree","Backtracking tree",
            " It backtracks to the root","It continues searching for other possible solutions","It traverses from a different route"," Recursively traverses through the same route",
            "Numerical problems","Exhaustive search","Combinatorial problems","Graph coloring problems",
            "Finding the shortest path","Finding the efficient quantity to shop","Ludo","Crossword",
            "Icon","Prolog","Fortran","Planner",
            "Subset sum problem","Constraint satisfaction problem","Hamiltonian circuit problem"," Travelling salesman problem",
            "Lehmer","Donald"," Ross","Ford",
            "n- queen problem","subset sum problem"," knapsack problem","hamiltonian circuit problem",
            "n-queen problem"," eight queens puzzle"," four queens puzzle","1-queen problem"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_tracking_question);
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
                    Intent in = new Intent(getApplicationContext(),ResultActivityBack.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivityBack.class);
                startActivity(intent);
            }
        });
    }
}