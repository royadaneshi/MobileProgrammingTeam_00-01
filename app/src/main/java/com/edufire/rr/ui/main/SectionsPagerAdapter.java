//package com.edufire.rr.ui.main;
//
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentPagerAdapter;
//
//import com.edufire.rr.ProfessorFragment;
//import com.edufire.rr.StudentFragment;
//
//
//public class SectionsPagerAdapter extends FragmentPagerAdapter {
//    private int numberOfTabs;
//
//    public SectionsPagerAdapter(FragmentManager fm, int numberOfTabs) {
//        super(fm);
//        this.numberOfTabs = numberOfTabs;
//
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//        switch (position) {
//            case 0:
//                return new StudentFragment();
//            case 1:
//                return new ProfessorFragment();
//            default:
//                return null;
//        }
//    }
//
//    @Override
//    public int getCount() {
//        return numberOfTabs;
//    }
//
//}








//////////////////////////////////////////////////////////////////////////////////////
//    @StringRes
//    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
//    private final Context mContext;
//
//    public SectionsPagerAdapter(Context context, FragmentManager fm) {
//        super(fm);
//        mContext = context;
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//        // getItem is called to instantiate the fragment for the given page.
//        // Return a PlaceholderFragment (defined as a static inner class below).
//        return PlaceholderFragment.newInstance(position + 1);
//    }
//
//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return mContext.getResources().getString(TAB_TITLES[position]);
//    }
//
//    @Override
//    public int getCount() {
//        // Show 2 total pages.
//        return 2;
//    }
