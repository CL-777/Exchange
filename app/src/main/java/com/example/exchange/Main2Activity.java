package com.example.exchange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    //TextView aaaa;
    EditText bbbb;
    EditText cccc;
    EditText dddd;
    //Button button;
    public Intent intent;

    Float dol;Float eur;Float won;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void button(View v){
        bbbb =(EditText) findViewById(R.id.bbbb);
        cccc =(EditText) findViewById(R.id.cccc);
        dddd =(EditText) findViewById(R.id.dddd);
        dol = Float.parseFloat( bbbb.getText().toString());
        eur = Float.parseFloat( cccc.getText().toString());
        won = Float.parseFloat( dddd.getText().toString());

        intent=new Intent(Main2Activity.this,MainActivity.class);
        Bundle bun = new Bundle();
        bun.putFloat("dol",dol);bun.putFloat("eur",eur);bun.putFloat("won",won);
        intent.putExtras(bun);
        setResult(RESULT_OK, intent);
        finish();
    }
}
