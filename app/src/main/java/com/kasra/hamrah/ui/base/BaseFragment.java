package com.kasra.hamrah.ui.base;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kasra.hamrah.R;
import com.kasra.hamrah.util.MyProgressDialog;
import com.kasra.hamrah.util.SetLanguage;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.Locale;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class BaseFragment extends Fragment {

    Context context;
    MyProgressDialog progressBar;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context != null) {
            this.context = context;
            SetLanguage.updateLanguage(context, Locale.getDefault().getLanguage());
            super.onAttach(CalligraphyContextWrapper.wrap(context));
        }
    }

    public void showMessage(String message) {
        if (message != null && context != null) {
            new StyleableToast
                    .Builder(context)
                    .text(message)
                    .textColor(context.getResources().getColor(R.color.color_black))
                    .backgroundColor(context.getResources().getColor(R.color.color_white))
                    .stroke(1, context.getResources().getColor(R.color.colorPrimaryDark))
                    .show();
        }
    }

    public void showErrorMessage(String message) {
        if (message != null && context != null) {
            new StyleableToast
                    .Builder(context)
                    .text(message)
                    .textColor(context.getResources().getColor(R.color.color_red))
                    .backgroundColor(context.getResources().getColor(R.color.color_white))
                    .stroke(1, context.getResources().getColor(R.color.colorPrimary))
                    .show();
        }
    }


    public void showProgress() {
        if (progressBar == null || !progressBar.isShowing()) {
            progressBar = new MyProgressDialog(context);
            progressBar.show();
        }
    }

    public void hideProgress() {
        if (progressBar != null)
            if (progressBar.isShowing())
                progressBar.dismiss();
    }


    public Typeface getIranSansTypeFace() {
        return Typeface.createFromAsset(context.getAssets(), context.getResources().getString(R.string.iransans_font));
    }

    public Typeface getCasablancaTypeFace() {
        return Typeface.createFromAsset(context.getAssets(), context.getResources().getString(R.string.casablanca_font));
    }

    public Typeface getBHomaTypeFace() {
        return Typeface.createFromAsset(context.getAssets(), context.getResources().getString(R.string.bhoma_font));
    }

    public Typeface getCasablancaHeavyTypeFace() {
        return Typeface.createFromAsset(context.getAssets(), context.getResources().getString(R.string.casablanca_heavy_font));
    }

    public Typeface getCasablancaLightTypeFace() {
        return Typeface.createFromAsset(context.getAssets(), context.getResources().getString(R.string.casablanca_light_font));
    }

}