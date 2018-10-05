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

public class CalculatedInterest {

    private int months;
    private double value;
    private double rate;

    public CalculatedInterest(int months, double value, double rate) {
        this.months = months;
        this.value = value;
        this.rate = rate;
    }

    public int getMonths() {
        return months;
    }

    public double getValue() {
        return value;
    }

    public double getRate() {
        return rate;
    }
}
