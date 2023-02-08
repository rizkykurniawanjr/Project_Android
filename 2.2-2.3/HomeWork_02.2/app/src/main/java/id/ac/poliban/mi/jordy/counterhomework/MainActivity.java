package id.ac.poliban.mi.jordy.counterhomework;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mcount = 0;
    private TextView mShowCount;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.show_count);

        if (savedInstanceState != null) {
            mcount =savedInstanceState.getInt("result");
            mShowCount.setText(Integer.toString(mcount));
        }
    }

    @Override
    protected void onSaveInstanceState(@Nullable Bundle outState) {
        outState.putInt("result", mcount);
        super.onSaveInstanceState(outState);
    }

    public void ShowCount(View view) {
        mcount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mcount));
        }
    }
}