package com.seth.fragmentblog;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Seth on 2017/5/5.
 */
public class Fragment1 extends Fragment {
    private String TAG  = "Fragment1";
    private Button To1;
    private Button To2;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"onCreate");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment,container,false);
        Log.i(TAG,"onCreateView");

        To1 = (Button) view.findViewById(R.id.change2);
        To2 = (Button) view.findViewById(R.id.change3);
        To1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Fragment2();
                //获取Fragment事务实例
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                //用replace方式替换
                //此方法下原fragment会被销毁
                transaction.replace(R.id.page_content,fragment);
                //提交事务
                transaction.commit();
            }
        });

        To2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Fragment3();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.page_content,fragment);
                //添加原fragment到返回栈，这时原fragment不会被销毁，并且为onStop()状态
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG,"onAttach");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,"onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG,"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG,"onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG,"onDetach");
    }
}
