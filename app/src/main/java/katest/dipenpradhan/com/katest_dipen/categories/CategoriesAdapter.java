package katest.dipenpradhan.com.katest_dipen.categories;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.view.View;

import com.squareup.picasso.Picasso;

import katest.dipenpradhan.com.katest_dipen.R;
import katest.dipenpradhan.com.katest_dipen.common.AbsDataAdapter;
import katest.dipenpradhan.com.katest_dipen.entity.Category;
import katest.dipenpradhan.com.katest_dipen.badges.BadgesActivity;

/**
 * Created by dipenpradhan on 2/8/16.
 */
public class CategoriesAdapter extends AbsDataAdapter<Category> {
    private Handler handler =new Handler();
    public CategoriesAdapter(Activity activity) {
        super(activity);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.category_list_item;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Category c = getItem(position);

        holder.txtName.setText(c.getTypeLabel());
        holder.txtDesc.setText(c.getDescription());
        Picasso.with(holder.imgIcon.getContext()).load(c.getLargeIconSrc()).into(holder.imgIcon);
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent(v.getContext(),BadgesActivity.class);
                intent.putExtra("id",c.getCategory());
                intent.putExtra("name",c.getTypeLabel());
                getActivity().startActivity(intent);
            }
        });
    }
}
