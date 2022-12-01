package www.hrminiapp.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class AddEmpFragment extends Fragment {
    View v;
    EditText edtName, edtDesig, edtDepart, edtEmail, edtSalary;
    Button btnSubmit;
    DBHelper dbh;
    Boolean insertStatus;

    public AddEmpFragment() {
        // Required empty public constructor
    }
    // basic onCreate method
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //creates the view and sets onclick listener for the button
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_add_emp, container, false);
        edtName = v.findViewById(R.id.edtName);
        edtDesig = v.findViewById(R.id.edtDesig);
        edtDepart = v.findViewById(R.id.edtDepartment);
        edtEmail = v.findViewById(R.id.edtEmailId);
        edtSalary = v.findViewById(R.id.edtSalary);
        btnSubmit = v.findViewById(R.id.btnSubmit);
        dbh = new DBHelper(getActivity());

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee objEmp = CreateEmployee();
                insertStatus = dbh.InsertEmployee(objEmp);
                if (insertStatus) {
                    Toast.makeText(getActivity(), "Employee Added Successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), "Employee Addition Failed", Toast.LENGTH_LONG).show();
                }
            }
        });

        return v;
    }

    //creates an employee object from the data entered in the edit text fields
    private Employee CreateEmployee() {
        Employee objEmp = new Employee();
        objEmp.setName(edtName.getText().toString().trim());
        objEmp.setDesig(edtDesig.getText().toString().trim());
        objEmp.setDept(edtDepart.getText().toString().trim());
        objEmp.setEmailid(edtEmail.getText().toString().trim());
        objEmp.setSalary(Integer.parseInt(edtSalary.getText().toString().trim()));
        return objEmp;
    }
}