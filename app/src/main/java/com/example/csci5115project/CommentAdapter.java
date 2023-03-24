package com.example.csci5115project;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Comment> commentList;

    //getting the context and product list with constructor
    public CommentAdapter(Context mCtx, List<Comment> commentList) {
        this.mCtx = mCtx;
        this.commentList = commentList;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
//        View view = inflater.inflate(R.layout.layout_products, null);
//        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        //getting the product of the specified position
        Comment comment = commentList.get(position);

        //binding the data with the viewholder views
//        holder.textViewTitle.setText(comment.getTitle());
//        holder.textViewShortDesc.setText(comment.getShortdesc());
//        holder.textViewRating.setText(String.valueOf(comment.getRating()));
//        holder.textViewPrice.setText(String.valueOf(comment.getPrice()));

//        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(comment.getImage()));

    }


    @Override
    public int getItemCount() {
        return commentList.size();
    }


    class CommentViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;

        public CommentViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
