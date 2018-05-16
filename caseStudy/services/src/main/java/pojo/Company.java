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

package pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * This class will define a company and its attributes
 * Look at resources/data/companyInfo.json
 */
public class Company {

    // TODO - Think back to your modelling session
    // Define the attributes of a Company based on the
    // provided data in resources/data
    @JsonFormat
    private String symbol;

    @JsonProperty
    private String name;

    @JsonProperty
    private String headquarterCity;

    @JsonProperty
    private String headquartersStateorCountry;

    @JsonProperty
    private int numberofEmployees;

    @JsonProperty
    private String sector;

    @JsonProperty
    private String industry;






    public String getSymbol() {
        return symbol;
    }
    public String getName() {
        return name;
    }
    public String getHQCity() {
        return headquarterCity;
    }
    public String getHQStateCountry() {
        return headquartersStateorCountry;
    }
    public int getNumEmploy() {
        return numberofEmployees;
    }
    public String getSector() {
        return sector;
    }
    public String getIndustry() {
        return industry;
    }






    // TODO - add getter and setter methods for your attributes





}