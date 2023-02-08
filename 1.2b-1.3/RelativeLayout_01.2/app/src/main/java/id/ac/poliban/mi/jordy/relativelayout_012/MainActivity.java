package id.ac.poliban.mi.jordy.relativelayout_012;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount =(TextView) findViewById(R.id.show_count);
    }
    public void showToast(View view) {
        mCount =0;
        mShowCount.setText(String.valueOf(mCount));
        Toast toast = Toast.makeText(this,"hello toast",Toast.LENGTH_SHORT);
        toast.show();
    }

    public void CountUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
    }
}