package jjasonhe.swateam;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Help1Activity extends AppCompatActivity {
    TextView tvTit;
    TextView tvPar;
    TextView tvBack;

    String theName;
    String theCity;
    int cityNum;
    int userExp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help1);

        Typeface montserratB = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Bold.ttf");
        Typeface montserratR = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Regular.ttf");

        tvTit = (TextView) findViewById(R.id.tvTit);
        tvTit.setTypeface(montserratB);
        tvPar = (TextView) findViewById(R.id.tvPar);
        tvPar.setTypeface(montserratR);

        tvBack = (TextView) findViewById(R.id.tvBack);
        tvBack.setTypeface(montserratR);

        Intent intent = getIntent();
        theName = intent.getStringExtra("etName");
        theCity = intent.getStringExtra("etCity");
        cityNum = intent.getIntExtra("cityNum", 0);
        userExp = intent.getIntExtra("userExp", 0);
    }

    public void clickBack(View view) {
        Intent intent = new Intent(this, ZonesActivity.class);
        intent.putExtra("etName", theName);
        intent.putExtra("etCity", theCity);
        intent.putExtra("cityNum", cityNum);
        intent.putExtra("userExp", userExp);
        startActivity(intent);
    }
}
