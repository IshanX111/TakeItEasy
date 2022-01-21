package mexa.example.takeiteasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

public class AlgorithmBasic extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout ;
    NavigationView navigationView;
    Menu menu;
    Toolbar toolbar;

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm_basic);
        listview=findViewById(R.id.listview);
        String[] values = new String[]{
                "Big O Notation","Complexity Class","Halting problem","Binary Search","Floyd cycle finding algorithm"
        };
        ArrayAdapter<String> adapter  = new ArrayAdapter(this, android.R.layout.simple_list_item_2,android.R.id.text2,values);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent=new Intent(view.getContext(),BigONotation.class);
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent=new Intent(view.getContext(),ComplexityClass.class);
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent=new Intent(view.getContext(),HaltingProblem.class);
                    startActivity(intent);
                }
                if(position==3){
                    Intent intent=new Intent(view.getContext(),BinarySearch.class);
                    startActivity(intent);
                }
                if(position==4){
                    Intent intent=new Intent(view.getContext(),FloydCycle.class);
                    startActivity(intent);
                }
            }
        });


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

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        return true;
    }
}