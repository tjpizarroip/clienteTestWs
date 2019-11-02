package com.intercop.springboot.ws.commons.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Util {
	public static Double promedio(List<Integer> v) {
		// AVERAGE -- Solution 1
		return v.stream().mapToInt(i -> i).average().getAsDouble();

	}

	public static Double desviacion(List<Integer> v) {
		double prom, sum = 0;
		int n = v.size();
		prom = promedio(v);

		for (Integer integer : v)
			sum += Math.pow(integer - prom, 2);

		return Math.sqrt(sum / (double) n);
	}

	@SuppressWarnings("deprecation")
	public static Date fechaPosibleFallecimiento(Date fechaNacimiento) {
		Date aux = new Date(fechaNacimiento.getYear(), fechaNacimiento.getMonth(), fechaNacimiento.getDate());
		Integer edad = Period
				.between(aux.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now())
				.getYears();
		Integer aniosVida = 0;
		if (15 <= edad) {
			aniosVida = numeroAleatorioEntre(60, 71);
		} else {
			aniosVida = numeroAleatorioEntre(60 - edad, 71 - edad);
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(aux);
		calendar.add(Calendar.YEAR, aniosVida);
		
		return calendar.getTime();

	}

	public static Integer numeroAleatorioEntre(Integer inicio, Integer fin) {
		return (int) Math.floor(Math.random() * (fin - inicio + 1) + inicio);
	}
	
	public static String formatFecha(Date fecha, String formato) {
		DateFormat dateFormat = new SimpleDateFormat(formato);  
		return dateFormat.format(fecha);  
	}
}
