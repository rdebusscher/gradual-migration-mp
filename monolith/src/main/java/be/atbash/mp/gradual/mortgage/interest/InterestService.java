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
package be.atbash.mp.gradual.mortgage.interest;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class InterestService {


    public CalculatedInterest getInterestValue(double value, int years, double rate) {

        double monthRate = rate / 100.0 / 12.0;
        int months = years * 12;

        double temp = Math.pow(1 + monthRate, months);
        double monthValue = value * monthRate * temp / (temp - 1);
        return new CalculatedInterest(months, monthValue, rate);
    }
}
