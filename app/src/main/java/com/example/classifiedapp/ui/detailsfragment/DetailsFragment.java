package com.example.classifiedapp.ui.detailsfragment;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.classifiedapp.R;
import com.example.classifiedapp.base.BaseFragment;

import org.jetbrains.annotations.NotNull;

public class DetailsFragment extends BaseFragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initiateView(view);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_details;
    }

    @Override
    public Object initiateView(@NotNull View view) {
        return DataBindingUtil.bind(view);
    }
}