package br.com.guilherme.boaviagem;

import java.util.Arrays;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ViagemListActivity extends ListActivity implements OnItemClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listarViagens()));
		ListView listView = getListView();
		listView.setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		TextView textView = (TextView) view;
		String mensagem = "Viagem Selecionada: " + textView.getText();
		Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
		startActivity(new Intent(this,GastoListActivity.class));
	}

	private List<String> listarViagens() {
		return Arrays.asList("Belo Horizonte", "Porto Alegre", "Florianopolis");
	}

}
