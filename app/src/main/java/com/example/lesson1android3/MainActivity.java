package com.example.lesson1android3;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lesson1android3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements CounterContracts.CounterView {
    ActivityMainBinding binding;
    CounterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new CounterPresenter();
        presenter.attachView(this);
        initListeners();

    }
    private void initListeners() {
        binding.btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.increment();
                presenter.sendMassage();

            }
        });
        binding.btnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.decrement();
                presenter.sendMassage();

            }
        });
        binding.btnMassage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.sendMassage();
                presenter.decrement();

            }
        });
    }

    @Override
    public void updateCounter(int count) {
        binding.numberTv.setText(String.valueOf(count));

    }

    @Override
    public void greenText() {
        binding.numberTv.setTextColor(Color.parseColor("#07E510"));

    }

    @Override
    public void showMassage(String massage) {
        Toast.makeText(this, massage, Toast.LENGTH_SHORT).show();

    }
}