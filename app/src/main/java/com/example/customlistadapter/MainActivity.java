package com.example.customlistadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listViewId);


        Person jhon = new Person("Jhon","12-20-1998","01819690506","drawable://" + R.drawable.gg);
        Person robi = new Person("robi","12-20-1998","01819690506","drawable://" + R.drawable.d);
        Person chobi = new Person("chobi","12-20-1998","01819690506","drawable://" + R.drawable.ggravity);
        Person mobi = new Person("mobi","12-20-1998","01819690506","drawable://" + R.drawable.gg);
        Person lobi = new Person("lobi","12-20-1998","01819690506","drawable://" + R.drawable.ggravity);
        Person gobi = new Person("gobi","12-20-1998","01819690506","drawable://" + R.drawable.d);
        Person mon = new Person("mon","12-20-1998","01819690506","drawable://" + R.drawable.ggravity);
        Person kon = new Person("kon","12-20-1998","01819690506","drawable://" + R.drawable.gg);
        Person chon = new Person("chon","12-20-1998","01819690506","drawable://" + R.drawable.d);
        Person bon = new Person("bon","12-20-1998","01819690506","drawable://" + R.drawable.gg);
        Person omon = new Person("omon","12-20-1998","01819690506","drawable://" + R.drawable.ggravity);
        Person lon = new Person("lon","12-20-1998","01819690506","drawable://" + R.drawable.d);
        Person chons = new Person("chons","12-20-1998","01819690506","drawable://" + R.drawable.ggravity);

        //going to make an arraylist and arraylist hold the person object
        ArrayList<Person> peopleList = new ArrayList<>(); // Making an Arraylist
        peopleList.add(jhon);
        peopleList.add(robi);
        peopleList.add(chobi);
        peopleList.add(mobi);
        peopleList.add(lobi);
        peopleList.add(gobi);
        peopleList.add(mon);
        peopleList.add(kon);
        peopleList.add(chon);
        peopleList.add(bon);
        peopleList.add(omon);
        peopleList.add(lon);
        peopleList.add(chons);

        //we need to create our person list adapter

//        ArrayAdapter adapter = new ArrayAdapter(); // this is regular adapter, in param it will take context
        PersonListAdapter adapter = new PersonListAdapter(this,R.layout.custom_view_layout, peopleList);
        listView.setAdapter(adapter);


    }
}