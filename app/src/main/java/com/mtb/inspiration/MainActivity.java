package com.mtb.inspiration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.mtb.inspiration.Adapters.ImageGalleryAdapter;
import com.mtb.inspiration.Models.FlickrImageResult;
import com.mtb.inspiration.ViewModels.FlickrImagesViewModel;


public class MainActivity extends AppCompatActivity {

    public FlickrImagesViewModel flickrImagesVM;
    private SwipeRefreshLayout pullToRefresh;
    private ProgressBar progressbar;
    private RecyclerView galleryRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        flickrImagesVM = ViewModelProviders.of(this).get(FlickrImagesViewModel.class);
        setContentView(R.layout.activity_main);
        findViewsById();

        flickrImagesVM.getErrorMLD().observe(this, errorValue-> {

            progressbar.setVisibility(View.GONE);
            pullToRefresh.setRefreshing(false);
            pullToRefresh.setVisibility(View.VISIBLE);

            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Something went wrong..");
            alertDialog.setMessage(errorValue);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    (dialog, which) -> dialog.dismiss());
            alertDialog.show();
        });


        flickrImagesVM.getSuccessMLD().observe(this, successValue-> {

            progressbar.setVisibility(View.GONE);
            pullToRefresh.setRefreshing(false);
            pullToRefresh.setVisibility(View.VISIBLE);

            FlickrImageResult result = flickrImagesVM.flickrImageResult;
            ImageGalleryAdapter imageAdapter = new ImageGalleryAdapter(result.photos.photo);

            GridLayoutManager glm = new GridLayoutManager(MainActivity.this, 3);
            galleryRecyclerView.setLayoutManager(glm);
            EndlessRecyclerViewScrollListener scrollListener = new EndlessRecyclerViewScrollListener(glm) {
                @Override
                public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                    //Fetch more data from the server here and apply to existing adapter, did not have the time to fully finish this..
                }
            };
            galleryRecyclerView.addOnScrollListener(scrollListener);
            galleryRecyclerView.setAdapter(imageAdapter);
        });

        flickrImagesVM.getFlickrImages(getApplicationContext());
        pullToRefresh.setOnRefreshListener(() -> flickrImagesVM.getFlickrImages(getApplicationContext()));
    }

    private void findViewsById(){
        pullToRefresh = findViewById(R.id.pullToRefresh);
        progressbar = findViewById(R.id.progressbar);
        galleryRecyclerView = findViewById(R.id.flickr_recycler_view);
    }
}
