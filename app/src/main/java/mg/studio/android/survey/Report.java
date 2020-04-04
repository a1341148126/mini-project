package mg.studio.android.survey;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class Report extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_survey);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        ((TextView)findViewById(R.id.R1)).setText(bundle.getString("q1"));
        ((TextView)findViewById(R.id.R2)).setText(bundle.getString("q2"));
        ((TextView)findViewById(R.id.R3)).setText(bundle.getString("q3"));
        ((TextView)findViewById(R.id.R4)).setText(bundle.getString("q4"));
        ((TextView)findViewById(R.id.R5)).setText(bundle.getString("q5"));
        ((TextView)findViewById(R.id.R6)).setText(bundle.getString("q6"));
        ((TextView)findViewById(R.id.R7)).setText(bundle.getString("q7"));
        ((TextView)findViewById(R.id.R8)).setText(bundle.getString("q8"));
        ((TextView)findViewById(R.id.R9)).setText(bundle.getString("q9"));
        ((TextView)findViewById(R.id.R10)).setText(bundle.getString("q10"));
        ((TextView)findViewById(R.id.R11)).setText(bundle.getString("q11"));
        ((TextView)findViewById(R.id.R12)).setText(bundle.getString("q12"));

        String msg = new String();
        msg = "{ \"Q1\":\"" + bundle.getString("q1") + "\", ";
        msg += "\"Q2\":\"" + bundle.getString("q2") + "\", ";
        msg += "\"Q3\":\"" + bundle.getString("q3") + "\", ";
        msg += "\"Q4\":\"" + bundle.getString("q4") + "\", ";
        msg += "\"Q5\":\"" + bundle.getString("q5") + "\", ";
        msg += "\"Q6\":\"" + bundle.getString("q6") + "\", ";
        msg += "\"Q7\":\"" + bundle.getString("q7") + "\", ";
        msg += "\"Q8\":\"" + bundle.getString("q8") + "\", ";
        msg += "\"Q9\":\"" + bundle.getString("q9") + "\", ";
        msg += "\"Q10\":\"" + bundle.getString("q10") + "\", ";
        msg += "\"Q11\":\"" + bundle.getString("q11") + "\", ";
        msg += "\"Q12\":\"" + bundle.getString("q12") + "\", ";

        saveToFile(msg);
    }

    public void saveToFile(String msg) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:SS");
        Date curdate = new Date(System.currentTimeMillis());

        try {
            FileOutputStream surveydata = openFileOutput("data-" + formatter.format(curdate) + ".json", Context.MODE_PRIVATE);
            surveydata.write(msg.getBytes());
            surveydata.flush();
            surveydata.close();

            Toast.makeText(this, "data saved", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
