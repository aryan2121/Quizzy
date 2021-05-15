package com.amanaryan.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
int index;
TextView Questiontxt,Truetxt,Falsetxt,Scoretxt;
ArrayList indexarray=new ArrayList();
String ans;
int previousindex;
int score=0;
    int arrint=0;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Questiontxt=findViewById(R.id.questiontxt);
        Truetxt=findViewById(R.id.truetxt);
        Falsetxt=findViewById(R.id.falsetxt);
        Scoretxt=findViewById(R.id.scoretxt);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        getWindow().setStatusBarColor(this.getResources().getColor(R.color.white));
    }

//int l=(Integer)R.integer.arraylength;
        Integer[] arr=new Integer[14];
//    ArrayList arr =new ArrayList<Integer>();
        for (int i=0;i<arr.length;i++){
            arr[i]=i;
        }

        Collections.shuffle(Arrays.asList(arr));
        ChangeQuestion(arr[arrint]);
Truetxt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (ans.contains("T")){
           score++;
        }else{
            Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
        }
if (arrint<10) {
    ChangeQuestion(arr[arrint++]);
}else{
    Intent intent=new Intent(getApplicationContext(),endpage.class);
    intent.putExtra("s",score+"");
    startActivity(intent);}

    }
});
Falsetxt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (ans.contains("F")){
            score++;
        }else{
            Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
        }

        if (arrint<10) {
            ChangeQuestion(arr[arrint++]);
        }else{
            Intent intent=new Intent(getApplicationContext(),endpage.class);
            intent.putExtra("s",score+"");
            startActivity(intent);
        }

    }
});

}

    private void ChangeQuestion(int x) {
        Scoretxt.setText(score+"/10");
        String[] question=getResources().getStringArray(R.array.questionsarray);
        String[] answer=getResources().getStringArray(R.array.answerarray);
        Questiontxt.setText(question[x].toString());
        ans=answer[x].toString();
    }
}