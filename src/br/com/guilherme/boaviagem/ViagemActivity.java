package br.com.guilherme.boaviagem;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class ViagemActivity extends Activity {
	
	private int diaSaida, mesSaida, anoSaida;
	private int diaChegada, mesChegada, anoChegada;
	Button dataSaida, dataChegada;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.novaviagemactivity);
		
		Calendar calendar = Calendar.getInstance();
		
		this.anoSaida = calendar.get(Calendar.YEAR);
		this.mesSaida = calendar.get(Calendar.MONTH);
		this.diaSaida = calendar.get(Calendar.DAY_OF_MONTH);
		
		this.anoChegada = calendar.get(Calendar.YEAR);
		this.mesChegada = calendar.get(Calendar.MONTH);
		this.diaChegada = calendar.get(Calendar.DAY_OF_MONTH);
		
		this.dataChegada = (Button) findViewById(R.id.data_chegada);
		this.dataChegada.setText(this.diaChegada + "/" + (this.mesChegada+1) + 
				"/" + this.anoChegada);
		
		this.dataSaida = (Button) findViewById(R.id.data_saida);
		this.dataSaida.setText(this.diaSaida + "/" + (this.mesSaida+1) +
				"/" + this.anoSaida);
	}
	
	@SuppressWarnings("deprecation")
	public void selecionarData(View view) {
		showDialog(view.getId());
	}
	
	private OnDateSetListener listenerSaida = new OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			// TODO Auto-generated method stub
			diaSaida = dayOfMonth;
			mesSaida = monthOfYear;
			anoSaida = year;
			
			dataSaida.setText(diaSaida + "/" + (mesSaida+1) +
					"/" + anoSaida);
		}
	};
	
	private OnDateSetListener listenerChegada = new OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			// TODO Auto-generated method stub
			diaChegada = dayOfMonth;
			mesChegada = monthOfYear;
			anoChegada = year;
			
			dataChegada.setText(diaChegada + "/" + (mesChegada+1) +
					"/" + anoChegada);
		}
	};
	
	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
			case R.id.data_chegada:
				return new DatePickerDialog(this, listenerChegada,
						this.anoChegada, this.mesChegada, this.diaChegada);				
			case R.id.data_saida:
				return new DatePickerDialog(this, listenerSaida,
						this.anoSaida,this.mesSaida,this.diaSaida);
			default:
				return null;
		}		
	}
}
