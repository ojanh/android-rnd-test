package com.ojanfauzan.rndtest.test1;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.location.places.ui.SupportPlaceAutocompleteFragment;
import com.google.android.gms.maps.model.LatLng;
import com.ojanfauzan.rndtest.R;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends FragmentActivity {



    @BindView(R.id.name_result)
    TextView nameResult;
    @BindView(R.id.address_result)
    TextView addressResult;

    SupportPlaceAutocompleteFragment placeAutocompleteFragment;

    Geocoder geocoder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        geocoder = new Geocoder(this, new Locale("in_ID"));

        initAutosearch();

    }

    private void initAutosearch() {

        placeAutocompleteFragment = (SupportPlaceAutocompleteFragment) getSupportFragmentManager().findFragmentById(R.id.main_fragment_autocomplete);
        placeAutocompleteFragment.setFilter(new AutocompleteFilter.Builder().setTypeFilter(AutocompleteFilter.TYPE_FILTER_CITIES).build());


        placeAutocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {


            @Override
            public void onPlaceSelected(Place place) {
                nameResult.setText(place.getName());
                LatLng latLng = place.getLatLng();







            }

            @Override
            public void onError(Status status) {

            }
        });
    }


}
