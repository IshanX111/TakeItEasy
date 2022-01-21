package mexa.example.takeiteasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class RankingPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout ;
    NavigationView navigationView;
    Menu menu;
    Toolbar toolbar;
    LinearLayout item1;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_page);
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
        listview=findViewById(R.id.listview);
        String[] values = new String[]{
                "Algorithm Basic","Data Structure","Graph Theory","BackTracking","Number Theory"
        };
        ArrayAdapter<String> adapter  = new ArrayAdapter(this, android.R.layout.simple_list_item_1,android.R.id.text1,values);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent=new Intent(view.getContext(),AlgorithmWeb.class);
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent=new Intent(view.getContext(),DataStructureWeb.class);
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent=new Intent(view.getContext(),GraphTheoryWeb.class);
                    startActivity(intent);
                }
                if(position==3){
                    Intent intent=new Intent(view.getContext(),BackTrackingWeb.class);
                    startActivity(intent);
                }
                if(position==4){
                    Intent intent=new Intent(view.getContext(),NumberTheoryWeb.class);
                    startActivity(intent);
                }

            }
        });

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
                Toast.makeText(RankingPage.this,"You clicked on cancel",Toast.LENGTH_LONG).show();
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

            Toast.makeText(RankingPage.this, "Error occured", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_home: Intent intent7 = new Intent(RankingPage.this,HomePage.class);
                startActivity(intent7);
                break;
            case R.id.nav_quiz:
                Intent intent = new Intent(RankingPage.this,QuizSection.class);
                startActivity(intent);
                break;

            case R.id.nav_learn:
                Intent intent1 = new Intent(RankingPage.this,CoursePage.class);
                startActivity(intent1);
                break;

            case R.id.nav_reminder:
                Intent intent2 = new Intent(RankingPage.this,DashBoardActivity.class);
                startActivity(intent2);
                break;

            case R.id.nav_logout:Intent intent3 = new Intent(RankingPage.this,Dashboard.class);
                startActivity(intent3);
                break;
            case R.id.nav_ranking:
                break;
            case R.id.nav_banglavideo:Intent intent5 = new Intent(RankingPage.this,BanglaVideo.class);
                startActivity(intent5);
                break;
            case R.id.nav_comment:Intent intent6 = new Intent(RankingPage.this,CommentSectionPage.class);
                startActivity(intent6);
                break;


            case R.id.nav_share: openshare();  break;
            case  R.id.nav_exit: exitapp();  break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);return true;
    }
}