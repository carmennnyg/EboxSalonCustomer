package com.example.eboxsalon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ReviewActivity extends AppCompatActivity {
    private ListView mStylistLV;

    String name[] = {"Anne Mary", "Kelly Tornedaz", "Sirio"};

    List<Staffs> staffListItems = new ArrayList<>();

    CustomAdapter customAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        mStylistLV = findViewById(R.id.stylist_list_view);

        for (int i = 0; i < name.length; i++) {
            Staffs staffs = new Staffs(name[i]);
            staffListItems.add(staffs);
        }

        customAdapter = new CustomAdapter(staffListItems,this);
        mStylistLV.setAdapter(customAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem menuItem = menu.findItem(R.id.search_view);

        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                customAdapter.getFilter().filter(newText);
                return true;
            }
        });

        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.search_view){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class CustomAdapter extends BaseAdapter implements Filterable {

        private List<Staffs> mStaffsList;
        private List<Staffs> mStaffsListFiltered;
        private Context context;

        public CustomAdapter(List<Staffs> mStaffsList, Context context) {
            this.mStaffsList = mStaffsList;
            this.mStaffsListFiltered = mStaffsList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return mStaffsListFiltered.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.row_staffs,null);
            TextView staffName = view.findViewById(R.id.staffName);

            staffName.setText(mStaffsListFiltered.get(position).getName());

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    startActivity(new Intent(ReviewActivity.this, RateReviewActivity.class).putExtra("item", mStaffsListFiltered.get(position)));
                }
            });

            return view;
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter(){
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults filterResults = new FilterResults();

                    if(constraint == null || constraint.length() == 0 ){
                        filterResults.count = mStaffsList.size();
                        filterResults.values = mStaffsList;

                    }else{
                        String searchStr = constraint.toString().toLowerCase();
                        List<Staffs> resultData = new ArrayList<>();

                        for(Staffs staffs:mStaffsList){
                            if(staffs.getName().contains(searchStr)){
                                resultData.add(staffs);
                            }

                            filterResults.count = resultData.size();
                            filterResults.values = resultData;
                        }

                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    mStaffsListFiltered = (List<Staffs>) results.values;
                    notifyDataSetChanged();

                }
            };
            return filter;
        }
    }
}