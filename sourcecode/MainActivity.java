package studio.okaria.fluxrss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button Ligue1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int pleinEcran = (int) WindowManager.LayoutParams.FLAG_FULLSCREEN ; getWindow().setFlags(pleinEcran,pleinEcran);

        Button Ligue1 = (Button)findViewById(R.id.buttonLigue1);
        Ligue1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openActivityLigue1();
            }
        });

        Button Internet = (Button)findViewById(R.id.buttonInternet);
        Internet.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openActivityInternet();
            }
        });

        Button Sport = (Button)findViewById(R.id.buttonSport);
        Sport.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openActivitySport();
            }
        });

        Button Societe = (Button)findViewById(R.id.buttonFrance);
        Societe.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openActivitySociete();
            }
        });

        Button Histoire = (Button)findViewById(R.id.buttonHistoire);
        Histoire.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openActivityHistoire();
            }
        });

        Button International = (Button)findViewById(R.id.buttonInternational);
        International.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openActivityInternational();
            }
        });

        Button Actualite = (Button)findViewById(R.id.buttonActualite);
        Actualite.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openActivityActualite();
            }
        });

        Button JeuxVideo = (Button)findViewById(R.id.buttonJeuxVideo);
        JeuxVideo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                openActivityJeuxVideo();
            }
        });

    }

    public void openActivityLigue1(){
        Intent intent = new Intent(this, FluxLigue1.class);
        startActivity(intent);
    }

    public void openActivityJeuxVideo(){
        Intent intent = new Intent(this, FluxJeuxVideo.class);
        startActivity(intent);
    }

    public void openActivityInternet(){
        Intent intent = new Intent(this, FluxInternet.class);
        startActivity(intent);
    }

    public void openActivitySport(){
        Intent intent = new Intent(this, FluxSport.class);
        startActivity(intent);
    }

    public void openActivityInternational(){
        Intent intent = new Intent(this, FluxInternational.class);
        startActivity(intent);
    }

    public void openActivityHistoire(){
        Intent intent = new Intent(this, FluxHistoire.class);
        startActivity(intent);
    }

    public void openActivitySociete(){
        Intent intent = new Intent(this, FluxSociete.class);
        startActivity(intent);
    }

    public void openActivityActualite(){
        Intent intent = new Intent(this, FluxActualite.class);
        startActivity(intent);
    }
}
