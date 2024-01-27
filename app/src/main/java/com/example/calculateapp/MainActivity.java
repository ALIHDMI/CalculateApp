package com.example.calculateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    StringBuilder strValue;
    Boolean firstBracket, secondBracket = false;
    int oneBracketCount;
    TextView textView;
    boolean isCompute = false;
    TextView textView1;
//    Animation scaleUp, scaledown;
    ImageButton button1, button2, button3, button4,

    button5, button6, button7, button8, button9, button0, buttonRemove, buttonC, buttonBrackets, buttonDivide,
    buttonPlus, buttonMultiply, buttonMinus, buttonEquals, buttonComma;
    Button buttonOpenBracket, buttonCloseBracket, buttonSin, buttonCos, buttonTan, buttonLn, buttonLog, buttonKoren,
     buttonAbs, buttonX2, buttonXY, buttonE, buttonPi;
//    Boolean button1Is = false, button2Is = false, button3Is = false, button4Is = false,
//            button5Is = false, button6Is = false, button7Is = false, button8Is = false, button9Is = false, button0Is = false,
//            buttonRemoveIs = false,
//            buttonCIs = false, buttonBracketsIs = false, buttonDivideIs = false,
//            buttonPlusIs = false, buttonMultiplyIs = false, buttonMinusIs = false, buttonEqualsIs = false,
//            buttonCommaIs = false, buttonPercentIs = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.textView1);
        textView = findViewById(R.id.textView0);
        if (savedInstanceState != null) {
            strValue = new StringBuilder();
            strValue.append(savedInstanceState.getString("strValue"));
            textView.setText(strValue);
            if (savedInstanceState.containsKey("strResult")) {
                textView1.setText(savedInstanceState.getString("strResult"));
            }
        }
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonC = findViewById(R.id.buttonC);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonRemove = findViewById(R.id.buttonRemove);
        buttonComma = findViewById(R.id.buttonPeriod);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonOpenBracket = findViewById(R.id.buttonOpenBracket);
        buttonCloseBracket = findViewById(R.id.buttonCloseBracket);
            buttonSin = findViewById(R.id.buttonSin);
            buttonCos = findViewById(R.id.buttonCos);
            buttonTan = findViewById(R.id.buttonTan);
            buttonLn = findViewById(R.id.buttonLn);
            buttonPi = findViewById(R.id.buttonPi);
            buttonLog = findViewById(R.id.buttonLog);
            buttonE = findViewById(R.id.buttonE);
            buttonAbs = findViewById(R.id.buttonAbs);
            buttonX2 = findViewById(R.id.buttonX2);
            buttonXY = findViewById(R.id.buttonXY);
            buttonKoren = findViewById(R.id.buttonKoren);
        strValue = new StringBuilder();
        strValue.append("");
        firstBracket = false;
        oneBracketCount = 0;

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            buttonX2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (strValue != null) {
                        String strResult = "";
                        Expression expression = new Expression(strValue.toString() + "^2");
                        strResult = String.valueOf(expression.calculate());
                        textView1.setText(strResult);
                    }
                }
            });
            buttonXY.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    strValue.append("^(");
                    textView.setText(strValue);
                }
            });
            buttonPi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    strValue.append("pi");
                    textView.setText(strValue);
                }
            });
            buttonSin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    strValue.append("sin(");
                    textView.setText(strValue);
                }
            });
            buttonCos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    strValue.append("cos(");
                    textView.setText(strValue);
                }
            });
            buttonTan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    strValue.append("tan(");
                    textView.setText(strValue);
                }
            });
            buttonLn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    strValue.append("ln(");
                    textView.setText(strValue);
                }
            });
            buttonLog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    strValue.append("Log(");
                    textView.setText(strValue);
                }
            });
            buttonKoren.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    strValue.append("√(");
                    textView.setText(strValue);
                }
            });
            buttonAbs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    strValue.append("abs(");
                    textView.setText(strValue);
                }
            });
            buttonE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    strValue.append("e");
                    textView.setText(strValue);
                }
            });
        }
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strValue.append("0");
                textView.setText(strValue);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strValue.append("1");
                textView.setText(strValue);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strValue.append("2");
                textView.setText(strValue);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strValue.append("3");
                textView.setText(strValue);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strValue.append("4");
                textView.setText(strValue);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strValue.append("5");
                textView.setText(strValue);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strValue.append("6");
                textView.setText(strValue);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strValue.append("7");
                textView.setText(strValue);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strValue.append("8");
                textView.setText(strValue);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strValue.append("9");
                textView.setText(strValue);
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strValue.delete(0, strValue.length());
                textView.setText(strValue);
                textView1.setText("");

            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (strValue.charAt(strValue.length() - 1) >= '0' & strValue.charAt(strValue.length() - 1) <= '9' |
                strValue.charAt(strValue.length() - 1) == ')' | strValue.charAt(strValue.length() - 1) == '(') {
                    strValue.append('-');
                    textView.setText(strValue);
                }
            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!strValue.equals("")) {
                    if (strValue.charAt(strValue.length() - 1) == ')') firstBracket = true;
                    if (strValue.charAt(strValue.length() - 1) == '(') firstBracket = false;
                    strValue.deleteCharAt(strValue.length() - 1);
                    textView.setText(strValue);
                }
            }
        });
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (strValue.charAt(strValue.length() - 1) >= '0' & strValue.charAt(strValue.length() - 1) <= '9' |
                        strValue.charAt(strValue.length() - 1) == ')' | strValue.charAt(strValue.length() - 1) == '(') {
                    strValue.append('+');
                    textView.setText(strValue);
                }
            }
        });
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (strValue.charAt(strValue.length() - 1) >= '0' & strValue.charAt(strValue.length() - 1) <= '9' |
                        strValue.charAt(strValue.length() - 1) == ')' | strValue.charAt(strValue.length() - 1) == '(' |
                strValue.charAt(strValue.length() - 1) == 'e' | strValue.charAt(strValue.length() - 1) =='i') {
                    strValue.append('*');
                    textView.setText(strValue);
                }
            }
        });
