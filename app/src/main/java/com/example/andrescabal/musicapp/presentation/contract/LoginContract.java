package com.example.andrescabal.musicapp.presentation.contract;

/**
 * Created by Andrés Cabal on 18/04/2018.
 */

public interface LoginContract {
    //contratos
    //vista marioneta del presenter
    interface View {
        void disableButton();
        void enableButton();
        void goToMain();
        void showLoginMessage(Throwable error);
        void goToCreateAccount();
    }

    //recibe eventos de la vista
    interface Presenter {
        void onLogin(String username,String password,boolean remember);
        void onDontHaveAccount();
    }
}
