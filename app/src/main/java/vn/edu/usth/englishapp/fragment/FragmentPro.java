package vn.edu.usth.englishapp.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentPro extends Fragment {

    private RecyclerView vote;

    private Button bt3, btYear, btVV;

//    private List<Vote> mList = new ArrayList<>();

//    String uid = getUIDCurrentUser();

    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pro, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bt3 = view.findViewById(R.id.bt3Thang);
        btYear = view.findViewById(R.id.bt1Nam);
        btVV = view.findViewById(R.id.btVinhVien);
        vote = view.findViewById(R.id.rvVote);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
//        VoteAdapter voteAdapter = new VoteAdapter();
//        voteAdapter.setData(TestData.getVoteUsers());

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference().child("vote");
//                .child(uid);
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (mList != null) {
//                   mList.clear();
                }
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                    Vote yourWord = dataSnapshot.getValue(Vote.class);
//                    mList.add(yourWord);
                }
//                mList.sort(Comparator
//                        .comparing(Vote::getRate)
//                        .reversed());
//                        .thenComparing((Vote item) -> Long.parseLong(item.getDateCreate())).reversed());
//                voteAdapter.setData(mList.stream().filter(vote1 -> vote1.getRate() >= 4).collect(Collectors.toList()));
//            }

//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(getContext(), "Có lỗi xảy ra", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//        vote.setAdapter(voteAdapter);
//        vote.setLayoutManager(linearLayoutManager);
//        DatabaseReference careRef = mDatabase.child("extend_feature");
//
//        bt3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                careRef.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        EndDate endDate = snapshot.getValue(EndDate.class);
//                        if (endDate != null && endDate.isNeverEnd()) {
//                            payment(299000L);
//                        } else {
//                            Toast.makeText(getContext(), "Bạn đã đăng ký gói vĩnh viễn rồi", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//
//            }
//        });
//
//        btYear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                careRef.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        EndDate endDate = snapshot.getValue(EndDate.class);
//                        if (endDate != null && endDate.isNeverEnd()) {
//                            payment(499000L);
//                        } else {
//                            Toast.makeText(getContext(), "Bạn đã đăng ký gói vĩnh viễn rồi", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//            }
//        });
//
//        btVV.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                careRef.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        EndDate endDate = snapshot.getValue(EndDate.class);
//                        if (endDate != null && endDate.isNeverEnd()) {
//                            payment(1399000L);
//                        } else {
//                            Toast.makeText(getContext(), "Bạn đã đăng ký gói vĩnh viễn rồi", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//            }
//        });
//    }
//
//    private void payment(Long price) {
//        PayModel payModel = new PayModel();
//        payModel.setUid(getUIDCurrentUser());
//        payModel.setVnp_Ammount(price * 100);
//        payModel.setVnp_TxnRef(new Random().nextLong());
//        payModel.setVnp_OrderInfo("Thanh toán ứng dụng tiếng anh");
//        payModel.setVnp_OrderType("Pay");
//        APIPayment.apiService.getUrlPayment(payModel).enqueue(new Callback<EnglishResponse<String>>() {
//            @Override
//            public void onResponse(Call<EnglishResponse<String>> call, Response<EnglishResponse<String>> response) {
//                EnglishResponse<String> data = response.body();
//                String url = data.getData();
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse(url));
//                startActivity(intent);
//            }
//
//            @Override
//            public void onFailure(Call<EnglishResponse<String>> call, Throwable t) {
//                Toast.makeText(getContext(), "Có lỗi xảy ra khi thanh toán", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    public String getUIDCurrentUser() {
//        String uid = null;
//        FirebaseAuth auth = FirebaseAuth.getInstance();
//        FirebaseUser user = auth.getCurrentUser();
//
//        if (user != null) {
//            uid = user.getUid();
//        }
//        if (uid != null) return uid;
//
//        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getContext());
//        if (account != null) {
//            uid = account.getId();
//        }
//        return uid;
//    }
//}