//        buttonBrackets.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!strValue.toString().equals("")) {
//                    if (strValue.toString().charAt(strValue.length() - 1) == '(') {
//                        strValue.append("(");
//                        textView.setText(strValue);
//                        oneBracketCount++;
//                    }
//                }
//                if (strValue.toString().equals("")) {
//                    strValue.append("(");
//                    textView.setText(strValue);
//                    firstBracket = true;
//                }
//                if (!firstBracket) {
//                    if (strValue.charAt(strValue.length() - 1) >= '0' & strValue.charAt(strValue.length() - 1)
//                    <= '9' | strValue.charAt(strValue.length() - 1) == ')') {
//                        strValue.append("*(");
//                        textView.setText(strValue);
//                        firstBracket = true;
//                    }
//                    if (strValue.charAt(strValue.length() - 1) == '-' |
//                            strValue.charAt(strValue.length() - 1) == '+' |
//                            strValue.charAt(strValue.length() - 1) == '*' |
//                            strValue.charAt(strValue.length() - 1) == '-' |
//                            strValue.charAt(strValue.length() - 1) == '/') {
//                        strValue.append("(");
//                        textView.setText(strValue);
//                        firstBracket = true;
//                    }
//                } else if (firstBracket) {
//                    if (strValue.charAt(strValue.length() - 1) == '-' |
//                            strValue.charAt(strValue.length() - 1) == '+' |
//                            strValue.charAt(strValue.length() - 1) == 'x' |
//                            strValue.charAt(strValue.length() - 1) == '-' |
//                            strValue.charAt(strValue.length() - 1) == '/') {
//                        strValue.append("(");
//                        textView.setText(strValue);
//                    } else if (strValue.charAt(strValue.length() - 1) >= '0' &
//                    strValue.charAt(strValue.length() - 1) <= '9' & oneBracketCount >= 1) {
//                        strValue.append(")");
//                        textView.setText(strValue);
//                        firstBracket = false;
//                    }
//                }
//            }
//        });
        buttonOpenBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strValue.append("(");
                textView.setText(strValue);
            }
        });
        buttonCloseBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strValue.append(")");
                textView.setText(strValue);
            }
        });
        buttonComma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (strValue.charAt(strValue.length() - 1) >= '0' & strValue.charAt(strValue.length() - 1) <= '9' |
                        strValue.charAt(strValue.length() - 1) == ')' | strValue.charAt(strValue.length() - 1) == '(') {
                    strValue.append('.');
                    textView.setText(strValue);
                }
            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (strValue.charAt(strValue.length() - 1) >= '0' & strValue.charAt(strValue.length() - 1) <= '9' |
                        strValue.charAt(strValue.length() - 1) == ')' | strValue.charAt(strValue.length() - 1) == '(') {
                    strValue.append('/');
                    textView.setText(strValue);
                }
            }
        });
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            String strResult = "";
            @Override
            public void onClick(View v) {
                Expression expression = new Expression(strValue.toString());
                strResult = String.valueOf(expression.calculate());
                textView1.setText(strResult);
            }
        });

