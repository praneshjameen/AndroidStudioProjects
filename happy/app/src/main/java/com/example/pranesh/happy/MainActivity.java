package com.example.pranesh.happy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        display(1);
        displayPrice(1*5);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.editText);
        quantityTextView.setText("" + number);

    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.txt2);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}
