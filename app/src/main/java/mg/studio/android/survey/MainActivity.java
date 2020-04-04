package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button start;

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private Button Buttonstart;
    private CheckBox box;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

       start = (Button) findViewById(R.id.start);
       textView1=(TextView)findViewById(R.id.textView1);
       textView2=(TextView)findViewById(R.id.textView2);
       textView3=(TextView)findViewById(R.id.textView3);
       textView4=(TextView)findViewById(R.id.textView4);
       textView5=(TextView)findViewById(R.id.textView5);
       textView6=(TextView)findViewById(R.id.textView6);
       Buttonstart=(Button) findViewById(R.id.buttonStart);
       box = (CheckBox) findViewById(R.id.checkbox);


       start.setOnClickListener(this);
    }

    public void btn_start(View v) {
        CheckBox box = (CheckBox) findViewById(R.id.checkbox);

        if (box.isChecked()) {
            startActivity(new Intent(this, Question1.class));
        } else {
            Toast.makeText(this, "Haven't selected to accept", Toast.LENGTH_LONG).show();
            return;
        }
    }


    @Override
    public void onClick(View v) {

        textView1.setVisibility(View.VISIBLE);
        textView2.setVisibility(View.VISIBLE);
        textView3.setVisibility(View.VISIBLE);
        textView4.setVisibility(View.VISIBLE);
        textView5.setVisibility(View.VISIBLE);
        textView6.setVisibility(View.VISIBLE);
        box.setVisibility(View.VISIBLE);
        Buttonstart.setVisibility(View.VISIBLE);

    }
}
