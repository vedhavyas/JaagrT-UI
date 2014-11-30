package settings.rescueme.ved.com.rescueme_settings;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.skyfishjy.library.RippleBackground;


public class Main_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main);

        new SetUI().execute();
    }

    private void startSettingsActivity(){
        Intent intent = new Intent(this,Settings_Activity.class);
        startActivity(intent);

        overridePendingTransition(R.anim.push_down_in,R.anim.push_down_out);
    }

    private void startProfileEditActivity(){
        Intent intent = new Intent(this, Profile_Edit_Activity.class);
        startActivity(intent);

        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
    }

    private void startCirclesActivity(){
        Intent intent = new Intent(this, Circles_Activity.class);
        startActivity(intent);

        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
    }

    private class SetUI extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {
            ImageButton settings = (ImageButton)findViewById(R.id.settingsBtn);
            settings.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startSettingsActivity();
                }
            });

            final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.rippleEffect);
            ImageView imageView=(ImageView)findViewById(R.id.panicBtn);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rippleBackground.startRippleAnimation();
                }
            });

            ImageButton profileBtn = (ImageButton) findViewById(R.id.userProfileBtn);
            profileBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startProfileEditActivity();
                }
            });

            ImageButton circlesBtn = (ImageButton) findViewById(R.id.circlesBtn);
            circlesBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startCirclesActivity();
                }
            });
            return null;
        }
    }

}
