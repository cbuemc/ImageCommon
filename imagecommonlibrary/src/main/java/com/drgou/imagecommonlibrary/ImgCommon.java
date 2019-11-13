package com.drgou.imagecommonlibrary;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

/**
 * Created by Zning on 2018/8/8.
 */
public class ImgCommon {

    /**
     * 设置背景
     *
     * @param view 控件
     * @param url  背景图地址
     */
    public static void setBg(final View view, String url) {
        if (view != null) {
            url = addHttp(url);
            GlideApp.with(view.getContext()).load(url).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                    view.setBackground(resource);
                }
            });
        }
    }

    /**
     * 设置图标
     *
     * @param imageView 图片控件
     * @param url       图片地址
     */
    public static void setIcon(ImageView imageView, String url) {
        setIcon(imageView, url, R.mipmap.ic_default_placeholder);
    }

    /**
     * 设置图标
     *
     * @param imageView     图片控件
     * @param url           图片地址
     * @param placeholderId 预览图&失败图
     */
    public static void setIcon(ImageView imageView, String url, int placeholderId) {
        if (imageView != null) {
            url = addHttp(url);
            GlideApp.with(imageView.getContext())
                    .load(url)
                    .placeholder(placeholderId)
                    .error(placeholderId)
                    .fallback(placeholderId)
                    .into(imageView);
        }
    }


    /**
     * 设置列表类型的图片
     * 居中裁剪
     *
     * @param iv  控件
     * @param url 网络路径
     */
    public static void setImg(ImageView iv, String url) {
        setImg(iv, url, R.mipmap.ic_default_placeholder);
    }


    /**
     * 设置无圆图片
     *
     * @param iv            控件
     * @param url           网络路径
     * @param placeholderId 预览图
     */
    public static void setImg(ImageView iv, String url, int placeholderId) {
        setImg(iv, url, getOptions(placeholderId, false));
    }

    /**
     * 设置无圆图片
     *
     * @param iv            控件
     * @param url           网络路径
     * @param placeholderId 预览图
     */
    public static void setImgFitCenter(ImageView iv, String url, int placeholderId) {
        setImgFitCenter(iv, url, getOptions(placeholderId, false));
    }

    /**
     * 圆角 列表图
     */
    public static void setRoundImg(ImageView iv, String url) {
        setRoundImg(iv, url, R.mipmap.ic_default_placeholder);
    }

    /**
     * 设置圆角图标
     *
     * @param iv            控件
     * @param url           网络路径
     * @param placeholderId 预览图
     */
    public static void setRoundImg(ImageView iv, String url, int placeholderId) {
        setImg(iv, url, getOptions(placeholderId, true));
    }

    /**
     * 圆形 列表图
     */
    public static void setCircleImg(ImageView iv, String url) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.ic_default_placeholder)
                .error(R.mipmap.ic_default_placeholder)
                .fallback(R.mipmap.ic_default_placeholder)
                .centerCrop()
                .circleCrop();
        setImg(iv, url, options);
    }

    private static void setImg(ImageView iv, String url, RequestOptions options) {
        if (iv == null) {
            return;
        }
        if (TextUtils.isEmpty(url)) {
            GlideApp.with(iv.getContext()).clear(iv);
        } else {
            url = addHttp(url);
            GlideApp.with(iv.getContext())
                    .load(url)
                    .apply(options)
                    .into(iv);
        }
    }

    private static void setImgFitCenter(ImageView iv, String url, RequestOptions options) {
        if (iv == null) {
            return;
        }
        if (TextUtils.isEmpty(url)) {
            GlideApp.with(iv.getContext()).clear(iv);
        } else {
            url = addHttp(url);
            GlideApp.with(iv.getContext())
                    .load(url)
                    .apply(options)
                    .fitCenter()
                    .into(iv);
        }
    }

    @SuppressLint("CheckResult")
    private static RequestOptions getOptions(int resId, boolean roundFlag) {
        RequestOptions options = new RequestOptions();
        options.centerCrop();
        options.placeholder(resId);
        options.error(resId);
        options.fallback(resId);
        if (roundFlag) {
            options.transform(new GlideRoundTransform());
        }
        return options;
    }

    public static String addHttp(String url) {
        if (!TextUtils.isEmpty(url) && !url.startsWith("http")) {
            //因为阿里很多不带http开头
            return "http:" + url;
        }
        return url;
    }

}
