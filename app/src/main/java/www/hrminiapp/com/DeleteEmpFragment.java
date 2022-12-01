package www.hrminiapp.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class DeleteEmpFragment extends Fragment {
    View v;
    EditText edtEmpId;
    Button btnDelete;

    public DeleteEmpFragment() {
        // Required empty public constructor
    }

    // basic onCreate method
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //returns the inflated view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_delete_emp, container, false);
        edtEmpId = v.findViewById(R.id.edtEmpId);
        btnDelete = v.findViewById(R.id.btnDelete);
        return v;
    }
}