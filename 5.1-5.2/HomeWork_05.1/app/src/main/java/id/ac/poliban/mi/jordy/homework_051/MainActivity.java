package id.ac.poliban.mi.jordy.homework_051;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private int imageLevel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar()!=null)getSupportActionBar().setTitle("DrawableTest");


        image = findViewById(R.id.battery_image);
        image.setImageLevel(imageLevel);
    }

    @SuppressLint("NonConstantResourceId")
    public void changeBatteryLevel(View view) {
        switch (view.getId()){
            case R.id.decrease_btn:
                if (imageLevel > 0){
                    imageLevel --;
                    image.setImageLevel(imageLevel);
                }
                break;
            case R.id.increase_btn:
                if (imageLevel < 6){
                    imageLevel ++;
                    image.setImageLevel(imageLevel);
                }
                break;
            default: break;
        }
    }
}