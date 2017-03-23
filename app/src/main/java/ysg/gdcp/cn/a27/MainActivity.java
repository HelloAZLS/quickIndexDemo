package ysg.gdcp.cn.a27;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.OvershootInterpolator;
import android.widget.ListView;
import android.widget.TextView;

import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

import java.util.ArrayList;
import java.util.Collections;

import ysg.gdcp.cn.a27.domain.Friend;
import ysg.gdcp.cn.a27.ui.QuickIndexBar;

public class MainActivity extends AppCompatActivity {

    private QuickIndexBar quickIndexBar;
    private ListView mMainLv;
    private TextView tvWord;
    private ArrayList<Friend> friends = new ArrayList<Friend>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();

    }

    private void initData() {
        fillList();
        Collections.sort(friends);
        mMainLv.setAdapter(new MyAdapter(this, friends));
    }

    private void initViews() {
        quickIndexBar = (QuickIndexBar) findViewById(R.id.quickindexbar);
        mMainLv = (ListView) findViewById(R.id.main_lv);
        tvWord = (TextView) findViewById(R.id.word);
        quickIndexBar.setOnTouchLeteerListener(new QuickIndexBar.onTouchLeteerListener() {
            @Override
            public void onTouchLetter(String word) {
                for (int i = 0; i < friends.size(); i++) {
                    String firstWord = friends.get(i).getPinYin().charAt(0) + "";
                    if (firstWord.equals(word)) {
                        mMainLv.setSelection(i);
                        break;
                    }
                }
                showCurrentWord(word);
            }
        });
        ViewHelper.setScaleX(tvWord, 0);
        ViewHelper.setScaleY(tvWord, 0);

    }

    private Handler handler = new Handler();
    private boolean isExcuteAnim = false;

    private void showCurrentWord(String word) {
        //  tvWord.setVisibility(View.VISIBLE);
        tvWord.setText(word);
        if (!isExcuteAnim) {
            isExcuteAnim = true;
            ViewPropertyAnimator.animate(tvWord).scaleX(1f).setInterpolator(new OvershootInterpolator()).setDuration(550).start();
            ViewPropertyAnimator.animate(tvWord).scaleY(1f).setInterpolator(new OvershootInterpolator()).setDuration(550).start();
        }
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ViewPropertyAnimator.animate(tvWord).scaleX(0f).setDuration(550).start();
                ViewPropertyAnimator.animate(tvWord).scaleY(0f).setDuration(550).start();
                isExcuteAnim=false;
            }
        }, 1500);
    }

    private void fillList() {
        // 虚拟数据
        friends.add(new Friend("李伟"));
        friends.add(new Friend("张三"));
        friends.add(new Friend("阿三"));
        friends.add(new Friend("阿四"));
        friends.add(new Friend("段誉"));
        friends.add(new Friend("段正淳"));
        friends.add(new Friend("张三丰"));
        friends.add(new Friend("陈坤"));
        friends.add(new Friend("林俊杰1"));
        friends.add(new Friend("陈坤2"));
        friends.add(new Friend("王二a"));
        friends.add(new Friend("林俊杰a"));
        friends.add(new Friend("张四"));
        friends.add(new Friend("林俊杰"));
        friends.add(new Friend("王二"));
        friends.add(new Friend("王二b"));
        friends.add(new Friend("赵四"));
        friends.add(new Friend("杨坤"));
        friends.add(new Friend("赵子龙"));
        friends.add(new Friend("杨坤1"));
        friends.add(new Friend("李伟1"));
        friends.add(new Friend("宋江"));
        friends.add(new Friend("宋江1"));
        friends.add(new Friend("李伟3"));
    }
}
