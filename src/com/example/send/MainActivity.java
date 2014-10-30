package com.example.send;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.HorizontalScrollView;


public class MainActivity extends ActionBarActivity {
	
	private HorizontalScrollView _scroll;
	private ViewGroup _layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        _scroll = (HorizontalScrollView) findViewById(R.id.horizontalview1);
        _layout = (ViewGroup) findViewById(R.id.linearlayout1);	
        
        int kLen = _layout.getChildCount();
        for (int i = 0; i < kLen; i++)
        {
            View v = _layout.getChildAt(i);
            if (v.getClass() != Button.class)
                return;
             
            v.setOnClickListener(onBtnClickListener);
        }
      
        
    }
    OnClickListener onBtnClickListener = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            int[] lo = new int[2];
            v.getLocationOnScreen(lo);
             
            // ��ư�� x ��ǥ
            int posX = lo[0];
             
            // ��ư�� �ʺ��� ����
            int halfWidth = (int) (v.getWidth() * 0.5f);
             
            // ȭ�� �ʺ�
            int screenWith = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
             
            // ȭ�� �ʺ��� ����
            int halfScreenWidth = (int) (screenWith * 0.5f);
             
            // ȭ���� ������ �߰� ��ġ�� ��ư�� �߰� ��ġ���� ���̸� ���Ѵ�.
            final int scroll = posX + halfWidth - halfScreenWidth;
            _scroll.post(new Runnable()
            {
                @Override
                public void run()
                {
                    _scroll.smoothScrollBy(scroll, 0);
                }
            });
        }
    };
    
  
 


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
