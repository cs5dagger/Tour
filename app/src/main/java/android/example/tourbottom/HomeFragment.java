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

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //ATTRACTIONS

        View rootView =  inflater.inflate(R.layout.fragment_home,container,false);

        final ArrayList<LocalAttraction> attractions = new ArrayList<>();

        final String[] attractionNames = getResources().getStringArray(R.array.list_attraction_names);
        final String[] attractionAddresses = getResources().getStringArray(R.array.list_attraction_addresses);
        final String[] attractionOpeningHours = getResources().getStringArray(R.array.list_attraction_opening_hours);
        final TypedArray attractionImages = getResources().obtainTypedArray(R.array.list_attraction_images);

        for  (int id = 0; id != attractionNames.length; ++id) {
            LocalAttraction newLocalAttraction = new LocalAttraction(attractionNames[id], attractionAddresses[id],
                    attractionOpeningHours[id], attractionImages.getDrawable(id));
            attractions.add(newLocalAttraction);
        }

        LocalAttractionAdapter adapter = new LocalAttractionAdapter(getActivity(), attractions);

        ListView listView = (ListView) rootView.findViewById(R.id.list_local_attraction);

        listView.setAdapter(adapter);

        return rootView;
    }
}
