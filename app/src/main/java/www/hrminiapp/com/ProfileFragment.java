package www.hrminiapp.com;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    View v;
    ImageView imgProfilePic;
    Intent cameraIntent;

    public ProfileFragment() {
        // Required empty public constructor
    }

    // inflates the view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_profile, container, false);
        imgProfilePic = v.findViewById(R.id.imageProfilePic);
        CaptureImage();
        return v;
    }

    // method to capture image
    private void CaptureImage() {
        imgProfilePic.setOnClickListener(v -> {
            checkPermissionAndOpenCamera();
        });
    }

    // method to check permission and open camera
    public void checkPermissionAndOpenCamera() {
        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.CAMERA}, 5);
        } else {
            takePhoto();
        }
    }

    // method to take photo
    private void takePhoto() {
        cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startForResult.launch(cameraIntent);
    }

    // method to get result from camera
    // implements contract
    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result != null && result.getResultCode() == RESULT_OK) {
                if(result.getData() != null) {
                    Bundle extras = result.getData().getExtras();
                    Bitmap imageBitmap = (Bitmap) extras.get("data");
                    imgProfilePic.setImageBitmap(imageBitmap);
                }
            }
        }
    });
}