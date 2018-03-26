package com.example.karol.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] shoppingList = {"chleb", "mleko", "masło", "woda", "pozycjometr", "makaron", "jajka", "wędlina", "papryka", "herbata", "mandarynki", "monitor", "gazeta", "subskrypcja artdroidowo.pl" };
        RecyclerView list = findViewById(R.id.my_list_rv);
        list.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(shoppingList);
        list.setAdapter(adapter);
    }
}
