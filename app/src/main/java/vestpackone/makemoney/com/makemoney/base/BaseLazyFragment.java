package vestpackone.makemoney.com.makemoney.base;

import android.view.View;

import com.qmuiteam.qmui.widget.QMUIEmptyView;

import cn.droidlover.xdroidmvp.mvp.IPresent;
import cn.droidlover.xdroidmvp.mvp.XLazyFragment;
import cn.droidlover.xdroidmvp.net.NetError;
import vestpackone.makemoney.com.makemoney.R;
import vestpackone.makemoney.com.makemoney.utils.ToastUtil;

/**
 * Created by Administrator on 2018/6/4 0004.
 */

public abstract class BaseLazyFragment<P extends IPresent> extends XLazyFragment<P> {
    protected QMUIEmptyView emptyView;

    @Override
    public void bindUI(View rootView) {
        super.bindUI(rootView);
        emptyView = (QMUIEmptyView) rootView.findViewById(R.id.empty_loading_layout);
    }

    public void setRetryView(NetError error) {
        if (emptyView != null) {
            getvDelegate().toastShort(error.getMessage());
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

    public abstract void getNetData();


    public void checkError(NetError error) {
        if (error.getType() == NetError.AuthError) {
            ToastUtil.showToast("登录已过期，请重新登录");
            context.finish();
        } else {
            ToastUtil.showToast(error.getMessage() + "");
        }
    }


}
