package id.triangkas.android.triangkaskalkulator;

import android.renderscript.Int2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtTempAkhir;
    EditText edtTempAction;
    EditText edtTempSum;
    EditText edtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTempAkhir = (EditText) findViewById(R.id.edtTempAkhir);
        edtTempAction = (EditText) findViewById(R.id.edtTempAction);
        edtTempSum = (EditText) findViewById(R.id.edtTempSum);
        edtHasil = (EditText) findViewById(R.id.edtHasil);

        ClearAction();
    }

    public void edtHasilView(String txt) {
        String edtHasilOld = edtHasil.getText().toString();
        edtHasil.setText(edtHasilOld+txt);
    }

    public void ClearAction() {
        edtTempAkhir.setText("");
        edtTempAction.setText("");
        edtTempSum.setText("0");
        edtHasil.setText("");
    }

    public void btn1Click(View view) {
        prosesTempSum("1", false);
        edtHasilView("1");
    }

    public void btn2Click(View view) {
        prosesTempSum("2", false);
        edtHasilView("2");
    }

    public void btn3Click(View view) {
        prosesTempSum("3", false);
        edtHasilView("3");
    }

    public void btn4Click(View view) {
        prosesTempSum("4", false);
        edtHasilView("4");
    }

    public void btn5Click(View view) {
        prosesTempSum("5", false);
        edtHasilView("5");
    }

    public void btn6Click(View view) {
        prosesTempSum("6", false);
        edtHasilView("6");
    }

    public void btnPlusClick(View view) {
        prosesTempSum("plus", true);
        edtHasilView("+");
    }

    public void btnKaliClick(View view) {
        prosesTempSum("kali", true);
        edtHasilView("x");
    }

    public void btnSumClick(View view) {
        prosesTempSum("sum", true);
        edtHasilView("=");

        String edtHasilGet = edtHasil.getText().toString();
        String edtTempSumGet = edtTempSum.getText().toString();

        edtHasil.setText(edtHasilGet+edtTempSumGet);
    }

    public void btnClearClick(View view) {
        ClearAction();
    }

    public void prosesTempSum(String txt, Boolean act){

        if(act == true){
            String edtTempAkhirGet = edtTempAkhir.getText().toString();
            String edtTempSumGet = edtTempSum.getText().toString();
            String edtTempActionGet = edtTempAction.getText().toString();

            int edtTempAkhirInt = Integer.valueOf(edtTempAkhirGet);
            int edtTempSumInt = Integer.valueOf(edtTempSumGet);

              if(edtTempActionGet.equals("plus")){
                  edtTempSum.setText(String.valueOf(edtTempAkhirInt + edtTempSumInt));
              }
              else if(edtTempActionGet.equals("kali")){
                  edtTempSum.setText(String.valueOf(edtTempAkhirInt * edtTempSumInt));
              }
              else if(edtTempActionGet.equals("sum")){
                  edtTempSum.setText("0");
              }
              else {
                  edtTempSum.setText(String.valueOf(edtTempAkhirInt));
              }

            edtTempAkhir.setText("");
            edtTempAction.setText(txt);
        } else {
            String edtTempActionGet = edtTempAction.getText().toString();
            if(edtTempActionGet.equals("sum")) {
                edtTempAction.setText("");
                edtTempSum.setText("0");
                edtHasil.setText("");
            }

            String edtTempAkhirOld = edtTempAkhir.getText().toString();
            edtTempAkhir.setText(edtTempAkhirOld+txt);
        }

    }
}
