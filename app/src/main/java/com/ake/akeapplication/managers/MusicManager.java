package com.ake.akeapplication.managers;

import com.ake.akeapplication.models.MusicModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 유현석 on 2017-03-02.
 */

public class MusicManager {

    private static MusicManager sInstance = new MusicManager();
    private List<MusicModel> list;

    public MusicManager() {
        this.list = new ArrayList<>();
    }
    public static MusicManager newInstance() {
        return sInstance;
    }

    public List<MusicModel> getList() {
        return list;
    }
}
