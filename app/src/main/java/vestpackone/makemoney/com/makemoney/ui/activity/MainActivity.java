package vestpackone.makemoney.com.makemoney.ui.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;

import butterknife.BindView;
import vestpackone.makemoney.com.makemoney.R;
import vestpackone.makemoney.com.makemoney.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @BindView(R.id.vp_main)
    ViewPager vpMain;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationView bottomNavigationBar;

    @Override
    public void getNetData() {

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
//        BottomNavigationViewHelper.disableShiftMode(bottomNavigationBar);
//        bottomNavigationBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.bottom_home:
//                        break;
//                    case R.id.bottom_knowledge:
//                        break;
//                    case R.id.bottom_navigation:
//                        break;
//                    case R.id.bottom_project:
//                        break;
//                    default:
//                        break;
//                }
//                return true;
//            }
//        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public Object newP() {
        return null;
    }

}
