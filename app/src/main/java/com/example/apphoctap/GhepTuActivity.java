package com.example.apphoctap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apphoctap.DatasourceConst.DataBaseCommon;
import com.example.apphoctap.model.GhepTu;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GhepTuActivity extends AppCompatActivity {
    private LinearLayout line1;
    private TextView tvResu;
    private Button btnRest;
    private ImageView imageView;
    private List<GhepTu> listgheptu;
    private String resu = "";
    int score=0;

    int totalQuestion = DataBaseCommon.getListNhinVat().size();

    int currentQuestionIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghep_tu);
        line1 = findViewById(R.id.line1);
        tvResu = findViewById(R.id.textresu);
        btnRest = findViewById(R.id.btnReset);
        imageView = findViewById(R.id.imageView);

        listgheptu = DataBaseCommon.getListNhinVat();

        ArrayList<TextView> ab = new ArrayList<TextView>();

        loadCauhoi();

        btnRest.setOnClickListener(view -> {
            String tmp = btnRest.getText().toString();
            if (tmp.equals("Подтвердить")) {
                line1.removeAllViews();
                loadCauhoi();
                tvResu.setText("");
            }else {
                currentQuestionIndex++;
                tvResu.setText("");
                loadCauhoi();
            }
        });

    }

    void finishQuiz(){
        new AlertDialog.Builder(this)
                .setTitle("Уведомление")
                .setMessage("Вы решили все вопросы")
                /*.setPositiveButton("ПОВТОРИТЬ",(dialogInterface, i) -> restartQuiz() )*/
                .setNegativeButton("ВЫЙТИ ИЗ ИГРЫ",(dialogInterface, i) -> finish() )
                .setCancelable(false)
                .show();
    }

    void restartQuiz(){
        currentQuestionIndex =0;
        loadCauhoi();
    }

    private void loadCauhoi() {
        resu = "";
        btnRest.setText("Подтвердить");
        tvResu.setTextColor(Color.BLACK);
        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            return;
        }


        imageView.setImageResource(listgheptu.get(currentQuestionIndex).getIamge());
        ArrayList<TextView> ab = new ArrayList<TextView>();
        String a[] = listgheptu.get(currentQuestionIndex).getCauhoi().split("");
        for (String b : a ) {
            if (!b.isEmpty()) {
                TextView tv = new TextView(this);
                tv.setText(b);
                tv.setBackgroundResource(R.drawable.customer_text);
                tv.setTextColor(Color.BLACK);
                tv.setTextSize(35);
                tv.setPadding(5,5,5,5);
                ab.add(tv);
                TextView tv1 = new TextView(this);
                tv1.setText("  ");
                ab.add(tv1);

            }
        }
        for (TextView b : ab) {
            line1.addView(b);
            b.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    //String str = "CORRECT";
                    String te = b.getText().toString();
                    if (!"  ".equals(te)) {
                        line1.removeView(b);
                        resu+=te;
                        tvResu.setText(resu);
                        String tmp = resu.trim();

                        if (tmp.equals(listgheptu.get(currentQuestionIndex).getDapan())) {
                            score++;
                            MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.correct);
                            mediaPlayer.start();
                            tvResu.setTextColor(Color.GREEN);
                            //Toast.makeText(GhepTuActivity.this, str, Toast.LENGTH_SHORT).show();
                            FancyToast.makeText(GhepTuActivity.this, "Ответить правильно !", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();


                            btnRest.setText("СЛЕДУЮЩИЙ");
                        }
                    }
                }
            });
        };
    }

    void finishQuizz2(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Пройденный";
        }else{
            passStatus = "Неудачный";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("баллов: "+ score+" из "+ totalQuestion)
                /*.setPositiveButton("ПОВТОРИТЬ",(dialogInterface, i) -> restartQuiz() )*/
                .setNegativeButton("ВЫЙТИ ИЗ ИГРЫ",(dialogInterface, i) -> finish() )
                /*.setCancelable(false)*/
                .show();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Уведомление")
                .setMessage("Хотите выйти из этой игры ?")
                /*.setPositiveButton("ПОВТОРИТЬ",(dialogInterface, i) -> restartQuiz() )*/
                .setNegativeButton("ДА",(dialogInterface, i) -> finishQuizz2() )
                .setPositiveButton("НЕТ",(dialogInterface, i) -> onVisibleBehindCanceled() )
                .setCancelable(false)
                .show();


    }

//    @Override
//    public void onBackPressed() {
//        new AlertDialog.Builder(this)
//                .setTitle("УВЕДОМЛЕНИЕ")
//                .setMessage("Хотите выйти из этого теста ?")
//                .setPositiveButton("НЕТ",(dialogInterface, i) -> onVisibleBehindCanceled() )
//                /* .setPositiveButton("ПОВТОРИТЬ",(dialogInterface, i) -> restartQuiz() )*/
//                .setNegativeButton("ДА",(dialogInterface, i) -> finishQuiz() )
//                .setCancelable(false)
//                .show();
//    }
}