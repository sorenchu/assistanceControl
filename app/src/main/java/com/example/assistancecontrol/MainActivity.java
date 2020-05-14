package com.example.assistancecontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void onItemSelected(AdapterView<?> adapter, View view, int position, long id) {
        String category = (String) adapter.getItemAtPosition(position);
        System.out.println("category" + category);
        ArrayList<Player> players = PlayerDao.getPlayerByCategory(category);
        if (players == null) {
            System.out.println("Category different from u18");
        } else {
            for (Player player : players) {
                System.out.println(player.getSurnameAndName());
            }
        }
    }

    public void onNothingSelected(AdapterView<?> adapter) {

    }
}
