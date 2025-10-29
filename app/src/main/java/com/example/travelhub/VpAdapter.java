package com.example.travelhub;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VpAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> FragArray = new ArrayList<>();

    public VpAdapter(@NonNull FragmentManager fm) {
        super(fm);

        FragArray.clear();

        ArrayList<String> TitleHome = new ArrayList<>();
        ArrayList<Integer> ImageAddressHome = new ArrayList<>();

        TitleHome.add("اتوبوس");
        ImageAddressHome.add(R.drawable.bus);
        TitleHome.add("قطار");
        ImageAddressHome.add(R.drawable.train);
        TitleHome.add("هواپیما");
        ImageAddressHome.add(R.drawable.airplane);
        TitleHome.add("قایق");
        ImageAddressHome.add(R.drawable.boating);
        TitleHome.add("دوچرخه");
        ImageAddressHome.add(R.drawable.cycling);
        TitleHome.add("پیاده روی");
        ImageAddressHome.add(R.drawable.walking);

        FragArray.add(new HomeFragment(TitleHome, ImageAddressHome));

        ArrayList<String> TitleProfile = new ArrayList<>();
        ArrayList<Integer> ImageAddressProfile = new ArrayList<>();
        TitleProfile.add("قهوه");
        ImageAddressProfile.add(R.drawable.bus);
        TitleProfile.add("آب معدنی");
        ImageAddressProfile.add(R.drawable.train);
        TitleProfile.add("بیسکوییت");
        ImageAddressProfile.add(R.drawable.airplane);
        TitleProfile.add("کیک");
        ImageAddressProfile.add(R.drawable.boating);
        TitleProfile.add("ویفر");
        ImageAddressProfile.add(R.drawable.cycling);
        TitleProfile.add("بستنی");
        ImageAddressProfile.add(R.drawable.walking);

        FragArray.add(new HomeFragment(TitleProfile, ImageAddressProfile));

        ArrayList<String> TitleFavorite = new ArrayList<>();
        ArrayList<Integer> ImageAddressFavorite = new ArrayList<>();
        TitleFavorite.add("اویل پمپ");
        ImageAddressFavorite.add(R.drawable.bus);
        TitleFavorite.add("واتر پمپ");
        ImageAddressFavorite.add(R.drawable.train);
        TitleFavorite.add("سر سیلندر");
        ImageAddressFavorite.add(R.drawable.airplane);
        TitleFavorite.add("واشر سر سیلندر");
        ImageAddressFavorite.add(R.drawable.boating);
        TitleFavorite.add("میل سوپاپ");
        ImageAddressFavorite.add(R.drawable.cycling);
        TitleFavorite.add("میل لنگ");
        ImageAddressFavorite.add(R.drawable.walking);


        FragArray.add(new HomeFragment(TitleFavorite, ImageAddressFavorite));

        ArrayList<String> TitleShop = new ArrayList<>();
        ArrayList<Integer> ImageAddressShop = new ArrayList<>();
        TitleShop.add("مرغ");
        ImageAddressShop.add(R.drawable.bus);
        TitleShop.add("ماهی");
        ImageAddressShop.add(R.drawable.train);
        TitleShop.add("گوشت گوساله");
        ImageAddressShop.add(R.drawable.airplane);
        TitleShop.add("گوشت گوسفند");
        ImageAddressShop.add(R.drawable.boating);
        TitleShop.add("معز و زبان");
        ImageAddressShop.add(R.drawable.cycling);
        TitleShop.add("گوشت صورت");
        ImageAddressShop.add(R.drawable.walking);

        FragArray.add(new HomeFragment(TitleShop, ImageAddressShop));
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return FragArray.get(position);
    }

    @Override
    public int getCount() {
        return FragArray.size();
    }
}
