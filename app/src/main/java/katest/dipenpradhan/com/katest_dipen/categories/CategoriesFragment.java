package katest.dipenpradhan.com.katest_dipen.categories;

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
import katest.dipenpradhan.com.katest_dipen.entity.Category;

/**
 * Created by dipenpradhan on 2/8/16.
 */
public class CategoriesFragment extends AbsFragment<List<Category>,Category> {

    private static final int LOADER_ID_CATEGORIES = 1;
    private CategoriesAdapter mCategoriesAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCategoriesAdapter = new CategoriesAdapter(getActivity());
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        String[] projection = null;
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = null;

        switch (id) {
            case LOADER_ID_CATEGORIES:

                return new CursorLoader(getActivity(),
                        Uri.withAppendedPath(DBConstants.CONTENT_URI,
                                DBProvider.DB_URIs.CATEGORY.getPath()),
                        projection,
                        selection,
                        selectionArgs,
                        sortOrder);
            default:
                return null;
        }

    }

    @Override
    protected void callApi() {
        APIManager.getCategories(getActivity(),0,this);
    }

    @Override
    protected int getLoaderId() {
        return LOADER_ID_CATEGORIES;
    }

    @Override
    protected AbsDataAdapter<Category> getDataAdapter() {
        return mCategoriesAdapter;
    }

    @Override
    protected Category dataFromCursor(Cursor cursor) {
        return Category.fromCursor(cursor);
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
