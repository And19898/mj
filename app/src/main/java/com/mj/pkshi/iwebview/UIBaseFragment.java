package com.mj.pkshi.iwebview;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public abstract class UIBaseFragment<T extends ViewDataBinding> extends Fragment {
    protected boolean isVisible;
    protected boolean isPrepared;
    protected boolean isLoaded;
    protected T databinding;

    public UIBaseFragment() {
    }

    @Nullable
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        databinding = DataBindingUtil.inflate(inflater, this.getContentView(), container, false);
        this.isPrepared = true;
        this.init();
        this.onVisible();
        return databinding.getRoot();
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (this.getUserVisibleHint()) {
            this.isVisible = true;
            this.onVisible();
        } else {
            this.isVisible = false;
            this.onInvisible();
        }

    }

    private void onVisible() {
        if (this.isPrepared && this.isVisible) {
            this.lzayLoadEveryVisible();
            if (!this.isLoaded) {
                this.isLoaded = true;
                this.lazyLoad();
            }
        }
    }

    protected abstract void lazyLoad();

    protected void lzayLoadEveryVisible() {
    }

    protected abstract int getContentView();

    protected void onInvisible() {

    }

    protected abstract void init();

}
