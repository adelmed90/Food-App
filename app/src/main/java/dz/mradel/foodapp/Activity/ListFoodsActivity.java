package dz.mradel.foodapp.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import dz.mradel.foodapp.Adapter.FoodsListAdapter;
import dz.mradel.foodapp.Domain.Foods;
import dz.mradel.foodapp.databinding.ActivityListFoodsBinding;

public class ListFoodsActivity extends BaseActivity {
    ActivityListFoodsBinding binding;
    private RecyclerView.Adapter adapterListFood;
    private int categoryId;
    private String categoryName;
    private String searchText;
    private Boolean isSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityListFoodsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getIntentExtra();
        iniList();

    }

    private void iniList() {
        DatabaseReference myRef=database.getReference("Foods");
        binding.progressBar.setVisibility(View.VISIBLE);
        ArrayList<Foods> list=new ArrayList<>();
        Query query;
        if(isSearch){
            query=myRef.orderByChild("Title").startAt(searchText).endAt(searchText+"\uf8ff");
        }else {
            query=myRef.orderByChild("CategoryId").equalTo(categoryId);
            //query=myRef.orderByChild("CategoryName").equalTo(categoryName);
            Toast.makeText(ListFoodsActivity.this, "CategoryId: " +categoryId, Toast.LENGTH_LONG).show();
        }
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot issue: snapshot.getChildren()){
                        list.add(issue.getValue(Foods.class));

                    }
                    if(list.size()>0){
                        binding.foodListView.setLayoutManager(new GridLayoutManager(ListFoodsActivity.this,2));
                        adapterListFood= new FoodsListAdapter(list);
                        binding.foodListView.setAdapter(adapterListFood);
                    }
                    binding.progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getIntentExtra() {
        //categoryId=getIntent().getIntExtra("CategoryId",0);
        categoryName=getIntent().getStringExtra("CategoryName");
        switch (categoryName){
            case "Pizza":{
                categoryId=0;
                break;
            }
            case "Burger":{
                categoryId=1;
                break;
            }
            case "Chicken":{
                categoryId=2;
                break;
            }
            case "Sushi":{
                categoryId=3;
                break;
            }
            case "Meat":{
                categoryId=4;
                break;
            }
            case "Hotdog":{
                categoryId=5;
                break;
            }
            case "Drink":{
                categoryId=6;
                break;
            }
            case "More":{
                categoryId=7;
                break;
            }
        }
        searchText=getIntent().getStringExtra("text");
        isSearch=getIntent().getBooleanExtra("isSearch",false);

        binding.titleTxt.setText(categoryName);
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}