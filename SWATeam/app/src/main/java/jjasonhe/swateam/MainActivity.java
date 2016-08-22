package jjasonhe.swateam;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvWelcome;
    TextView tvToThe;
    //TextView tvSWATeam;
    EditText etName;
    EditText etCity;
    int cityNum;
    int userExp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface montserratB = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Bold.ttf");
        Typeface montserratR = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Regular.ttf");

        tvWelcome = (TextView) findViewById(R.id.tvWelcome);
        tvToThe = (TextView) findViewById(R.id.tvToThe);
        //tvSWATeam = (TextView) findViewById(R.id.tvSWATeam);
        etName = (EditText) findViewById(R.id.tvName);
        etCity = (EditText) findViewById(R.id.tvCity);

        tvWelcome.setTypeface(montserratB);
        tvToThe.setTypeface(montserratB);
        //tvSWATeam.setTypeface(montserratB);

        cityNum = 0;
        userExp = 0;
    }

    public void onClick(View view) {
        String theName = etName.getText().toString();
        String theCity = etCity.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("etName", theName);
        intent.putExtra("etCity", theCity);
        intent.putExtra("cityNum", cityNum);
        intent.putExtra("userExp", userExp);
        startActivity(intent);
    }
}
