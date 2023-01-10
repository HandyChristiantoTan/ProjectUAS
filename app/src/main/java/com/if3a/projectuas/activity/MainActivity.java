package com.if3a.projectuas.activity;

import static com.if3a.projectuas.R.id.menu_about;
import static com.if3a.projectuas.R.menu.menu_atas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.if3a.projectuas.R;
import com.if3a.projectuas.fragment.NarutoFragment;
import com.if3a.projectuas.fragment.OnePieceFragment;
import com.if3a.projectuas.fragment.SaoFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bnvAniquo;
    private ActionBar judulBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        judulBar = getSupportActionBar();
        bukaFragment(new NarutoFragment());
        judulBar.setTitle("Aniquo");

        bnvAniquo = findViewById(R.id.bnv_aniquo);
        bnvAniquo.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment FR;

                switch (item.getItemId()){
                    case R.id.menu_naruto:
                        bukaFragment(new NarutoFragment());
                        judulBar.setTitle("Naruto Quote");
                        return true;
                    case R.id.menu_onepiece:
                        bukaFragment(new OnePieceFragment());
                        judulBar.setTitle("One Piece Quote");
                        return true;
                    case R.id.menu_sao:
                        bukaFragment(new SaoFragment());
                        judulBar.setTitle("SAO Quote");
                        return true;
                }
                return false;
            }
        });
    }

    private void bukaFragment(Fragment FRG){
        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        FT.replace(R.id.fl_container, FRG);
        FT.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(menu_atas, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == menu_about){
            startActivity(new Intent(MainActivity.this,AboutActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}