package android.example.tourbottom;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FavouriteFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //ACCOMODATIONS
        View rootView = inflater.inflate(R.layout.fragment_local_attraction,container,false);

        final ArrayList<LocalAttraction> accomodations = new ArrayList<>();

        final String[] accomodationNames = getResources().getStringArray(R.array.list_accomodation_names);
        final String[] accomodationAddresses = getResources().getStringArray(R.array.list_accomodation_addresses);
        final String[] accomodationOpeningHours = getResources().getStringArray(R.array.list_accomodation_opening_hours);
        final TypedArray accomodationImages = getResources().obtainTypedArray(R.array.list_accomodation_images);

        for  (int id = 0; id != accomodationNames.length; ++id) {
            LocalAttraction newLocalAttraction = new LocalAttraction(accomodationNames[id], accomodationAddresses[id],
                    accomodationOpeningHours[id], accomodationImages.getDrawable(id));
            accomodations.add(newLocalAttraction);
        }

        LocalAttractionAdapter adapter = new LocalAttractionAdapter(getActivity(), accomodations);

        ListView listView = (ListView) rootView.findViewById(R.id.list_local_attraction);

        listView.setAdapter(adapter);

        return rootView;
    }
}
