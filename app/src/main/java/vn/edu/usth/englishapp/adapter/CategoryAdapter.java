package vn.edu.usth.englishapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import vn.edu.usth.englishapp.R;
import vn.edu.usth.englishapp.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<Category> mListCategory;

    private CategoryItemListener listener;



    public void setData(List<Category> categories, CategoryItemListener listener) {
        this.mListCategory = categories;
        this.listener = listener;
        notifyDataSetChanged();
    }

    public void addCategoryAdmin(Category category) {
        this.mListCategory.add(category);
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = mListCategory.get(position);
        if (category == null) {
            return;
        }
        holder.tvTitle.setText(category.getName());
        holder.imgCategory.setImageResource(category.getResourceId());
        holder.imgCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickCategory(category);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListCategory != null) {
            return mListCategory.size();
        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgCategory;
        private TextView tvTitle;

        public CategoryViewHolder(@NonNull View itemView){
            super(itemView);
            imgCategory = itemView.findViewById(R.id.img_category);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }

    public interface CategoryItemListener {
        void onClickCategory(Category category);
    }
}
