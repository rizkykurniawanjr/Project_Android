package id.ac.poliban.mi.jordy.codingchallenge_033;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView mHelloTextView;
    private String[] mColorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelloTextView = findViewById(R.id.hello_textview);
        if (savedInstanceState != null) mHelloTextView.setTextColor(savedInstanceState.getInt("color"));
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("color", mHelloTextView.getCurrentTextColor());
    }

    public void changeColor(View view)
    {
        Random random = new Random();
        String colorName = mColorArray[random.nextInt(20)]; //nextInt(x) generates random ints from 0 to x-1
        Log.d("colorName", colorName);

        int colorResourceName = getResources().getIdentifier(colorName, "color", getApplicationContext().getPackageName());
        int colorRes = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            colorRes = getResources().getColor(colorResourceName, this.getTheme());
        }

        mHelloTextView.setTextColor(colorRes);
    }

}