package com.example.assistancecontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import dao.PlayerDao;
import model.Player;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_MESSAGE = "com.example.assistancecontrol.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.showSpinner();
    }

    public void showSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.category_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.category_array,
                android.R.layout.simple_spinner_dropdown_item
        );
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> categoryAdapter, View view, int position, long id) {
        String category = (String) categoryAdapter.getItemAtPosition(position);
        System.out.println("category" + category);
        ArrayList<Player> players = PlayerDao.getPlayerByCategory(category);
        ListView listview = (ListView) findViewById(R.id.nameslistview);
        ArrayList<String> names = new ArrayList<>();
        if (players == null) {
            System.out.println("Category different from u18");
            names.add("Categoría diferente de sub18");
        } else {
            for (Player player : players) {
                System.out.println(player.getSurnameAndName());
                names.add(player.getSurnameAndName());
            }
        }
        ArrayAdapter<String> namesAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                names
        );
        listview.setAdapter(namesAdapter);
    }

    public void onNothingSelected(AdapterView<?> adapter) {

    }
}
