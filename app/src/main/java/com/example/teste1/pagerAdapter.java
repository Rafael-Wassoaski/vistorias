package com.example.teste1;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class pagerAdapter extends FragmentPagerAdapter {

    private String[] mTabTiles;

    public pagerAdapter(FragmentManager fm, String[]mTabTiles) {
        super(fm);
        this.mTabTiles = mTabTiles;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){
            case 0:

                return new ocorrenciaCadastro();
            case 1:
                return new danosHumanos();
            case 2:
                return new danosMateriais();
            case 3 :
                return  new danosAmbientais();

            case 4:
                return new danosEconomicos();

            case 5:
                return new iahframento();

                default:
                    return  null;

        }

    }

    @Override
    public int getCount() {
        return this.mTabTiles.length;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return this.mTabTiles[position];
    }
}
