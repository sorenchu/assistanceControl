package com.example.assistancecontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import dao.PlayerDao;
import model.Player;
import spinner.CategorySpinner;

import static model.Category.*;

public class AddPlayerActivity extends AppCompatActivity {

    private CategorySpinner categorySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
        this.showSpinner();
    }

    public void savePlayer(View view) {
        Intent intent = new Intent(this, AddPlayerActivity.class);
        Player player = this.generatePlayer();
        PlayerDao.addPlayerToCategory(player);
        startActivity(intent);
        finish();
    }

    private void showSpinner() {
        this.categorySpinner = new CategorySpinner(this, R.id.select_category_spinner);
    }

    // TODO: should this be here?
    private Player generatePlayer() {
        EditText editText = (EditText) findViewById(R.id.editText3);
        String name = editText.getText().toString();
        editText = (EditText) findViewById(R.id.editText4);
        String surname = editText.getText().toString();
        String category = this.categorySpinner.getSpinner().getSelectedItem().toString();
        switch (category) {
            case "Sub18":
                return new Player(name, surname, U18);
            case "Sub16":
                return new Player(name, surname, U16);
            default:
                return null;
        }
    }
}
