package com.github.apppetr.doshatest.Fragments;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import com.github.apppetr.doshatest.Utils.FileUtils;
import com.github.apppetr.doshatest.soundtherapy.MusicPlayer;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.github.apppetr.doshatest.R;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MusicFragment extends Fragment {
    ListView files_listView;
    String[] items;
    String track_name;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.music_list, container, false);
        files_listView = view.findViewById(R.id.item_list);
        storage_access_permission();
        // setListAdapter(new MenuListAdapter(R.layout.row_menu_action_item, getActivity(), MenuActionItem.values()));
        return view;
    }

    public ArrayList<File> search_file(File file) throws IOException {

        ArrayList<File> list = new ArrayList<>();
        //Add to list files from asset folder
        String[] assets = super.getActivity().getAssets().list("");
        for (String assetName : assets) {
            if (!assetName.contains("@")) {
                if (assetName.endsWith(".mp3") || assetName.endsWith(".wav")) {
                    File assetFile = FileUtils.fileFromAsset(this.getContext(), assetName);
                    list.add(assetFile);
                }
            }
        }
        return list;
    }

    void display() throws IOException {

        File root = new File(Environment
                .getExternalStorageDirectory()
                .getAbsolutePath());

        final ArrayList<File> my_files = search_file(root);

        items = new String[my_files.size()];

        for (int i = 0; i < my_files.size(); i++) {

            items[i] = my_files.get(i).getName().toString().replace(".mp3", "");
        }

        final ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1, items);
        files_listView.setAdapter(stringArrayAdapter);

        files_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                track_name = files_listView.getItemAtPosition(i).toString();

                startActivity(new Intent(view.getContext(), MusicPlayer.class)
                        .putExtra("track", track_name).putExtra("tracklist", my_files).putExtra("pos", i)
                );
            }
        });
    }

    public void storage_access_permission() {

        Dexter.withContext(super.getContext())
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        try {
                            display();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();
    }
}
