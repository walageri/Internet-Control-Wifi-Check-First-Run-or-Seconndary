package com.blogspot.programer27android.internetcheck;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends ConnectCheck{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //caraDua();
        internet();
        Boolean isFirstRun=getSharedPreferences("PREFERENCE",MODE_PRIVATE).getBoolean("isfirstrun",true);
        if(isFirstRun){
            Toast.makeText(this, "Pertama", Toast.LENGTH_SHORT).show();
            getSharedPreferences("PREFERENCE",MODE_PRIVATE).edit().putBoolean("isfirstrun",false).commit();
        }else{
            Toast.makeText(this,"kali kedua",Toast.LENGTH_LONG).show();
        }

    }
    public void caraDua(){
        SharedPreferences pf=getSharedPreferences("prf",MODE_PRIVATE);
        Boolean start=pf.getBoolean("first",true);
        if (start){
            Toast.makeText(this, "pertama", Toast.LENGTH_SHORT).show();
            pf.edit().putBoolean("first",false).apply();
        }

    }
}
