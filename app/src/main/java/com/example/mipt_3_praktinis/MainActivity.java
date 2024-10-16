package com.example.mipt_3_praktinis;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvSolution;
    Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    Button btnPlus, btnMinus, btnDivide, btnMultiply;
    Button btnMC, btnMR, btnMS, btnMPlus, btnMMinus, btnBack, btnCE, btnC, btnPlusMinus, btnSquareRoot, btnPercentage, btnDivideOneByX, btnDot, btnEquals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSolution = findViewById(R.id.tvSolution);

        assignId(btnZero, R.id.btnZero);
        assignId(btnOne, R.id.btnOne);
        assignId(btnTwo, R.id.btnTwo);
        assignId(btnThree, R.id.btnThree);
        assignId(btnFour, R.id.btnFour);
        assignId(btnFive, R.id.btnFive);
        assignId(btnSix, R.id.btnSix);
        assignId(btnSeven, R.id.btnSeven);
        assignId(btnEight, R.id.btnEight);
        assignId(btnNine, R.id.btnNine);

        assignId(btnPlus, R.id.btnPlus);
        assignId(btnMinus, R.id.btnMinus);
        assignId(btnMultiply, R.id.btnMultiply);
        assignId(btnDivide, R.id.btnDivide);

        assignId(btnMC, R.id.btnMC);
        assignId(btnMR, R.id.btnMR);
        assignId(btnMS, R.id.btnMS);
        assignId(btnMPlus, R.id.btnMPlus);
        assignId(btnMMinus, R.id.btnMMinus);
        assignId(btnBack, R.id.btnBack);
        assignId(btnCE, R.id.btnCE);
        assignId(btnC, R.id.btnC);
        assignId(btnPlusMinus, R.id.btnPlusMinus);
        assignId(btnSquareRoot, R.id.btnSquareRoot);
        assignId(btnPercentage, R.id.btnPercentage);
        assignId(btnDivideOneByX, R.id.btnDivideOneByX);
        assignId(btnDot, R.id.btnDot);
        assignId(btnEquals, R.id.btnEquals);
    }

    void assignId(Button btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = tvSolution.getText().toString();


        if (button.getId() == R.id.btnEquals) {
            calculateResult(dataToCalculate);
            return;
        }

        if (button.getId() == R.id.btnC) {
            tvSolution.setText("0");
            return;
        }

        if (button.getId() == R.id.btnBack){
            if (dataToCalculate.length() > 0) {
                dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
                tvSolution.setText(dataToCalculate);
            }
            if (dataToCalculate.length() == 0) {tvSolution.setText("0");}
            return;
        }

        if (dataToCalculate.equals("0") || dataToCalculate.equals("Error")) {
            dataToCalculate = "";
        }

        if (button.getId() == R.id.btnPlusMinus) {
            if (!dataToCalculate.equals("0") && !dataToCalculate.equals("Error")) {
                int lastOperatorIndex = Math.max(
                        dataToCalculate.lastIndexOf('+'),
                        Math.max(
                                dataToCalculate.lastIndexOf('-'),
                                Math.max(
                                        dataToCalculate.lastIndexOf('*'),
                                        dataToCalculate.lastIndexOf('/')
                                )
                        )
                );

                String lastNumber;
                if (lastOperatorIndex == -1) {
                    lastNumber = dataToCalculate;
                } else {
                    lastNumber = dataToCalculate.substring(lastOperatorIndex + 1);
                }

                if (lastNumber.startsWith("-")) {
                    lastNumber = lastNumber.substring(1);
                } else {
                    lastNumber = "-" + lastNumber;
                }

                if (lastOperatorIndex == -1) {
                    dataToCalculate = lastNumber;
                } else {
                    dataToCalculate = dataToCalculate.substring(0, lastOperatorIndex + 1) + lastNumber;
                }

                dataToCalculate = dataToCalculate.replace("+-", "-")
                        .replace("++", "+")
                        .replace("--", "+")
                        .replace("-+", "-");

                if(dataToCalculate.startsWith("+")) {
                    dataToCalculate = dataToCalculate.substring(1);
                }

                tvSolution.setText(dataToCalculate);
            }
            return;
        }



        dataToCalculate = dataToCalculate + buttonText;
        tvSolution.setText(dataToCalculate);
    }

    private void calculateResult(String dataToCalculate) {
        try {
            Expression expression = new Expression(dataToCalculate);
            double result = expression.calculate();

            if (Double.isNaN(result)) {
                tvSolution.setText("Error");
            } else {
                if (result == (int) result) {
                    tvSolution.setText(String.valueOf((int) result));
                } else {
                    tvSolution.setText(String.valueOf(result));
                }
            }
        } catch (Exception e) {
            tvSolution.setText("Error");
        }
    }
}
