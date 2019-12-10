package ru.arvelm.lesson_6;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolderTypeOne> {

    List<AddData> dataList;
    final static int TYPE_ONE = 1;
    final static int TYPE_TWO = 2;

    public static class MyViewHolderTypeOne extends RecyclerView.ViewHolder{
        public CardView cardView;
        public TextView textViewId, textViewInfo, textViewTitle;
        public ImageView imageViewAlert, image;

        public MyViewHolderTypeOne(View v){
            super(v);
            cardView = v.findViewById(R.id.card_view);
            textViewId = v.findViewById(R.id.textViewIdClient);
            textViewTitle = v.findViewById(R.id.textViewTitle);
            textViewInfo = v.findViewById(R.id.textViewMessage);
            image = v.findViewById(R.id.imageView);
            imageViewAlert = v.findViewById(R.id.imageState);
        }
    }

    public static class MyViewHolderTypeTwo extends RecyclerView.ViewHolder{
        public CardView cardView;
        public TextView textViewId, textViewInfo, textViewTitle;
        public ImageView imageViewAlert, image;

        public MyViewHolderTypeTwo(View v){
            super(v);
            cardView = v.findViewById(R.id.card_view);
            textViewId = v.findViewById(R.id.textViewIdClient);
            textViewTitle = v.findViewById(R.id.textViewTitle);
            textViewInfo = v.findViewById(R.id.textViewMessage);
            image = v.findViewById(R.id.imageView);
            imageViewAlert = v.findViewById(R.id.imageState);
        }
    }

    abstract static class ViewHolder {

        public static RecyclerView.ViewHolder create(View v, int viewType) {
            if (viewType == 1){
                return new MyViewHolderTypeOne(v);
            } else {
                return new MyViewHolderTypeTwo(v);
            }
        }
    }

    public MyAdapter(List<AddData> dataList){
        this.dataList = dataList;
    }

    @Override
    public MyAdapter.MyViewHolderTypeOne onCreateViewHolder(ViewGroup parent, int viewType){

        if(viewType == TYPE_ONE){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_type_one, parent, false);
            MyViewHolderTypeOne viewHolder = new MyViewHolderTypeOne(v);
            return viewHolder;
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_type_two, parent, false);
            MyViewHolderTypeOne viewHolder = new MyViewHolderTypeOne(v);
            return viewHolder;
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (dataList.get(position).getType() == TYPE_TWO){
            return TYPE_TWO;
        } else {
            return TYPE_ONE;
        }
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(MyViewHolderTypeOne holder, int position){
        holder.textViewId.setText(dataList.get(position).getID());
        holder.textViewTitle.setText(dataList.get(position).getTitle());
        holder.image.setImageResource(dataList.get(position).getImage());

        if (dataList.get(position).getRedTextFlag()){
            holder.imageViewAlert.setImageResource(dataList.get(position).getImageAlert());
            holder.textViewInfo.getResources().getColor(R.color.colorCoral);
            String message = "Необходимо подать показания до ";
            String s = message + dataList.get(position).getInfo();
            holder.textViewInfo.setText(s);
        } else {
            holder.textViewInfo.getResources().getColor(R.color.colorCharcoalGray);
            String message = "Показания сданы ";
            String message2 =" и будут учтены при следующем расчете ";
            String[] date = dataList.get(position).getInfo().split(" ");
            holder.textViewInfo.setText(Html.fromHtml(message + "<strong>" + date[0] + "</strong>" + message2 + "<strong>" + date[1] + "</strong>"));
        }
    }

    @Override
    public int getItemCount(){
        return dataList.size();
    }
}
