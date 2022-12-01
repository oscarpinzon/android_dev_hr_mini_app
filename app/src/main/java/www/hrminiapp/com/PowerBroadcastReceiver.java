package www.hrminiapp.com;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class PowerBroadcastReceiver extends BroadcastReceiver {
    // basic onReceive method
    // makes the toast when the broadcast is received
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            Toast.makeText(context, "Power connected", Toast.LENGTH_LONG).show();
        }
    }
}
