package www.hrminiapp.com;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListEmpFragment extends Fragment {
    View v;
    RecyclerView rcView;
    List<Employee> mList = new ArrayList<>();
    DBHelper dbh;
    ListAdapter mAdapter;

    public ListEmpFragment() {
        // Required empty public constructor
    }

    // basic onCreate method
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //returns the inflated view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_list_emp, container, false);

        rcView = v.findViewById(R.id.rcView);

        dbh = new DBHelper(getActivity());

        Cursor cursor1 = dbh.ListEmployee();

        if (cursor1 == null) {
            Toast.makeText(getActivity(), "No employee records found", Toast.LENGTH_LONG).show();
        } else {
            cursor1.moveToFirst();

            do {
                Employee emp = new Employee();
                emp.setId(cursor1.getInt(0));
                emp.setName(cursor1.getString(1));
                emp.setDesig(cursor1.getString(2));
                emp.setDept(cursor1.getString(4));
                emp.setEmailid(cursor1.getString(4));
                emp.setSalary(cursor1.getInt(5));
                mList.add(emp);
            } while (cursor1.moveToNext());

            cursor1.close();
            dbh.close();
            BindAdapter();
        }
        return v;
    }

    //binds the adapter to the recycler view
    private void BindAdapter() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rcView.setLayoutManager(layoutManager);
        mAdapter = new ListAdapter(mList, getContext());
        rcView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}