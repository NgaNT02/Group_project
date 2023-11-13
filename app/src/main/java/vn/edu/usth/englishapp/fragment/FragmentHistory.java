package vn.edu.usth.englishapp.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import vn.edu.usth.englishapp.R;
//import com.ptit.englishapp.adapter.WordRecentAdapter;
//import com.ptit.englishapp.adapter.WordRecentHistoryAdapter;
//import com.ptit.englishapp.adapter.YourWordAdapter;
//import com.ptit.englishapp.app.Dic109KActivity;
//import com.ptit.englishapp.app.OxfordActivity;
//import com.ptit.englishapp.app.SearchActivity;
//import com.ptit.englishapp.model.WordRecent;
//import com.ptit.englishapp.model.YourWord;
//import com.ptit.englishapp.realtimedatabase.FirebaseHelper;
//import com.ptit.englishapp.utils.Constant;
//import com.ptit.englishapp.service.TestData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FragmentHistory extends Fragment {

    private Button bt;
    private RecyclerView rvYourWord;
    private RecyclerView rvWordRecent;

//    FirebaseHelper firebaseHelper = new FirebaseHelper();

//    List<YourWord> mList = new ArrayList<>();

//    List<WordRecent> mListWordRecent = new ArrayList<>();

    String uuid;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        initView(view);
