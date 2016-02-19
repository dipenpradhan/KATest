package katest.dipenpradhan.com.katest_dipen.common;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import katest.dipenpradhan.com.katest_dipen.R;
import katest.dipenpradhan.com.katest_dipen.api.APIListener;
import katest.dipenpradhan.com.katest_dipen.api.APIResult;

/**
 * Created by dipenpradhan on 2/8/16.
 */
public abstract class AbsFragment<T, D> extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>, APIListener<T>, SwipeRefreshLayout.OnRefreshListener {

    private static final int LOADER_ID_BADGES = 1;

    @Bind(R.id.recycler)
    RecyclerView recycler;

    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), null);
        ButterKnife.bind(this, view);
        if (recycler != null) {
            recycler.setAdapter(getDataAdapter());
            recycler.setLayoutManager(getLayoutManager());
            recycler.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL_LIST));
        }
        if (swipeRefresh != null) {
            swipeRefresh.setOnRefreshListener(this);
        }
        getLoaderManager().initLoader(getLoaderId(), getInitialBundle(), this);
        callApi();
        return view;
    }


    @Override
    public abstract Loader<Cursor> onCreateLoader(int id, Bundle args);

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        if (loader.getId() == getLoaderId()) {
            getDataAdapter().refreshList(new ArrayList<D>());
        }
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (loader.getId() == getLoaderId()) {
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                List<D> dataList = new ArrayList<>();
                while (!cursor.isClosed() || !cursor.isLast()) {
                    D data = dataFromCursor(cursor);
                    dataList.add(data);
                    if (!cursor.moveToNext()) break;
                }
                getDataAdapter().refreshList(dataList);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getLoaderManager().destroyLoader(getLoaderId());
    }

    @Override
    public void onBegin(int requestId) {
        if (swipeRefresh != null)
            swipeRefresh.setRefreshing(true);
    }

    @Override
    public void onSuccess(int requestId, APIResult<T> apiResult) {
        if (swipeRefresh != null)
            swipeRefresh.setRefreshing(false);
    }

    @Override
    public void onFailure(int requestId, @NonNull APIResult.FailureType failureType, @Nullable Throwable t) {
        if (swipeRefresh != null)
            swipeRefresh.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        callApi();
    }

    protected abstract void callApi();

    protected abstract int getLoaderId();

    protected Bundle getInitialBundle() {
        return null;
    }

    protected abstract AbsDataAdapter<D> getDataAdapter();

    protected abstract D dataFromCursor(Cursor cursor);

    protected abstract RecyclerView.LayoutManager getLayoutManager();

    protected abstract
    @LayoutRes
    int getLayoutResId();
}
