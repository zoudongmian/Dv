package android.com.myapplication.News;

import android.com.myapplication.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/7/5.
 */

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.ViewHold> {
    private List<Dog> mDogList;

    static class ViewHold extends RecyclerView.ViewHolder{
        ImageView dogImage;
        TextView dogName;
        public ViewHold(View view){
            super(view);
            dogImage = (ImageView)view.findViewById(R.id.dog_image);
            dogName = (TextView)view.findViewById(R.id.dog_name);
        }
    }
    public DogAdapter(List<Dog>dogList){
        mDogList = dogList;
    }
    @Override
    public ViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
         View view =LayoutInflater.from(parent.getContext())
                 .inflate(R.layout.dog_item,parent,false);
        ViewHold holder = new ViewHold(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHold holder, int position) {
        Dog dog = mDogList.get(position);
        holder.dogImage.setImageResource(dog.getImageId());
        holder.dogName.setText(dog.getName());
    }

    @Override
    public int getItemCount() {
        return mDogList.size();
    }


}
