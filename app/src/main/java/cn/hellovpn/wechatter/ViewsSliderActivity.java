package cn.hellovpn.wechatter;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

//import info.androidhive.viewpager2.R;
//import cn.hellovpn.wechatter.R;
//import cn.hellovpn.wechatter.databinding.ActivityViewsSliderBinding;
import cn.hellovpn.wechatter.databinding.ActivityViewsSliderBinding;
import cn.hellovpn.wechatter.fragments.EventsFragment;
import cn.hellovpn.wechatter.fragments.AssociateFragment;
import cn.hellovpn.wechatter.fragments.HealthBaoFragment;
//import cn.hellovpn.wechatter.databinding.SlideOneBinding;




public class ViewsSliderActivity extends AppCompatActivity {
    private ViewsSliderAdapter mAdapter;
    private TextView[] dots;
    private int[] layouts;
    private ActivityViewsSliderBinding binding;
    private TextView tvSelfCheck;
    private TextView tvScan;
    private Button btnHealth;
    private Button btnTripCard;
    //private SlideOneBinding slideOneBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewsSliderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();

        Window window = getWindow();
        WindowManager.LayoutParams winParams = window.getAttributes();
        winParams.flags &= ~WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        window.setAttributes(winParams);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

       // slideOneBinding = SlideOneBinding.inflate(getLayoutInflater());
       // this.btnHealth = findViewById(R.id.btnHealth);
       // btnHealth = slideOneBinding.btnHealth;




//        btnHealth.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("Yes");
//                Toast.makeText(getApplicationContext(), "Health Clicked. ", Toast.LENGTH_LONG).show();
//            }
//        });






    }

    private void init() {
        // layouts of all welcome sliders
        // add few more layouts if you want
        layouts = new int[]{
                R.layout.slide_healthbao,
                R.layout.slide_associates
               };

//                R.layout.slide_three,
//                R.layout.slide_four};

        //mAdapter = new ViewsSliderAdapter();
        //binding.viewPager.setAdapter(new ViewsSliderAdapter());
        binding.viewPager.setAdapter(new ViewPagerFragmentAdapter(this));
        //binding.viewPager
       binding.viewPager.setCurrentItem(1);
        //binding.viewPager.set.setLayoutDirection();
        binding.viewPager.registerOnPageChangeCallback(pageChangeCallback);

        binding.btnSkip.setOnClickListener(v -> launchHomeScreen());

        binding.btnNext.setOnClickListener(v -> {
            // checking for last page
            // if last page home screen will be launched
            int current = getItem(+1);
            if (current < layouts.length) {
                // move to next screen
                binding.viewPager.setCurrentItem(current);
            } else {
                launchHomeScreen();
            }
        });

        binding.iconMore.setOnClickListener(view -> {
            showMenu(view);
        });

        // adding bottom dots
       // addBottomDots(0);
        binding.viewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
    }

    /*
     * Adds bottom dots indicator
     * */
    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        binding.layoutDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            binding.layoutDots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    private int getItem(int i) {
        return binding.viewPager.getCurrentItem() + i;
    }

    private void launchHomeScreen() {
        Toast.makeText(this, R.string.slides_ended, Toast.LENGTH_LONG).show();
        finish();
    }

    private void showMenu(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.pager_transformers, popup.getMenu());
        popup.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.action_orientation) {
                binding.viewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
            } else {
                binding.viewPager.setPageTransformer(Utils.getTransformer(item.getItemId()));
                binding.viewPager.setCurrentItem(0);
                binding.viewPager.getAdapter().notifyDataSetChanged();
            }
            return false;
        });
        popup.show();
    }

    /*
     * ViewPager page change listener
     */
    ViewPager2.OnPageChangeCallback pageChangeCallback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
           // addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
//            if (position == layouts.length - 1) {
//                // last page. make button text to GOT IT
//                binding.btnNext.setText(getString(R.string.start));
//                binding.btnSkip.setVisibility(View.GONE);
//            } else {
//                // still pages are left
//                binding.btnNext.setText(getString(R.string.next));
//                binding.btnSkip.setVisibility(View.VISIBLE);
//            }
        }
    };

    public class ViewsSliderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        public ViewsSliderAdapter() {
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(viewType, parent, false);
            return new SliderViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemViewType(int position) {
            return layouts[position];
        }

        @Override
        public int getItemCount() {
            return layouts.length;
        }

        public class SliderViewHolder extends RecyclerView.ViewHolder {
            public TextView title, year, genre;

            public SliderViewHolder(View view) {
                super(view);
            }
        }
    }

    private class ViewPagerFragmentAdapter extends FragmentStateAdapter {

        public ViewPagerFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new HealthBaoFragment();

                case 1:
                    return new AssociateFragment();

            }
            return new AssociateFragment();
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }

}
