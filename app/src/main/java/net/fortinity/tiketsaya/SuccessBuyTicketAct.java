package net.fortinity.tiketsaya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SuccessBuyTicketAct extends AppCompatActivity {

    Button btn_my_dashboard, btn_view_ticket;
    Animation app_splash, btt, ttb;
    TextView app_title, app_subtitle;
    ImageView icon_success_ticket;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_buy_ticket);

        btn_view_ticket = findViewById(R.id.btn_view_ticket);
        app_title = findViewById(R.id.app_title);
        app_subtitle = findViewById(R.id.app_subtitle);
        icon_success_ticket = findViewById(R.id.icon_success_ticket);
        btn_my_dashboard = findViewById(R.id.btn_my_dashboard);

        // load animation
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);
        ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);

        // run animation
        icon_success_ticket.startAnimation(app_splash);

        app_title.startAnimation(ttb);
        app_subtitle.startAnimation(ttb);

        btn_view_ticket.startAnimation(btt);
        btn_my_dashboard.startAnimation(btt);

        btn_my_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotodashboard = new Intent(SuccessBuyTicketAct.this, HomeAct.class);
                startActivity(gotodashboard);
            }
        });
    }
}
