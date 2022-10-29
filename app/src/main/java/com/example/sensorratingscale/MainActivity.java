package com.example.sensorratingscale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sensorratingscale.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    DrawerLayout drawerLayout;
    NavigationView navigationview;
    Toolbar toolbar;
    private Button button;

    TextView text;
    ImageView image;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerLayout = navigationView.getHeaderView(0);

        text = headerLayout.findViewById(R.id.nav_text);
        image = headerLayout.findViewById(R.id.nav_image);

        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null) {
            FirebaseUser user = mAuth.getCurrentUser();
            updateUI(user);
        }

       // binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(binding.getRoot());

        //setSupportActionBar(binding.appBarMain.toolbar);

       // DrawerLayout drawer = binding.drawerLayout;
        //NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            String name = user.getDisplayName();
            String email = user.getEmail();
            text.append(name + "\n");
            text.append(email);

        }
    }
    public void onClick(View view)
    {
        Toast.makeText(getApplicationContext(),"Thank you for choosing us!",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this,StarActivity.class);
        startActivity(intent);

    }

    public void onClick2(View view)
    {
        Toast.makeText(getApplicationContext(),"Thank you for choosing us!",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this,EmojiActivity.class);
        startActivity(intent);

    }

    public void onClick3(View view)
    {
        Toast.makeText(getApplicationContext(),"Thank you for choosing us!",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this,DescriptiveActivity.class);
        startActivity(intent);

    }
}