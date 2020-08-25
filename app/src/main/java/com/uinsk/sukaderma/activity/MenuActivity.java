package com.uinsk.sukaderma.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.uinsk.sukaderma.R;

public class MenuActivity extends AppCompatActivity {

    private Button btnZakat, btnInfaq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnZakat = findViewById(R.id.btn_zakat);
        btnInfaq = findViewById(R.id.btn_infaq);

        btnZakat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MenuActivity.this, PantiActivity.class);
                intent.putExtra(PantiActivity.EXTRA_NAME, "zakat");
                startActivity(intent);
            }
        });

        btnInfaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MenuActivity.this, PantiActivity.class);
                intent.putExtra(PantiActivity.EXTRA_NAME, "infaq");
                startActivity(intent);
            }
        });
    }



}