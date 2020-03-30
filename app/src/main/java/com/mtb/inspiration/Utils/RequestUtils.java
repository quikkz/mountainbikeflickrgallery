package com.mtb.inspiration.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.Locale;

public class RequestUtils {
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static String getErrorMessageBasedOnErrorCode(int errorCode){
        switch (errorCode){
            case 96:
                return "Invalid signature";
            case 98:
                return "Invalid auth token";
            case 100:
                return "The API key passed was not valid or has expired.";
            case 105:
                return "Service currently unavailable";
            case 106:
                return "Write operation failed";
            case 111:
                return "Format not found";
            case 112:
                return "Method not found";
            case 114:
                return "Invalid SOAP envelope";
            case 115:
                return "Invalid XML-RPC Method Call";
            case 116:
                return "Bad URL found";
            default:
                return "";
        }
    }
}
