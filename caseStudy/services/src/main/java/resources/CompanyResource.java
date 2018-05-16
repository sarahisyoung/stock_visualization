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
import utility.FileHelper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.IOException;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;

import pojo.Company;
import pojo.Stock;


// TODO - add your @Path here
@Path("company")
public class CompanyResource {
    // TODO - Add a @GET resource to get company data
    // Your service should return data for a given stock ticker

    private HashMap<String, Company> allcompanies;
    private int built = 0;


    public void buildDataBase() throws IOException {
        //        building the map
        List<Company> companies = FileHelper.readAllCompanies("companyInfo.json");

            allcompanies = new HashMap<String, Company>();

            for (Company company : companies) {
                if (!allcompanies.containsKey(company.symbol)) {
                    allcompanies.put(company.symbol, company);
                }
            }
    }

    @GET
    @Path("allcompanies")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCompanies() throws IOException {
        List<Company> companies = FileHelper.readAllCompanies("companyInfo.json");

        if built == 0 {
            buildDataBase();
            built = 1;
        }


        return Response.ok(companiesinfo).build();
    }


    // @GET
    // @Path("allstocks")
    // @Produces(MediaType.APPLICATION_JSON)
    // public Response getAllStocks() throws IOException {
    //     List<Stock> allstocks = FileHelper.readAllStocks("historicalStockData.json");
    //     return Response.ok(companiesinfo).build();
    // }



    @GET
    @Path("basicinfo/{companysymb}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOneCompanyBasicInfo(@PathParam("companysymb") String companysymb) throws IOException {
        if built == 0 {
            buildDataBase();
            built = 1;
        }

        if (allcompanies.containsKey(companysymb)) {
            Company thisCompany = allcompanies.get(companysymb);

        } else {
            String info = "No such company symbol";
            System.out.println(info);
            Company thisCompany = new Company();
        }

        return Response.ok().entity(thisCompany).build();
    }




}
