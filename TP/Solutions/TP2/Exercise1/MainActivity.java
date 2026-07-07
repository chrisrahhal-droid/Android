    package com.example.exercise1;
    import android.app.AlertDialog;
    import android.content.DialogInterface;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;
    import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {
        EditText Value1,Value2;
        TextView Result;
        double result = 0;

        TextView t;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Value1 = findViewById(R.id.Value1);
            Value2 = findViewById(R.id.Value2);
            Result = findViewById(R.id.Result);
        }

        public void calculate(View v){
            String a = Value1.getText().toString();
            String b = Value2.getText().toString();
            if(a.isEmpty() || b.isEmpty()){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Error Message");
                builder.setMessage("Enter the numbers");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else{
             double v1 = Double.parseDouble(a);
             double v2 = Double.parseDouble(b);
             result = v1 + v2;
             Result.setText(String.valueOf(result));
                if( Result.getText().toString().isEmpty()){
                    Toast.makeText(this, "There is no result", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this,"The result is "+result,Toast.LENGTH_SHORT).show();
                }
            }
        }

        public void resetFields(View v){
            Result.setText("");
            Value1.setText("");
            Value2.setText("");
        }
    }