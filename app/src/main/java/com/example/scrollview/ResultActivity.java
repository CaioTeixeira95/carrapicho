package com.example.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textViewResult = (TextView) findViewById(R.id.textViewResult);
        TextView textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        TextView textViewContent = (TextView) findViewById(R.id.textViewContent);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        String text = getString(R.string.result);
        int totalPoints = getIntent().getIntExtra("totalPoints", 0);

        if (totalPoints >= 0 && totalPoints <= 10) {
            imageView.setImageResource(R.drawable.delicious);
            textViewResult.setText(text + " " + totalPoints);
            textViewTitle.setText(R.string.zero_to_ten_title);
            textViewContent.setText(R.string.zero_to_ten_content);
        }
        else if (totalPoints >= 11 && totalPoints <= 20) {
            imageView.setImageResource(R.drawable.partiu_malhar);
            textViewResult.setText(text + " " + totalPoints);
            textViewTitle.setText(R.string.eleven_to_twenty_title);
            textViewContent.setText(R.string.eleven_to_twenty_content);
        }
        else if (totalPoints >= 21 && totalPoints <= 28) {
            imageView.setImageResource(R.drawable.good_body);
            textViewResult.setText(text + " " + totalPoints);
            textViewTitle.setText(R.string.twenty_one_to_twenty_eight_title);
            textViewContent.setText(R.string.twenty_one_to_twenty_eight_content);
        }
        else {
            imageView.setImageResource(R.drawable.fitness);
            textViewResult.setText(text + " " + totalPoints);
            textViewTitle.setText(R.string.twenty_nine_to_forty_title);
            textViewContent.setText(R.string.twenty_nine_to_forty_content);
        }

    }
}
