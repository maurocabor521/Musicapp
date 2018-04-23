package com.example.andrescabal.musicapp.presentation.view.activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.example.andrescabal.musicapp.R;
import com.example.andrescabal.musicapp.presentation.contract.LoginContract;
import com.example.andrescabal.musicapp.presentation.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,LoginContract.View {

    TextInputEditText username;
    TextInputEditText password;
    Switch remember;
    Button btnsesion;
    Button btndonthaveacount;
    Button swRemember;
    LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username =  findViewById(R.id.etusername);
        password =  findViewById(R.id.etpassword);
        remember = (Switch) findViewById(R.id.swRemenber);
        btnsesion = (Button) findViewById(R.id.btnsesion);
        btndonthaveacount = (Button) findViewById(R.id.btndonthaveacount);
        btnsesion.setOnClickListener(this);
        btndonthaveacount.setOnClickListener(this);
        //
        presenter=new LoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnsesion:/* paso a goToMain
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);*/
                onLogin();
                break;
            case R.id.btndonthaveacount:
                presenter.onDontHaveAccount();
                break;
        }
    }

    @Override
    public void disableButton() {
        btnsesion.setEnabled(false);
        btndonthaveacount.setEnabled(false);
        swRemember.setEnabled(false);
    }

    @Override
    public void enableButton() {
        btnsesion.setEnabled(true);
        btndonthaveacount.setEnabled(true);
        swRemember.setEnabled(true);
    }

    @Override
    public void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        //para que no puede dar back como si estuviera logueado,quita de la pila el activity
        finish();
    }

    @Override
    public void showLoginMessage(Throwable error) {
        //TODO PENDINTE IMPLEMENTAR AGREGAR UN TEXTVIEW EN EL LAYOUT PARA MOSTRAR EL ERRORs
    }

    @Override
    public void goToCreateAccount() {
        //TODO MOSTRAR O ABRIR PAGINAS DE REGISTRO DE LAST.FM
    }
    private void onLogin(){
        String strusername=username.getText().toString();
        String stpassword=password.getText().toString();
        boolean blremember=remember.isChecked();
        presenter.onLogin(strusername,stpassword,blremember);
    }
}
