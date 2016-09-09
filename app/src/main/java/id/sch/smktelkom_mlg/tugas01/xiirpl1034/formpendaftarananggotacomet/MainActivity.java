package id.sch.smktelkom_mlg.tugas01.xiirpl1034.formpendaftarananggotacomet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etPanjang, etPanggilan;
    Button btSm;
    TextView tvHasil;
    Spinner spKelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPanjang = (EditText) findViewById(R.id.editTextPanjang);
        etPanggilan = (EditText) findViewById(R.id.editTextPanggilan);
        spKelas = (Spinner) findViewById(R.id.spinnerKelas);
        btSm = (Button) findViewById(R.id.buttonSm);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        btSm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });
    }

    private void doProcess() {
        if (isValid()) {
            String panjang = etPanjang.getText().toString();
            String panggilan = etPanggilan.getText().toString();

            tvHasil.setText(
                    "Nama Panjang    : " + panjang + "\nNama Panggilan : " + panggilan +
                            "\nKelas                   : " + spKelas.getSelectedItem().toString());
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String Panjang = etPanjang.getText().toString();
        String Panggilan = etPanggilan.getText().toString();

        if (Panjang.isEmpty()) {
            etPanjang.setError("Nama Panjang belum diisi");
            valid = false;
        } else if (Panjang.length() < 4) {
            etPanjang.setError("Nama minimal 4 karakter");
            valid = false;
        } else {
            etPanggilan.setError(null);
        }

        if (Panggilan.isEmpty()) {
            etPanggilan.setError("Nama Panggilan belum diisi");
            valid = false;
        } else {
            etPanggilan.setError(null);
        }

        return valid;
    }
}
