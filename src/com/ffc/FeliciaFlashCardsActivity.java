package com.ffc;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FeliciaFlashCardsActivity extends ListActivity 
{
    String[] cards;
    
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        cards = getResources().getStringArray(R.array.cardsets);
        
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.main, R.id.label, cards));
        
        ListView cardView = getListView();
        
        cardView.setOnItemClickListener(new OnItemClickListener() 
        {
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
        	{
        		Intent i = new Intent(getApplicationContext(), FlashCardsActivity.class);
        		i.putExtra("cardNum", position);
        		startActivity(i);
        	}
		});
        
    }
}