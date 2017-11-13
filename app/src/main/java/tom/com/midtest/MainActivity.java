package tom.com.midtest;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int max = 100;
    int min = 0;
    Random ran = new Random();
    int r = ran.nextInt(99) + 1;

    public void send(View view) {
        Button bSend = (Button) findViewById(R.id.b_send);

        EditText edNumber = (EditText) findViewById(R.id.ed_number);    /*抓輸入進去的數字*/
        int count = Integer.parseInt(edNumber.getText().toString());            /*將 EditText 轉為 int*/

        if (count == r) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("遊戲結果")
                    .setMessage("猜對了")
                    .setPositiveButton("確定", null)
                    .show();
        }
        if (count >= max) {
            Toast.makeText(MainActivity.this, "請重新輸入一個更小的數字", Toast.LENGTH_SHORT).show();
        }
        if (count <= min) {
            Toast.makeText(MainActivity.this, "請重新輸入一個更大的數字", Toast.LENGTH_SHORT).show();
        }
        while (count > r && count > min && count < max) {
            Toast.makeText(MainActivity.this, "小一點", Toast.LENGTH_SHORT).show();
            TextView number100 = (TextView) findViewById(R.id.number_100);
            String s = String.valueOf(count);
            number100.setText(s);
            break;
        }
        while (count < r && count > min && count < max) {
            Toast.makeText(MainActivity.this, "大一點", Toast.LENGTH_SHORT).show();
            TextView number0 = (TextView) findViewById(R.id.number_0);
            String s = String.valueOf(count);
            number0.setText(s);
            break;
        }
    }


    public void info(View view) {
        Button bInfo = (Button) findViewById(R.id.b_info);
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("遊戲規則如下")
                .setMessage("遊戲內容xxxxxxxxxxxxxx")
                .setPositiveButton("了解", null)
                .show();
    }
}
