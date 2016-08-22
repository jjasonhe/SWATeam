package jjasonhe.swateam;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tvWelcome;
    TextView tvName;
    TextView tvCity;
    int fragNum;

    String theName;
    String theCity;
    int cityNum;
    int userExp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Typeface montserratB = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Bold.ttf");
        Typeface montserratR = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Regular.ttf");

        tvWelcome = (TextView) findViewById(R.id.tvWelcome);
        tvName = (TextView) findViewById(R.id.tvName);
        tvCity = (TextView) findViewById(R.id.tvCity);

        tvWelcome.setTypeface(montserratB);
        tvName.setTypeface(montserratR);
        tvCity.setTypeface(montserratR);

        Intent intent = getIntent();
        theName = intent.getStringExtra("etName");
        theCity = intent.getStringExtra("etCity");
        cityNum = intent.getIntExtra("cityNum", 0);
        userExp = intent.getIntExtra("userExp", 0);

        tvName.setText(theName);
        tvCity.setText("from " + theCity);
    }

    public void clickMozzie(View view) {
        fragNum = 0;
        Intent intent = new Intent(this, ZonesActivity.class);
        intent.putExtra("fragNum", fragNum);
        intent.putExtra("etName", theName);
        intent.putExtra("etCity", theCity);
        intent.putExtra("cityNum", cityNum);
        intent.putExtra("userExp", userExp);
        startActivity(intent);
    }

    public void clickTrap(View view) {
        fragNum = 1;
        Intent intent = new Intent(this, TrapsActivity.class);
        intent.putExtra("fragNum", fragNum);
        intent.putExtra("etName", theName);
        intent.putExtra("etCity", theCity);
        intent.putExtra("cityNum", cityNum);
        intent.putExtra("userExp", userExp);
        startActivity(intent);
    }

    public void clickPrevent(View view) {
        fragNum = 2;
        Intent intent = new Intent(this, PreventionActivity.class);
        intent.putExtra("fragNum", fragNum);
        intent.putExtra("etName", theName);
        intent.putExtra("etCity", theCity);
        intent.putExtra("cityNum", cityNum);
        intent.putExtra("userExp", userExp);
        startActivity(intent);
    }

    public void clickReport(View view) {
        Intent intent = new Intent(this, ReportActivity.class);
        intent.putExtra("etName", theName);
        intent.putExtra("etCity", theCity);
        intent.putExtra("cityNum", cityNum);
        intent.putExtra("userExp", userExp);
        startActivity(intent);
    }

    public void clickProf(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("etName", theName);
        intent.putExtra("etCity", theCity);
        intent.putExtra("cityNum", cityNum);
        intent.putExtra("userExp", userExp);
        startActivity(intent);
    }
}
