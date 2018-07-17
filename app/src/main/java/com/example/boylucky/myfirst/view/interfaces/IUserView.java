package com.example.boylucky.myfirst.view.interfaces;

import com.example.boylucky.myfirst.bean.FileBean;
import com.example.boylucky.myfirst.bean.NickBean;

/**
 * Created by BoyLucky on 2018/7/10.
 */

public interface IUserView {
    void onSuccess(NickBean nickBean);
    void onSuccess(FileBean fileBean);
}
