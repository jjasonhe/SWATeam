package jjasonhe.swateam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TrapsActivity extends AppCompatActivity {
    TextView tvCam;
    TextView tvHelp;

    String theName;
    String theCity;
    int cityNum;
    int userExp;

    boolean working;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traps);

        Typeface montserratB = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Bold.ttf");
        Typeface montserratR = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Regular.ttf");

        tvCam = (TextView) findViewById(R.id.tvCam);
        tvCam.setTypeface(montserratR);
        tvHelp = (TextView) findViewById(R.id.tvHelp);
        tvHelp.setTypeface(montserratR);

        Intent intent = getIntent();
        theName = intent.getStringExtra("etName");
        theCity = intent.getStringExtra("etCity");
        cityNum = intent.getIntExtra("cityNum", 0);
        userExp = intent.getIntExtra("userExp", 0);
    }

    private Uri fileUri;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public void clickCam(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }

    private static Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    @SuppressLint("SimpleDateFormat")
    private static File getOutputMediaFile(int type) {
        final File mediaStorageDir;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "SWATeam");
        } else {
            mediaStorageDir = new File("/storage/sdcard0/SWATeam/");
        }
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("SWATeam", "failed to create directory");
                return null;
            }
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile = null;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");
        } else {
            return null;
        }
        return mediaFile;
    }

    public static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == 1) {
                Toast.makeText(this, "Image successfully saved", Toast.LENGTH_SHORT).show();
            } else if (resultCode == 0) {
                Toast.makeText(this, "Just kidding", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Image failed to save", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onRadioCondClick(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radioCondY:
                if (checked)
                    working = true;
                    break;
            case R.id.radioCondN:
                if (checked)
                    working = false;
                    break;
        }
    }

    public void clickGo(View view) {
        if (working) {
            cityNum += 1;
            userExp += 10;
        } else {
            userExp += 5;
        }

        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("etName", theName);
        intent.putExtra("etCity", theCity);
        intent.putExtra("cityNum", cityNum);
        intent.putExtra("userExp", userExp);
        startActivity(intent);
    }
}
