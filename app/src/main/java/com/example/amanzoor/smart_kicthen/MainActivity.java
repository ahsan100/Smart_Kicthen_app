package com.example.amanzoor.smart_kicthen;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public String IP, GROUPID, MEMBERID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        IP = getIntent().getStringExtra("IP");
        GROUPID = getIntent().getStringExtra("groupid");
        MEMBERID = getIntent().getStringExtra("memberid");
        System.out.println("AHSANING" + IP + GROUPID + MEMBERID);
        Intent intent = new Intent(getBaseContext(), LocationService.class);
        intent.putExtra("IP", IP);
        intent.putExtra("memberid", MEMBERID);
        intent.putExtra("groupid", GROUPID);
        startService(intent);
        Intent intent1 = new Intent(getBaseContext(), NotificationService.class);
        intent1.putExtra("IP", IP);
        intent1.putExtra("memberid", MEMBERID);
        intent1.putExtra("groupid", GROUPID);
        //startService(intent1);
        Intent intent2 = new Intent(getBaseContext(), NotificationService_NoBtn.class);
        intent2.putExtra("IP", IP);
        intent2.putExtra("memberid", MEMBERID);
        intent2.putExtra("groupid", GROUPID);
        startService(intent2);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            // Handle the camera action
        }
        else if (id == R.id.members) {
            Intent intent = new Intent(getBaseContext(), member.class);
            intent.putExtra("IP", IP);
            intent.putExtra("memberid", MEMBERID);
            intent.putExtra("groupid", GROUPID);
            startActivity(intent);
        }
        else if (id == R.id.groups) {
            Intent intent = new Intent(getBaseContext(), group.class);
            intent.putExtra("IP", IP);
            intent.putExtra("memberid", MEMBERID);
            intent.putExtra("groupid", GROUPID);
            startActivity(intent);

        }
        else if (id == R.id.inventory) {
            Intent intent = new Intent(getBaseContext(), inventory.class);
            intent.putExtra("IP", IP);
            intent.putExtra("memberid", MEMBERID);
            intent.putExtra("groupid", GROUPID);
            startActivity(intent);
        }
        else if (id == R.id.recipe) {
            Intent intent = new Intent(getBaseContext(), recipe.class);
            intent.putExtra("IP", IP);
            intent.putExtra("memberid", MEMBERID);
            intent.putExtra("groupid", GROUPID);
            startActivity(intent);
        } else if (id == R.id.list_product) {
            Intent intent = new Intent(getBaseContext(), list_product.class);
            intent.putExtra("IP", IP);
            intent.putExtra("memberid", MEMBERID);
            intent.putExtra("groupid", GROUPID);
            startActivity(intent);
        }else if (id == R.id.logout) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
