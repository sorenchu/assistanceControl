package com.example.assistancecontrol;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

import dao.PlayerDao;
import fragment.DatePickerFragment;
import model.Player;
import spinner.CategorySpinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    EditText selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.showSpinner();
        this.showDatePicker();
    }
    }

    private void showSpinner() {
        CategorySpinner categorySpinner = new CategorySpinner(this, R.id.show_category_spinner);
        categorySpinner.getSpinner().setOnItemSelectedListener(this);
    }

    private void showDatePicker() {
        this.selectedDate = (EditText) findViewById(R.id.selectedDate);
        this.selectedDate.setOnClickListener(this);
        this.selectedDate.setText(this.getTodayDate());
    }
    private String getTodayDate() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return this.getDateWithFormat(year, month, day);
    }

    private String getDateWithFormat(int year, int month, int day) {
        return day + "/" + (month+1) + "/" + year;
    }

    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                final String date = getDateWithFormat(year, month, day);
                selectedDate.setText(date);
            }
        });
        newFragment.show(this.getSupportFragmentManager(), "datePicker");
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

    public void onNothingSelected(AdapterView<?> adapter) {}

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.selectedDate:
                showDatePickerDialog();
                break;
        }
    }
}
