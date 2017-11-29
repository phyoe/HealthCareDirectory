package com.pkz.healthcaredirectory.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.pkz.healthcaredirectory.R;
import com.pkz.healthcaredirectory.fragments.ArticleListFragment;
import com.pkz.healthcaredirectory.HealthCareDirectoryApp;

import com.pkz.healthcaredirectory.data.vos.HealthCareInfoVO;
import com.pkz.healthcaredirectory.views.holders.HealthCareInfoViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleListActivity extends AppCompatActivity
        implements HealthCareInfoViewHolder.ControllerHealthCareInfoItem {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public static Intent newInent(){
        Intent intent = new Intent(HealthCareDirectoryApp.getContext(), ArticleListActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.pkz.healthcaredirectory.R.layout.activity_article_list);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (savedInstanceState == null) {
            ArticleListFragment fragment = ArticleListFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
        }
    }

    @Override
    public void onTapHealthCareInfo(HealthCareInfoVO healthCareInfo) {

        long id = healthCareInfo.getId();

        /**
         Intent intent = ArticleDetailActivity.newIntent(id);
         startActivity(intent);
         /**/

        Intent intent = ArticleDetailWebViewActivity.newIntent(id);
        startActivity(intent);
    }
}
