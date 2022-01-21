package mexa.example.takeiteasy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class HomePage extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    RelativeLayout courses1;
    RelativeLayout quizpage;
    RelativeLayout reminder;
    RelativeLayout ranking;
    RelativeLayout bangla;
    RelativeLayout comment;
    DrawerLayout drawerLayout ;
    NavigationView navigationView;
    Menu menu;
    Toolbar toolbar;
    String Chatname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Chatname=getIntent().getExtras().getString("ChatName");

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);




        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        courses1=findViewById(R.id.courses1);
        courses1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCoursePage();
            }
        });
        comment=findViewById(R.id.comment);
        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCommentPage();
            }
        });




        bangla=findViewById(R.id.bangla);
       bangla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBanglaVideoPage();
            }
        });

        quizpage=findViewById(R.id.quizpage);
        quizpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizsection();
            }
        });
        reminder=findViewById(R.id.reminder);
        reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openReminderPage();
            }
        });

        ranking=findViewById(R.id.ranking);
        ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRankingPage();
            }
        });

    }
    public void openReminderPage(){
        Intent intent=new Intent(this,DashBoardActivity.class);
        startActivity(intent);
    }
    public void openCommentPage(){
        Intent intent=new Intent(this,CommentSectionPage.class);
        intent.putExtra("ChatName", Chatname);
        startActivity(intent);
    }

    public void openBanglaVideoPage(){
        Intent intent=new Intent(this,BanglaVideo.class);
        startActivity(intent);
    }
    public void openRankingPage(){
        Intent intent=new Intent(this,RankingPage.class);
        startActivity(intent);
    }
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }
    public void openCoursePage(){
        Intent intent=new Intent(this,CoursePage.class);
        startActivity(intent);
    }
    public void openQuizsection(){
        Intent intent=new Intent(this,QuizSection.class);
        startActivity(intent);
    }
    public  void exitapp(){
        //moveTaskToBack(true);
        // android.os.Process.killProcess(android.os.Process.myPid());
        // System.exit(1);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Confirm exit!");
        alertDialogBuilder.setIcon(R.drawable.exit_24);
        alertDialogBuilder.setMessage("Are you sure you want to exit?");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();

            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(HomePage.this,"You clicked on cancel",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    public void openshare(){
        try{
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT,"share demo");
            String shareMessage = "https://play.google.com/store/apps/details?="+BuildConfig.APPLICATION_ID+"\n\n";
            intent.putExtra(Intent.EXTRA_TEXT,shareMessage);
            startActivity(Intent.createChooser(intent,"share by"));
        }catch (Exception e){

            Toast.makeText(HomePage.this, "Error occured", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_home: break;
            case R.id.nav_quiz:
                Intent intent = new Intent(HomePage.this,QuizSection.class);
                startActivity(intent);
                break;

            case R.id.nav_learn:
                Intent intent1 = new Intent(HomePage.this,CoursePage.class);
                startActivity(intent1);
                break;
            case R.id.nav_reminder:
                Intent intent2 = new Intent(HomePage.this,DashBoardActivity.class);
                startActivity(intent2);
                break;

            case R.id.nav_logout:Intent intent3 = new Intent(HomePage.this,Dashboard.class);
                startActivity(intent3);
                break;
            case R.id.nav_ranking:Intent intent4 = new Intent(HomePage.this,RankingPage.class);
                startActivity(intent4);
                break;
            case R.id.nav_banglavideo:Intent intent5 = new Intent(HomePage.this,BanglaVideo.class);
                startActivity(intent5);
                break;
            case R.id.nav_comment:Intent intent6 = new Intent(HomePage.this,CommentSectionPage.class);
                startActivity(intent6);
                break;


            case R.id.nav_share: openshare();  break;
            case  R.id.nav_exit: exitapp();  break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);return true;
    }
}