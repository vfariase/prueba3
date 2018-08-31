package cl.companyvfarias.prueba_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    private  static final int RC_SIGN_IN= 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        if(new CurrentUser().getCurrentUser()!=null)
        {
            logged();
        }

        else { signUp();}

    }



    private void signUp(){

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(Arrays.asList(
                                new AuthUI.IdpConfig.EmailBuilder().build(),
                                new AuthUI.IdpConfig.GoogleBuilder().build()/*,
                                new AuthUI.IdpConfig.FacebookBuilder().build(),
                                 new AuthUI.IdpConfig.TwitterBuilder().build(),
                                 new AuthUI.IdpConfig.GitHubBuilder().build(),
                                 new AuthUI.IdpConfig.PhoneBuilder().build()*/))
                        //.setTheme(R.style.LoginTheme)
                        //.setLogo(R.mipmap.logo)
                        .build(),
                RC_SIGN_IN);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);


            if (resultCode == RESULT_OK) {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            } else {

                if (response == null) {
                    // User pressed back button
                    Toast.makeText(this, "CANCELLED", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (response.getError().getErrorCode() == ErrorCodes.NO_NETWORK) {
                    Toast.makeText(this, "NO HAY INTERNET", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(this, "ERROR DESCONOCIDO", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void logged(){
        Toast.makeText(this, "Logged", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        //finish();

    }
}

