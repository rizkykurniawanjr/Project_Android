package id.ac.poliban.mi.jordy.recyclerviewespresso_061;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar()!=null)getSupportActionBar().setTitle("RecyclerView EspressoTest");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            int wordListSize = mWordList.size();
            mWordList.addLast("+ Word " + wordListSize);
            Objects.requireNonNull(mRecyclerView.getAdapter()).notifyItemInserted(wordListSize);
            mRecyclerView.smoothScrollToPosition(wordListSize);
        });

        for (int i = 1; i < 21; i++) {
            mWordList.add("Word " + i);
        }

        mRecyclerView = findViewById(R.id.recyclerView);
        WordListAdapter mAdapter = new WordListAdapter(this, mWordList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
