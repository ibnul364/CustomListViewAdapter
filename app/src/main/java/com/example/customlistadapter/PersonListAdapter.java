package com.example.customlistadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;


public class PersonListAdapter extends ArrayAdapter<Person> {
    private Context mContext;
    int mResource;
    private int lastPosition = -1;

    private  static class ViewHolder{
        TextView name;
        TextView birthday;
        TextView phone;
        ImageView img;
    }





    public PersonListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Person> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        setupImageLoader();

//        return super.getView(position, convertView, parent);
        //get the user info
        String name = getItem(position).getName();
        String birthday = getItem(position).getBirthDay();
        String phone = getItem(position).getPhoneNumber();
        String imgURL = getItem(position).getImgURL();


        //create the view Result for showing the orientation
        final View result;

        //create viewholder object
        ViewHolder holder;

        if(convertView==null) {
    //Create the Person Object with the information
//        Person person = new Person(name,birthday,phone);
    //Create a layoutInflater then set our view to our layout inflater
    LayoutInflater inflater = LayoutInflater.from(mContext);
    convertView = inflater.inflate(mResource, parent, false);

    holder = new ViewHolder();
    holder.name = convertView.findViewById(R.id.textView);
    holder.birthday = convertView.findViewById(R.id.textView2);
    holder.phone = convertView.findViewById(R.id.textView3);
    holder.img = convertView.findViewById(R.id.imageId);

            result = convertView;
            convertView.setTag(holder);
            }else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        //Animation
//        Animation animation  = AnimationUtils.loadAnimation(mContext,(position>lastPosition) ?R.anim.load_animation);
//        result = startAnimation(animation);
//        lastPosition = position;


        ImageLoader imageLoader = ImageLoader.getInstance();
        int defaultImage = mContext.getResources().getIdentifier("@drawable/image_failed",null,mContext.getPackageName());
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisk(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage)
                .showImageOnLoading(defaultImage).build();

        imageLoader.displayImage(imgURL, holder.img,options);

        holder.name.setText(name);
        holder.birthday.setText(birthday);
        holder.phone.setText(phone);


        return convertView;
    }

    private void setupImageLoader(){
        //Universal Image Loader setup
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisk(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                mContext)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024* 1024).build();

        ImageLoader.getInstance().init(config);


    }




}
