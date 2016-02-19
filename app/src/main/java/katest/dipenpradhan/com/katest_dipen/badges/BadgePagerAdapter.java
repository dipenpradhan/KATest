package katest.dipenpradhan.com.katest_dipen.badges;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import katest.dipenpradhan.com.katest_dipen.entity.Badge;

/**
 * Created by dipenpradhan on 2/8/16.
 */
public class BadgePagerAdapter extends FragmentStatePagerAdapter {

    private List<Badge> badgeList = new ArrayList<>();

    public BadgePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag = new BadgePagerFrag();
        Bundle b = new Bundle();
        b.putParcelable("badge",badgeList.get(position));

        frag.setArguments(b);

        return frag;
    }

    @Override
    public int getCount() {
        return badgeList.size();
    }

    public void refreshList(List<Badge> badgeList){
        this.badgeList = new ArrayList<>(badgeList);
        notifyDataSetChanged();
    }
}
