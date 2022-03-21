package com.alexis.rodriguez.melimutants.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.alexis.rodriguez.melimutants.localization.MutantConstants;

public class MutantUtils {
	
	/**
	 * Metodo para transformar el dna enviado al servicio en formato JSON 
	 * a un array de String.
	 * NOTA: Si salta una excepcion del tipo JSONException y no puede realizar la
	 * conversion retornara null.
	 * @param jsonRequest
	 * @return
	 */
	public static String[] extractDnaFromRequest(String jsonRequest) {
		Vector dnaBuilder = new Vector<>();
		boolean jsonExceptionOccurs = false;
		try {

			JSONArray dna = extractJsonArrayFromRequest(jsonRequest);

			for (int i = 0; i < dna.length(); i++) {
				dnaBuilder.add(dna.getString(i));
			}

		} catch (JSONException e) {
			jsonExceptionOccurs = true;
		}

		
		
		
		if (!jsonExceptionOccurs) {
			Object[] objArray = dnaBuilder.toArray();
			String[] objArrayParsed =  Arrays.copyOf(objArray, objArray.length,  String[].class);
			
			return objArrayParsed;
			
		}else {
			return null;
		}
		
	}
	
	/**
	 * Metodo para extraer un objeto JSONArray del request enviado al servicio.
	 * @param jsonRequest
	 * @return JSONArray
	 */
	public static JSONArray extractJsonArrayFromRequest(String jsonRequest) {
		
		JSONObject jObj = new JSONObject(jsonRequest);
		JSONArray jsonArray = jObj.getJSONArray(MutantConstants.DNA);
		
		return jsonArray;
	}

}
