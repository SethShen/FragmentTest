package com.seth.fragmentblog;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private Fragment mFragment1;
    private Fragment mFragment2;
    private Fragment mFragment3;
    private RelativeLayout tab1;
    private RelativeLayout tab2;
    private RelativeLayout tab3;
    private FragmentManager fm;
    private Fragment contentFragment;       //储存当前在显示的Fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*底部tab栏获取控件*/
        tab1 = (RelativeLayout) findViewById(R.id.tab1);
        tab2 = (RelativeLayout) findViewById(R.id.tab2);
        tab3 = (RelativeLayout) findViewById(R.id.tab3);
        /*获取fragmentManager*/
        fm = getSupportFragmentManager();
        /*注册fragment*/
        mFragment1 = fm.findFragmentById(R.id.page_content);
        mFragment2 = fm.findFragmentById(R.id.page_content);
        mFragment3 = fm.findFragmentById(R.id.page_content);

        if(mFragment1 == null ){//默认开始为第一个页面
            mFragment1 = new Fragment1();
            fm.beginTransaction().add(R.id.page_content, mFragment1).commit();
            contentFragment = mFragment1;
        }
    }
    //fragment替换方法
    private void addOrShowFragment(FragmentTransaction transaction, Fragment fragment){
        if(contentFragment == fragment){
            return ;
        }
        if(!fragment.isAdded()){    //如果当前fragment为被添加，则添加到Fragment管理器中
            transaction.hide(contentFragment).add(R.id.page_content, fragment).commit();
        }else{
            //此种方法替换fragment时，原fragment状态依旧为onResume
            transaction.hide(contentFragment).show(fragment).commit();
        }
        contentFragment = fragment;
    }
    //跳转到第一个页面
    public void ToFirstPage(View view){

        if (mFragment1 == null){
            mFragment1 = new Fragment1();
        }
        addOrShowFragment(fm.beginTransaction(), mFragment1);

    }
    //跳转到第二个页面
    public void ToThirdPage(View view){
        if(mFragment2 == null){
            mFragment2 = new Fragment2();
        }
        addOrShowFragment(fm.beginTransaction(), mFragment2);
    }
    //跳转到第三个页面
    public void ToSecondPage(View view){
        if(mFragment3 == null){
            mFragment3 = new Fragment3();
        }
        addOrShowFragment(fm.beginTransaction(), mFragment3);
    }
}
