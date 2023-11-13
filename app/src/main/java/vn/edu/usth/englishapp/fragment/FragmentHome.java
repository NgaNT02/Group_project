package vn.edu.usth.englishapp.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
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
import vn.edu.usth.englishapp.adapter.CategoryAdapter;
import vn.edu.usth.englishapp.model.Category;
import vn.edu.usth.englishapp.service.TestData;
import vn.edu.usth.englishapp.utils.Constant;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class FragmentHome extends Fragment {

    ImageSlider imageSlider;

    SearchView searchView;

    RecyclerView rvCategory;

    RecyclerView rvRecent;

    RecyclerView rvArticle;

    Button bt;

    String uuid;

//    List<WordRecent> mListWordRecent = new ArrayList<>();
//
//    List<Article> mListArticle = new ArrayList<>();
//
//    FirebaseHelper helper = new FirebaseHelper();

    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageSlider = view.findViewById(R.id.imgSlider);
        uuid = getUIDCurrentUser();
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.slide1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slide2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slide3, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        rvCategory = view.findViewById(R.id.rvCategory);
        rvRecent = view.findViewById(R.id.rvWordRecent);
        rvArticle = view.findViewById(R.id.rvArticle);
        bt = view.findViewById(R.id.btThamGia);
        searchView = view.findViewById(R.id.searchViewHome);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
           public boolean onQueryTextSubmit(String s) {
//                Intent intent = new Intent(getContext(), OxfordActivity.class);
//                intent.putExtra("search", s);
//                helper.addRecentData(uuid, s, Constant.TypeDictionary.OXFORD);
//                startActivity(intent);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 5);
        CategoryAdapter categoryAdapter = new CategoryAdapter();
        categoryAdapter.setData(TestData.getListCategory(), new CategoryAdapter.CategoryItemListener() {
            @Override
            public void onClickCategory(Category category) {
//                handleOnClick(category);
            }
        });

//        if (uuid.equals("h6jsQkoGGfbFPTD0r85w6gRshhz1")) {
//            categoryAdapter.addCategoryAdmin(new Category(R.drawable.ic_thongke, "Statistical", ""));
//            categoryAdapter.addCategoryAdmin(new Category(R.drawable.ic_article, "Article", ""));
//        }

        rvCategory.setLayoutManager(layoutManager);
        rvCategory.setAdapter(categoryAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
//        WordRecentAdapter wordRecentAdapter = new WordRecentAdapter();

//        wordRecentAdapter.setData(TestData.getWordRecent());
        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference().child("word_recent").child(uuid);
//        myRef.addValueEventListener(new ValueEventListener() {
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
//                wordRecentAdapter.setData(mListWordRecent);
////                mListWordRecent.forEach(System.out::println);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(getContext(), "Có lỗi xảy ra", Toast.LENGTH_SHORT).show();
//            }
//        });

//        wordRecentAdapter.setMListener(new WordRecentAdapter.OnClickListener() {
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
        rvRecent.setLayoutManager(linearLayoutManager);
//        rvRecent.setAdapter(wordRecentAdapter);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        ArticleAdapter adapter = new ArticleAdapter();
//        adapter.setListen(new ArticleAdapter.IListenerArticle() {
//            @Override
//            public void onClick(Article article) {
//                handlerClickArticle(article);
//            }
//        });
//
//        FirebaseDatabase db = FirebaseDatabase.getInstance();
//        DatabaseReference articleRef = db.getReference().child("article");
//
//        articleRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (mListArticle != null) {
//                    mListArticle.clear();
//                }
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                    Article yourWord = dataSnapshot.getValue(Article.class);
//                    mListArticle.add(yourWord);
//                }
//                mListArticle.sort(Comparator.comparing(Article::getTime).reversed());
//                adapter.setMListArticle(mListArticle);
//            }

//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {

//            }
//        });


        rvArticle.setLayoutManager(linearLayoutManager1);
        rvArticle.setNestedScrollingEnabled(false);
//        rvArticle.setAdapter(adapter);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationGroupFacebook();
            }
        });
    }

//    private void handlerClickArticle(Article article) {
//        helper.addLogCareArticle(article); // add log article
//        Intent intent = new Intent(getContext(), ArticleActivity.class);
//        intent.putExtra("article", article);
//        startActivity(intent);
//    }

    private void navigationGroupFacebook() {
        String groupId = "d19cnat";
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://group/" + groupId));
            startActivity(intent);
        } catch (Exception e) {
            // Nếu không cài đặt Facebook trên thiết bị, hãy mở trang nhóm trong trình duyệt web.
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/groups/" + groupId));
            startActivity(intent);
        }
    }

//    private void handleOnClick(Category category) {
//        Intent intent;
//        DatabaseReference careRef = mDatabase.child("extend_feature");
//        switch (category.getName()) {
//            case "Oxford":
//                intent = new Intent(getContext(), OxfordActivity.class);
//                startActivity(intent);
//                break;
//            case "Quiz":
//                intent = new Intent(getContext(), DailyWordActivity.class);
//                startActivity(intent);
//                break;
//            case "3KWord":
//                intent = new Intent(getContext(), SearchActivity.class);
//                startActivity(intent);
//                break;
//            case "Topic":
//                intent = new Intent(getContext(), TopicActivity.class);
//                startActivity(intent);
//                break;
//            case "Dic109K":
//                intent = new Intent(getContext(), Dic109KActivity.class);
//                startActivity(intent);
//                break;
//            case "Statistical":
//                intent = new Intent(getContext(), ChartActivity.class);
//                startActivity(intent);
//                break;
//            case "Article":
//                intent = new Intent(getContext(), CreateVoteActivity.class);
//                startActivity(intent);
//                break;
//            case "Translate":
//                careRef.child(uuid).addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        EndDate endDate = snapshot.getValue(EndDate.class);
//                        if (endDate != null && (endDate.isNeverEnd() || endDate.getDateEnd() >= new Date().getTime())) {
//                            Intent intent = new Intent(getContext(), TranslateTextActivity.class);
//                            startActivity(intent);
//                        } else {
//                            Toast.makeText(getContext(), "Tài khoản chưa trả phí hoặc đã hết hạn", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//                break;
//            case "Pronounce":
//                final boolean[] isPayment1 = {false};
//                careRef.child(uuid).addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        EndDate endDate = snapshot.getValue(EndDate.class);
//                        if (endDate != null && (endDate.isNeverEnd() || endDate.getDateEnd() >= new Date().getTime())) {
//                            Intent intent = new Intent(getContext(), PronounceActivity.class);
//                            startActivity(intent);
//                        } else {
//                            Toast.makeText(getContext(), "Tài khoản chưa trả phí hoặc đã hết hạn", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//                break;
//        }
//    }

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
