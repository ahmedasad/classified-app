package com.example.classifiedapp.ui.detailsfragment;

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
import com.example.classifiedapp.databinding.FragmentDetailsBinding;
import com.example.classifiedapp.model.getclassifiedlistresponse.Items;
import com.example.classifiedapp.utils.Helper;
import com.jakewharton.rxbinding.view.RxView;

import org.jetbrains.annotations.NotNull;

import rx.functions.Action1;


public class DetailsFragment extends BaseFragment {

    public static String ITEM = "item";
    FragmentDetailsBinding binding;
    Items item;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding = (FragmentDetailsBinding) initiateView(view);
        super.onViewCreated(view, savedInstanceState);
        setView(binding);
    }

    private void setView(FragmentDetailsBinding binding) {
        RxView.clicks(binding.backBtn).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                navController.navigateUp();
            }
        });

        if (item.getImage_urls() != null && !item.getImage_urls().isEmpty())
            Helper.INSTANCE.loadImg(binding.itemImg, item.getImage_urls().get(0));
        else Helper.INSTANCE.loadImg(binding.itemImg, "");

        binding.itemNameText.setText(item.getName());
        Helper.INSTANCE.setPrice(binding.itemPriceText,item.getPrice());
    }

    @Override
    public void handleArguments(@NotNull Bundle arguments) {
        item = (Items) arguments.get(ITEM);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_details;
    }

    @Override
    public Object initiateView(@NotNull View view) {
        return FragmentDetailsBinding.bind(view);
    }
}