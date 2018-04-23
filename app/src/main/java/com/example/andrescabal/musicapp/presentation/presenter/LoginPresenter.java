package com.example.andrescabal.musicapp.presentation.presenter;

import com.example.andrescabal.musicapp.presentation.contract.LoginContract;

/**
 * Created by Andrés Cabal on 18/04/2018.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void onLogin(String username, String password, boolean remember) {
        view.disableButton();
        //TODO LLAMAR CASO DE USO
        view.enableButton();
        //si ok
        view.goToMain();
        //error
        view.showLoginMessage(null);
    }

    @Override
    public void onDontHaveAccount() {
        view.goToCreateAccount();
    }
}
