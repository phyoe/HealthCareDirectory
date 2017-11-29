package com.pkz.healthcaredirectory.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pkz.healthcaredirectory.data.vos.DoctorVO;
import com.pkz.healthcaredirectory.views.holders.DoctorViewHolder;
import com.pkz.healthcaredirectory.HealthCareDirectoryApp;
import com.pkz.healthcaredirectory.R;

import java.util.List;

/**
 * Created by Phyoe Khant on 9/16/2016.
 */
public class DoctorAdapter extends RecyclerView.Adapter<DoctorViewHolder> {

    private LayoutInflater mInflater;
    private List<DoctorVO> mDoctorList;
    private DoctorViewHolder.ControllerDocotorItem mControllerDocotorItem;

    public DoctorAdapter(List<DoctorVO> doctorList, DoctorViewHolder.ControllerDocotorItem controllerDocotorItem) {
        mInflater = LayoutInflater.from(HealthCareDirectoryApp.getContext());
        mDoctorList = doctorList;
        mControllerDocotorItem = controllerDocotorItem;
    }

    @Override
    public DoctorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.view_item_doctor, parent, false);
        return new DoctorViewHolder(itemView, mControllerDocotorItem);
    }

    @Override
    public void onBindViewHolder(DoctorViewHolder holder, int position) {
        holder.bindData(mDoctorList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDoctorList.size();
    }
}
