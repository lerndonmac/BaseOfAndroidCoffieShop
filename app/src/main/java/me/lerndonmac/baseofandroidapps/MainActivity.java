package me.lerndonmac.baseofandroidapps;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView qounterView;
    private TextView priceTextView;
    private int qounter = 0;
    private String massage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonAdd = findViewById(R.id.button);
        qounterView = findViewById(R.id.qounterTextView);
        priceTextView = findViewById(R.id.PriceTextView);
        Button plussBut = findViewById(R.id.buttonPluss);
        Button minBut = findViewById(R.id.buttonMinus);
        plussBut.setOnClickListener(view -> increment());
        minBut.setOnClickListener(view -> dicremint());
        buttonAdd.setOnClickListener(view -> submitOrder());
    }
    private void increment(){
        qounter += 1;
        qounterView.setText(String.valueOf(qounter));
        displayPrice(qounter);
    }
    private void dicremint(){
        qounter -= 1;
        qounterView.setText(String.valueOf(qounter));
        displayPrice(qounter);
    }
    @SuppressLint("SetTextI18n")
    private void displayPrice(int qounter){
        if (qounter == 0){
            massage = "Free";
        }else {
            massage = "Total price : $"+qounter*5+"\n Thanks for order";
        }
        priceTextView.setText(massage);
    }
    private void submitOrder(){
        String email = "fadeev_dima2001@mail.ru";
        sendEmail(email);
    }

    @SuppressLint("IntentReset")
    private void sendEmail(String emailAddress){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/plaint");
        intent.putExtra(Intent.EXTRA_SUBJECT, "price of coff");
        intent.putExtra(Intent.EXTRA_TEXT, massage);
        intent.setData(Uri.parse("mailto:"+emailAddress));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}