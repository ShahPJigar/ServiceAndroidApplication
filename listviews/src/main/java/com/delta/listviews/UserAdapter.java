package com.delta.listviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UserAdapter extends ArrayAdapter<User> {

    Context mContext;
    int mLayoutResourceId;
    User mData[] = null;

    public UserAdapter(Context context, int resource, User[] data) {
        super(context, resource, data);

        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.mData = data;

    }

    @Override
    public User getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        PlaceHolder holder = null;

        //if we currently don’t have a row View to reuse..
        if(row == null){
            //Create a new View
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(mLayoutResourceId,parent,false);

            holder = new PlaceHolder();

            holder.nameView = (TextView) row.findViewById(R.id.nameTextView);
            holder.emailView = (TextView) row.findViewById(R.id.emailTextView);
            holder.phoneView = (TextView) row.findViewById(R.id.phoneTextView);
            holder.zipView = (TextView) row.findViewById(R.id.addressTextView);
            holder.imageView = (ImageView) row.findViewById(R.id.imageView);

            row.setTag(holder);
        }else{
            //Otherwise use an existing one
            holder = (PlaceHolder) row.getTag();
        }

        //Getting the data form the data array
        User user = mData[position];

        //Setup and reuse the same listener for each row
        holder.imageView.setOnClickListener(PopupListener);
        Integer rowPosition = position;
        holder.imageView.setTag(rowPosition);


        //setting the view to reflect the data we need to display
        holder.nameView.setText(user.mNameOfUser);
        holder.emailView.setText(user.mEmail);
        holder.phoneView.setText(user.mPhone);
        holder.zipView.setText(user.mAddress);

        //for getting the image
        int resID = mContext.getResources().getIdentifier(user.mNameOfImage,"drawable",mContext.getPackageName());
        holder.imageView.setImageResource(resID);


        //returning the row (because this is called getView after all)

        return row;


    }

    View.OnClickListener PopupListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Integer viewPosition = (Integer) view.getTag();
            User p = mData[viewPosition];
            Toast.makeText(getContext(),p.mPopup,Toast.LENGTH_SHORT).show();
        }
    };


    private static class PlaceHolder {
        TextView nameView;
        TextView emailView;
        TextView phoneView;
        TextView zipView;
        ImageView imageView;
    }



}