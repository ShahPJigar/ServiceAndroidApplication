package com.delta.listviews;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListViewActivity extends Activity {
    //initial data
    User[] myUserArray = new User[]{

            new User("Leanne Graham", "Sincere@april.biz", "1-770-736-8031 x56442", "Apt. 556, Kulas Light, Gwenborough, 92998-3874", "user1" ,"Bret"),
            new User("Ervin Howell", "Shanna@melissa.tv", "010-692-6593 x09125", "Suite 879, Victor Plains, Wisokyburgh, 90566-7771", "user2","Antonette"),
            new User("Clementine Bauch", "Nathan@yesenia.net", "1-463-123-4447", "Suite 847, Douglas Extension, McKenziehaven, 59590-4157", "user3","Samantha"),
            new User("Patricia Lebsack", "Julianne.OConner@kory.org", "493-170-9623 x156", "Apt. 692, Hoeger Mall, South Elvis, 53919-4257", "user4", "Karianne"),
            new User("Chelsey Dietrich", "Lucio_Hettinger@annie.ca", "(254)954-1289", "Suite 351, Skiles Walks, Roscoeview, 33263", "user5","Kamren"),
            new User("Mrs. Dennis Schulist", "Karley_Dach@jasper.info", "1-477-935-8478 x6430", "Apt. 950, Norberto Crossing, South Christy, 23505-1337", "user6" , "Leopoldo_Corkery"),
            new User("Kurtis Weissnat", "Telly.Hoeger@billy.biz", "210.067.6132", "Suite 280, Rex Trail, Howemouth, 58804-1099", "user7" ,"Elwyn.Skiles"),
            new User("Nicholas Runolfsdottir V", "Sherwood@rosamond.me", "586.493.6943 x140", "Suite 729, Ellsworth Summit, Aliyaview, 76495-3109", "user8", "Maxime_Nienow"),
            new User("Glenna Reichert", "Chaim_McDermott@dana.io", "(775)976-6794 x41206", "Suite 449, Dayna Park, Bartholomebury, 76495-3109", "user9", "Delphine"),
            new User("Clementina DuBuque", "Rey.Padberg@karina.biz", "024-648-3804", "Suite 198, Kattie Turnpike, Lebsackbury, 31428-2261", "user10" ,"Moriah.Stanton"),
    };

    private ListView mListView;
    private UserAdapter mUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mListView = (ListView) findViewById(R.id.myListView);

        mUserAdapter = new UserAdapter(getApplicationContext(),R.layout.row,myUserArray);

        if(mListView != null) {
            mListView.setAdapter(mUserAdapter);
        }

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("USER", myUserArray[i].mNameOfUser);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}