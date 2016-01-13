package br.com.guilherme.boaviagem;

import java.util.Arrays;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class GastoListActivity extends ListActivity 
							   implements OnItemClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				showGastos()));
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		TextView textView = (TextView) view;
		String mensagem = "Gasto Selecionado: " + textView.getText();
		Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
	}
	
	public List<String> showGastos(){
		return Arrays.asList("Sanduiche - R$19,90", "Taxi - R$50,00", "Revista - R$12,00");
	}
}
