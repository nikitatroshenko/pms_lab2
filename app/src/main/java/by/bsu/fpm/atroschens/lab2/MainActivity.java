package by.bsu.fpm.atroschens.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public EditText etTry;
    public Button btnTry;
    public TextView tvResponse;
    private final int theNumber;
    private boolean gameOver;

    {
        theNumber = new Random().nextInt(100);
        gameOver = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
    }

    private void bindViews() {
        etTry = (EditText) findViewById(R.id.textNumber);
        btnTry = (Button) findViewById(R.id.btnTry);
        tvResponse = (TextView) findViewById(R.id.textViewResponse);
    }

    protected void onBtnTryClick(View v) {
        if (gameOver) {
            this.finishAffinity();
            System.exit(0);
        }

        try {
            int n = Integer.parseInt(etTry.getText().toString());

            if (n < 0 || n > 100) {
                tvResponse.setText(R.string.out_of_range);
            }
            if (n > theNumber) {
                tvResponse.setText(R.string.guessed_greater);
            } else if (n < theNumber) {
                tvResponse.setText(R.string.guessed_less);
            } else {
                tvResponse.setText(R.string.guessed_equal);
                gameOver = true;
                btnTry.setText(R.string.quit_btn_capt);
            }
        } catch (NumberFormatException ex) {
            tvResponse.setText(R.string.number_format_err_msg);
        }
    }
}
