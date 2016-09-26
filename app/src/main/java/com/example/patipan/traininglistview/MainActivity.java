package com.example.patipan.traininglistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    List<Dog> dogs = new ArrayList<>();
    int dataSize;
    public Dog listDog = new Dog();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstances();


    }

    private void initInstances() {

        prepareData();

        ListAdapter adapter = new ListAdapter(MainActivity.this, listDog);
        listView = (ListView) findViewById(R.id.list_item);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listViewClickListener);

    }

    private void prepareData() {

        int resId[] = {R.drawable.german_shepherd, R.drawable.labrador_retriever, R.drawable.blue_dog, R.drawable.beagle
                , R.drawable.boxer, R.drawable.golden_retriever, R.drawable.poodle, R.drawable.pug, R.drawable.siberian_husky,
                R.drawable.great_dane, R.drawable.german_shepherd, R.drawable.labrador_retriever, R.drawable.blue_dog, R.drawable.beagle
                , R.drawable.boxer, R.drawable.golden_retriever, R.drawable.poodle, R.drawable.pug, R.drawable.siberian_husky,
                R.drawable.great_dane, R.drawable.german_shepherd, R.drawable.labrador_retriever, R.drawable.blue_dog, R.drawable.beagle
                , R.drawable.boxer, R.drawable.golden_retriever, R.drawable.poodle, R.drawable.pug, R.drawable.siberian_husky,
                R.drawable.great_dane, R.drawable.german_shepherd, R.drawable.labrador_retriever, R.drawable.blue_dog, R.drawable.beagle
                , R.drawable.boxer, R.drawable.golden_retriever, R.drawable.poodle, R.drawable.pug, R.drawable.siberian_husky,
                R.drawable.great_dane};

        String breed[] = {"German shepherd", "Labrador retriever", "Bull dog", "Beagle",
                "Boxer", "Golden retriever", "Poodle", "Pug", "Siberian husky",
                "Great dane", "German shepherd", "Labrador retriever", "Bull dog", "Beagle",
                "Boxer", "Golden retriever", "Poodle", "Pug", "Siberian husky",
                "Great dane", "German shepherd", "Labrador retriever", "Bull dog", "Beagle",
                "Boxer", "Golden retriever", "Poodle", "Pug", "Siberian husky",
                "Great dane", "German shepherd", "Labrador retriever", "Bull dog", "Beagle",
                "Boxer", "Golden retriever", "Poodle", "Pug", "Siberian husky",
                "Great dane"};

        String description[] = {getString(R.string.german_shepherd_des), getString(R.string.labrador_retriever_des), getString(R.string.blue_dog_des), getString(R.string.beagle_des)
                , getString(R.string.boxer_des), getString(R.string.golden_des), getString(R.string.poodle_des), getString(R.string.pug_des), getString(R.string.siberian_des)
                , getString(R.string.greatdane_des), getString(R.string.german_shepherd_des), getString(R.string.labrador_retriever_des), getString(R.string.blue_dog_des), getString(R.string.beagle_des)
                , getString(R.string.boxer_des), getString(R.string.golden_des), getString(R.string.poodle_des), getString(R.string.pug_des), getString(R.string.siberian_des)
                , getString(R.string.greatdane_des), getString(R.string.german_shepherd_des), getString(R.string.labrador_retriever_des), getString(R.string.blue_dog_des), getString(R.string.beagle_des)
                , getString(R.string.boxer_des), getString(R.string.golden_des), getString(R.string.poodle_des), getString(R.string.pug_des), getString(R.string.siberian_des)
                , getString(R.string.greatdane_des), getString(R.string.german_shepherd_des), getString(R.string.labrador_retriever_des), getString(R.string.blue_dog_des), getString(R.string.beagle_des)
                , getString(R.string.boxer_des), getString(R.string.golden_des), getString(R.string.poodle_des), getString(R.string.pug_des), getString(R.string.siberian_des)
                , getString(R.string.greatdane_des),};
        dataSize = resId.length;


        Log.d("khem", "dataSize " + resId.length);
        Log.d("khem", "breed " + resId.length);
        Log.d("khem", "description " + resId.length);



        for (int i = 0; i < dataSize; i++) {
            Log.d("khem", " " + i);
            Dog dog = new Dog(resId[i], breed[i], description[i]);
            dogs.add(dog);
        }

        listDog.setDogs(dogs);

        //Log.d("khem",listDog);
    }

    /*************************
     * Listener
     ***************************/

    AdapterView.OnItemClickListener listViewClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, "POSITION:= " + position,
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this,ShowDetailActivity.class);
            intent.putExtra("resId",listDog.getDogs().get(position).getResId());
            intent.putExtra("breed",listDog.getDogs().get(position).getBreed());
            intent.putExtra("desc",listDog.getDogs().get(position).getDescription());

            startActivity(intent);
        }
    };

}
