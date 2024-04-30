package dz.mradel.foodapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.io.Serializable;
import java.util.ArrayList;

import dz.mradel.foodapp.Activity.DetailActivity;
import dz.mradel.foodapp.Domain.Foods;
import dz.mradel.foodapp.R;

public class FoodsListAdapter extends RecyclerView.Adapter<FoodsListAdapter.viewholder> {
    ArrayList<Foods> items;
    Context context;

    public FoodsListAdapter(ArrayList<Foods> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public FoodsListAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_list_food,parent,false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodsListAdapter.viewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.titleTxt.setText(items.get(position).getTitle());
        holder.priceTxt.setText(items.get(position).getPrice()+" $");
        holder.timeTxt.setText(items.get(position).getTimeValue()+"");
        holder.starTxt.setText(items.get(position).getStar()+"");

        Glide.with(context)
                .load(items.get(position).getImagePath())
                .transform(new CenterCrop(),new RoundedCorners(30))
                .into(holder.pic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("object", (Serializable) items.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView titleTxt, priceTxt, starTxt, timeTxt;
        ImageView pic;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            titleTxt=itemView.findViewById(R.id.titleTxt);
            priceTxt=itemView.findViewById(R.id.priceTxt);
            starTxt=itemView.findViewById(R.id.rateTxt);
            timeTxt=itemView.findViewById(R.id.timeTxt);
            pic=itemView.findViewById(R.id.img);
        }
    }
}
