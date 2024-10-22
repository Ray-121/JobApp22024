package com.example.application22024.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;


import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;


import com.example.application22024.R;
import com.example.application22024.adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    private InputMethodManager inputMethodManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        //ẩn nút back
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this);

        // Khởi tạo các Fragment và thêm vào Adapter

        adapter.addFragment(new Page1());

        adapter.addFragment(new Page2());
        adapter.addFragment(new Page3());
        adapter.addFragment(new Page4());


        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);

        int[] tabIcons = {R.drawable.ic_home, R.drawable.ic_taikhoan, R.drawable.ic_bookmark, R.drawable.ic_menu};
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            // Xác định hình ảnh cho tab dựa trên vị trí
            tab.setIcon(tabIcons[position]);
        }).attach();

        

        // Xử lý sự kiện khi nhấn vào tab cuối cùng (icon thứ 4)
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                    viewPager.setCurrentItem(position, true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Không cần xử lý khi tab bị bỏ chọn
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Không cần xử lý khi tab được chọn lại
            }
        });
    }
}
