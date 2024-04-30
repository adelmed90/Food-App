package dz.mradel.foodapp.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

import dz.mradel.foodapp.Domain.Foods;
import dz.mradel.foodapp.R;
import dz.mradel.foodapp.databinding.ActivityDetailBinding;

public class DetailActivity extends BaseActivity {
    ActivityDetailBinding binding;
    private Foods object;
    private int num=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getIntentExtra();
        setVariable();
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(view -> {finish();});

        Glide.with(DetailActivity.this)
                .load(object.getImagePath())
                .into(binding.pic);

        binding.priceTxt.setText(object.getPrice()+"$");
        binding.titleTxt.setText(object.getTitle());
        binding.descriptionTxt.setText(object.getDescription());
        binding.rateTxt.setText(object.getStar()+" Rating");
        binding.ratingBar.setRating((float) object.getStar());
        binding.totalTxt.setText(num*object.getPrice()+"$");
        binding.timeTxt.setText(object.getTimeValue()+" min");

    }

    private void getIntentExtra() {
        object=(Foods) getIntent().getSerializableExtra("object");
    }
}