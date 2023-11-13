package vn.edu.usth.englishapp.fragment;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import vn.edu.usth.englishapp.MainActivity;
import vn.edu.usth.englishapp.R;
import vn.edu.usth.englishapp.utils.Commons;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FragmentAccount extends Fragment {


    private FirebaseAuth mAuth;
    Button vote, nhacNho, upload, huongDan, version, btPrivate;
    Button dieuKhoan, dangXuat;

    SwitchCompat switchCompat;

    TextView email, name;

    ImageView avatar;

    private int hour = 9;
    private int minute = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        vote = view.findViewById(R.id.btVote);
        nhacNho = view.findViewById(R.id.btNhacNho);
        upload = view.findViewById(R.id.btUploadProfile);
        huongDan = view.findViewById(R.id.btHuongDanSuDung);
        version = view.findViewById(R.id.btVersion);
        btPrivate = view.findViewById(R.id.btPrivate);
        dieuKhoan = view.findViewById(R.id.btDieuKhoan);
        dangXuat = view.findViewById(R.id.btDangXuat);
        email = view.findViewById(R.id.profile_email);
        avatar = view.findViewById(R.id.profile_image);
        name = view.findViewById(R.id.profile_name);
        switchCompat = view.findViewById(R.id.switchNhacNho);

        nhacNho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Chức năng này đang được triển khai", Toast.LENGTH_SHORT).show();
            }
        });

        String t = nhacNho.getText().toString();
        if (t.toLowerCase(Locale.ROOT).startsWith("nhắc nhở")) {
            String hm[] = t.substring(9).split(":");
            hour = Integer.parseInt(hm[0].trim());
            minute = Integer.parseInt(hm[1].trim());
        }

        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            // Lấy URL ảnh đại diện từ Firebase
            Uri photoUrl = user.getPhotoUrl();
            if (photoUrl != null) {
                String profileImageUrl = photoUrl.toString();
                // Hiển thị ảnh đại diện trong ImageView bằng Glide
                Glide.with(FragmentAccount.this)
                        .load(profileImageUrl)
                        .apply(new RequestOptions()
                                .placeholder(R.drawable.circle_background) // Ảnh mặc định hiển thị trong quá trình tải
                                .circleCrop()) // Hiển thị ảnh trong hình tròn
                        .into(avatar);
            }
            String email1 = user.getEmail(); // Lấy địa chỉ email
            String name1 = user.getDisplayName(); // Lấy tên tài khoản

            email.setText(email1);
            name.setText(name1);
        }

        vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Chức năng này đang được triển khai", Toast.LENGTH_SHORT).show();
            }
        });

        btPrivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
                startActivity(intent);
            }
        });
        dieuKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
                startActivity(intent);
            }
        });
        version.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
                startActivity(intent);
            }
        });
        huongDan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
                startActivity(intent);
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Chức năng này đang được triển khai", Toast.LENGTH_SHORT).show();
            }
        });
        dangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Chức năng này đang được triển khai", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    private void handleShowAlert() {
//        final Dialog digDialog = new Dialog(getContext());
//        digDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        digDialog.setContentView(R.layout.diglog_vote);
//
//        Window window = digDialog.getWindow();
//        if (window == null) {
//            return;
//        }
//
//        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//        WindowManager.LayoutParams windowAttribute = window.getAttributes();
//        windowAttribute.gravity = Gravity.CENTER;
//
//        window.setAttributes(windowAttribute);
//
//        digDialog.setCancelable(true); // click ra tat diglog;
//
//        EditText title, content, name;
//        RatingBar ratingBar;
//        Button btnAdd, btnCancel;
//        title = digDialog.findViewById(R.id.titleVote);
//        content = digDialog.findViewById(R.id.contentVote);
//        name = digDialog.findViewById(R.id.nameVote);
//        ratingBar = digDialog.findViewById(R.id.rateVote);
//        ratingBar.setRating(5);
//
//        btnAdd = digDialog.findViewById(R.id.btGopY);
//        btnCancel = digDialog.findViewById(R.id.btVoteCancel);
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getContext(), "Chức năng này đang được triển khai", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        btnCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                digDialog.dismiss();
//            }
//        });
//        digDialog.show();
//    }
}
