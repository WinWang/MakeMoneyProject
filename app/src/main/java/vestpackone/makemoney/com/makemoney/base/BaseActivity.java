package vestpackone.makemoney.com.makemoney.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.View;

import com.qmuiteam.qmui.widget.QMUIEmptyView;
import com.qmuiteam.qmui.widget.QMUITopBar;

import cn.droidlover.xdroidmvp.cache.Sp;
import cn.droidlover.xdroidmvp.mvp.IPresent;
import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.droidlover.xdroidmvp.net.NetError;
import me.jessyan.autosize.AutoSize;
import vestpackone.makemoney.com.makemoney.R;
import vestpackone.makemoney.com.makemoney.utils.AppManager;

/**
 * Created by admin on 2018/4/24.
 */

public abstract class BaseActivity<P extends IPresent> extends XActivity<P> {


    protected QMUITopBar topBar;
    private QMUIEmptyView emptyView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);

    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        AutoSize.autoConvertDensityOfGlobal(this);
        return super.onCreateView(name, context, attrs);
    }

    @Override
    protected void initTopBar() {
        topBar = (QMUITopBar) findViewById(R.id.qm_topbar);
        emptyView = (QMUIEmptyView) findViewById(R.id.empty_loading_layout);
        if (topBar != null) {
            topBar.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
            if (isShowBack()) {
                topBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                });

            }
        }
    }


    public void setRetryView(NetError error) {
        getvDelegate().toastLong(error.getMessage());
        if (emptyView != null) {
            emptyView.show(false, error.getMessage(), null, "点击重试", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    emptyView.show(true);
                    getNetData();
                }
            });
        }
    }


    public void hideLoading() {
        if (emptyView != null) {
            emptyView.hide();
        }
    }


    @Override
    public void onBackPressed() {
        AppManager.getAppManager().finishActivity(this);
        super.onBackPressed();
    }

    protected boolean isShowBack() {
        return true;
    }

    public void useDayNight(boolean isNight) {
        if (isNight) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        }
        recreate();
    }

    public abstract void getNetData();





}
