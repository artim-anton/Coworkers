package com.artimanton.coworkers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class AddCoworkerActivity extends AppCompatActivity {
    public static final String EXTRA_NAME =
            "com.artimanton.coworker.EXTRA_NAME";
    public static final String EXTRA_AGE =
            "com.artimanton.coworker.EXTRA_AGE";
    public static final String EXTRA_PHONE =
            "com.artimanton.coworker.EXTRA_PHONE";
    public static final String EXTRA_GENDER =
            "com.artimanton.coworker.EXTRA_GENDER";
    private EditText editTextName;
    private EditText editTextAge;
    private EditText editTextPhone;
    private RadioButton maleRadioButton;
    private RadioButton femaleRadioButton;
    private String gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_coworker);

        editTextName = (EditText) findViewById(R.id.edit_text_name);
        editTextAge = (EditText) findViewById(R.id.edit_text_age);
        editTextPhone = (EditText) findViewById(R.id.edit_text_phone);

        maleRadioButton = (RadioButton)findViewById(R.id.radio_male);
        maleRadioButton.setOnClickListener(radioButtonClickListener);

        femaleRadioButton = (RadioButton)findViewById(R.id.radio_female);
        femaleRadioButton.setOnClickListener(radioButtonClickListener);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_save);
        setTitle(getString(R.string.title_add_activity));
    }

    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton)v;
            switch (rb.getId()) {
                case R.id.radio_male: gender = getString(R.string.male);
                    break;
                case R.id.radio_female: gender = getString(R.string.female);
                    break;
                default:
                    break;
            }
        }
    };

    private void saveNote() {
        String name = editTextName.getText().toString();
        int age = getInteger(String.valueOf(editTextAge.getText()));
        String phone = editTextPhone.getText().toString();
        if (name.trim().isEmpty() || age == 0 || phone.trim().isEmpty())  {
            Toast.makeText(this, R.string.toast_empty_edit, Toast.LENGTH_SHORT).show();
            return;
        }
        if (gender == null)  {
            Toast.makeText(this, R.string.toast_null_gender, Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_NAME, name);
        data.putExtra(EXTRA_AGE, age);
        data.putExtra(EXTRA_PHONE, phone);
        data.putExtra(EXTRA_GENDER, gender);
        setResult(RESULT_OK, data);
        finish();
    }

    public int getInteger(String no) {
        if (!no.equals("")) {
            return Integer.parseInt(no);
        } else {
            return 0;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_coworker_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}