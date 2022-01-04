package com.example.glideapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.util.concurrent.Future;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.load_image)
    ImageView load_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @SuppressLint("NonConstantResourceId")
    @OnClick(R.id.load_btn)
    public void GlideLoad() {
        String[] urls = {"https://i.imgur.com/DvpvklR.png",
        "https://2f.zol-img.com.cn/product/104_1200x900/305/cevDJaCdeLQ6.gif",
        "https://pic6.huitu.com/res/20130116/84481_20130116142820494200_1.jpg"};
        RequestListener listener = new RequestListener() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target target, boolean isFirstResource) {
                assert e != null;
                Toast.makeText(MainActivity.this, "onException : " + e.toString(), Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onResourceReady(Object resource, Object model, Target target, DataSource dataSource, boolean isFirstResource) {
                Toast.makeText(MainActivity.this, "onResourceReady", Toast.LENGTH_SHORT).show();
                return false;
            }
        };
        Glide.with(this)
                /*
                 * with(this)
                 * 加载图片的请求会与该参数的生命周期绑定在一起
                 * onPause()时候Glide就会暂停加载
                 * onResume之后，又会继续加载
                 *
                 * 非Application参数不管是Activity，Fragment，
                 * 最终都会向当前Activity传入一个隐藏的Fragment，
                 * 因为Glide需要监控Activity的生命周期，
                 * Fragment依赖Activity生命周期并且是同步的，
                 * 通过这个隐藏的Fragment就监听到Activity生命周期
                 */
                .asGif()
                .load(urls[1])
                /*
                 * 返回一个RequestBuilder用于指定待加载的图片资源
                 * 支持网络图片网址、二进制流、drawable资源、本地图片的传入
                 * */
                //.placeholder(R.drawable.ic_launcher_background)
                //.transition(withCrossFade(300))
                /*
                 * 交叉淡入变换效果
                 * crossFade(int duration)。
                 * 如果你想要去减慢（或加快）动画，
                 * 随时可以传一个毫秒的时间给这个方法。
                 * 动画默认的持续时间是 300毫秒
                 * */
                .override(800,300)
                //.error(R.mipmap.ic_launcher_round)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .listener(listener)
                .into(load_image);

    }
}