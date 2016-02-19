package katest.dipenpradhan.com.katest_dipen.badges;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.view.View;

import com.squareup.picasso.Picasso;

import katest.dipenpradhan.com.katest_dipen.R;
import katest.dipenpradhan.com.katest_dipen.common.AbsDataAdapter;
import katest.dipenpradhan.com.katest_dipen.entity.Badge;

/**
 * Created by dipenpradhan on 2/8/16.
 */
public class BadgesAdapter extends AbsDataAdapter<Badge> {

    private Handler handler = new Handler();

    public BadgesAdapter(Activity activity) {
        super(activity);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.category_list_item;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Badge b = getItem(position);

        holder.txtName.setText(b.getName());
        holder.txtName.setText(b.getDescription());
        Picasso.with(holder.imgIcon.getContext()).load(b.getIcons().getLarge()).into(holder.imgIcon);
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent(v.getContext(),BadgePagerActivity.class);
                intent.putExtra("id",b.getBadgeCategory());
                intent.putExtra("name",b.getName());
                intent.putExtra("pos",position);
                getActivity().startActivity(intent);
            }
        });
    }
}