//        uuid = getUIDCurrentUser();
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
//        YourWordAdapter adapter = new YourWordAdapter();
//
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference().child("your_word").child(uuid);
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (mList != null) {
//                    mList.clear();
//                }
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                    YourWord yourWord = dataSnapshot.getValue(YourWord.class);
//                    mList.add(yourWord);
//                }
//                mList.sort(Comparator.comparing(YourWord::getDateCreate).reversed());
//                adapter.setData(mList);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(getContext(), "Có lỗi xảy ra", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//        adapter.setMListener(new YourWordAdapter.OnClickListener() {
//            @Override
//            public void onClick(YourWord yourWord) {
//                handleShowDigLogUpdateRemove(yourWord);
//            }
//        });
//
//        rvYourWord.setLayoutManager(linearLayoutManager);
//        rvYourWord.setAdapter(adapter);
//
//        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
//        WordRecentHistoryAdapter adapter1 = new WordRecentHistoryAdapter();
////        adapter1.setData(TestData.getWordRecent());
//
//
//        DatabaseReference myRef1 = database.getReference().child("word_recent").child(uuid);
//        myRef1.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (mListWordRecent != null) {
//                    mListWordRecent.clear();
//                }
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                    WordRecent yourWord = dataSnapshot.getValue(WordRecent.class);
//                    mListWordRecent.add(yourWord);
//                }
//                mListWordRecent = new ArrayList<>(new HashSet<>(mListWordRecent));
//                mListWordRecent.sort(Comparator.comparing(WordRecent::getCreateDate).reversed());
//                adapter1.setData(mListWordRecent);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(getContext(), "Có lỗi xảy ra", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        adapter1.setMListener(new WordRecentAdapter.OnClickListener() {
//            @Override
//            public void onClick(WordRecent wordRecent) {
//                if (wordRecent == null) return;
//                Intent intent = null;
//                switch (wordRecent.getTypeDictionary()) {
//                    case Constant.TypeDictionary.OXFORD:
//                        intent = new Intent(getContext(), OxfordActivity.class);
//                        intent.putExtra("search", wordRecent.getRecent());
//                        break;
//                    case Constant.TypeDictionary.DIC3K:
//                        intent = new Intent(getContext(), SearchActivity.class);
//                        intent.putExtra("search", wordRecent.getRecent());
//                        break;
//                    case Constant.TypeDictionary.DIC109K:
//                        intent = new Intent(getContext(), Dic109KActivity.class);
//                        intent.putExtra("search", wordRecent.getRecent());
//                        break;
//                }
//                startActivity(intent);
//            }
//        });
//        rvWordRecent.setAdapter(adapter1);
//        rvWordRecent.setLayoutManager(linearLayoutManager1);
//
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                handleShowDiglogAdd();
//            }
//        });
//
//    }
//
//    private void handleShowDigLogUpdateRemove(YourWord yourWord) {
//        final Dialog digDialog = new Dialog(getContext());
//        digDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        digDialog.setContentView(R.layout.diglog_update_remove_your_word);
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
//        digDialog.setCancelable(false); // click ra ngoai khong the tat diglog;
//
//        EditText word, phonetic, mean, desc, id;
//        Button btnAdd, btnCancel, btRemove;
//        id = digDialog.findViewById(R.id.idUpdateUR);
//        word = digDialog.findViewById(R.id.word109KInfoUR);
//        phonetic = digDialog.findViewById(R.id.phonetic109KInfoUR);
//        mean = digDialog.findViewById(R.id.mean109KInfoUR);
//        desc = digDialog.findViewById(R.id.desc109KInfoUR);
//
//        id.setText(yourWord.getId().toString());
//        word.setText(yourWord.getWord());
//        phonetic.setText(yourWord.getPhonetic());
//        mean.setText(yourWord.getMean());
//        desc.setText(yourWord.getDescription());
//
//        btnAdd = digDialog.findViewById(R.id.btnUpdateYourWordUR);
//        btnCancel = digDialog.findViewById(R.id.btnCancelYourWordUR);
//        btRemove = digDialog.findViewById(R.id.btnRemovelYourWordUR);
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (word.getText().toString().isEmpty()) {
//                    Toast.makeText(getContext(), "Không được để trống từ", Toast.LENGTH_SHORT).show();
//                } else {
//                    YourWord yourWord = new YourWord(Long.parseLong(id.getText().toString()), word.getText().toString(), phonetic.getText().toString(), mean.getText().toString(), desc.getText().toString(), uuid, new Date());
//                    handleUpdateWord(yourWord);
//                    Toast.makeText(getContext(), "Cập nhật thành công", Toast.LENGTH_SHORT).show();
//                    digDialog.dismiss();
//                }
//            }
//        });
//
//        btnCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                digDialog.dismiss();
//            }
//        });
//
//        btRemove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                handleRemoveWord(id.getText().toString());
//                Toast.makeText(getContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();
//                digDialog.dismiss();
//            }
//        });
//        digDialog.show();
//    }
//
//    private void handleUpdateWord(YourWord yourWord) {
//        firebaseHelper.updateYourWord(uuid, yourWord.getId().toString(), yourWord);
//    }
//
//    private void handleRemoveWord(String id) {
//        firebaseHelper.deleteYourWord(uuid, id);
//    }
//
//    private void handleShowDiglogAdd() {
//        final Dialog digDialog = new Dialog(getContext());
//        digDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        digDialog.setContentView(R.layout.diglog_add_your_word);
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
//        digDialog.setCancelable(false); // click ra ngoai khong the tat diglog;
//
//        EditText word, phonetic, mean, desc;
//        Button btnAdd, btnCancel;
//        word = digDialog.findViewById(R.id.word109KInfoAdd);
//        phonetic = digDialog.findViewById(R.id.phonetic109KInfoAdd);
//        mean = digDialog.findViewById(R.id.mean109KInfoAdd);
//        desc = digDialog.findViewById(R.id.desc109KInfoAdd);
//
//        btnAdd = digDialog.findViewById(R.id.btnAddYourWord);
//        btnCancel = digDialog.findViewById(R.id.btnCancelYourWord);
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (word.getText().toString().isEmpty()) {
//                    Toast.makeText(getContext(), "Ít nhất phải nhập từ", Toast.LENGTH_SHORT).show();
//                } else {
//                    YourWord yourWord = new YourWord(new Random().nextLong(), word.getText().toString(), phonetic.getText().toString(), mean.getText().toString(), desc.getText().toString(), uuid, new Date());
//                    handleAddWord(yourWord);
//                    Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
//                    digDialog.dismiss();
//                }
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
//
//    private void handleAddWord(YourWord yourWord) {
//        firebaseHelper.addYourWord(getUIDCurrentUser(), yourWord);
//    }

    private void initView(View view) {
        bt = view.findViewById(R.id.btXemThem);
        rvYourWord = view.findViewById(R.id.rvTuCuaBan);
        rvWordRecent = view.findViewById(R.id.rvTuDaTra);
    }

    public String getUIDCurrentUser() {
        String uid = null;
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        if (user != null) {
            uid = user.getUid();
        }
        if (uid != null) return uid;

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getContext());
        if (account != null) {
            uid = account.getId();
        }
        return uid;
    }
}
