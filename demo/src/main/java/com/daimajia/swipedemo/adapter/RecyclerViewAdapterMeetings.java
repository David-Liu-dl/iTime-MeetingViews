package com.daimajia.swipedemo.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Dimension;
import android.support.v4.media.RatingCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.daimajia.swipedemo.R;

import java.util.ArrayList;

public class RecyclerViewAdapterMeetings extends RecyclerSwipeAdapter<RecyclerView.ViewHolder> {
    public static final int INVITATION_DETAILS = 1;
    public static final int INVITATION_MESSAGE = 2;
    public static final int HOSTING_DETAILS = 3;

    public class InvitationDetailsViewHolder extends RecyclerView.ViewHolder {
        int position = 0;

        SwipeLayout swipeLayout;
        View infoBlock;
        //menu
        View pin;
        View mute;
        View archive;
        //card
        View container;
        ImageView statusIcon;
        TextView statusText;
        ImageView profilePhoto;
        TextView updatedTimeText;
        TextView msgText;
        TextView titleText;
        TextView gratingText;
        TextView reminderText;

        public InvitationDetailsViewHolder(View itemView) {
            super(itemView);
            initViews();
            initActions();
            initBg();

            swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
        }

        private void initViews(){
            swipeLayout = (SwipeLayout) itemView.findViewById(R.id.swipe);
            infoBlock = itemView.findViewById(R.id.info_container);
            //menu
            pin = itemView.findViewById(R.id.pin_btn);
            mute = itemView.findViewById(R.id.mute_btn);
            archive = itemView.findViewById(R.id.archive_btn);
            //card
            container = itemView.findViewById(R.id.invitation_card);
            statusIcon = (ImageView) itemView.findViewById(R.id.status_icon);
            statusText = (TextView) itemView.findViewById(R.id.status_text);
            profilePhoto = (ImageView) itemView.findViewById(R.id.profile_photo);
            updatedTimeText = (TextView) itemView.findViewById(R.id.updated_time_text);
            msgText = (TextView) itemView.findViewById(R.id.message_text);
            titleText = (TextView) itemView.findViewById(R.id.title_text);
            gratingText = (TextView) itemView.findViewById(R.id.grating_text);
            reminderText = (TextView) itemView.findViewById(R.id.reminder_text);

        }

