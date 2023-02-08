package id.ac.poliban.mi.jordy.codingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import id.ac.poliban.mi.jordy.codingchallenge.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding secondBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        secondBinding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(secondBinding.getRoot());

        Intent intent = getIntent();
        switch (intent.getIntExtra(MainActivity.EXTRA_ACTIVITY_MAIN, 0)) {
            case 0:
                secondBinding.textView.setText(R.string.text_one);
                break;
            case 1:
                secondBinding.textView.setText(R.string.text_two);
                break;
            case 2:
                secondBinding.textView.setText(R.string.text_three);
        }
    }
}