package win.pipi.swiftemotionboard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import win.pipi.swiftemotionboard.R;
import win.pipi.swiftemotionboard.R2;
import win.pipi.swiftemotionboard.fragment.Communicator;
import win.pipi.swiftemotionboard.model.EmotionGroup;
import win.pipi.swiftemotionboard.model.OneEmotion;

/**
 * Created by pipi6 on 2018/1/24.
 */

public class AEmotionAdapter extends RecyclerView.Adapter<AEmotionAdapter.AEmotionViewHolder> {

    private EmotionGroup memotionGroup;

    private Communicator mCommunicator;
    private Context context;

    public AEmotionAdapter(Context context1, EmotionGroup emotionGroup, Communicator communicator) {
        context=context1;
        memotionGroup=emotionGroup;
        mCommunicator=communicator;
    }



    @Override
    public AEmotionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_emotion_item, parent, false);


        return new AEmotionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AEmotionViewHolder holder, int position) {
        final OneEmotion oneEmotion=memotionGroup.getEmotions().get(position);
        String uri=oneEmotion.getUri();

        holder.textviewOneEmotion.setText(oneEmotion.getTextRepresent());

        Glide.with(context)
                .load(uri)
                .into(holder.imageviewOneEmotion);


        holder.imageviewOneEmotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCommunicator!=null){
                    mCommunicator.setText(oneEmotion.getTextRepresent());
                }
            }
        });


    }




    @Override
    public int getItemCount() {
        return memotionGroup.getEmotions().size();
    }



    static class AEmotionViewHolder extends ViewHolder {
        @BindView(R2.id.imageview_one_emotion)
        ImageView imageviewOneEmotion;
        @BindView(R2.id.textview_one_emotion)
        TextView textviewOneEmotion;

        public AEmotionViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
