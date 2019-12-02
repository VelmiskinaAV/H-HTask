package ru.arvelm.lesson_4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolderTypeOne> {

    private Context mContext;
    static final int TYPE_ONE = 1;
    static final int TYPE_TWO = 2;
    private List<AddData> listOfData;

    MyAdapter(Context mContext, List<AddData> listOfData) {
        this.mContext = mContext;
        this.listOfData = listOfData;
    }

    @Override
    public ViewHolderTypeOne onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == TYPE_ONE){
            return new ViewHolderTypeOne(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row_type_one, parent, false));
        } else {
            return new ViewHolderTypeOne(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row_type_two, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (listOfData.get(position).getType() == TYPE_TWO || (position + 1 < listOfData.size() && listOfData.get(position).getType() == TYPE_ONE && listOfData.get(position + 1).getType() == TYPE_TWO)){
            return TYPE_TWO;
        } else {
            return TYPE_ONE;
        }
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(final ViewHolderTypeOne holder, int position) {
        holder.mImage.setImageResource(listOfData.get(position).getImage());
        holder.mTitle.setText(listOfData.get(position).getTitle());

        if (listOfData.get(position).getRedTextFlag()){
            holder.subTitle.setTextColor(mContext.getResources().getColor(R.color.red));
            holder.subTitle.setText(listOfData.get(position).getInfo());
        } else {
            holder.subTitle.setTextColor(mContext.getResources().getColor(R.color.warmGray));
            holder.subTitle.setText(listOfData.get(position).getInfo());
        }
    }

    @Override
    public int getItemCount() {
        return listOfData.size();
    }

    public static class ViewHolderTypeOne extends RecyclerView.ViewHolder {

        ImageView mImage;
        TextView mTitle;
        TextView subTitle;

        ViewHolderTypeOne(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
            mTitle = itemView.findViewById(R.id.textViewTitle);
            subTitle = itemView.findViewById(R.id.textViewSubTitle);
        }
    }

    public static class ViewHolderTypeTwo extends RecyclerView.ViewHolder {

        ImageView mImage;
        TextView mTitle;
        TextView subTitle;

        ViewHolderTypeTwo(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
            mTitle = itemView.findViewById(R.id.textViewTitle);
            subTitle = itemView.findViewById(R.id.textViewSubTitle);
        }
    }

    abstract static class ViewHolder {

        public static RecyclerView.ViewHolder create(View v, int viewType) {
            if (viewType == TYPE_ONE){
                return new ViewHolderTypeOne(v);
            } else {
                return new ViewHolderTypeTwo(v);
            }
        }
    }
}


