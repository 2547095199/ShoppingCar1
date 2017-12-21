package com.bwie.huang.shoppingcar1.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bwie.huang.shoppingcar1.R;

public class AnimationActivity extends AppCompatActivity {
    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ImageView img= (ImageView) findViewById(R.id.img);
        /*Animation animation = AnimationUtils.loadAnimation(this, R.anim.animationset);


        img.startAnimation(animation);
*/
        //透明
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(img, "alpha", 1f, 0f, 1f);
        //旋转
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(img, "rotation", 0f, 0f, 360f);
        //平移
        ObjectAnimator animator = ObjectAnimator.ofFloat(img, "translationY", 0f, 0f, 300f);
        //缩放
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(img, "scaleY", 1f, 2f, 1f);
        AnimatorSet set = new AnimatorSet();
        set.play(animator2).with(animator1).with(animator).with(scaleYAnimator);
        set.setDuration(3000);
        set.start();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(AnimationActivity.this,Main2Activity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
