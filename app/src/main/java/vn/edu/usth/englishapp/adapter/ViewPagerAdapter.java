package vn.edu.usth.englishapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import vn.edu.usth.englishapp.fragment.FragmentAccount;
import vn.edu.usth.englishapp.fragment.FragmentHistory;
import vn.edu.usth.englishapp.fragment.FragmentHome;
import vn.edu.usth.englishapp.fragment.FragmentPro;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new FragmentHome();
            case 1: return new FragmentHistory();
            case 2: return new FragmentPro();
            case 3: return new FragmentAccount();
        }
        return new FragmentHome();
    }

    @Override
    public int getCount() {
        return 4;
    }
}
