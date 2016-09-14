package com.example.souvik.flappymenu.DumyModelAndAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.souvik.flappymenu.R;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.UndoAdapter;
import com.nhaarman.listviewanimations.util.Swappable;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Souvik on 14-Sep-16.
 */
public class DummyListAdapter  extends BaseAdapter
        implements Swappable, UndoAdapter, OnDismissCallback {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<DummyModel> mDummyModelList;


    public DummyListAdapter(Context context, ArrayList<DummyModel> dummyModelList){
        mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mDummyModelList = dummyModelList;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public int getCount() {
        return mDummyModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDummyModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mDummyModelList.get(position).getmId();
    }

    @Override
    public void swapItems(int positionOne, int positionTwo) {
        Collections.swap(mDummyModelList, positionOne, positionTwo);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        convertView = mInflater.inflate(R.layout.list_swipable, parent, false);
        holder = new ViewHolder();
        holder.transactionAmount = (TextView) convertView.findViewById(R.id.transaction_amount);
        holder.transactionDate = (TextView) convertView.findViewById(R.id.transaction_date);
        holder.transactionFrom = (TextView) convertView.findViewById(R.id.transaction_from);
        holder.transactionTo = (TextView) convertView.findViewById(R.id.transaction_to);

        DummyModel dm = mDummyModelList.get(position);
        holder.transactionFrom.setText(dm.getTransactionFrom());
        holder.transactionTo.setText(dm.getTransactionTo());
        holder.transactionAmount.setText(dm.getTransactionAmount());
        holder.transactionDate.setText(dm.getTransactionDate());
        return convertView;
    }

    private static class ViewHolder {
        public TextView transactionAmount;
        public TextView transactionDate;
        public TextView transactionFrom;
        public TextView transactionTo;
    }

    @Override
    @NonNull
    public View getUndoClickView(@NonNull View view) {
        return view.findViewById(R.id.undo_button_travel);
    }

    @Override
    @NonNull
    public View getUndoView(final int position, final View convertView, @NonNull final ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.list_undo, parent, false);
        }
        return view;
    }


    @Override
    public void onDismiss(@NonNull final ViewGroup listView,
                          @NonNull final int[] reverseSortedPositions) {
        for (int position : reverseSortedPositions) {
            remove(position);
        }
    }

    public void remove(int position) {
        mDummyModelList.remove(position);
    }

}
