package katest.dipenpradhan.com.katest_dipen.badges;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import katest.dipenpradhan.com.katest_dipen.R;
import katest.dipenpradhan.com.katest_dipen.database.DBConstants;
import katest.dipenpradhan.com.katest_dipen.database.DBProvider;
import katest.dipenpradhan.com.katest_dipen.entity.Badge;

/**
 * Created by dipenpradhan on 2/8/16.
 */
public class BadgePagerActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    @Bind(R.id.pager)
    ViewPager pager;

    private BadgePagerAdapter pagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badge_pager);
        ButterKnife.bind(this);
        pagerAdapter = new BadgePagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        getSupportLoaderManager().initLoader(0,null,this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = null;
        String selection = DBConstants.BADGE_CATEGORY + " = ?";
        String[] selectionArgs = new String[]{String.valueOf(getIntent().getIntExtra("id", 0))};
        String sortOrder = null;

        return new CursorLoader(this,
                Uri.withAppendedPath(DBConstants.CONTENT_URI,
                        DBProvider.DB_URIs.BADGE.getPath()),
                projection,
                selection,
                selectionArgs,
                sortOrder);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            List<Badge> dataList = new ArrayList<>();
            while (!cursor.isClosed() || !cursor.isLast()) {
                Badge data = Badge.fromCursor(cursor);
                dataList.add(data);
                if (!cursor.moveToNext()) break;
            }
            pagerAdapter.refreshList(dataList);
            pager.setCurrentItem(getIntent().getIntExtra("pos",0));
        }
    }

    @Override
    protected void onDestroy() {
        getSupportLoaderManager().destroyLoader(0);
        super.onDestroy();

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
