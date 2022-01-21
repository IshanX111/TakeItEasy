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

public class AlgorithmBasicQuestion extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "Problems that cannot be solved by any algorithm are called?",
            "Find the slowest time.?",
            "Halting problem is an example for?",
            "Which of the following problems is not NP complete?",
            "The choice of polynomial class has led to the development of an extensive theory called ________",
            "\n" +
                    "What does the following piece of code do?\n" +
                    "\n" +
                    "public void func(Tree root)\n" +
                    "{\n" +
                    "\tfunc(root.left());\n" +
                    "\tfunc(root.right());\n" +
                    "\tSystem.out.println(root.data());\n" +
                    "}",
            "\n" +
                    "What is the speciality about the inorder traversal of a binary search tree?",
            "Floyd Warshall’s Algorithm can be applied on __________",
            "What approach is being followed in Floyd Warshall Algorithm?",
            "Indicate constant time complexity in terms of Big-O notation"
    };
    String answers[] = {"undecidable problems","O(n!)","undecidable problem","Halting problem","computational complexity","Postorder traversal"," It traverses in an increasing order","Directed graphs","Dynamic Programming","O(1)"};
    String opt[] = {
            " tractable problems","intractable problems","undecidable problems","decidable problems",
            "O(n)","O(n^2)","O(2^n)","O(n!)",
            "decidable problem","undecidable problem","complete problem","trackable problem",
            "Hamiltonian circuit","Bin packing","Halting problem","Partition problem",
            "computational complexity","time complexity","problem complexity","decision complexity",
            "Preorder traversal","Inorder traversal","Postorder traversal","Level order traversal",
            "It traverses in a non increasing order"," It traverses in an increasing order","It traverses in a random fashionIt traverses in a random fashion","It traverses based on priority of the node",
            " Undirected and unweighted graphs","Undirected graphs","Directed graphs","Acyclic graphs",
            " Greedy technique","Dynamic Programming","Linear Programming","Backtracking",
            " O(1)","O(logn) ","O(n^2) ","O(n)"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm_basic_question);
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
                    Intent in = new Intent(getApplicationContext(),ResultActivityAlgo.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivityAlgo.class);
                startActivity(intent);
            }
        });
    }
}