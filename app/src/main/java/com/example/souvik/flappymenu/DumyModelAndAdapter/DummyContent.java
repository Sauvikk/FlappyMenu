package com.example.souvik.flappymenu.DumyModelAndAdapter;

import com.example.souvik.flappymenu.R;

import java.util.ArrayList;


public class DummyContent {

    public static ArrayList<DummyModel> getDummyData() {
        ArrayList<DummyModel> list = new ArrayList<>();

        list.add(new DummyModel(0, R.string.fontello_icon_mastercard, R.string.fontello_icon_taxi, "112.55", "Monday, January 16"));
        list.add(new DummyModel(1, R.string.fontello_icon_visa, R.string.fontello_icon_coffee, "53.34", "Wednesday, January 29"));
        list.add(new DummyModel(2, R.string.fontello_icon_mastercard, R.string.fontello_icon_pizza, "1,453.55", "Monday, February 19"));
        list.add(new DummyModel(3, R.string.fontello_icon_paypal, R.string.fontello_icon_flight, "11,258.23", "Sunday, July 20"));
        list.add(new DummyModel(4, R.string.fontello_icon_visa, R.string.fontello_icon_pharmacy, "658.25", "Tuesday, July 22"));
        list.add(new DummyModel(5, R.string.fontello_icon_paypal, R.string.fontello_icon_pizza, "853.55", "Friday, July 25"));
        list.add(new DummyModel(6, R.string.fontello_icon_mastercard, R.string.fontello_icon_taxi, "63.25", "Monday, August 10"));
        list.add(new DummyModel(7, R.string.fontello_icon_visa, R.string.fontello_icon_coffee, "153.55", "Sunday, August 16"));

        return list;
    }
}
