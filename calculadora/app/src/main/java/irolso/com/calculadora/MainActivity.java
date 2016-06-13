package irolso.com.calculadora;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button boton_0;
    Button boton_1;
    Button boton_2;
    Button boton_3;
    Button boton_4;
    Button boton_5;
    Button boton_6;
    Button boton_7;
    Button boton_8;
    Button boton_9;
    Button boton_mas;
    Button boton_menos;
    Button boton_multiplica;
    Button boton_divide;
    Button boton_decimal;
    Button boton_binario;
    Button boton_limpia;
    Button boton_borra;
    Button boton_igual;
    Button boton_puntoDeciamal;
    TextView numero1;
    TextView numero2;
    TextView total;
    TextView operador;
    String numeroString1 = "";
    String numeroString2= "";
    String totalString = "";
    String operadorString = "";
    boolean banderaPunto =true ,banderaPunto2 = true;
    boolean numeroprimero = true;
    boolean nuevaOperacion = true;
    boolean activarOperadores = true;
    Typeface heroLight;
    Typeface hero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentes();
        iniciarteclas();
        listener();
     //   binario();
    }

    public void iniciarteclas(){
        heroLight= Typeface.createFromAsset(getAssets(), "font/Hero-Light.otf");
        hero= Typeface.createFromAsset(getAssets(), "font/Hero.otf");

        boton_0 = (Button) findViewById(R.id.tecla_0);
        boton_1 = (Button) findViewById(R.id.tecla_1);
        boton_2 = (Button) findViewById(R.id.tecla_2);
        boton_3 = (Button) findViewById(R.id.tecla_3);
        boton_4 = (Button) findViewById(R.id.tecla_4);
        boton_5 = (Button) findViewById(R.id.tecla_5);
        boton_6 = (Button) findViewById(R.id.tecla_6);
        boton_7 = (Button) findViewById(R.id.tecla_7);
        boton_8 = (Button) findViewById(R.id.tecla_8);
        boton_9 = (Button) findViewById(R.id.tecla_9);

        boton_mas = (Button) findViewById(R.id.tecla_mas);
        boton_menos = (Button) findViewById(R.id.tecla_menos);
        boton_multiplica = (Button) findViewById(R.id.tecla_multiplicar);
        boton_divide = (Button) findViewById(R.id.tecla_div);

        boton_decimal = (Button) findViewById(R.id.tecla_decimal);
        boton_binario = (Button) findViewById(R.id.tecla_binario);
        boton_limpia = (Button) findViewById(R.id.tecla_limpiar);
        boton_borra = (Button) findViewById(R.id.tecla_borrar);

        boton_igual = (Button) findViewById(R.id.tecla_igual);
        boton_puntoDeciamal= (Button) findViewById(R.id.tecla_punto);

        boton_0.setTypeface(heroLight);
        boton_1.setTypeface(heroLight);
        boton_2.setTypeface(heroLight);
        boton_3.setTypeface(heroLight);
        boton_4.setTypeface(heroLight);
        boton_5.setTypeface(heroLight);
        boton_6.setTypeface(heroLight);
        boton_7.setTypeface(heroLight);
        boton_8.setTypeface(heroLight);
        boton_9.setTypeface(heroLight);

        boton_mas.setTypeface(heroLight);
        boton_menos.setTypeface(heroLight);
        boton_multiplica.setTypeface(heroLight);
        boton_divide.setTypeface(heroLight);
        boton_decimal.setTypeface(heroLight);
        boton_binario.setTypeface(heroLight);
        boton_limpia.setTypeface(heroLight);
        boton_borra.setTypeface(heroLight);

        numero1.setTypeface(heroLight);
        numero2.setTypeface(heroLight);
        total.setTypeface(heroLight);
        operador.setTypeface(heroLight);

        boton_igual.setTypeface(heroLight);
        boton_puntoDeciamal.setTypeface(heroLight);

    }

    public void iniciarComponentes(){
        numero1 = (TextView) findViewById(R.id.numero1);
        numero2 = (TextView) findViewById(R.id.numero2);
        total =(TextView) findViewById(R.id.numeroTotal);
        operador =(TextView) findViewById(R.id.operador);

    }
    public void listener(){
        findViewById(R.id.tecla_0).setOnClickListener(this);
        findViewById(R.id.tecla_1).setOnClickListener(this);
        findViewById(R.id.tecla_2).setOnClickListener(this);
        findViewById(R.id.tecla_3).setOnClickListener(this);
        findViewById(R.id.tecla_4).setOnClickListener(this);
        findViewById(R.id.tecla_5).setOnClickListener(this);
        findViewById(R.id.tecla_6).setOnClickListener(this);
        findViewById(R.id.tecla_7).setOnClickListener(this);
        findViewById(R.id.tecla_8).setOnClickListener(this);
        findViewById(R.id.tecla_9).setOnClickListener(this);

        findViewById(R.id.tecla_mas).setOnClickListener(this);
        findViewById(R.id.tecla_menos).setOnClickListener(this);
        findViewById(R.id.tecla_multiplicar).setOnClickListener(this);
        findViewById(R.id.tecla_div).setOnClickListener(this);

        findViewById(R.id.tecla_decimal).setOnClickListener(this);
        findViewById(R.id.tecla_binario).setOnClickListener(this);
        findViewById(R.id.tecla_limpiar).setOnClickListener(this);
        findViewById(R.id.tecla_borrar).setOnClickListener(this);

        findViewById(R.id.tecla_punto).setOnClickListener(this);
        findViewById(R.id.tecla_igual).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tecla_0:
                funcionNumeros("0");
                break;
            case R.id.tecla_1:
                funcionNumeros("1");
                break;
            case R.id.tecla_2:
                funcionNumeros("2");
                break;
            case R.id.tecla_3:
                funcionNumeros("3");
                break;
            case R.id.tecla_4:
                funcionNumeros("4");
                break;
            case R.id.tecla_5:
                funcionNumeros("5");
                break;
            case R.id.tecla_6:
                funcionNumeros("6");
                break;
            case R.id.tecla_7:
                funcionNumeros("7");
                break;
            case R.id.tecla_8:
                funcionNumeros("8");
                break;
            case R.id.tecla_9:
                funcionNumeros("9");
                break;

            case R.id.tecla_punto:
                if(numeroprimero) {
                    if (banderaPunto) {
                        numeroString1 += ".";
                        numero1.setText(numeroString1);
                        banderaPunto = false;
                    }
                }else{
                    if (banderaPunto2) {
                        numeroString2 += ".";
                        numero2.setText(numeroString2);
                        banderaPunto2 = false;
                    }
                }
                break;



            case R.id.tecla_mas:
                operadores("+");
                break;
            case R.id.tecla_menos:
                operadores("-");
                break;
            case R.id.tecla_multiplicar:
                operadores("x");
                break;
            case R.id.tecla_div:
                operadores("/");
                break;

            case R.id.tecla_igual:
                if(operadorString!=""&&numeroString1!=""&&numeroString2!="")
                funcionIgual();
                break;

            case R.id.tecla_limpiar:
                limpiar();
                break;

            case R.id.tecla_borrar:
                borrar();
                break;

        }
    }

    private void borrar() {
        if(numeroprimero){
            if(!numeroString1.equals("")){
        numeroString1 = numeroString1.substring(0, numeroString1.length()-1);
        numero1.setText(numeroString1);
                borrarTotal();
            }
        }else{
            if(!numeroString2.equals("")) {
                numeroString2 = numeroString2.substring(0, numeroString2.length() - 1);
                numero2.setText(numeroString2);
                borrarTotal();
            }
        }
    }

    private void limpiar() {
        activarOperadores = true;
        banderaPunto =true;
        banderaPunto2 = true;
        numeroprimero = true;
        nuevaOperacion = true;
        numeroString1 = "";
        numeroString2= "";
        operadorString = "";
        numero1.setText(numeroString1);
        numero2.setText(numeroString2);
        operador.setText(operadorString);
        borrarTotal();
    }

    private void funcionIgual() {
        Float totalf;
        Float numerof = Float.parseFloat(numeroString1);
        Float numerof2 = Float.parseFloat(numeroString2);

        switch (operadorString){
            case "+":
                totalf = numerof + numerof2;
                totalString = Float.toString(totalf);
                break;
            case "x":
                totalf = numerof * numerof2;
                totalString = Float.toString(totalf);
                break;
            case "/":
                totalf = numerof / numerof2;
                totalString = Float.toString(totalf);
                break;
            case "-":
                totalf = numerof - numerof2;
                totalString = Float.toString(totalf);
                break;
        }
        tamañoFuente(30,30,35);

        total.setText(totalString);
    }

    public void operadores(String s){
        if(!activarOperadores) {
            if (totalString.equals("")) {
                operadorString = s;
                operador.setText(operadorString);
                numeroprimero = false;
                nuevaOperacion = false;
            } else {
                banderaPunto2 = true;
                operadorString = s;
                operador.setText(operadorString);
                numeroString1 = totalString;
                numero1.setText(numeroString1);
                numeroString2 = "";
                numero2.setText(numeroString2);
                borrarTotal();
            }
        }
    }

    public void funcionNumeros(String s){

        if(numeroprimero){
            tamañoFuente(35,30,30);
            numeroString1 += s;
            numero1.setText(numeroString1);
            activarOperadores=false;
        }else{
            tamañoFuente(30,35,30);
            numeroString2 += s;
            numero2.setText(numeroString2);
            totalString = "";
            total.setText(totalString);
        }

    }

    public void tamañoFuente(int num1,int num2, int tol){
        numero1.setTextSize(num1);
        numero2.setTextSize(num2);
        total.setTextSize( tol);
    }

    public void borrarTotal(){
        totalString = "";
        total.setText(totalString);
    }

    public void binario(){
        boton_puntoDeciamal.setText("1");
        boton_1.setVisibility(View.INVISIBLE);
        boton_2.setVisibility(View.INVISIBLE);
        boton_3.setVisibility(View.INVISIBLE);
        boton_4.setVisibility(View.INVISIBLE);
        boton_5.setVisibility(View.INVISIBLE);
        boton_6.setVisibility(View.INVISIBLE);
        boton_7.setVisibility(View.INVISIBLE);
        boton_8.setVisibility(View.INVISIBLE);
        boton_9.setVisibility(View.INVISIBLE);

        boton_multiplica.setVisibility(View.INVISIBLE);
        boton_divide.setVisibility(View.INVISIBLE);
        boton_menos.setVisibility(View.INVISIBLE);
    }
}
