package com.example.assistancecontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import dao.PlayerDao;
import model.Player;
import spinner.CategorySpinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.showSpinner();
    }

    private void showSpinner() {
        CategorySpinner categorySpinner = new CategorySpinner(this, R.id.show_category_spinner);
        categorySpinner.getSpinner().setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> categoryAdapter, View view, int position, long id) {
        String category = (String) categoryAdapter.getItemAtPosition(position);
        ArrayList<Player> players = PlayerDao.getPlayerByCategory(category);
        ListView listview = (ListView) findViewById(R.id.nameslistview);
        ArrayList<String> names = new ArrayList<>();
        if (players == null) {
            names.add("Añade algún jugador a esta categoría");
        } else {
            for (Player player : players) {
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

    public void createNewPlayer(View view) {
        Intent intent = new Intent(this, AddPlayerActivity.class);
        startActivity(intent);
    }
}
