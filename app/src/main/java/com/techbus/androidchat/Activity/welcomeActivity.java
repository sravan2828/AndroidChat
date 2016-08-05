package com.techbus.androidchat.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.techbus.androidchat.R;

public class welcomeActivity extends Activity {

    private Button btnJoin;
    private EditText txtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnJoin = (Button) findViewById(R.id.btnJoin);
        txtName = (EditText) findViewById(R.id.name);
        SharedPreferences prefs = getApplication().getSharedPreferences("ChatPrefs", 0);
        String mUsername = prefs.getString("username", null);
        if(mUsername!=null)
        {
            Intent intent = new Intent(welcomeActivity.this, MainActivity.class);
            intent.putExtra("name", mUsername);
            startActivity(intent);
        }


        btnJoin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (txtName.getText().toString().trim().length() > 0) {

                    String name = txtName.getText().toString().trim();

                    Intent intent = new Intent(welcomeActivity.this,
                            MainActivity.class);
                    intent.putExtra("name", name);

                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your name", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
