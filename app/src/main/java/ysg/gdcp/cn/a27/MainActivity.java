package ysg.gdcp.cn.a27;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

import ysg.gdcp.cn.a27.domain.Friend;
import ysg.gdcp.cn.a27.ui.QuickIndexBar;

public class MainActivity extends AppCompatActivity {

    private QuickIndexBar quickIndexBar;
    private ListView mMainLv;
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
        mMainLv.setAdapter(new MyAdapter(this,friends));
    }

    private void initViews() {
        quickIndexBar = (QuickIndexBar) findViewById(R.id.quickindexbar);
        mMainLv = (ListView) findViewById(R.id.main_lv);
        quickIndexBar.setOnTouchLeteerListener(new QuickIndexBar.onTouchLeteerListener() {
            @Override
            public void onTouchLetter(String word) {
                Log.i("niaho", word);
            }
        });

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
