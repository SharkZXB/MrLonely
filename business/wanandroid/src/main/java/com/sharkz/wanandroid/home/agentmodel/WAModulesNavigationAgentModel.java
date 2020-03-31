package com.sharkz.wanandroid.home.agentmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sharkz.framework.agent.FWBaseLayoutAgent;
import com.sharkz.wanandroid.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/25  12:08
 * 描    述 首页导航模块
 * 修订历史：
 * ================================================
 */
public class WAModulesNavigationAgentModel extends FWBaseLayoutAgent {

    private WeakReference<Context> context;
    private RecyclerView rvNavigation;

    public WAModulesNavigationAgentModel(Context context) {
        this.context = new WeakReference<>(context);
    }

    public View getViewRoot() {
        View view = LayoutInflater.from(context.get()).inflate(R.layout.tab_home_modules_navigation_model_layout, null);
        setRootView(view);
        rvNavigation = bind(R.id.rvNavigation);
        initRVNavigation();
        return view;
    }


    // =============================================================================================


    private void initRVNavigation() {
        if (context.get() == null) {
            return;
        }

        List<String> list = new ArrayList<>();
        list.add("广场");
        list.add("公众号");
        list.add("体系");
        list.add("项目");
        list.add("导航");

        LinearLayoutManager manager = new LinearLayoutManager(context.get());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvNavigation.setLayoutManager(manager);
        WAModulesNavigationAgentModelAdapter agentModelAdapter = new WAModulesNavigationAgentModelAdapter(list);
        rvNavigation.setAdapter(agentModelAdapter);
    }

}
