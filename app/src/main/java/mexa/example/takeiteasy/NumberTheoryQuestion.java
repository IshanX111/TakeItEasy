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

public class NumberTheoryQuestion extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "The linear combination of gcd(252, 198) = 18 is?",
            " The linear combination of gcd(117, 213) = 3 can be written as _________",
            "The inverse of 7 modulo 26 is",
            " The integer 561 is a Carmichael number.",
            "The inverse of 19 modulo 141 is?",
            "The integer 2821 is a Carmichael number.",
            " The solution of the linear congruence 4x = 5(mod 9) is?",
            "The linear combination of gcd(10, 11) = 1 can be written as _________",
            "The value of 52003 mod 7 is?",
            "The inverse of 3 modulo 7 is?"
    };
    String answers[] = {"252*4 – 198*5  "," 10*213 + (-20)*117","15","True","52","True","8(mod 9)","(-1)*10 + 1*11  ","3","-2"};
    String opt[] = {
            "252*4 – 198*5  ","252*5 – 198*4","252*5 – 198*2","252*4 – 198*4",
            "11*213 + (-20)*117"," 10*213 + (-20)*117"," 11*117 + (-20)*213","20*213 + (-25)*117",
            "12","14","15","20",
            "True","False","None","All of the above",
            "50","51","52","54",
            "True","False","None","All of the above",
            "6(mod 9)","8(mod 9)","9(mod 9)","10(mod 9)",
            "(-1)*10 + 1*11  "," (-2)*10 + 2*11"," (-2)*10 + 2*11","(-1)*10 + 2*11)",
            "8","4","3","9",
            "-1","-2","-3","-4"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_theory_question);
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
                    Intent in = new Intent(getApplicationContext(),ResultActivityNumberTheory.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivityNumberTheory.class);
                startActivity(intent);
            }
        });
    }
}