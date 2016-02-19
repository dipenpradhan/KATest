package katest.dipenpradhan.com.katest_dipen.common;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import katest.dipenpradhan.com.katest_dipen.R;

/**
 * Created by dipenpradhan on 2/8/16.
 */
public abstract class AbsDataAdapter<T> extends  RecyclerView.Adapter<AbsDataAdapter.ViewHolder> {

    private List<T> list= new ArrayList<>();

    private Activity activity;

    public AbsDataAdapter(Activity activity) {
        this.activity = activity;
    }

    public Activity getActivity() {
        return activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(),getLayoutId(), null);

        return new ViewHolder(view);
    }


    public T getItem(int pos){
        if(list.size()>pos){
            return list.get(pos);
        }else{
            return null;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void refreshList(List<T> list) {
        this.list = new ArrayList<>(list);
        notifyDataSetChanged();
    }
    protected  abstract  @LayoutRes int getLayoutId();


    public static class ViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.container)
        public ViewGroup container;

        @Bind(R.id.txt_name)
        public TextView txtName;

        @Bind(R.id.txt_desc)
        public TextView txtDesc;

        @Bind(R.id.img_icon)
        public ImageView imgIcon;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