        private void initActions(){
            swipeLayout.addDrag(SwipeLayout.DragEdge.Right, swipeLayout.findViewById(R.id.menu));

            pin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onMenuListener != null){
                        onMenuListener.onPin(mDataset.get(position));
                    }
                }
            });
            mute.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onMenuListener != null){
                        onMenuListener.onMute(mDataset.get(position));
                    }
                }
            });
            archive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onMenuListener != null){
                        onMenuListener.onArchive(mDataset.get(position));
                    }
                }
            });
        }

        private void initBg(){
            GradientDrawable containerDrawable = (GradientDrawable) container.getBackground();
            containerDrawable.mutate();
            containerDrawable.setColor(itemView.getContext().getResources().getColor(R.color.brightBlue));

            float cornerDim = itemView.getContext().getResources().getDimension(R.dimen.card_radius);
            GradientDrawable infoBgDrawable = (GradientDrawable) infoBlock.getBackground();
            infoBgDrawable.mutate();
            infoBgDrawable.setCornerRadii(new float[]{0f,0f,cornerDim,cornerDim,cornerDim,cornerDim,0f,0f});
            infoBgDrawable.invalidateSelf();
        }
    }

    public class InvitationMessageViewHolder extends RecyclerView.ViewHolder {
        int position = 0;

        SwipeLayout swipeLayout;
        View infoBlock;
        //menu
        View pin;
        View mute;
        View archive;
        //card
        View container;
        ImageView statusIcon;
        TextView statusText;
        TextView updatedTimeText;
        TextView titleText;
        TextView reminderText;

        public InvitationMessageViewHolder(View itemView) {
            super(itemView);
            initViews();
            initActions();
            initBg();
            swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
        }

        private void initViews(){
            swipeLayout = (SwipeLayout) itemView.findViewById(R.id.swipe);
            infoBlock = itemView.findViewById(R.id.info_container);
            //menu
            pin = itemView.findViewById(R.id.pin_btn);
            mute = itemView.findViewById(R.id.mute_btn);
            archive = itemView.findViewById(R.id.archive_btn);
            //card
            container = itemView.findViewById(R.id.invitation_card);
            statusIcon = (ImageView) itemView.findViewById(R.id.status_icon);
            statusText = (TextView) itemView.findViewById(R.id.status_text);
            updatedTimeText = (TextView) itemView.findViewById(R.id.updated_time_text);
            titleText = (TextView) itemView.findViewById(R.id.title_text);
            reminderText = (TextView) itemView.findViewById(R.id.reminder_text);
        }

        private void initActions(){
            swipeLayout.addDrag(SwipeLayout.DragEdge.Right, swipeLayout.findViewById(R.id.menu));

            pin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onMenuListener != null){
                        onMenuListener.onPin(mDataset.get(position));
                    }
                }
            });
            mute.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onMenuListener != null){
                        onMenuListener.onMute(mDataset.get(position));
                    }
                }
            });
            archive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onMenuListener != null){
                        onMenuListener.onArchive(mDataset.get(position));
                    }
                }
            });
        }

        private void initBg(){
            float cornerDim = itemView.getContext().getResources().getDimension(R.dimen.card_radius);
            GradientDrawable infoBgDrawable = (GradientDrawable) infoBlock.getBackground();
            infoBgDrawable.mutate();
            infoBgDrawable.setCornerRadii(new float[]{0f,0f,cornerDim,cornerDim,cornerDim,cornerDim,0f,0f});
            infoBgDrawable.invalidateSelf();
        }
    }

    public class HostingDetailsViewHolder extends RecyclerView.ViewHolder {
        int position = 0;

        SwipeLayout swipeLayout;
        //menu
        View pin;
        View mute;
        View archive;
        //card
        View container;
        TextView reminderText;
        TextView updatedTimeText;
        TextView titleText;
        TextView gratingText;
        //event status components
        TextView label1;
        TextView value1;
        TextView label2;
        TextView value2;
        TextView label3;
        TextView value3;


        public HostingDetailsViewHolder(View itemView) {
            super(itemView);
            initViews();
            initActions();

            swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
        }

        private void initViews(){
            swipeLayout = (SwipeLayout) itemView.findViewById(R.id.swipe);
            //menu
            pin = itemView.findViewById(R.id.pin_btn);
            mute = itemView.findViewById(R.id.mute_btn);
            archive = itemView.findViewById(R.id.archive_btn);
            //card
            container = itemView.findViewById(R.id.invitation_card);
            reminderText = (TextView) itemView.findViewById(R.id.reminder_text);
            updatedTimeText = (TextView) itemView.findViewById(R.id.updated_time_text);
            titleText = (TextView) itemView.findViewById(R.id.title_text);
            gratingText = (TextView) itemView.findViewById(R.id.grating_text);
            //event status components
            label1 = (TextView) itemView.findViewById(R.id.label_1);
            label2 = (TextView) itemView.findViewById(R.id.label_2);
            label3 = (TextView) itemView.findViewById(R.id.label_3);
            value1 = (TextView) itemView.findViewById(R.id.value_1);
            value2 = (TextView) itemView.findViewById(R.id.value_2);
            value3 = (TextView) itemView.findViewById(R.id.value_3);
        }

        private void initActions(){
            swipeLayout.addDrag(SwipeLayout.DragEdge.Right, swipeLayout.findViewById(R.id.menu));

            pin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onMenuListener != null){
                        onMenuListener.onPin(mDataset.get(position));
                    }
                }
            });
            mute.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onMenuListener != null){
                        onMenuListener.onMute(mDataset.get(position));
                    }
                }
            });
            archive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onMenuListener != null){
                        onMenuListener.onArchive(mDataset.get(position));
                    }
                }
            });
        }
    }

    private Context mContext;
    private ArrayList<String> mDataset;
    private OnMenuListener onMenuListener;

    //protected SwipeItemRecyclerMangerImpl mItemManger = new SwipeItemRecyclerMangerImpl(this);

    public RecyclerViewAdapterMeetings(Context context, ArrayList<String> objects) {
        this.mContext = context;
        this.mDataset = objects;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;

        switch (viewType){
            case INVITATION_DETAILS:{
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inviation_item_detailed, parent, false);
                holder = new InvitationDetailsViewHolder(view);
                break;
            }
            case INVITATION_MESSAGE:{
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inviation_item_message, parent, false);
                holder = new InvitationMessageViewHolder(view);
                break;
            }
            case HOSTING_DETAILS:{
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hosting_item, parent, false);
                holder = new HostingDetailsViewHolder(view);
                break;
            }
            default:
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        int type = viewHolder.getItemViewType();
        // TODO: 21/06/2017 settting data
        switch (type){
            case INVITATION_DETAILS:{
                InvitationDetailsViewHolder holder = (InvitationDetailsViewHolder) viewHolder;
                holder.position = position;
                break;
            }
            case INVITATION_MESSAGE:{
                InvitationMessageViewHolder holder = (InvitationMessageViewHolder) viewHolder;
                holder.position = position;
                break;
            }
            case HOSTING_DETAILS:{
                HostingDetailsViewHolder holder = (HostingDetailsViewHolder) viewHolder;
                holder.position = position;
                holder.label1.setText("Voted");
                holder.label2.setText("Can't go");
                holder.label3.setText("No reply");
                holder.value1.setText("8");
                holder.value2.setText("5");
                holder.value3.setText("10");
                break;
            }
            default:
                break;
        }

        mItemManger.bind(viewHolder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (position%3 == 0){
            return  HOSTING_DETAILS;
        }

        if (position%3 == 1){
            return  INVITATION_MESSAGE;
        }

        if (position%3 == 2){
            return  INVITATION_DETAILS;
        }

        return -1;
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    public interface OnMenuListener<T> {
        void onPin(T obj);
        void onMute(T obj);
        void onArchive(T obj);
    }

    public OnMenuListener getOnMenuListener() {
        return onMenuListener;
    }

    public void setOnMenuListener(OnMenuListener onMenuListener) {
        this.onMenuListener = onMenuListener;
    }
}
