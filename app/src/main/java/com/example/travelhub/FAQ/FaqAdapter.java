package com.example.travelhub.FAQ;


import static android.view.View.GONE;

import android.content.Context;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;

import com.example.travelhub.R;

import java.util.List;

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.FaqItem> {

    Context C;
    List<FaqModel> list;

    public FaqAdapter(Context c, List<FaqModel> list) {
        C = c;
        this.list = list;
    }

    @NonNull
    @Override
    public FaqItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(C).inflate(R.layout.item_faq, parent, false);

        return new FaqItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FaqItem holder, int position) {
        FaqModel model = list.get(position);

        holder.txtQuestion.setText(model.Question);
        holder.txtAnswer.setText(model.Answer);
        holder.imgIcon.setImageResource(model.Image);

        holder.itemView.setOnClickListener(v -> {

            //Includes questions, answers and photos
            ViewGroup container = holder.itemView.findViewById(R.id.frame);

            TransitionManager.beginDelayedTransition(container, new ChangeBounds());

            if (holder.txtAnswer.getVisibility() == GONE) {
                holder.txtAnswer.setVisibility(View.VISIBLE);

                //Move the photo to the middle.
                holder.imgIcon.animate()
                        .translationX(container.getWidth()/2 - holder.imgIcon.getWidth()/2)
                        .translationY(container.getHeight()/2 - holder.imgIcon.getHeight()/2)
                        .setDuration(300)
                        .start();

            } else {
                holder.txtAnswer.setVisibility(GONE);

                //Return the photo to its original location.
                holder.imgIcon.animate()
                        .translationX(0)
                        .translationY(0)
                        .setDuration(300)
                        .start();
            }





        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FaqItem extends RecyclerView.ViewHolder {

        TextView txtQuestion, txtAnswer;
        ImageView imgIcon;

        public FaqItem(@NonNull View itemView) {
            super(itemView);
            txtQuestion = itemView.findViewById(R.id.txtQuestion);
            txtAnswer = itemView.findViewById(R.id.txtAnswer);
            imgIcon = itemView.findViewById(R.id.imgIcon);

        }
    }
}