//        scaleUp = AnimationUtils.loadAnimation(this, R.anim.startanimation);
//        scaledown = AnimationUtils.loadAnimation(this, R.anim.endanimation);

//        scaleUp.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                if (button0Is) {
//                    button0.clearAnimation();
//                    button0.startAnimation(scaledown);
//                    button0Is = false;
//                } else if (button1Is) {
//                    button1.clearAnimation();
//                    button1.startAnimation(scaledown);
//                    button1Is = false;
//                } else if (button2Is) {
//                    button2.clearAnimation();
//                    button2.startAnimation(scaledown);
//                    button2Is = false;
//                } else if (button3Is) {
//                    button3.clearAnimation();
//                    button3.startAnimation(scaledown);
//                    button3Is = false;
//                } else if (button4Is) {
//                    button4.clearAnimation();
//                    button4.startAnimation(scaledown);
//                    button4Is = false;
//                } else if (button5Is) {
//                    button5.clearAnimation();
//                    button5.startAnimation(scaledown);
//                    button5Is = false;
//                } else if (button6Is) {
//                    button6.clearAnimation();
//                    button6.startAnimation(scaledown);
//                    button6Is = false;
//                } else if (button7Is) {
//                    button7.clearAnimation();
//                    button7.startAnimation(scaledown);
//                    button7Is = false;
//                } else if (button8Is) {
//                    button8.clearAnimation();
//                    button8.startAnimation(scaledown);
//                    button8Is = false;
//                } else if (button9Is) {
//                    button9.clearAnimation();
//                    button9.startAnimation(scaledown);
//                    button9Is = false;
//                } else if (buttonRemoveIs) {
//                    buttonRemove.clearAnimation();
//                    buttonRemove.startAnimation(scaledown);
//                    buttonRemoveIs = false;
//                } else if (buttonCommaIs) {
//                    buttonComma.clearAnimation();
//                    buttonComma.startAnimation(scaledown);
//                    buttonCommaIs = false;
//                } else if (buttonCIs) {
//                    buttonC.clearAnimation();
//                    buttonC.startAnimation(scaledown);
//                    buttonCIs = false;
//                } else if (buttonBracketsIs) {
//                    buttonBrackets.clearAnimation();
//                    buttonBrackets.startAnimation(scaledown);
//                    buttonBracketsIs = false;
//                } else if (buttonDivideIs) {
//                    buttonDivide.clearAnimation();
//                    buttonDivide.startAnimation(scaledown);
//                    buttonDivideIs = false;
//                } else if (buttonPlusIs) {
//                    buttonPlus.clearAnimation();
//                    buttonPlus.startAnimation(scaledown);
//                    buttonPlusIs = false;
//                } else if (buttonMinusIs) {
//                    buttonMinus.clearAnimation();
//                    buttonMinus.startAnimation(scaledown);
//                    buttonMinusIs = false;
//                } else if (buttonMultiplyIs) {
//                    buttonMultiply.clearAnimation();
//                    buttonMultiply.startAnimation(scaledown);
//                    buttonMultiplyIs = false;
//                } else if (buttonEqualsIs) {
//                    buttonEquals.clearAnimation();
//                    buttonEquals.startAnimation(scaledown);
//                    buttonEqualsIs = false;
//                } else if (buttonPercentIs) {
//                    buttonPercent.clearAnimation();
//                    buttonPercent.startAnimation(scaledown);
//                    buttonPercentIs = false;
//                }
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });

