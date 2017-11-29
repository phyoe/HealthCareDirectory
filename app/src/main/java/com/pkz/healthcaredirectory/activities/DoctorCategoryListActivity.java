package com.pkz.healthcaredirectory.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.pkz.healthcaredirectory.HealthCareDirectoryApp;
import com.pkz.healthcaredirectory.data.vos.DoctorVO;
import com.pkz.healthcaredirectory.fragments.DoctorCategoryListFragment;
import com.pkz.healthcaredirectory.views.holders.DoctorCategoryViewHolder;
import com.pkz.healthcaredirectory.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DoctorCategoryListActivity extends AppCompatActivity
       implements DoctorCategoryViewHolder.ControllerDocotorCategoryItem {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public static Intent newIntent(){
        Intent intent = new Intent(HealthCareDirectoryApp.getContext(), DoctorCategoryListActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_category_list);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (savedInstanceState == null) {
            DoctorCategoryListFragment fragment = DoctorCategoryListFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
        }
    }

    @Override
    public void onTapDoctorCategory(DoctorVO doctor) {

        String categoryName = doctor.getCategory();
        long doctorId = doctor.getId();

        Intent intent = DoctorListActivity.newIntent(categoryName, doctorId);
        startActivity(intent);
    }
}
