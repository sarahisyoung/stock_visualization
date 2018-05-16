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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static utility.FileHelper.DATEFORMAT;

// TODO - add your @Path here
@Path("events")
public class StockResource {

    // TODO - Add a @GET resource to get stock data
    // Your service should return data based on 3 inputs
    // Stock ticker, start date and end date



    @GET
    @Path("startDate/{startDate}/endDate/{endDate}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Stock> getEventsInRange(@PathParam("startDate") String startDateStr, @PathParam("endDate") String endDateStr) throws IOException, ParseException {
        System.out.println(startDateStr);
        System.out.println(23423);

        List<Stock> events = FileHelper.readAllStocks("historicalStockData.json");
        System.out.println(events.get(0).getName());
        List<Stock> eventsInRange = new ArrayList<>();
        /*for (Stock event: events) {
            if ((event.getDate().before(endDate) || event.getDate().equals(endDate))
                    && (event.getDate().after(startDate) || event.getDate().equals(startDate))) {
                eventsInRange.add(event);
            }
        }*/
        return eventsInRange;
    }




}
