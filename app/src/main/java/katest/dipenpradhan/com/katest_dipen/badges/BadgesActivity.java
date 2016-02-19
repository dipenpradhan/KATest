package katest.dipenpradhan.com.katest_dipen.badges;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import katest.dipenpradhan.com.katest_dipen.R;

/**
 * Created by dipenpradhan on 2/8/16.
 */
public class BadgesActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setTitle(getIntent().getStringExtra("name"));
        Fragment frag = new BadgesFragment();
        Bundle b = new Bundle();
        b.putAll(getIntent().getExtras());
        frag.setArguments(b);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, frag)
                .commit();
    }
}
