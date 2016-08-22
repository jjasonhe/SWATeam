package jjasonhe.swateam;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {
    TextView tvName;
    TextView tvCity;
    ImageView ivExp;
    TextView tvLvl;
    TextView tvMenu;

    String theName;
    String theCity;
    int cityNum;
    int userExp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Typeface montserratB = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Bold.ttf");
        Typeface montserratR = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Regular.ttf");

        tvName = (TextView) findViewById(R.id.tvName);
        tvCity = (TextView) findViewById(R.id.tvCity);
        tvName.setTypeface(montserratB);
        tvCity.setTypeface(montserratB);
        tvLvl = (TextView) findViewById(R.id.tvLvl);
        tvLvl.setTypeface(montserratR);
        tvMenu = (TextView) findViewById(R.id.tvMenu);
        tvMenu.setTypeface(montserratR);

        ivExp = (ImageView) findViewById(R.id.ivExp);

        Intent intent = getIntent();
        theName = intent.getStringExtra("etName");
        theCity = intent.getStringExtra("etCity");
        cityNum = intent.getIntExtra("cityNum", 0);
        userExp = intent.getIntExtra("userExp", 0);

        tvName.setText(theName);
        tvCity.setText(theCity);

        if(userExp < 10) {
            ivExp.setImageResource(R.drawable.prof_00);
            tvLvl.setText("Apprentice");
        } else if (userExp < 20) {
            ivExp.setImageResource(R.drawable.prof_01);
            tvLvl.setText("Recruit");
        } else if (userExp < 30) {
            ivExp.setImageResource(R.drawable.prof_02);
            tvLvl.setText("Novice");
        } else if (userExp < 40) {
            ivExp.setImageResource(R.drawable.prof_03);
            tvLvl.setText("Sidekick");
        } else if (userExp < 50) {
            ivExp.setImageResource(R.drawable.prof_04);
            tvLvl.setText("All-Star");
        } else if (userExp < 60) {
            ivExp.setImageResource(R.drawable.prof_05);
            tvLvl.setText("Vigilante");
        } else if (userExp < 70) {
            ivExp.setImageResource(R.drawable.prof_06);
            tvLvl.setText("Hero");
        } else if (userExp < 80) {
            ivExp.setImageResource(R.drawable.prof_07);
            tvLvl.setText("Superhero");
        } else {
            ivExp.setImageResource(R.drawable.prof_08);
            tvLvl.setText("Vampire Slayer");
        }
    }

    public void clickMenu(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("etName", theName);
        intent.putExtra("etCity", theCity);
        intent.putExtra("cityNum", cityNum);
        intent.putExtra("userExp", userExp);
        startActivity(intent);
    }
}
