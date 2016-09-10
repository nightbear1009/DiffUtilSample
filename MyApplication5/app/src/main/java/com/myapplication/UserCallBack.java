package com.myapplication;

import android.support.v7.util.DiffUtil;

import java.util.List;

/**
 * Created by tedliang on 2016/9/10.
 */
public class UserCallBack extends DiffUtil.Callback {
    private final List<User> mNewList;
    private final List<User> mOldList;

    public UserCallBack(List<User> newList, List<User> oldList) {
        mNewList = newList;
        mOldList = oldList;
    }

    @Override
    public int getOldListSize() {
        return mOldList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mNewList.get(newItemPosition).getName() == mOldList.get(oldItemPosition).getName();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return mNewList.get(newItemPosition).toString() == mOldList.get(oldItemPosition).toString();
    }
}
