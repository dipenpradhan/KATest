package katest.dipenpradhan.com.katest_dipen.badges;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import katest.dipenpradhan.com.katest_dipen.R;
import katest.dipenpradhan.com.katest_dipen.entity.Badge;

/**
 * Created by dipenpradhan on 2/8/16.
 */
public class BadgePagerFrag extends Fragment {

    @Bind(R.id.txt_name)
    TextView txtName;

    @Bind(R.id.txt_desc)
    TextView txtDesc;

    @Bind(R.id.txt_safe_desc)
    TextView txtSafeDesc;

    @Bind(R.id.txt_points)
    TextView txtPoints;

    @Bind(R.id.img_icon)
    ImageView imgIcon;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Badge badge = getArguments().getParcelable("badge");
        View view = inflater.inflate(R.layout.badge_pager_item, null);
        ButterKnife.bind(this,view);
        if (badge != null) {
            txtName.setText(badge.getName());
            txtDesc.setText(badge.getDescription());
            txtSafeDesc.setText(badge.getSafeExtendedDescription());
            txtPoints.setText(String.valueOf(badge.getPoints()));
            Picasso.with(getActivity()).load(badge.getIcons().getLarge()).into(imgIcon);
        }
        return view;
    }
}
