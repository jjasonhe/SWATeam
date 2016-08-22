package jjasonhe.swateam;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ReportActivity extends AppCompatActivity {
    ImageView ivTips;
    String theName;
    String theCity;
    int cityNum;
    int userExp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        Intent intent = getIntent();
        theName = intent.getStringExtra("etName");
        theCity = intent.getStringExtra("etCity");
        cityNum = intent.getIntExtra("cityNum", 0);
        userExp = intent.getIntExtra("userExp", 0);

        ivTips = (ImageView) findViewById(R.id.ivTips);

        renderTips();
    }

    private void renderTips() {
        if (cityNum <= -9) {
            ivTips.setImageResource(R.drawable.icon03_tips5);
        } else if (cityNum <= -7) {
            ivTips.setImageResource(R.drawable.icon03_tips4);
        } else if (cityNum <= -5) {
            ivTips.setImageResource(R.drawable.icon03_tips3);
        } else if (cityNum <= -3) {
            ivTips.setImageResource(R.drawable.icon03_tips2);
        } else {
            ivTips.setImageResource(R.drawable.icon03_tips1);
        }
    }

    public void clickReport(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("etName", theName);
        intent.putExtra("etCity", theCity);
        intent.putExtra("cityNum", cityNum);
        intent.putExtra("userExp", userExp);
        startActivity(intent);
    }
}