//        animationButton();
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        if (!textView1.getText().equals("")) {
//            isCompute = true;
//        }
//    }
    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("strValue", strValue.toString());
        bundle.putString("strResult", textView1.getText().toString());
    }
    public void textClick(ImageButton imageButton) {

    }

//    public void animationButton() {
//        final Handler handler = new Handler();
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//                if (button0Is) {
//                    setAnimationAndReset(button0);
//                } else if (button1Is) {
//                    setAnimationAndReset(button1);
//                } else if (button2Is) {
//                    setAnimationAndReset(button2);
//                } else if (button3Is) {
//                    setAnimationAndReset(button3);
//                } else if (button4Is) {
//                    setAnimationAndReset(button4);
//                } else if (button5Is) {
//                    setAnimationAndReset(button5);
//                } else if (button6Is) {
//                    setAnimationAndReset(button6);
//                } else if (button7Is) {
//                    setAnimationAndReset(button7);
//                } else if (button8Is) {
//                    setAnimationAndReset(button8);
//                } else if (button9Is) {
//                    setAnimationAndReset(button9);
//                } else if (buttonRemoveIs) {
//                    setAnimationAndReset(buttonRemove);
//                } else if (buttonCommaIs) {
//                    setAnimationAndReset(buttonComma);
//                } else if (buttonCIs) {
//                    setAnimationAndReset(buttonC);
//                } else if (buttonBracketsIs) {
//                    setAnimationAndReset(buttonBrackets);
//                } else if (buttonDivideIs) {
//                    setAnimationAndReset(buttonDivide);
//                } else if (buttonPlusIs) {
//                    setAnimationAndReset(buttonPlus);
//                } else if (buttonMinusIs) {
//                    setAnimationAndReset(buttonMinus);
//                } else if (buttonMultiplyIs) {
//                    setAnimationAndReset(buttonMultiply);
//                } else if (buttonEqualsIs) {
//                    setAnimationAndReset(buttonEquals);
//                } else if (buttonPercentIs) {
//                    setAnimationAndReset(buttonPercent);
//                }
//                handler.postDelayed(this, 5);
//            }
//        });
//    }

//    public void setAnimationAndReset(ImageButton buttonIs) {
//        buttonIs.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                buttonIs.startAnimation(scaleUp);
//            }
//        });
//    }

//    public void setBooleanButton(View view) {
//        ImageButton imageButton = (ImageButton) view;
//        switch(String.valueOf(imageButton.getId())) {
//            case "button0":
//                button0Is = true;
//                break;
//            case "button1":
//                button1Is = true;
//                break;
//            case "button3":
//                button3Is = true;
//                break;
//            case "button4":
//                button4Is = true;
//                break;
//            case "button5":
//                button5Is = true;
//                break;
//            case "button6":
//                button6Is = true;
//                break;
//            case "button7":
//                button7Is = true;
//                break;
//            case "button8":
//                button8Is = true;
//                break;
//            case "button9":
//                button9Is = true;
//                break;
//            case "buttonRemove":
//                buttonRemoveIs = true;
//                break;
//            case "buttonEquals":
//                buttonEqualsIs = true;
//                break;
//            case "buttonPlus":
//                buttonPlusIs = true;
//                break;
//            case "buttonMinus":
//                buttonMinusIs = true;
//                break;
//            case "buttonMultiply":
//                buttonMultiplyIs = true;
//                break;
//            case "buttonDivide":
//                buttonDivideIs = true;
//                break;
//            case "buttonProcent":
//                buttonPercentIs = true;
//                break;
//            case "buttonBracket":
//                buttonBracketsIs = true;
//                break;
//            case "buttonC":
//                buttonCIs = true;
//                break;
//        }
//    }
}