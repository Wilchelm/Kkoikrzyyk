package com.example.kkoikrzyyk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private TextView textView2;
    private TextView button1;
    private TextView button2;
    private TextView button3;
    private TextView button4;
    private TextView button5;
    private TextView button6;
    private TextView button7;
    private TextView button8;
    private TextView button9;
    private Button reset;
    private Integer[][] matrix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        reset = findViewById(R.id.reset);

        matrix = new Integer[3][3];
        reset();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMovePossible() == true && matrix[0][0] == 0) {
                    button1.setText("X");
                    matrix[0][0] = 1;
                    if (tryOponentWin(matrix) == false) {
                        oponentMove(matrix);
                    }
                    winner();
                } else {
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Remis");
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMovePossible() == true && matrix[0][1] == 0) {
                    button2.setText("X");
                    matrix[0][1] = 1;
                    if (tryOponentWin(matrix)==false && whoIsWinner()!=1) {
                        oponentMove(matrix);
                    }
                    winner();
                } else {
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Remis");
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMovePossible() == true && matrix[0][2] == 0) {
                    button3.setText("X");
                    matrix[0][2] = 1;
                    if (tryOponentWin(matrix)==false && whoIsWinner()!=1) {
                        oponentMove(matrix);
                    }
                    winner();
                } else {
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Remis");
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMovePossible() == true && matrix[1][0] == 0) {
                    button4.setText("X");
                    matrix[1][0] = 1;
                    if (tryOponentWin(matrix)==false && whoIsWinner()!=1) {
                        oponentMove(matrix);
                    }
                    winner();
                } else {
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Remis");
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMovePossible() == true && matrix[1][1] == 0) {
                    button5.setText("X");
                    matrix[1][1] = 1;
                    if (tryOponentWin(matrix)==false && whoIsWinner()!=1) {
                        oponentMove(matrix);
                    }
                    winner();
                } else {
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Remis");
                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMovePossible() == true && matrix[1][2] == 0) {
                    button6.setText("X");
                    matrix[1][2] = 1;
                    if (tryOponentWin(matrix)==false && whoIsWinner()!=1) {
                        oponentMove(matrix);
                    }
                    winner();
                } else {
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Remis");
                }
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMovePossible() == true && matrix[2][0] == 0) {
                    button7.setText("X");
                    matrix[2][0] = 1;
                    if (tryOponentWin(matrix)==false && whoIsWinner()!=1) {
                        oponentMove(matrix);
                    }
                    winner();
                } else {
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Remis");
                }
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMovePossible() == true && matrix[2][1] == 0) {
                    button8.setText("X");
                    matrix[2][1] = 1;
                    if (tryOponentWin(matrix)==false && whoIsWinner()!=1) {
                        oponentMove(matrix);
                    }
                    winner();
                } else {
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Remis");
                }
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMovePossible() == true && matrix[2][2] == 0) {
                    button9.setText("X");
                    matrix[2][2] = 1;
                    if (tryOponentWin(matrix)==false && whoIsWinner()!=1) {
                        oponentMove(matrix);
                    }
                    winner();
                } else {
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Remis");
                }
            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

    }

    private void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = 0;
            }
        }

        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");

        textView.setVisibility(View.GONE);

        enableButtons();
    }


    private Integer whoIsWinner() {
        if (matrix[0][0] == 1 && matrix[0][1] == 1 && matrix[0][2] == 1) {
            button1.setText("-");
            button2.setText("-");
            button3.setText("-");
            return 1;
        }
        if (matrix[1][0] == 1 && matrix[1][1] == 1 && matrix[1][2] == 1) {
            button4.setText("-");
            button5.setText("-");
            button6.setText("-");
            return 1;
        }
        if (matrix[2][0] == 1 && matrix[2][1] == 1 && matrix[2][2] == 1) {
            button7.setText("-");
            button8.setText("-");
            button9.setText("-");
            return 1;
        }
        if (matrix[0][0] == 1 && matrix[1][0] == 1 && matrix[2][0] == 1) {
            button1.setText("|");
            button4.setText("|");
            button7.setText("|");
            return 1;
        }
        if (matrix[0][1] == 1 && matrix[1][1] == 1 && matrix[2][1] == 1) {
            button2.setText("|");
            button5.setText("|");
            button8.setText("|");
            return 1;
        }
        if (matrix[0][2] == 1 && matrix[1][2] == 1 && matrix[2][2] == 1) {
            button3.setText("|");
            button6.setText("|");
            button9.setText("|");
            return 1;
        }
        if (matrix[0][0] == 1 && matrix[1][1] == 1 && matrix[2][2] == 1) {
            button1.setText("\\");
            button5.setText("\\");
            button9.setText("\\");
            return 1;
        }
        if (matrix[0][2] == 1 && matrix[1][1] == 1 && matrix[2][0] == 1) {
            button3.setText("/");
            button5.setText("/");
            button7.setText("/");
            return 1;
        }
        if (matrix[0][0] == 2 && matrix[0][1] == 2 && matrix[0][2] == 2) {
            button1.setText("-");
            button2.setText("-");
            button3.setText("-");
            return 2;
        }
        if (matrix[1][0] == 2 && matrix[1][1] == 2 && matrix[1][2] == 2) {
            button4.setText("-");
            button5.setText("-");
            button6.setText("-");
            return 2;
        }
        if (matrix[2][0] == 2 && matrix[2][1] == 2 && matrix[2][2] == 2) {
            button7.setText("-");
            button8.setText("-");
            button9.setText("-");
            return 2;
        }
        if (matrix[0][0] == 2 && matrix[1][0] == 2 && matrix[2][0] == 2) {
            button1.setText("|");
            button4.setText("|");
            button7.setText("|");
            return 2;
        }
        if (matrix[0][1] == 2 && matrix[1][1] == 2 && matrix[2][1] == 2) {
            button2.setText("|");
            button5.setText("|");
            button8.setText("|");
            return 2;
        }
        if (matrix[0][2] == 2 && matrix[1][2] == 2 && matrix[2][2] == 2) {
            button3.setText("|");
            button6.setText("|");
            button9.setText("|");
            return 2;
        }
        if (matrix[0][0] == 2 && matrix[1][1] == 2 && matrix[2][2] == 2) {
            button1.setText("\\");
            button5.setText("\\");
            button9.setText("\\");
            return 2;
        }
        if (matrix[0][2] == 2 && matrix[1][1] == 2 && matrix[2][0] == 2) {
            button3.setText("/");
            button5.setText("/");
            button7.setText("/");
            return 2;
        } else {
            return 0;
        }
    }

    public void winner() {
        if (whoIsWinner() == 1) {
            textView.setVisibility(View.VISIBLE);
            textView.setText("X wygrał");
            disableButtons();
        }
        if (whoIsWinner() == 2) {
            textView.setVisibility(View.VISIBLE);
            textView.setText("O wygrał");
            disableButtons();
        }
    }

    public boolean isMovePossible() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void drawOponent(int a, int b) {
        if (a == 0 && b == 0) {
            matrix[a][b] = 2;
            button1.setText("O");
        }
        if (a == 0 && b == 1) {
            matrix[a][b] = 2;
            button2.setText("O");
        }
        if (a == 0 && b == 2) {
            matrix[a][b] = 2;
            button3.setText("O");
        }
        if (a == 1 && b == 0) {
            matrix[a][b] = 2;
            button4.setText("O");
        }
        if (a == 1 && b == 1) {
            matrix[a][b] = 2;
            button5.setText("O");
        }
        if (a == 1 && b == 2) {
            matrix[a][b] = 2;
            button6.setText("O");
        }
        if (a == 2 && b == 0) {
            matrix[a][b] = 2;
            button7.setText("O");
        }
        if (a == 2 && b == 1) {
            matrix[a][b] = 2;
            button8.setText("O");
        }
        if (a == 2 && b == 2) {
            matrix[a][b] = 2;
            button9.setText("O");
        }
    }

    public void oponentMove(Integer table[][]) {

        if (isMovePossible() == false) {
            textView.setVisibility(View.VISIBLE);
            textView.setText("Remis");
            disableButtons();
            return;
        }

        if (table[0][0] == 1 && table[0][1] == 1) {
            if (table[0][2] == 0) {
                drawOponent(0, 2);
                return;
            }
        }
        if (table[0][0] == 1 && table[1][1] == 1) {
            if (table[2][2] == 0) {
                drawOponent(2, 2);
                return;
            }
        }
        if (table[0][0] == 1 && table[1][0] == 1) {
            if (table[2][0] == 0) {
                drawOponent(2, 0);
                return;
            }
        }
        if (table[0][2] == 1 && table[0][1] == 1) {
            if (table[0][0] == 0) {
                drawOponent(0, 0);
                return;
            }
        }
        if (table[0][2] == 1 && table[1][1] == 1) {
            if (table[2][0] == 0) {
                drawOponent(2, 0);
                return;
            }
        }
        if (table[0][2] == 1 && table[1][2] == 1) {
            if (table[2][2] == 0) {
                drawOponent(2, 2);
                return;
            }
        }
        if (table[0][0] == 1 && table[2][0] == 1) {
            if (table[1][0] == 0) {
                drawOponent(1, 0);
                return;
            }
        }
        if (table[0][1] == 1 && table[2][1] == 1) {
            if (table[1][1] == 0) {
                drawOponent(1, 1);
                return;
            }
        }
        if (table[0][2] == 1 && table[2][2] == 1) {
            if (table[1][2] == 0) {
                drawOponent(1, 2);
                return;
            }
        }
        if (table[0][1] == 1 && table[1][1] == 1) {
            if (table[2][1] == 0) {
                drawOponent(2, 1);
                return;
            }
        }
        if (table[0][0] == 1 && table[2][2] == 1) {
            if (table[1][1] == 0) {
                drawOponent(1, 1);
                return;
            }
        }
        if (table[1][0] == 1 && table[1][1] == 1) {
            if (table[1][2] == 0) {
                drawOponent(1, 2);
                return;
            }
        }
        if (table[1][2] == 1 && table[1][1] == 1) {
            if (table[1][0] == 0) {
                drawOponent(1, 0);
                return;
            }
        }
        if (table[1][0] == 1 && table[1][2] == 1) {
            if (table[1][1] == 0) {
                drawOponent(1, 1);
                return;
            }
        }
        if (table[2][1] == 1 && table[1][1] == 1) {
            if (table[0][1] == 0) {
                drawOponent(0, 1);
                return;
            }
        }
        if (table[2][0] == 1 && table[1][0] == 1) {
            if (table[0][0] == 0) {
                drawOponent(0, 0);
                return;
            }
        }
        if (table[2][0] == 1 && table[1][1] == 1) {
            if (table[0][2] == 0) {
                drawOponent(0, 2);
                return;
            }
        }
        if (table[2][2] == 1 && table[1][2] == 1) {
            if (table[0][2] == 0) {
                drawOponent(0, 2);
                return;
            }
        }
        if (table[2][2] == 1 && table[1][1] == 1) {
            if (table[0][0] == 0) {
                drawOponent(0, 0);
                return;
            }
        }
        if (table[2][0] == 1 && table[2][1] == 1) {
            if (table[2][2] == 0) {
                drawOponent(2, 2);
                return;
            }
        }
        if (table[2][2] == 1 && table[2][1] == 1) {
            if (table[2][0] == 0) {
                drawOponent(2, 0);
                return;
            }
        }
        if (table[0][0] == 1 && table[0][2] == 1) {
            if (table[0][1] == 0) {
                drawOponent(0, 1);
                return;
            }
        }
        if (table[2][0] == 1 && table[2][2] == 1) {
            if (table[2][1] == 0) {
                drawOponent(2, 1);
                return;
            }
        }
        if (table[2][0] == 1 && table[0][2] == 1) {
            if (table[1][1] == 0) {
                drawOponent(1, 1);
                return;
            }
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (matrix[i][j] == 0) {
                        drawOponent(i, j);
                        return;
                    }
                }
            }
        }
    }

    public boolean tryOponentWin(Integer table[][]) {
        if (table[0][0] == 2 && table[0][1] == 2) {
            if (table[0][2] == 0) {
                drawOponent(0, 2);
                return true;
            }
        }
        if (table[0][0] == 2 && table[1][1] == 2) {
            if (table[2][2] == 0) {
                drawOponent(2, 2);
                return true;
            }
        }
        if (table[0][0] == 2 && table[1][0] == 2) {
            if (table[2][0] == 0) {
                drawOponent(2, 0);
                return true;
            }
        }
        if (table[0][2] == 2 && table[0][1] == 2) {
            if (table[0][0] == 0) {
                drawOponent(0, 0);
                return true;
            }
        }
        if (table[0][2] == 2 && table[1][1] == 2) {
            if (table[2][0] == 0) {
                drawOponent(2, 0);
                return true;
            }
        }
        if (table[0][2] == 2 && table[1][2] == 2) {
            if (table[2][2] == 0) {
                drawOponent(2, 2);
                return true;
            }
        }
        if (table[0][0] == 2 && table[2][0] == 2) {
            if (table[1][0] == 0) {
                drawOponent(1, 0);
                return true;
            }
        }
        if (table[0][1] == 2 && table[2][1] == 2) {
            if (table[1][1] == 0) {
                drawOponent(1, 1);
                return true;
            }
        }
        if (table[0][2] == 2 && table[2][2] == 2) {
            if (table[1][2] == 0) {
                drawOponent(1, 2);
                return true;
            }
        }
        if (table[0][1] == 2 && table[1][1] == 2) {
            if (table[2][1] == 0) {
                drawOponent(2, 1);
                return true;
            }
        }
        if (table[0][0] == 2 && table[2][2] == 2) {
            if (table[1][1] == 0) {
                drawOponent(1, 1);
                return true;
            }
        }
        if (table[1][0] == 2 && table[1][1] == 2) {
            if (table[1][2] == 0) {
                drawOponent(1, 2);
                return true;
            }
        }
        if (table[1][2] == 2 && table[1][1] == 2) {
            if (table[1][0] == 0) {
                drawOponent(1, 0);
                return true;
            }
        }
        if (table[1][0] == 2 && table[1][2] == 2) {
            if (table[1][1] == 0) {
                drawOponent(1, 1);
                return true;
            }
        }
        if (table[2][1] == 2 && table[1][1] == 2) {
            if (table[0][1] == 0) {
                drawOponent(0, 1);
                return true;
            }
        }
        if (table[2][0] == 2 && table[1][0] == 2) {
            if (table[0][0] == 0) {
                drawOponent(0, 0);
                return true;
            }
        }
        if (table[2][0] == 2 && table[1][1] == 2) {
            if (table[0][2] == 0) {
                drawOponent(0, 2);
                return true;
            }
        }
        if (table[2][2] == 2 && table[1][2] == 2) {
            if (table[0][2] == 0) {
                drawOponent(0, 2);
                return true;
            }
        }
        if (table[2][2] == 2 && table[1][1] == 2) {
            if (table[0][0] == 0) {
                drawOponent(0, 0);
                return true;
            }
        }
        if (table[2][0] == 2 && table[2][1] == 2) {
            if (table[2][2] == 0) {
                drawOponent(2, 2);
                return true;
            }
        }
        if (table[2][2] == 2 && table[2][1] == 2) {
            if (table[2][0] == 0) {
                drawOponent(2, 0);
                return true;
            }
        }
        if (table[0][0] == 2 && table[0][2] == 2) {
            if (table[0][1] == 0) {
                drawOponent(0, 1);
                return true;
            }
        }
        if (table[2][0] == 2 && table[2][2] == 2) {
            if (table[2][1] == 0) {
                drawOponent(2, 1);
                return true;
            }
        }
        if (table[2][0] == 2 && table[0][2] == 2) {
            if (table[1][1] == 0) {
                drawOponent(1, 1);
                return true;
            }
        }
        return false;
    }

    public void disableButtons() {
        button1.setClickable(false);
        button2.setClickable(false);
        button3.setClickable(false);
        button4.setClickable(false);
        button5.setClickable(false);
        button6.setClickable(false);
        button7.setClickable(false);
        button8.setClickable(false);
        button9.setClickable(false);
    }

    public void enableButtons() {
        button1.setClickable(true);
        button2.setClickable(true);
        button3.setClickable(true);
        button4.setClickable(true);
        button5.setClickable(true);
        button6.setClickable(true);
        button7.setClickable(true);
        button8.setClickable(true);
        button9.setClickable(true);
    }
}
