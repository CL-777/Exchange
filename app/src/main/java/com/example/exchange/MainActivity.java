package com.example.exchange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements Runnable{

    EditText aaa;
    TextView bbb;

    public String str;
    public Float a;

    Intent intent;
    //Bundle bun;
    Float dol;Float eur;Float won;

    public SharedPreferences shp;

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //aaa =(EditText) findViewById(R.id.aaa);
        //bbb =(TextView)findViewById(R.id.bbb);
        //str=aaa.getText().toString();
        //a = Double.parseDouble(str);
        /*Button b1 = findViewById(R.id.b1);
        final Button b2 = findViewById(R.id.b2);
        final Button b3 = findViewById(R.id.b3);
        final Button b4 = findViewById(R.id.b4);*/
        //Double dol = 7.12;Double eur = 7.82;Double won = 0.006;

        shp = getSharedPreferences("test",MainActivity.MODE_PRIVATE);
        //out.setText(info);
        dol = shp.getFloat("dol",0.0f);
        eur = shp.getFloat("eur",0.0f);
        won = shp.getFloat("won",0.0f);

        handler = new Handler(){
            @Override
            public void handleMessage( Message msg) {
                super.handleMessage(msg);
            }
        };

        Thread t = new Thread();
    }

    public void b1(View v){
        //onActivityResult(RESULT_OK,1,intent)

        //SharedPreferences shp1= getSharedPreferences("shp", 0);
        //Float dol1 = shp1.getFloat("dol",dol);

        aaa = (EditText) findViewById(R.id.aaa);
        bbb = (TextView) findViewById(R.id.bbb);
        str=aaa.getText().toString();
        a = Float.parseFloat(str);
        String tag = dol +"111";
        Log.i(tag,dol + "111");
        //a = a * dol1;
        String s = String.valueOf(a);
        Log.i(tag,dol + "111");
        bbb.setText(""+a*dol );
        Log.i(tag,dol + "111");


    }

    public void b2(View v){
        //onActivityResult(RESULT_OK,1,intent);

        //SharedPreferences shp1= getSharedPreferences("shp", 0);
        //float eur1 = shp1.getFloat("eur",eur);

        aaa = (EditText) findViewById(R.id.aaa);
        bbb = (TextView) findViewById(R.id.bbb);
        str=aaa.getText().toString();
        a = Float.parseFloat(str);
        //a = a * eur;
        bbb.setText(""+a* eur);


    }

    public void b3(View v){
        //onActivityResult(RESULT_OK,1,intent);

        //SharedPreferences shp1= getSharedPreferences("shp", 0);
        //float won1 = shp1.getFloat("won",won);

        aaa = (EditText) findViewById(R.id.aaa);
        bbb = (TextView) findViewById(R.id.bbb);
        str=aaa.getText().toString();
        a = Float.parseFloat(str);
        //a = a * won;
        bbb.setText(""+a* won);


    }

    public void b4(View v){
        //str=aaa.getText().toString();
        //a = Double.parseDouble(str);
        startActivityForResult(new Intent(MainActivity.this, Main2Activity.class), 1);
        onActivityResult(RESULT_OK,1,intent);
        String tag = dol +"111";
        Log.i(tag,dol + "111");
        //bun = getIntent().getExtras();
        //startActivity(intent);
        //onActivityResult(RESULT_OK,1,intent);
        //dol = bun.getDouble("dol");
        //eur = bun.getDouble("eur");
        //won = bun.getDouble("won");


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) { //resultCode为回传的标记，我在B中回传的是RESULT_OK
            case RESULT_OK:
                Bundle bun = data.getExtras(); //data为B中回传的Intent
                dol = bun.getFloat("dol");

                String tag = dol +"111";
                Log.i(tag,dol + "111");

                eur = bun.getFloat("eur");
                won = bun.getFloat("won");//str即为回传的值
                break;
            default:
                break;
        }
        SharedPreferences.Editor editor = shp.edit();
        editor.putFloat("dol",dol);editor.putFloat("eur",eur);editor.putFloat("won",won);
        editor.commit();
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuItem menuItem = menu.add(0, 0, 0, "菜单111111111111111111111");

// MenuItem.setIcon() - 设置菜单项的图标
// MenuItem.setTitleCondensed() - 菜单的简标题，如果指定了简标题的话，菜单项上的标题将会以此简标题为准
// MenuItem.setAlphabeticShortcut() - 设置选中此菜单项的快捷键
// 注：菜单项超过 6 个的话，第 6 个菜单将会变为 More 菜单，多余的菜单会在单击 More 菜单之后显示出来
        //menuItem.setIcon(R.drawable.icon01);
        menuItem.setTitleCondensed("菜单1");
        menuItem.setAlphabeticShortcut('a');

        //menu.add(0, 1, 1, "菜单2").setIcon(R.drawable.icon02);
        //menu.add(0, 2, 2, "菜单3").setIcon(R.drawable.icon03);
        menu.add(0, 3, 3, "菜单4");
        menu.add(0, 4, 4, "菜单5");
        menu.add(0, 5, 5, "菜单6");
        //menu.add(0, 6, 6, "菜单7").setIcon(R.drawable.icon04);
        //menu.add(0, 7, 7, "菜单8").setIcon(R.drawable.icon05);

        return true;
    }

    // 重写 onOptionsItemSelected 用以响应选项菜单
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        Toast.makeText(MainActivity.this, "被单击的菜单项为：" + String.valueOf(item.getItemId()), Toast.LENGTH_SHORT).show();

        return false;
    }

    @Override
    public void run() {
        Message msg = handler.obtainMessage(5);
        msg.obj = "";
        handler.sendMessage(msg);

        URL url = null;
        try {
            url = new URL("http://www.usd-cny.com/icbc.htm");
            HttpURLConnection http=(HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
