package com.example.apphoctap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apphoctap.DatasourceConst.DataBaseCommon;
import com.example.apphoctap.DatasourceConst.QuestionAnswer;
import com.example.apphoctap.model.GhepTu;
import com.example.apphoctap.model.Quizz;
import com.shashank.sony.fancytoastlib.FancyToast;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuizzActivity extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView;
    private List<Quizz> list;

    private String idtext = "";
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    int score=0;
    int totalQuestion = DataBaseCommon.getListQuizzText().size();
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        list = DataBaseCommon.getListQuizzText();
        Collections.shuffle(Arrays.asList(list));


        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Всего вопросов : "+totalQuestion);

        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn){
            String stateSubmit = submitBtn.getText().toString();
            if ("SUBMIT".equals(stateSubmit)) {
                String a  = ansA.getText().toString();
                String b  = ansB.getText().toString();
                String c  = ansC.getText().toString();
                String d  = ansD.getText().toString();

                if (a.equals(list.get(currentQuestionIndex).getDapan()) && !selectedAnswer.equals(a)) {
                    ansA.setBackgroundColor(Color.YELLOW);
                }

                if (b.equals(list.get(currentQuestionIndex).getDapan()) && !selectedAnswer.equals(b)) {
                    ansB.setBackgroundColor(Color.YELLOW);
                }

                if (c.equals(list.get(currentQuestionIndex).getDapan()) && !selectedAnswer.equals(c)) {
                    ansC.setBackgroundColor(Color.YELLOW);
                }

                if (d.equals(list.get(currentQuestionIndex).getDapan()) && !selectedAnswer.equals(d)) {
                    ansD.setBackgroundColor(Color.YELLOW);
                }


                if(selectedAnswer.equals(list.get(currentQuestionIndex).getDapan())){
                    score++;
                    MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
                    mediaPlayer.start();
                    FancyToast.makeText(this, "Ответить правильно + 1 баллов !", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();
                } else {
                    MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.sai);
                    mediaPlayer.start();
                    FancyToast.makeText(this, "Ответить неправильно", FancyToast.LENGTH_SHORT, FancyToast.ERROR, true).show();
                }
                ansA.setEnabled(false);
                ansB.setEnabled(false);
                ansC.setEnabled(false);
                ansD.setEnabled(false);
                submitBtn.setText("NEXT");
            } else {
                currentQuestionIndex++;
                loadNewQuestion();
                submitBtn.setText("SUBMIT");
                ansA.setEnabled(true);
                ansB.setEnabled(true);
                ansC.setEnabled(true);
                ansD.setEnabled(true);
            }


        }else{
            //choices button clicked
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }

    }



    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            return;
        }

        questionTextView.setText(list.get(currentQuestionIndex).getCauhoi());
        ansA.setText(list.get(currentQuestionIndex).getAnsA());
        ansB.setText(list.get(currentQuestionIndex).getAnsB());
        ansC.setText(list.get(currentQuestionIndex).getAnsC());
        ansD.setText(list.get(currentQuestionIndex).getAnsD());

    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Пройденный";
        }else{
            passStatus = "Неудачный";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("баллов: "+ score+" из "+ totalQuestion)
//                .setPositiveButton("THI LẠI",(dialogInterface, i) -> restartQuiz() )
                .setNegativeButton("ВЫЙТИ ИЗ ИГРЫ",(dialogInterface, i) -> finish() )
                .setCancelable(false)
                .show();
    }

    void restartQuiz(){
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        submitBtn.setText("SUBMIT");
        Collections.shuffle(Arrays.asList(list));
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("УВЕДОМЛЕНИЕ")
                .setMessage("Хотите выйти из этого теста ?")
                .setPositiveButton("НЕТ",(dialogInterface, i) -> onVisibleBehindCanceled() )
                .setNegativeButton("ДА",(dialogInterface, i) -> finishQuiz() )
                .setCancelable(false)
                .show();
    }
}