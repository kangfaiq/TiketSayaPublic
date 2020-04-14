package net.fortinity.tiketsaya;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TicketCheckoutAct extends AppCompatActivity {

    Button btn_buy_ticket, btnmines, btnplus;
    TextView textjumlahtiket, texttotalharga, textmybalance;
    Integer valJumlahTiket = 1;
    Integer myBalance = 200;
    Integer valTotalHarga = 0;
    Integer valHargaTiket = 75;
    ImageView notice_uang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_checkout);

        btnmines = findViewById(R.id.btnmines);
        btnplus = findViewById(R.id.btnplus);
        textjumlahtiket = findViewById(R.id.textjumlahtiket);

        texttotalharga = findViewById(R.id.texttotalharga);
        textmybalance = findViewById(R.id.textmybalance);

        btn_buy_ticket = findViewById(R.id.btn_buy_ticket);

        notice_uang = findViewById(R.id.notice_uang);

        // setting value baru untuk beberapa komponen
        textjumlahtiket.setText(valJumlahTiket.toString());
        textmybalance.setText("US$ " + myBalance + "");
        valTotalHarga = valHargaTiket * valJumlahTiket;
        texttotalharga.setText("US$ " + valTotalHarga + "");

        // secara default, hide btnmines
        btnmines.animate().alpha(0).setDuration(300).start();
        btnmines.setEnabled(false);
        notice_uang.setVisibility(View.GONE);

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valJumlahTiket += 1;
                textjumlahtiket.setText(valJumlahTiket.toString());
                if (valJumlahTiket > 1) {
                    btnmines.animate().alpha(1).setDuration(300).start();
                    btnmines.setEnabled(true);
                }

                valTotalHarga = valHargaTiket * valJumlahTiket;
                texttotalharga.setText("US$ " + valTotalHarga + "");

                if (valTotalHarga > myBalance) {
                    btn_buy_ticket.animate().translationY(250)
                            .alpha(0).setDuration(350).start();
                    btn_buy_ticket.setEnabled(false);
                    textmybalance.setTextColor(Color.parseColor("#D1206B"));
                    notice_uang.setVisibility(View.VISIBLE);
                }
            }
        });

        btnmines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valJumlahTiket -= 1;
                textjumlahtiket.setText(valJumlahTiket.toString());
                if (valJumlahTiket < 2) {
                    btnmines.animate().alpha(0).setDuration(300).start();
                    btnmines.setEnabled(false);
                }

                valTotalHarga = valHargaTiket * valJumlahTiket;
                texttotalharga.setText("US$ " + valTotalHarga + "");

                if (valTotalHarga < myBalance) {
                    btn_buy_ticket.animate().translationY(0)
                            .alpha(1).setDuration(350).start();
                    btn_buy_ticket.setEnabled(true);
                    textmybalance.setTextColor(Color.parseColor("#203DD1"));
                    notice_uang.setVisibility(View.GONE);
                }
            }
        });

        btn_buy_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotosuccessbuyticket = new Intent(TicketCheckoutAct.this, SuccessBuyTicketAct.class);
                startActivity(gotosuccessbuyticket);
            }
        });
    }
}
