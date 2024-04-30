package dz.mradel.foodapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dz.mradel.foodapp.Activity.ListFoodsActivity;
import dz.mradel.foodapp.Domain.Category;
import dz.mradel.foodapp.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewholder> {
    ArrayList<Category> items;
    Context context;

    public CategoryAdapter(ArrayList<Category> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoryAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.viewholder holder, int position) {
        holder.titleTxt.setText(items.get(position).getName());

        switch (position){
            case 0:{
                holder.pic.setBackgroundResource(R.drawable.cat_0_background);
                holder.pic.setImageResource(R.drawable.btn_1);
                break;
            }
            case 1:{
                holder.pic.setBackgroundResource(R.drawable.cat_1_background);
                holder.pic.setImageResource(R.drawable.btn_2);
                break;
            }
            case 2:{
                holder.pic.setBackgroundResource(R.drawable.cat_2_background);
                holder.pic.setImageResource(R.drawable.btn_3);
                break;
            }
            case 3:{
                holder.pic.setBackgroundResource(R.drawable.cat_3_background);
                holder.pic.setImageResource(R.drawable.btn_4);
                break;
            }
            case 4:{
                holder.pic.setBackgroundResource(R.drawable.cat_4_background);
                holder.pic.setImageResource(R.drawable.btn_5);
                break;
            }
            case 5:{
                holder.pic.setBackgroundResource(R.drawable.cat_5_background);
                holder.pic.setImageResource(R.drawable.btn_6);
                break;
            }
            case 6:{
                holder.pic.setBackgroundResource(R.drawable.cat_6_background);
                holder.pic.setImageResource(R.drawable.btn_7);
                break;
            }
            case 7:{
                holder.pic.setBackgroundResource(R.drawable.cat_7_background);
                holder.pic.setImageResource(R.drawable.btn_8);
                break;
            }
        }

        /*
        int drawableResourceId=context.getResources().getIdentifier(
                items.get(position).getImagePath(),"drawable",
                holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.pic);*/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context, ListFoodsActivity.class);
                intent.putExtra("CategoryId",items.get(position).getId());
                Log.d("CategoryID", String.valueOf(items.get(position).getId()));
                intent.putExtra("CategoryName",items.get(position).getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView titleTxt;
        ImageView pic;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            titleTxt=itemView.findViewById(R.id.catNameTxt);
            pic=itemView.findViewById(R.id.imageCat);
        }
    }
}
