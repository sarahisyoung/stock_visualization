/**
 * Copyright 2018 Goldman Sachs.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package resources;

import pojo.Stock;
import utility.FileHelper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static utility.FileHelper.DATEFORMAT;

// TODO - add your @Path here
@Path("events")
public class StockResource {

    // TODO - Add a @GET resource to get stock data
    // Your service should return data based on 3 inputs
    // Stock ticker, start date and end date


    List<String> tickerNames;
    TreeMap<String, Double> map = new TreeMap<String, Double>();

    @GET
    @Path("startDate/{startDate}/endDate/{endDate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Stock getEventsInRange(String ticker, @PathParam("startDate") String startDateStr, @PathParam("endDate") String endDateStr) throws IOException, ParseException {


        List<Stock> stockList = FileHelper.readAllStocks("historicalStockData.json");

        tickerNames = new ArrayList<String>();


        for(Stock each: stockList) {
            if(each.getName().equals("BIDU")) {
                //map of the dates to prices, ordered
                map = each.getDailyClosePrice().get(0);

            }
        }


        //set of dates
        List<String> dateSet = new ArrayList<String>();
        List<Double> priceSet = new ArrayList<Double>();


        startDateStr = startDateStr.replace('-', '/');
        endDateStr = endDateStr.replace('-', '/');

        //fix dates
        startDateStr = fixDateFormat(startDateStr);
        endDateStr = fixDateFormat(endDateStr);


        //find dates within range
        for(String date: new TreeSet<>(map.keySet())) {

            String new_date = fixDateFormat(date);
            if((new_date.compareTo(startDateStr) > 0 && new_date.compareTo(endDateStr) < 0)
                    || new_date.compareTo(endDateStr) == 0
                    || new_date.compareTo(startDateStr) == 0) {
                dateSet.add(date);

                //update price set
                priceSet.add(map.get(date));
            }

        }

        Stock stock = new Stock();
        stock.setDateSet(dateSet);
        stock.setPriceSet(priceSet);

        return stock;
    }


    /**
     * Takes in a date in the format or M/D/YYYY and turns it into MM/DD/YYYY
     * @param date
     * @return String
     */
    public String fixDateFormat(String date) {

        // MM
        int index = date.indexOf("/");
        String mm = date.substring(0,index);

        //check if month is MM
        if(mm.length() < 2) {
            mm = "0" + mm;
        }

        // DD/YYYY
        date = date.substring(index+1);
        index = date.indexOf('/');
        String dd = date.substring(0, index);

        //check if day is DD
        if(dd.length() < 2) {
            dd = "0" + dd;
        }


        date = mm + "/" + dd + "/" + date.substring(index+1);

        return date;
    }



}
