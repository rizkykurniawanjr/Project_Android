package id.ac.poliban.mi.jordy.keyboarddialphone_042;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) getSupportActionBar().setTitle("DialPad Number");

        EditText editText = findViewById(R.id.editText_main);

        if (editText != null)
            editText.setOnEditorActionListener(
                    (textView, actionId, keyEvent) -> {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            dialNumber();
                            handled = true;
                        }
                        return handled;
                    });
    }

    @SuppressLint("QueryPermissionsNeeded")
    private void dialNumber() {

        EditText editText = findViewById(R.id.editText_main);
        String phoneNum = null;

        if (editText != null) phoneNum = "tel:" + editText.getText().toString();
        Log.d(TAG, "dialNumber: " + phoneNum);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(phoneNum));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d(TAG, "ImplicitIntents: Can't handle this!");
        }
    }
}