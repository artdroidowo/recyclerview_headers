package com.example.karol.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Karol on 2018-02-10.
 */

class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 1;
    private static final int TYPE_FOOTER = 2;
    private static final int TYPE_ITEM = 3;
    String[] listItems;

    public MyAdapter(String[] shoppingList) {
        listItems = shoppingList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case TYPE_HEADER:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.row_list_header, parent, false);
                return new HeaderHolder(view);
            case TYPE_ITEM:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.row_list_item, parent, false);
                return new ItemHolder(view);
            case TYPE_FOOTER:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.row_list_footer, parent, false);
                return new FooterHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemHolder) {
            ItemHolder itemHolder = (ItemHolder) holder;
            itemHolder.itemTv.setText(listItems[position - 1]);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else if (position == listItems.length + 1) {
            return TYPE_FOOTER;
        } else return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return listItems.length + 2;
    }

    private class FooterHolder extends RecyclerView.ViewHolder {
        public FooterHolder(View view) {
            super(view);
        }
    }

    private class ItemHolder extends RecyclerView.ViewHolder {

        TextView itemTv;

        public ItemHolder(View view) {
            super(view);
            itemTv = view.findViewById(R.id.list_item_tv);
        }
    }

    private class HeaderHolder extends RecyclerView.ViewHolder {
        public HeaderHolder(View view) {
            super(view);
        }
    }
}
