package com.fedming.bottomnavigationdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruce on 2016/11/1.
 * ViewPagerAdapter
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super( manager );

    }

    //该类中新增的一个虚函数。函数的目的为生成新的 Fragment对象。重载该函数时需要注意这一点。在需要时，该函数将被 instantiateItem() 所调用。
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get( position );
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem( container, position );
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem( container, position, object );
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment) {
        mFragmentList.add( fragment );
    }

}
