package com.example.micha.mappe3s300378;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> pureinput = new ArrayList<String>();
    public static ArrayList<String> convertedinput = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE | ActionBar.DISPLAY_USE_LOGO);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_screen_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.buttonSettings:
                startActivity(new Intent(this, Settings.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void sButton(View view) {
        inputInterp();
        String msg = "";
        for (int i=0;i<convertedinput.size(); i++ ){
            msg = msg + convertedinput.get(i) + " ";
        }
        toastMessageLong(msg);
        codeView();
    }

    private void codeView(){
        Log.d("myTag", "CodeView");
        String msg = "";
        TextView raw = findViewById(R.id.rawView);

        for (int i=0;i<convertedinput.size(); i++ ){

            Log.d("myTag", "For1");
            String tmp[] = convertedinput.get(i).split("");
            for (int o=0; o<tmp.length; o++){

                Log.d("myTag", "For2");
                if (tmp[o].equals("1")){
                    msg = msg + "-";
                }
                if (tmp[o].equals("0")){
                    msg = msg + ".";
                }
                if (tmp[o].equals("s")){
                    msg = msg + "  ";
                }
            }
            msg = msg + "  ";
        }

        Log.d("myTag", "END");
        raw.setText(msg);
    }

    private void inputInterp(){
        pureinput.clear();
        convertedinput.clear();
        EditText imputEdit = findViewById(R.id.plainText);
        String[] imptos = imputEdit.getText().toString().split("");
        pureinput = new ArrayList<String>(Arrays.asList(imptos));

        //0 = Dot
        //1 = Dash
        for (int i=0; i<pureinput.size(); i++) {
            String letter = imptos[i];

            if ((letter.equals(" "))){
                convertedinput.add("s");
            }
            if (letter.equals("A") || letter.equals("a")){
                convertedinput.add("01");
            }
            if (letter.equals("B") || letter.equals("b")){
                convertedinput.add("1000");
            }
            if (letter.equals("C") || letter.equals("c")){
                convertedinput.add("1010");
            }
            if (letter.equals("D") || letter.equals("d")){
                convertedinput.add("100");
            }
            if (letter.equals("E") || letter.equals("e")){
                convertedinput.add("0");
            }
            if (letter.equals("F") || letter.equals("f")){
                convertedinput.add("0010");
            }
            if (letter.equals("G") || letter.equals("g")){
                convertedinput.add("110");
            }
            if (letter.equals("H") || letter.equals("h")){
                convertedinput.add("0000");
            }
            if (letter.equals("I") || letter.equals("i")){
                convertedinput.add("00");
            }
            if (letter.equals("J") || letter.equals("j")){
                convertedinput.add("0111");
            }
            if (letter.equals("K") || letter.equals("k")){
                convertedinput.add("101");
            }
            if (letter.equals("L") || letter.equals("l")){
                convertedinput.add("0100");
            }
            if (letter.equals("M") || letter.equals("m")){
                convertedinput.add("11");
            }
            if (letter.equals("N") || letter.equals("n")){
                convertedinput.add("10");
            }
            if (letter.equals("O") || letter.equals("o")){
                convertedinput.add("111");
            }
            if (letter.equals("P") || letter.equals("p")){
                convertedinput.add("0110");
            }
            if (letter.equals("Q") || letter.equals("q")){
                convertedinput.add("1101");
            }
            if (letter.equals("R") || letter.equals("r")){
                convertedinput.add("010");
            }
            if (letter.equals("S") || letter.equals("s")){
                convertedinput.add("000");
            }
            if (letter.equals("T") || letter.equals("t")){
                convertedinput.add("1");
            }
            if (letter.equals("U") || letter.equals("u")){
                convertedinput.add("001");
            }
            if (letter.equals("V") || letter.equals("v")){
                convertedinput.add("0001");
            }
            if (letter.equals("W") || letter.equals("w")){
                convertedinput.add("011");
            }
            if (letter.equals("X") || letter.equals("x")){
                convertedinput.add("1001");
            }
            if (letter.equals("Y") || letter.equals("y")){
                convertedinput.add("1011");
            }
            if (letter.equals("Z") || letter.equals("z")){
                convertedinput.add("1100");
            }
            if (letter.equals("0")){
                convertedinput.add("11111");
            }
            if (letter.equals("1")){
                convertedinput.add("01111");
            }
            if (letter.equals("2")){
                convertedinput.add("000111");
            }
            if (letter.equals("3")){
                convertedinput.add("000011");
            }
            if (letter.equals("3")){
                convertedinput.add("00001");
            }
            if (letter.equals("4")){
                convertedinput.add("00000");
            }
            if (letter.equals("5")){
                convertedinput.add("10000");
            }
            if (letter.equals("6")){
                convertedinput.add("110000");
            }
            if (letter.equals("7")){
                convertedinput.add("11100");
            }
            if (letter.equals("9")){
                convertedinput.add("11110");
            }
            if (letter.equals(".")){
                convertedinput.add("010101");
            }
            if (letter.equals(",")){
                convertedinput.add("110011");
            }
            if (letter.equals("?")){
                convertedinput.add("001100");
            }
            if (letter.equals("'")){
                convertedinput.add("011110");
            }
            if (letter.equals("!")){
                convertedinput.add("101011");
            }
            if (letter.equals("/")){
                convertedinput.add("10010");
            }
            if (letter.equals("(")){
                convertedinput.add("10110");
            }
            if (letter.equals(")")){
                convertedinput.add("101101");
            }
            if (letter.equals(":")){
                convertedinput.add("111000");
            }
            if (letter.equals(";")){
                convertedinput.add("101010");
            }
            if (letter.equals("=")){
                convertedinput.add("10001");
            }
            if (letter.equals("+")){
                convertedinput.add("01010");
            }
            if (letter.equals("-")){
                convertedinput.add("100001");
            }
            if (letter.equals("_")){
                convertedinput.add("001101");
            }
            if (letter.equals("$")){
                convertedinput.add("0001001");
            }
            if (letter.equals("@")){
                convertedinput.add("011010");
            }
        }
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    private void toastMessageLong(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
