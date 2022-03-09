//package com.edufire.rr;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentActivity;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentPagerAdapter;
//import androidx.lifecycle.Lifecycle;
//import androidx.viewpager2.adapter.FragmentStateAdapter;
//
//import java.util.ArrayList;
//
//
//public class PagerAdapter extends FragmentStateAdapter {
//    private int numBerOfTabs;
//
//    public PagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
//        super(fragmentManager, lifecycle);
//    }
//
//
////    public PagerAdapter(FragmentActivity fa, int numBerOfTabs) {
////        super(fa);
////        this.numBerOfTabs = numBerOfTabs;
////    }
//
//
//    @Override
//    public Fragment createFragment(int position) {
//
//        switch (position) {
//            case 0:
//                return new StudentFragment();
//            case 1:
//              //  return new ProfessorFragment();
//            default:
//                return null;
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return 2;
//    }
//}
//
////
////public class PagerAdapter extends FragmentPagerAdapter {
////    private int numBerOfTabs;
////
////
////    public PagerAdapter(@NonNull FragmentManager fm, int numBerOfTabs) {
////        super(fm);
////        this.numBerOfTabs = numBerOfTabs;
////    }
////
////    @Override
////    @NonNull
////    public Fragment getItem(int position) {
////        switch (position) {
////            case 0:
////                return new StudentFragment();
////            case 1:
////                return new ProfessorFragment();
////            default:
////                return null;
////        }
////    }
////
////    @Override
////    public int getCount() {
////        return numBerOfTabs;
////    }
////}
////
