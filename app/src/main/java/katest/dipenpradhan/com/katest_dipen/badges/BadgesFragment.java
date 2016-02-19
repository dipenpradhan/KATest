package katest.dipenpradhan.com.katest_dipen.badges;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import katest.dipenpradhan.com.katest_dipen.R;
import katest.dipenpradhan.com.katest_dipen.api.APIManager;
import katest.dipenpradhan.com.katest_dipen.common.AbsDataAdapter;
import katest.dipenpradhan.com.katest_dipen.common.AbsFragment;
import katest.dipenpradhan.com.katest_dipen.database.DBConstants;
import katest.dipenpradhan.com.katest_dipen.database.DBProvider;
import katest.dipenpradhan.com.katest_dipen.entity.Badge;

/**
 * Created by dipenpradhan on 2/8/16.
 */
public class BadgesFragment extends AbsFragment<List<Badge>, Badge> {

    private static final int LOADER_ID_BADGES = 1;
    private BadgesAdapter mBadgesAdapter;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mBadgesAdapter = new BadgesAdapter(getActivity());
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = null;
        String selection = DBConstants.BADGE_CATEGORY+" = ?";
        String[] selectionArgs = new String[]{String.valueOf(getArguments().getInt("id"))};
        String sortOrder = null;

        if (id == getLoaderId()) {
            return new CursorLoader(getActivity(),
                    Uri.withAppendedPath(DBConstants.CONTENT_URI,
                            DBProvider.DB_URIs.BADGE.getPath()),
                    projection,
                    selection,
                    selectionArgs,
                    sortOrder);
        }
        return null;

    }

    @Override
    protected void callApi() {
        APIManager.getBadges(getActivity(), 0, this);
    }

    @Override
    protected int getLoaderId() {
        return LOADER_ID_BADGES;
    }

    @Override
    protected AbsDataAdapter<Badge> getDataAdapter() {
        return mBadgesAdapter;
    }

    @Override
    protected Badge dataFromCursor(Cursor cursor) {
        return Badge.fromCursor(cursor);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.frag_categories;
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getActivity());
    }
}
