package settings.rescueme.ved.com.rescueme_settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


public class Login_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login);

        Button fbBtn = (Button)findViewById(R.id.fbBtn);

        fbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getBaseContext(),Main_Activity.class);
                mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(mainIntent);
                overridePendingTransition(R.anim.start_animation,R.anim.login_exit_animetion);
            }
        });

        Button signUpBtn = (Button)findViewById(R.id.signUpBtn);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUp = new Intent(getBaseContext(),SignUp_Activity.class);
                signUp.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                signUp.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(signUp);
                overridePendingTransition(R.anim.start_animation,R.anim.login_exit_animetion);
            }
        });
    }
}
