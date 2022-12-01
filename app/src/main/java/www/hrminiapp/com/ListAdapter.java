package www.hrminiapp.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Employee> mList;

    public ListAdapter(List<Employee> list, Context context) {
        super();
        mList = list;
    }

    // returns the inflated view
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    // sets the text of the text views in the inflated view
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Employee emp = mList.get(position);
        ((ViewHolder) holder).mId.setText(String.valueOf(emp.getId()));
        ((ViewHolder) holder).mName.setText(emp.getName());
        ((ViewHolder) holder).mDesig.setText(emp.getDesig());
        ((ViewHolder) holder).mDept.setText(emp.getDept());
        ((ViewHolder) holder).mEmail.setText(emp.getEmailid());
        ((ViewHolder) holder).mSalary.setText(String.valueOf(emp.getSalary()));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder {
    public TextView mId, mName, mDesig, mDept, mEmail, mSalary;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mId = itemView.findViewById(R.id.txtId);
        mName = itemView.findViewById(R.id.txtName);
        mDesig = itemView.findViewById(R.id.txtDesig);
        mDept = itemView.findViewById(R.id.txtDept);
        mEmail = itemView.findViewById(R.id.txtEmail);
        mSalary = itemView.findViewById(R.id.txtSalary);
    }
}
