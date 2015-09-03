package com.ast.unittestdemo.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.TextView;

import com.ast.unittestdemo.R;
import com.ast.unittestdemo.objects.UserBO;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2015 AsianTech inc.
 * Created by longhv on 28/08/2015.
 */
public class UserInforAdapter extends BaseAdapter {

    List<UserBO> userBOList;
    private Context context;

    public UserInforAdapter(Context context){
        super();
        this.context = context;
        userBOList = new ArrayList<>();
    }
    @Override
    public int getCount() {
        return userBOList.size();
    }

    @Override
    public Object getItem(int position) {
        return userBOList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void updateData(List<UserBO> userBOList){
        this.userBOList = userBOList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UserHolder userHolder;
        UserBO userBO = userBOList.get(position);
        if (convertView == null){
            userHolder = new UserHolder();
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_list_user_infor, parent, false);

            userHolder.tvId = (TextView) convertView.findViewById(R.id.tvId);
            userHolder.tvUsername = (TextView) convertView.findViewById(R.id.tvUsername);

            convertView.setTag(userHolder);
        }else {
            userHolder = (UserHolder)convertView.getTag();
        }

        if (null != userBO){
            userHolder.tvId.setText(userBO.getId());
            userHolder.tvUsername.setText(userBO.getName());
        }
        return convertView;
    }

    class UserHolder{
        TextView tvId;
        TextView tvUsername;
    }
}
