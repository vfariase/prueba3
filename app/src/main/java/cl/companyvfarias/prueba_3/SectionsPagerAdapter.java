package cl.companyvfarias.prueba_3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ProductsFragment.newInstance();

            case 1:
                return SalesFragment.newInstance();

            default:
                return ProductsFragment.newInstance();

        }

    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 2;
    }
}
