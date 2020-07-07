package com.rohankadkol.favoritedogsappfinal.utils;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.rohankadkol.favoritedogsappfinal.R;
import com.rohankadkol.favoritedogsappfinal.pojos.Dog;

public final class AlertDialogUtils {
    private AlertDialogUtils() {
    }

    public static void showDeleteAlertDialog(final Context context,
                                                   DialogInterface.OnClickListener onPositiveClicked,
                                                   DialogInterface.OnClickListener onNegativeClicked) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.delete_alert_title));
        builder.setIcon(context.getResources().getDrawable(R.drawable.ic_warning));
        builder.setMessage(context.getResources().getString(R.string.delete_alert_message));
        builder.setPositiveButton(context.getResources().getString(R.string.delete_alert_positive_text), onPositiveClicked);
        builder.setNegativeButton(context.getResources().getString(R.string.delete_alert_negative_text), onNegativeClicked);
        builder.create().show();
    }
}
