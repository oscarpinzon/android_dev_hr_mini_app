package www.hrminiapp.com;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class InvalidDialog extends DialogFragment {
    // basic onCreate method
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Invalid Username or Password")
                .setTitle("Login Failed")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast toast = Toast.makeText(getActivity(), "Positive Button Clicked", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
