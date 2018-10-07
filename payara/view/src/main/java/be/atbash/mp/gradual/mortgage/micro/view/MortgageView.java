/*
 * Copyright 2018 Rudy De Busscher (https://www.atbash.be)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package be.atbash.mp.gradual.mortgage.micro.view;

import be.atbash.mp.gradual.mortgage.micro.mortgage.api.MortgageData;
import be.atbash.mp.gradual.mortgage.micro.mortgage.api.MortgageDataResponse;
import be.atbash.mp.gradual.mortgage.micro.mortgage.api.MortgageResource;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class MortgageView {

    @Inject
    @RestClient
    private MortgageResource mortgageResource;

    private String name;
    private double mortgageValue;
    private int years;

    private MortgageDataResponse mortgageDataResponse;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMortgageValue() {
        return mortgageValue;
    }

    public void setMortgageValue(double mortgageValue) {
        this.mortgageValue = mortgageValue;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public void calculate() {

        MortgageData data = new MortgageData();
        data.setName(name);
        data.setValue(mortgageValue);
        data.setYears(years);

        mortgageDataResponse = mortgageResource.getInterestValue(data);
    }

    public MortgageDataResponse getMortgageDataResponse() {
        return mortgageDataResponse;
    }
}
