package com.sandy.sandtracker.Activities.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.sandy.sandtracker.Activities.Beans.CountryBeans;
import com.sandy.sandtracker.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class CountryListAdapter extends RecyclerView.Adapter {
    public OnItemLongClickListener mItemLongClickListener;
    public OnItemClickListener mItemClickListener;

    Context context;
    Object object = new Object();
    ArrayList<CountryBeans> menuList;


    public CountryListAdapter(Context context, ArrayList<CountryBeans> menuList) {
        this.context = context;
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_country, viewGroup, false);

        return new ViewHolder(v);

    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        //Here you can fill your row view

        if (holder instanceof ViewHolder) {
            final CountryBeans name = getItem(position);
            final ViewHolder genericViewHolder = (ViewHolder) holder;
            genericViewHolder.tvCountryName.setText(name.getC_name());
            genericViewHolder.tvAcctCase.setText(name.getConfirmed());
            genericViewHolder.tvDeathCase.setText(name.getDeaths());
            genericViewHolder.tvDate.setText(name.getTime());
            genericViewHolder.tvRank.setText(name.getRanking());
            genericViewHolder.tvRecoveredCase.setText(name.getRecovered());
            genericViewHolder.cardView.setCardBackgroundColor(ContextCompat.getColor(context,name.getColorCv()));


            //genericViewHolder.imgView.setImageResource(name.getActivityIcon());
            // genericViewHolder.tvName.setText(name.getActivityName());
        }
    }


    //    need to override this method
    @Override
    public int getItemViewType(int position) {

        return position;
    }


    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public void setOnItemClickListener(final CountryListAdapter.OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    void setOnItemLongClickListener(final CountryListAdapter.OnItemLongClickListener mItemLongClickListener) {
        this.mItemLongClickListener = mItemLongClickListener;
    }

    private CountryBeans getItem(int position) {
        return menuList.get(position);
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position, ArrayList<CountryBeans> menulist);
    }

    public interface OnBottomReachedListener {

        void onBottomReached(int position);

    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position, ArrayList<CountryBeans> names);
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCountryName, tvDate,tvAcctCase,tvRecoveredCase,tvDeathCase,tvRank;
        private ImageView imgvRankCountry;
        private CardView cardView;


        ViewHolder(final View itemView) {
            super(itemView);
//            mItemClickListener.onItemClick(itemView, getAdapterPosition(), menuList);
           tvCountryName=itemView.findViewById(R.id.tvCountryName);
            tvDate=itemView.findViewById(R.id.tvDate);
            tvAcctCase=itemView.findViewById(R.id.tvAcctCase);
            tvRecoveredCase=itemView.findViewById(R.id.tvRecoveredCase);
            tvDeathCase=itemView.findViewById(R.id.tvDeathCase);
            tvRank=itemView.findViewById(R.id.tvRank);
            imgvRankCountry=itemView.findViewById(R.id.imgvRankCountry);
            cardView=itemView.findViewById(R.id.cvCountryList);





            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mItemClickListener.onItemClick(itemView, getAdapterPosition(), menuList);


                }
            });


          /* itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mItemLongClickListener.onItemLongClick(itemView, getAdapterPosition(), menuList);

                    return true;
                }
            });*/


        }
    }
}