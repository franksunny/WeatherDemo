package com.frank.weatherdemo.ui.fragment;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.frank.weatherdemo.R;
import com.frank.weatherdemo.ui.activity.base.BaseActivity;

import static com.frank.weatherdemo.utils.LogUtil.makeLogTag;


public class ProgressDialog extends DialogFragment {
    @SuppressWarnings("unused")
    private static final String TAG = makeLogTag(ProgressDialog.class);
    private static final String PARAM_DESC = "_desc";
    private static final String PROGRESS_TAG = "_progress";


    public ProgressDialog() {
        // Required empty public constructor
    }

    public static void display(BaseActivity activity, int descId) {
        if (activity.isPaused || activity.isFinishing()) {
            return;
        }

        FragmentManager fm = activity.getSupportFragmentManager();
        ProgressDialog.newInstance(descId).show(fm, PROGRESS_TAG);

        //after transaction you must call the executePendingTransactions
        fm.executePendingTransactions();
    }

    public static void dismiss(BaseActivity activity) {
        Fragment fragment = activity.getSupportFragmentManager().findFragmentByTag(PROGRESS_TAG);
        if (fragment instanceof ProgressDialog) {
            ((ProgressDialog) fragment).dismiss();
        }
    }

    private static ProgressDialog newInstance(int resId) {
        ProgressDialog progressDialog = new ProgressDialog();
        Bundle b = new Bundle();
        b.putInt(PARAM_DESC, resId);
        progressDialog.setArguments(b);
        return progressDialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        android.app.ProgressDialog pd = new android.app.ProgressDialog(getActivity());
        int resId = getArguments().getInt(PARAM_DESC, 0);
        pd.setMessage(getString(resId == 0 ? R.string.common_blocking_please_wait : resId));
        return pd;
    }
}
