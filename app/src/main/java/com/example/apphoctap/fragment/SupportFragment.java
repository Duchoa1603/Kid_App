package com.example.apphoctap.fragment;

import static com.example.apphoctap.MainActivity.user;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apphoctap.R;

import androidx.preference.PreferenceFragmentCompat;

public class SupportFragment extends Fragment {
    private TextView tvname,tvemail;
    private Button feedback;






    public SupportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        Button feedback;
//         Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_support, container, false);
//        feedback = view.findViewById(R.id.button);
//        feedback.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Intent.ACTION_SENDTO);
//                String Uritext = "Mailto: " + Uri.encode("duchoa160399@gmail.com") + "?subject="+
//                        Uri.encode("Feedback") + "$body=" + Uri.encode("");
//                Uri uri = Uri.parse(Uritext);
//                intent.setData(uri);
//                startActivity(Intent.createChooser(intent,"Send email"));
//            }
//        });


        EditText edit1 = view.findViewById(R.id.edit1);
        EditText edit2 = view.findViewById(R.id.edit2);
        Button btn = view.findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(Intent.ACTION_SENDTO);
//                i.setType("massage/html");
//                i.putExtra(Intent.EXTRA_EMAIL,new String("duchoa160399@gmail.com"));
//                i.putExtra(Intent.EXTRA_SUBJECT,"Feedback from app");
//                i.putExtra(Intent.EXTRA_TEXT,"Name:"+edit1.getText()+"\n Message:"+edit2.getText());
//                try {
//                    startActivity(Intent.createChooser(i,"please select Email"));
//                }
//                catch (android.content.ActivityNotFoundException ex){
//                    Toast.makeText(getActivity(),"There are no Email Clients",Toast.LENGTH_SHORT).show();
//                }

                if(edit1.length() == 0){
                    edit1.setError("Введите ИМЯ");
                }
                else if(edit2.length()==0){
                    edit2.setError("Введите отзыв");
                }
                else{
                    Intent i = new Intent(Intent.ACTION_SENDTO);
                    i.setType("massage/html");
                    i.putExtra(Intent.EXTRA_EMAIL,new String("duchoa160399@gmail.com"));
                    i.putExtra(Intent.EXTRA_SUBJECT,"Отзыв от приложения");
                    i.putExtra(Intent.EXTRA_TEXT,"Name:"+edit1.getText()+"\n Message:"+edit2.getText());
                    try {
                        startActivity(Intent.createChooser(i,"Пожалуйста, выберите Электронная почта"));
                    }
                    catch (android.content.ActivityNotFoundException ex){
                        Toast.makeText(getActivity(),"Нет почтовых клиентов",Toast.LENGTH_SHORT).show();
                    }
                }


//                Intent intent = new Intent(Intent.ACTION_SENDTO);
//                String Uritext = "Mailto: " + Uri.encode("duchoa160399@gmail.com") + "?subject="+
//                        Uri.encode("Feedback") + "$body=" + Uri.encode("");
//                Uri uri = Uri.parse(Uritext);
//                intent.setData(uri);
//                startActivity(Intent.createChooser(intent,"Send email"));






            }
        });
        return view;

    }




}